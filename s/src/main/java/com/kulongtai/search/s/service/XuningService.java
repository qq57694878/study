package com.kulongtai.search.s.service;

import com.kulongtai.search.s.model.Article;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Title: XuningService
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/4 16:46
 */
public class XuningService {
	@Autowired
	@Qualifier("solrClientNuning")
	private SolrClient solrClient;
	public void reIndexall() throws Exception{
		solrClient.optimize();
	}

	public void rmIndexAll() throws Exception{
		solrClient.deleteByQuery("*:*");
		solrClient.optimize();
	}

	public void update(Article article) {
	}

	public void delete(String id) {
	}

	public void create(Article article) {
	}

	public Article findOne(String id) {
		return null;
	}

	public Page<Article> search(String query, Pageable pageable) {
		return null;
	}
}
