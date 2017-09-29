package cn.com.jldata.solrdemo.service;

import cn.com.jldata.solrdemo.common.util.SearchUtil;
import cn.com.jldata.solrdemo.common.util.StringUtils;
import cn.com.jldata.solrdemo.converter.BeanMapper;
import cn.com.jldata.solrdemo.domain.Article;
import cn.com.jldata.solrdemo.mapper.ArticleMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {
    @Autowired
    @Qualifier("solrClientDemo")
    private SolrClient solrClientDemo;
    @Autowired
    private ArticleMapper articleMapper;

    public int create(Article article) {
        return articleMapper.insertSelective(article);
    }

    public int delete(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    public int update(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article);
    }

    public Article findOne(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    public Page<Article> search(String q, Page<Article> page) throws Exception {
        Page<Article> result = new Page<Article>();
        SolrQuery query = new SolrQuery();
        //设置搜索域
        String word ="*";
        if(!StringUtils.isEmpty(q)){
            word = buildQuery(q);
        }
        query.setQuery(word);
        query.setStart(page.getPageNum());
        query.setRows(page.getPageSize());
        query.setHighlight(true);
        query.addHighlightField("content").addHighlightField("title");
        query.setHighlightFragsize(300);
        query.setHighlightSnippets(1);
        query.setHighlightSimplePre("<em>");
        query.setHighlightSimplePost("</em>");
        QueryResponse qr = solrClientDemo.query(query);
        int qt = qr.getQTime();
        System.out.println("搜索用时:" + qt + "毫秒");
        SolrDocumentList sdl = qr.getResults();
        Map<String, Map<String, List<String>>> highlighting = qr.getHighlighting();
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
        String splitWord = SearchUtil.splitWord(s);
        q.append("(content:" + splitWord + ")");
        q.append(" OR ");
        q.append("(title:" + splitWord + ")");
        q.append(" OR ");
        q.append("(id:" + s + ")");
        q.append(" OR ");
        q.append("(type:" + s + ")");
        return q.toString();
    }

    public Page<Article> findAll(Page<Article> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return articleMapper.selectAll();
    }

    public void createIndex(Page<Article> list) throws Exception{
        if(list!=null&&list.size()>0){
            for(Article article:list){
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
    }

    public void reIndexall() throws Exception {
        solrClientDemo.deleteByQuery("*:*");
        Page<Article> page = new Page<Article>(1,100);
        Page<Article> list  = this.findAll(page);
        this.createIndex(list);
        for(int i=2;i<=list.getPages();i++){
            page.setPageNum(i);
            page.setPageSize(100);
            list  = this.findAll(page);
            this.createIndex(list);
        }
        solrClientDemo.optimize();
    }
}
