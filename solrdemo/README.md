# 搜索引擎开发demo
基于apache solr 框架的搜索引擎开发文档
### 说明
solr是apache 开源的java搜索引擎服务，底层是基于lucence（Lucene是一个开放源代码的全文检索引擎工具jar包）。可独立运行支持搜索服务，也可嵌入到咱自己的应用系统中提供搜索功能。
我们可以通过solrj客户端封装的客户端jar包来调用搜索服务。
概念： 
 solr core：就是存放索引数据文件，索引配置文件和搜索配置文件的文件夹。也就相当于数据库内的一个表。
 索引：就是按照一定规则，存放的数据；我们通过接口把我们要搜索的数据库表的内的数据，创建为搜索引擎识别的数据，就是创建索引。搜索引擎就是对索引进行搜索的。
 分词器：如IKAnalyzer中文分词工具包。如我们搜索“我爱你我的祖国，hello world!”，那么我们通过IKAnalyzer，可能切分为：“我爱你 祖国 hello world” 来对切分的词进行搜索。
## 开发步骤
### 1.搭建solr搜索服务器（独立搜索服务）
[下载solr最新版：](https://mirrors.tuna.tsinghua.edu.cn/apache/lucene/solr/7.0.1/solr-7.0.1.zip)
(Windows为例，linux同理)
  解压到：F:\solr-7.0.0 (自定义)
    F: 
    cd F:\solr-7.0.0\bin  
    solr start   --开启服务
    solr create -c mysolrcore  --创建solr库
    http://localhost:8983/solr/   --进行访问，查看
### 2.配置索引
 - 我们的业务表如下：
  CREATE TABLE `article` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `title` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
    `content` text CHARACTER SET utf8 COMMENT '内容',
    `type` varchar(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型',
    `createTime` datetime DEFAULT NULL COMMENT '出生日期',
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=100995 DEFAULT CHARSET=latin1 COMMENT='文章';
- 修改索引搜索配置文件F:\solr-7.0.0\server\solr\mysolrcore\conf\managed-schema，增加如下内容
 <field name="id" type="string" indexed="true" stored="true" required="true" multiValued="false" />
    <field name="title" type="text_ik" indexed="true" stored="true" multiValued="false"/>
    <field name="content" type="text_ik" indexed="true" stored="true" multiValued="false"/>
    <field name="type" type="string" indexed="true" stored="true" multiValued="false"/>
    <field name="createtime" type="pdate" indexed="true" stored="true" multiValued="false"/>
    <fieldType name="text_ik" class="solr.TextField">
        <analyzer type="index">
            <tokenizer class="org.wltea.analyzer.lucene.IKTokenizerFactory" useSmart="false" />
        </analyzer>
        <analyzer type="query">
            <tokenizer class="org.wltea.analyzer.lucene.IKTokenizerFactory" useSmart="true" />
        </analyzer>
    </fieldType>
### 3.编写索引增删改代码（Spring aop形式）

@Component
@Aspect
public class SolrIndexDemoAspect {
    @Autowired
    @Qualifier("solrClientEmbed")
    private SolrClient solrClientDemo;
    
    @Pointcut("execution(* cn.com.jldata.solrdemo.mapper.ArticleMapper.insert*(..)) && args(cn.com.jldata.solrdemo.domain.Article)")//
    public void insertArticle() {}
    @After("cn.com.jldata.solrdemo.config.SolrIndexDemoAspect.insertArticle() && args(article)")
    public void afterInsertArticle(Article article) throws Throwable { //新增索引
        System.out.println(article);
        SolrInputDocument solrInputDocument =new SolrInputDocument();
        solrInputDocument.addField("id",String.valueOf(article.getId()));
        solrInputDocument.addField("title",article.getTitle());
        solrInputDocument.addField("content",article.getContent());
        solrInputDocument.addField("type",article.getType());
        solrInputDocument.addField("createtime",article.getCreatetime());
        solrClientDemo.add(solrInputDocument);
        solrClientDemo.commit();
    }

    @Pointcut("execution(* cn.com.jldata.solrdemo.mapper.ArticleMapper.delte*(..)) && args(Integer)")//
    public void deleteArticle() {}
    @After("cn.com.jldata.solrdemo.config.SolrIndexDemoAspect.insertArticle() && args(id)")
    public void afterdeleteArticle(Integer id) throws Throwable {//删除索引
        System.out.println(id);
        solrClientDemo.deleteById(String.valueOf(id));
        solrClientDemo.commit();
    }

    @Pointcut("execution(* cn.com.jldata.solrdemo.mapper.ArticleMapper.update*(..)) && args(cn.com.jldata.solrdemo.domain.Article)")//
    public void updateArticle() {}
    @After("cn.com.jldata.solrdemo.config.SolrIndexDemoAspect.updateArticle() && args(article)")
    public void afterUpdateArticle(Article article) throws Throwable {//修改索引
        System.out.println(article);
        SolrInputDocument solrInputDocument =new SolrInputDocument();
        solrInputDocument.addField("id",String.valueOf(article.getId()));
        solrInputDocument.addField("title",article.getTitle());
        solrInputDocument.addField("content",article.getContent());
        solrInputDocument.addField("type",article.getType());
        solrInputDocument.addField("createtime",article.getCreatetime());
        solrClientDemo.add(solrInputDocument);
        solrClientDemo.commit();
    }
}

### 4.编写搜索代码

@Service
public class ArticleService {
    @Autowired
    @Qualifier("solrClientEmbed")
    private SolrClient solrClientDemo;
    @Autowired
    private ArticleMapper articleMapper;

    public Page<Article> search(String q, Page<Article> page) throws Exception {
        Page<Article> result = new Page<Article>();
        SolrQuery query = new SolrQuery();
        //设置搜索域
        String word ="*";
        if(!StringUtils.isEmpty(q)){
            word = buildQuery(q);   //构造搜索条件
        }
        query.setQuery(word);
        query.setStart(page.getStartRow()); //开始位置
        query.setRows(page.getPageSize());  //取出记录数
        query.setHighlight(true);  //是否输出高亮
        query.addHighlightField("content").addHighlightField("title");
        query.setHighlightFragsize(300); //高亮单片段长度
        query.setHighlightSnippets(1);  //高亮片段个数
        query.setHighlightSimplePre("<em>"); // 高亮包裹html标签
        query.setHighlightSimplePost("</em>");
        QueryResponse qr = solrClientDemo.query(query);  //调用搜索查询服务
        int qt = qr.getQTime();
        System.out.println("搜索用时:" + qt + "毫秒");
        SolrDocumentList sdl = qr.getResults();
        Map<String, Map<String, List<String>>> highlighting = qr.getHighlighting();//获取高亮数据
        for (SolrDocument doc : sdl) {
            Article a = new Article();
        /*    BeanMapper beanMapper = new BeanMapper();
            beanMapper.copy(doc,a);*/
        String id  =String.valueOf(doc.get("id"));
            List<String> contents = highlighting.get(id).get("content");
            List<String> titles = highlighting.get(id).get("title");
            a.setId(Integer.parseInt(id));
            a.setContent((contents!=null&&contents.size()>0)?listToString(contents):(String)doc.get("content"));
            a.setType((String)doc.get("type"));
            a.setTitle((titles!=null&&titles.size()>0)?listToString(titles):(String)doc.get("title"));
            a.setCreatetime((Date) doc.get("createtime"));
            result.add(a);
        }
        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setTotal(sdl.getNumFound());
        return result;
    }
    private String listToString(List<String> list){
        StringBuilder sb =  new StringBuilder();
        if(list!=null){
            for(String s:list){
                sb.append(s) ;
            }
        }
        return sb.toString();
    }

    private String buildQuery(String s) {
        StringBuilder q = new StringBuilder();
        String splitWord = SearchUtil.splitWord(s); //对关键字进行分词
        q.append("(content:" + splitWord + ")");
        q.append(" OR ");
        q.append("(title:" + splitWord + ")");
        q.append(" OR ");
        q.append("(id:" + s + ")");
        q.append(" OR ");
        q.append("(type:" + s + ")");
        return q.toString();
    }

}

 


