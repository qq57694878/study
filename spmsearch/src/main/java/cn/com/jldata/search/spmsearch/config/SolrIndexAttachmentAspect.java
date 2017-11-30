package cn.com.jldata.search.spmsearch.config;

import cn.com.jldata.search.spmsearch.domain.Attachment;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SolrIndexAttachmentAspect {
    @Autowired
    @Qualifier("solrClientAttachment")
    private SolrClient solrClientAttachment;

    @Pointcut("execution(* cn.com.jldata.search.spmsearch.mapper.AttachmentMapper.insert*(..)) && args(cn.com.jldata.search.spmsearch.domain.Attachment)")//
    public void insertAttachment() {}

    @After("cn.com.jldata.search.spmsearch.config.SolrIndexAttachmentAspect.insertAttachment() && args(attachment)")
    public void afterInsertArticle(Attachment attachment) throws Throwable {
        System.out.println(attachment);
        SolrInputDocument solrInputDocument =new SolrInputDocument();
        solrInputDocument.addField("id",String.valueOf(attachment.getId()));
        solrInputDocument.addField("title",attachment.getTitle());
        solrInputDocument.addField("content",attachment.getContent());
        solrInputDocument.addField("desc",attachment.getDesc());
        solrInputDocument.addField("createtime",attachment.getCreatetime());
        solrClientAttachment.add(solrInputDocument);
        solrClientAttachment.commit();
    }

    @Pointcut("execution(* cn.com.jldata.search.spmsearch.mapper.AttachmentMapper.delete*(..)) && args(String)")//
    public void deleteArticle() {}
    @After("cn.com.jldata.search.spmsearch.config.SolrIndexAttachmentAspect.deleteArticle() && args(id)")
    public void afterdeleteArticle(Integer id) throws Throwable {
        System.out.println(id);
        solrClientAttachment.deleteById(String.valueOf(id));
        solrClientAttachment.commit();
    }

    @Pointcut("execution(* cn.com.jldata.search.spmsearch.mapper.AttachmentMapper.update*(..)) && args(cn.com.jldata.search.spmsearch.domain.Attachment)")//
    public void updateAttachment() {}
    @After("cn.com.jldata.search.spmsearch.config.SolrIndexAttachmentAspect.updateAttachment() && args(attachment)")
    public void afterUpdateArticle(Attachment attachment) throws Throwable {
        System.out.println(attachment);
        SolrInputDocument solrInputDocument =new SolrInputDocument();
        solrInputDocument.addField("id",String.valueOf(attachment.getId()));
        solrInputDocument.addField("title",attachment.getTitle());
        solrInputDocument.addField("content",attachment.getContent());
        solrInputDocument.addField("desc",attachment.getDesc());
        solrInputDocument.addField("createtime",attachment.getCreatetime());
        solrClientAttachment.add(solrInputDocument);
        solrClientAttachment.commit();
    }
}
