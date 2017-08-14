package com.ljl.section1_6;

/**
 * Created by Administrator on 2017/8/7/007.
 */
public class Main1 {
    public static void main(String[] args) {
        String s="spring-aop\n" +
                "spring-aspects\n" +
                "spring-beans\n" +
                "spring-context\n" +
                "spring-context-support\n" +
                "spring-core\n" +
                "spring-expression\n" +
                "spring-instrument\n" +
                "spring-instrument-tomcat\n" +
                "spring-jdbc\n" +
                "spring-jms\n" +
                "spring-messaging\n" +
                "spring-orm\n" +
                "spring-oxm\n" +
                "spring-test\n" +
                "spring-tx\n" +
                "spring-web\n" +
                "spring-webmvc\n" +
                "spring-webmvc-portlet\n" +
                "spring-websocket\n";
        StringBuilder sb = new StringBuilder();
        String s1= "  <dependency>\n" +
                "    <groupId>org.springframework</groupId>\n" +
                "    <artifactId>%s</artifactId>\n" +
                "  </dependency>\n";
       String ss[]= s.split("\n");
        for (String s2:ss) {
            if(s2.length()>0){
                sb.append(String.format(s1, s2));
            }
        }
        System.out.println(sb.toString());
    }
}
