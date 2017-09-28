package cn.com.jldata.solrdemo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.core.CoreContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class SpringSolrConfig {

    private String solrServerUrl ="http://localhost:8983/solr/";

    @Bean("solrClientDemo")
    public SolrClient solrClientDemo() {
        String urlString = solrServerUrl+"mysolrcore";
        SolrClient solr = new HttpSolrClient.Builder(urlString).build();
        return solr;
    }
}
