package com.kulongtai.search.s.service;

import com.kulongtai.search.s.model.Article;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Title: XuningService
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/4 16:46
 */
@Service
public class XuningService {

	@Autowired
	private SolrClient solrClient;
	public void reIndexall() throws Exception{
		solrClient.optimize();
	}

	public void rmIndexAll() throws Exception{
		solrClient.deleteByQuery("*:*");
		solrClient.optimize();
	}

	public void update(Article article)throws Exception {
		SolrInputDocument solrInputDocument =new SolrInputDocument();
		solrInputDocument.addField("id",String.valueOf(article.getId()));
		solrInputDocument.addField("title",article.getTitle());
		solrInputDocument.addField("content",article.getContent());
		solrInputDocument.addField("filenames",article.getFilenames());
		solrInputDocument.addField("remark",article.getRemark());
		solrInputDocument.addField("type",article.getType());
		solrInputDocument.addField("create_date",article.getCreate_date());
		solrClient.add(solrInputDocument);
		solrClient.commit();
	}

	public void delete(String id) throws Exception {
		solrClient.deleteById(id);
	}

	public void create(Article article) throws Exception{
		SolrInputDocument solrInputDocument =new SolrInputDocument();
		solrInputDocument.addField("id",String.valueOf(article.getId()));
		solrInputDocument.addField("title",article.getTitle());
		solrInputDocument.addField("content",article.getContent());
		solrInputDocument.addField("filenames",article.getFilenames());
		solrInputDocument.addField("remark",article.getRemark());
		solrInputDocument.addField("type",article.getType());
		solrInputDocument.addField("create_date",article.getCreate_date());
		solrClient.add(solrInputDocument);
		solrClient.commit();
	}

	public Article findOne(String id) throws Exception{
		Article article =new Article();
		SolrDocument solrDocument = solrClient.getById(id);
		article.setId((String)solrDocument.getFieldValue("id"));
		article.setContent((String)solrDocument.getFieldValue("content"));
		article.setCreate_date((Date)solrDocument.getFieldValue("create_date"));
		article.setRemark((String)solrDocument.getFieldValue("remark"));
		article.setType((String)solrDocument.getFieldValue("type"));
		Collection<Object> filenames =  solrDocument.getFieldValues("filenames");
		if(filenames!=null){
			article.setFilenames(filenames.stream().map(v->{return String.valueOf(v); }).collect(Collectors.toList()));
		}
		return article;
	}

	public Page<Article> search(String q, Pageable pageable) throws Exception{
		Page<Article> result = null;
		SolrQuery query = new SolrQuery();
		//设置搜索域
		String word ="*";
		if(!StringUtils.isEmpty(q)){
			word = buildQuery(q);   //构造搜索条件
		}
		query.setQuery(word);
		query.setStart(pageable.getPageNumber()*pageable.getPageSize()); //开始位置
		query.setRows(pageable.getPageSize());  //取出记录数
		query.setHighlight(true);  //是否输出高亮
		query.addHighlightField("content").addHighlightField("title").addHighlightField("desc");
		query.setHighlightFragsize(300); //高亮单片段长度
		query.setHighlightSnippets(1);  //高亮片段个数
		query.setHighlightSimplePre("<em>"); // 高亮包裹html标签
		query.setHighlightSimplePost("</em>");
		QueryResponse qr = solrClient.query(query);  //调用搜索查询服务

		int qt = qr.getQTime();
		System.out.println("搜索用时:" + qt + "毫秒");
		SolrDocumentList sdl = qr.getResults();
		Map<String, Map<String, List<String>>> highlighting = qr.getHighlighting();//获取高亮数据
		List<Article> list = new ArrayList<>();
		for (SolrDocument doc : sdl) {
			Article a = new Article();
			String id  =String.valueOf(doc.get("id"));
			List<String> contents = highlighting.get(id).get("content");
			List<String> titles = highlighting.get(id).get("title");
			List<String> descs = highlighting.get(id).get("desc");
			a.setId(id);
			a.setContent((contents!=null&&contents.size()>0)?listToString(contents):(String)doc.get("content"));
			a.setType((String)doc.get("type"));
			a.setTitle((titles!=null&&titles.size()>0)?listToString(titles):(String)doc.get("title"));
			a.setRemark(descs!=null&&descs.size()>0?listToString(descs):(String)doc.get("remark"));
			a.setCreate_date((Date) doc.get("create_date"));
			if(doc.getFieldValues("filenames")!=null){
				a.setFilenames(doc.getFieldValues("filenames").stream().map(v-> String.valueOf(v)).collect(
						Collectors.toList()));
			}
			list.add(a);
		}
		result = new SolrResultPage<Article>(list,pageable,sdl.getNumFound(),null);
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
		String splitWord = s;
		q.append("(content:" + splitWord + ")");
		q.append(" OR ");
		q.append("(title:" + splitWord + ")");
		q.append(" OR ");
		q.append("(id:" + s + ")");

		return q.toString();
	}
}
