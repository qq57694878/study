package ljl.tem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/2.
 */
public class A {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\s*constraint\\s+)(\\w+)(\\s+check\\s+\\(.*)");
        Matcher m = p.matcher("  1    constraint CKC_BEGIN_TIME_TYPE_DISCOUNT check (BEGIN_TIME_TYPE in (1,2)),");
        System.out.println(m.matches());
    }
    public void test1(){
        String s="";
        String[]array = new String[]{"",""};
        Pattern p = Pattern.compile("[0123456789]");
        Matcher m = p.matcher(s);
        StringBuffer sb = new StringBuffer();


    }

}
