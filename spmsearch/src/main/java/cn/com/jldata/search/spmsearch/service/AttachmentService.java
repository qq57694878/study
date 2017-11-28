package cn.com.jldata.search.spmsearch.service;

import cn.com.jldata.search.spmsearch.common.util.SearchUtil;
import cn.com.jldata.search.spmsearch.common.util.StringUtils;
import cn.com.jldata.search.spmsearch.domain.Attachment;
import cn.com.jldata.search.spmsearch.mapper.AttachmentMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AttachmentService {
    @Autowired
    @Qualifier("solrClientAttachment")
    private SolrClient solrClientAttachment;
    @Autowired
    private AttachmentMapper attachmentMapper;

    public int create(Attachment attachment) {
        return attachmentMapper.insertSelective(attachment);
    }

    public int delete(String id) {
        return attachmentMapper.deleteByPrimaryKey(id);
    }

    public int update(Attachment attachment) {
        return attachmentMapper.updateByPrimaryKeySelective(attachment);
    }

    public Attachment findOne(String id) {
        return attachmentMapper.selectByPrimaryKey(id);
    }

    /**
     * 搜索
     * @param q  要搜索的关键字
     * @param page 分页参数
     * @return
     * @throws Exception
     */
    public Page<Attachment> search(String q, Page<Attachment> page) throws Exception {
        Page<Attachment> result = new Page<Attachment>();
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
        query.addHighlightField("content").addHighlightField("title").addHighlightField("desc");
        query.setHighlightFragsize(300); //高亮单片段长度
        query.setHighlightSnippets(1);  //高亮片段个数
        query.setHighlightSimplePre("<em>"); // 高亮包裹html标签
        query.setHighlightSimplePost("</em>");
        QueryResponse qr = solrClientAttachment.query(query);  //调用搜索查询服务
        int qt = qr.getQTime();
        System.out.println("搜索用时:" + qt + "毫秒");
        SolrDocumentList sdl = qr.getResults();
        Map<String, Map<String, List<String>>> highlighting = qr.getHighlighting();//获取高亮数据
        for (SolrDocument doc : sdl) {
            Attachment a = new Attachment();
        /*    BeanMapper beanMapper = new BeanMapper();
            beanMapper.copy(doc,a);*/
        String id  =String.valueOf(doc.get("id"));
            List<String> contents = highlighting.get(id).get("content");
            List<String> titles = highlighting.get(id).get("title");
            List<String> descs = highlighting.get(id).get("desc");
            a.setId(id);
            a.setContent((contents!=null&&contents.size()>0)?listToString(contents):(String)doc.get("content"));
            a.setType((String)doc.get("type"));
            a.setTitle((titles!=null&&titles.size()>0)?listToString(titles):(String)doc.get("title"));
            a.setDesc(descs!=null&&descs.size()>0?listToString(descs):(String)doc.get("desc"));
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
        q.append("(desc:" + s + ")");
        return q.toString();
    }

    public Page<Attachment> findAll(Page<Attachment> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return attachmentMapper.selectAll();
    }

    public void createIndex(Page<Attachment> list) throws Exception{
        if(list!=null&&list.size()>0){
            for(Attachment attachment:list){
                SolrInputDocument solrInputDocument =new SolrInputDocument();
                solrInputDocument.addField("id",String.valueOf(attachment.getId()));
                solrInputDocument.addField("title",attachment.getTitle());
                solrInputDocument.addField("content",attachment.getContent());
                solrInputDocument.addField("type",attachment.getType());
                solrInputDocument.addField("createtime",attachment.getCreatetime());
                solrClientAttachment.add(solrInputDocument);
                solrClientAttachment.commit();
            }

        }
    }

    public void reIndexall() throws Exception {
        solrClientAttachment.deleteByQuery("*:*");
        Page<Attachment> page = new Page<Attachment>(1,100);
        Page<Attachment> list  = this.findAll(page);
        this.createIndex(list);
        for(int i=2;i<=list.getPages();i++){
            page.setPageNum(i);
            page.setPageSize(100);
            list  = this.findAll(page);
            this.createIndex(list);
        }
        solrClientAttachment.optimize();
    }
}
