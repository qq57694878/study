package com.ljl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jinliang on 2017/4/14.
 */
public class Main3 {
    public static void main(String[] args) {
        a();
    }
    public static void a(){
          String s="#{V_TB_SP_D_TYPE_ID,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_TB_SP_TYPE_ID,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{V_TB_SP_MTYPE,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_TS_PP_INFO_ID,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_BANAME,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_TS_SP_NAME,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{V_TS_SP_ENAME,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008343,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_TS_SP_XH,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_TS_SP_GG,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008363,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008347,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008348,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{V_10008349,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008344,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{V_10008345,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008365,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{V_10008346,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_TS_SP_BZ_QX,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008350,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008351 ,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008352,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{V_TS_SP_BZ,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_TS_SP_XSJ,mode=IN,jdbcType=NUMERIC},\n" +
                  "\t\t\t\t#{ V_10008353,mode=IN,jdbcType=NUMERIC},\n" +
                  "\t\t\t\t#{V_10008354,mode=IN,jdbcType=NUMERIC},\n" +
                  "\t\t\t\t#{ V_10008364,mode=IN,jdbcType=NUMERIC},\n" +
                  "\t\t\t\t #{V_10008355,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008356,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008357,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008358,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008359,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008360,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{ V_10008361,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t#{V_10008362,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{v_BANO,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{ v_TS_SP_ABC,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{v_TS_SP_DISCOUNT,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{v_TS_SP_QY,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008690,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008698,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008691,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{V_10008697,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{topywid,mode=IN,jdbcType=VARCHAR},\n" +
                  "\t\t\t\t #{cuserid,mode=IN,jdbcType=VARCHAR}";
           s = s.replaceAll("[\t]","").replace(' ','%').replaceAll("%","");
            System.out.println(s);


        Pattern pattern = Pattern.compile("^#\\{(\\w+),(\\w+),(\\w+)\\}$");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(1);
            System.out.println(matcher.group(1));
        }

    }
}
