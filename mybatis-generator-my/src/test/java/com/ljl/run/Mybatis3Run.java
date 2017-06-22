package com.ljl.run;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */

public class Mybatis3Run {

    @Test
    public  void generateJavaFiles() throws Exception {
         generateJavaFiles("/generatorConfig.xml");
    }
    @Test
    public  void generateJavaFilesHgc35() throws Exception {
        generateJavaFiles("/generator_config_hgc_172.17.17.35.xml");
    }

    private void generateJavaFiles(String configFile) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(Mybatis3Run.class.getResourceAsStream(configFile));

        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(null, null, null, true);
        List<GeneratedXmlFile> xmlFiles = myBatisGenerator.getGeneratedXmlFiles();
        List<GeneratedJavaFile> javaFiles =  myBatisGenerator.getGeneratedJavaFiles();
    }
}
