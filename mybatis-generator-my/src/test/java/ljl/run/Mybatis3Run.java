package ljl.run;

import org.junit.Test;

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
    @Test
    public  void generateJavaFilesLocalOracle() throws Exception {
        generateJavaFiles("/localhostoracle.xml");
    }
    @Test
    public  void generateJavaFilesLocalMysql() throws Exception {
        generateJavaFiles("/mysql-generator-config.xml");
    }

    @Test
    public  void generatorMysqlGenerator() throws Exception {
        generateJavaFiles("/mysqlGenerator.xml");
    }

    @Test
    public  void generatorMysqlGeneratorTest() throws Exception {
        generateJavaFiles("/mysqlGeneratortest.xml");
    }

    @Test
    public  void generatorAttachment() throws Exception {
        generateJavaFiles("/attachment_generator.xml");
    }

    @Test
    public  void generatorHelpFile() throws Exception {
        generateJavaFiles("/help_file_generator.xml");
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
