package com.ljl.section7;

import com.ljl.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * Created by Administrator on 2017/8/11/011.
 */
public class Main extends TestBase{
    @Autowired
    private InitBean initBean;
    @Autowired
    private InitBeanAnotation initBeanAnotation;
    @Autowired
    private InitBeanXml initBeanXml;
    @Autowired
    private InitBeanDefault initBeanDefault;
    @Autowired
    private SelectBean selectBean;
    @Test
    public void testInitBean(){
        initBean.sayHelle();
    }
    @Test
    public void testInitBeanAnotation(){
        initBeanAnotation.sayHelle();
    }
    @Test
    public void testInitBeanXml(){
        initBeanXml.sayHelle();
    }
    @Test
    public void testInitBeanDefault(){
        initBeanDefault.sayHello();
    }
    @Test
    public void testCreateFile(){
        File p = new File("E:\\programe");
        for (int i = 0; i < 6; i++) {
            File f = new File(p,""+i);
            if(!f.exists()){
                f.mkdir();
            }
        }
    }
    @Test
    public void testWirteFile() throws IOException {
        File f = new File("E:\\programe\\3\\1.txt");
        StringBuilder sb = new StringBuilder();
        sb.append("nia33333333  银帆").append("\r\n");
        sb.append("mmm604511  银帆滨").append("\r\n");
        sb.append("annan5643  安娜").append("\r\n");
        sb.append("skk7778  戏子").append("\r\n");
        sb.append("mm518fafafa  雨萌").append("\r\n");
        sb.append("W511314K  开发区香香").append("\r\n");
        sb.append("waini7673  千秋陵").append("\r\n");
        sb.append("ACE86869696  新人淼淼和平").append("\r\n");
        sb.append("N2211126  子凡").append("\r\n");
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write(sb.toString());
        writer.close();
    }
@Test
    public void testSelectBean(){
        selectBean.sayHello();;
        selectBean.sayHello1();
    }
}
