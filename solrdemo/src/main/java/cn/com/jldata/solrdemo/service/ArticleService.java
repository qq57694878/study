package cn.com.jldata.solrdemo.service;

import cn.com.jldata.solrdemo.converter.BeanMapper;
import cn.com.jldata.solrdemo.domain.Article;
import cn.com.jldata.solrdemo.mapper.ArticleMapper;
import com.github.pagehelper.Page;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {
    @Autowired
    @Qualifier("solrClientDemo")
    private SolrClient solrClientDemo;
    @Autowired
    private ArticleMapper  articleMapper;

    public int create(Article article) {
       return  articleMapper.insertSelective(article);
    }

    public int delete(Integer id) {
        return  articleMapper.deleteByPrimaryKey(id);
    }

    public int update(Article article) {
        return  articleMapper.updateByPrimaryKeySelective(article);
    }

    public Article findOne(Integer id) {
        return  articleMapper.selectByPrimaryKey(id);
    }

    public Page<Article> findPage(Article article,Page<Article> page) throws Exception {
        Page<Article> result = new Page<Article>();
        SolrQuery query = new SolrQuery();
        query.setStart(page.getPageNum());
        query.setRows(page.getPageSize());
        QueryResponse qr = solrClientDemo.query(query);
        int qt = qr.getQTime();
        System.out.println("搜索用时:"+qt+"毫秒");
        SolrDocumentList sdl = qr.getResults();
        for (SolrDocument doc : sdl) {
           Map<String,Object> m =  doc.getFieldValueMap();
            Article a = new Article();
            BeanMapper beanMapper = new BeanMapper();
            beanMapper.copy(m,a);
            result.add(a);
        }
        return   result;
    }
}
