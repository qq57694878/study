package com.kulongtai.search.s.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Title: SolrConfig
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/4 16:41
 */
@Configuration
public class SolrConfig {
	@Value("${solr.host}")
	private String solrHost;
	@Bean("solrClient")
	public SolrClient solrClientXuning() {
		String urlString = solrHost+"/xuning";
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();
		return solr;
	}
}
