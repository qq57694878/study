package ljl.generator;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/8/008.
 */
public class Mybatis3Generator {
    public static void main(String[] args) throws Exception {
        //generateJavaFiles("/generator/demoGeneratorConfig.xml");
    }



/*
    public static void generateJavaFiles(String configFile) throws Exception {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(Mybatis3Generator.class.getResourceAsStream(configFile));

        DefaultShellCallback shellCallback = new DefaultShellCallback(true);

        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
        myBatisGenerator.generate(null, null, null, true);
        List<GeneratedXmlFile> xmlFiles = myBatisGenerator.getGeneratedXmlFiles();
        List<GeneratedJavaFile> javaFiles =  myBatisGenerator.getGeneratedJavaFiles();
    }*/
}
