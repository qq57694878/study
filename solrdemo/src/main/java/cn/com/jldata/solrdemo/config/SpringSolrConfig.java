package cn.com.jldata.solrdemo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.core.CoreContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.File;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Configuration
public class SpringSolrConfig {

    @Value("${solr.homepath}")
    private String solrHomePath;
    @Value("${solr.serverurl}")
    private String solrServerUrl;

    @Bean("solrClientDemo")
    public SolrClient solrClientDemo() {
        String urlString = solrServerUrl+"mysolrcore";
        SolrClient solr = new HttpSolrClient.Builder(urlString).build();
        return solr;
    }
    @Bean("solrClientEmbed")
    public SolrClient solrClientEmbed() {
        Path SOLR_HOME =getFile(solrHomePath).toPath().toAbsolutePath();
        System.setProperty("solr.solr.home", SOLR_HOME.toString());
      //  Path SOLR_HOME = FileSystems.getDefault().getPath(solrHomePath);
        CoreContainer cores = CoreContainer.createAndLoad(SOLR_HOME);
      //  CoreContainer cores = new CoreContainer(SOLR_HOME.toString());//CoreContainer.createAndLoad(SOLR_HOME,  SOLR_HOME.resolve("solr.xml"));

        return new EmbeddedSolrServer(cores, "mysolrcore");
    }



    public static File getFile(String name) {
        final URL url = SpringSolrConfig.class.getClassLoader().getResource(name.replace(File.separatorChar, '/'));
        if (url != null) {
            try {
                return new File(url.toURI());
            } catch (Exception e) {
                throw new RuntimeException("Resource was found on classpath, but cannot be resolved to a " +
                        "normal file (maybe it is part of a JAR file): " + name);
            }
        }
        final File file = new File(name);
        if (file.exists()) {
            return file;
        }
        throw new RuntimeException("Cannot find resource in classpath or in file-system (relative to CWD): " + name);
    }


}
