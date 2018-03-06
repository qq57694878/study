package com.ljl.vuehttp;

public class InitData {
    public static String[] status=new String[]{"published","draft","deleted"};
    public static void main(String[] args) {
        /*for(int i=1;i<102;i++){

            String sql ="INSERT INTO ARTICLE (ID, TITLE,CONTENT,CREATE_DATE) VALUES (%d, '标题%d','内容%d',PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));";
            System.out.println(  String.format(sql,i,i,i ));
        }*/
        for(int i=1;i<102;i++){

            String sql ="INSERT INTO DOCUMENT (ID, TITLE,AUTHOR,STATUS,PAGEVIEWS,DISPLAY_TIME) VALUES (%d, '标题标题标题标题标题标题标题标题%d','作者%d','%s',%d,PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));";
            System.out.println(  String.format(sql,i,i,i,status[i%3], i*1000));
        }
    }

}
