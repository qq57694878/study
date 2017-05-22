package com.ljl.tem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/19.
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(isNum("111"));
        System.out.println(isNum("8880.1"));
    }
    public static boolean isNum(String str){
        if(str!=null&&str.length()>0){
            Pattern pattern = Pattern.compile("^[0-9]+(\\.[0-9]+)*$");
            Matcher isNum = pattern.matcher(str);
            if( !isNum.matches() ) {
                return false;
            }
        }
        return true;
    }
}
