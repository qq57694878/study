package cn.com.jldata.search.spmsearch.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

@Configuration
public class SpringSolrConfig {

    @Value("${solr.serverurl}")
    private String solrServerUrl;

    @Bean("solrClientDemo")
    public SolrClient solrClientDemo() {
        String urlString = solrServerUrl+"spm_attachment";
        SolrClient solr = new HttpSolrClient.Builder(urlString).build();
        return solr;
    }
}
