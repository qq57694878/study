package com.ljl.tem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/6/2.
 */
public class Main2 {
    public static void main(String[] args) {
        String s ="+-/\\%？“’@*你好12+-/\\%？“’@*be_* adnHAO你哈德";
        String s1 = filterSpecialChar(s);
        System.out.println(s1);

    }

    public  static String filterSpecialChar1(String s){
        String result="";
        //String regEx="[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
        String regEx="[@%*\\-+‘’\\'“”\"/？?\\\\]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
        result = matcher.replaceAll("");
        return result;
    }

    public  static String filterSpecialChar(String s){
        String result=s;
        char[] specialChars = new char[]{'+','-','/','\\','%','？','“','”','‘','’','@','*','"','\''};
        for(char c: specialChars){
            result = result.replace(c,' ');
        }
        result = result.replaceAll(" ","");
        return result;
    }
}
