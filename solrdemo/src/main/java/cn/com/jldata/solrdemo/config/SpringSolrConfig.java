package cn.com.jldata.solrdemo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSolrConfig {

    @Bean("solrClient")
    public SolrClient solrClient () {

        CoreContainer coreContainer = CoreContainer.createAndLoad("D://test//solrcore//core1");
        coreContainer
        EmbeddedSolrServer client =    EmbeddedSolrServer( coreContainer, "");
    }
}
