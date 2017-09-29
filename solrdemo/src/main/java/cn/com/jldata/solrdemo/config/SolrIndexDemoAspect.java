package cn.com.jldata.solrdemo.config;

import cn.com.jldata.solrdemo.domain.Article;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SolrIndexDemoAspect {
    @Autowired
    @Qualifier("solrClientDemo")
    private SolrClient solrClientDemo;

    @Pointcut("execution(* cn.com.jldata.solrdemo.mapper.ArticleMapper.insert*(..)) && args(cn.com.jldata.solrdemo.domain.Article)")//
    public void insertArticle() {}
    @After("cn.com.jldata.solrdemo.config.SolrIndexDemoAspect.insertArticle() && args(article)")
    public void afterInsertArticle(Article article) throws Throwable {
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
    public void afterdeleteArticle(Integer id) throws Throwable {
        System.out.println(id);
        solrClientDemo.deleteById(String.valueOf(id));
        solrClientDemo.commit();
    }

    @Pointcut("execution(* cn.com.jldata.solrdemo.mapper.ArticleMapper.update*(..)) && args(cn.com.jldata.solrdemo.domain.Article)")//
    public void updateArticle() {}
    @After("cn.com.jldata.solrdemo.config.SolrIndexDemoAspect.updateArticle() && args(article)")
    public void afterUpdateArticle(Article article) throws Throwable {
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
