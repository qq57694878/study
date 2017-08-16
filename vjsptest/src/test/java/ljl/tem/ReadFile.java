package ljl.tem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/2.
 */
public class ReadFile {
    public static void main(String[] args) throws Exception{
b();
    }
    public static void a()throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\ideaWorkspace\\svn_background\\vjspdemo\\src\\test\\resources\\123.sql")));
        String s=null;
        Pattern p = Pattern.compile("(\\s*constraint\\s+)(\\w+)(\\s+check\\s+\\(.*)(,)");
        StringBuffer sb = new StringBuffer();
        while((s=reader.readLine())!=null){
            //"      constraint CKC_OPER_TYPE_ORD_PART1 check (OPER_TYPE is null or (OPER_TYPE in ('1000','1100','1200'))),"
            Matcher m =   p.matcher(s);
            if( m.matches()){
                String constraint1 = m.group(2);
                String s1 = m.group(4);//m.group(1)+constraint1+"_1"+m.group(3);
                sb.append(s1);
            }else{

                sb.append(s);
            }
            sb.append("\r\n");

        }
        FileWriter writer = new FileWriter("C:\\123.sql");
        writer.write(sb.toString());
        reader.close();
        writer.close();
    }
    public static void b()throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\ideaWorkspace\\svn_background\\vjspdemo\\src\\test\\resources\\123.sql")));//11111111111.pdc
        String s=null;
        Pattern p = Pattern.compile("create table (\\w+)");
        StringBuffer sb = new StringBuffer();
        int count =0;
        while((s=reader.readLine())!=null){
            //"      constraint CKC_OPER_TYPE_ORD_PART1 check (OPER_TYPE is null or (OPER_TYPE in ('1000','1100','1200'))),"
            Matcher m =   p.matcher(s);
            if( m.matches()){
                String constraint1 = m.group(1);
                String s1 = m.group(1);//m.group(1)+constraint1+"_1"+m.group(3);
                sb.append(s1);
                sb.append("\r\n");
                count++;
            }

        }
        System.out.println(sb.toString());
        System.out.println(count);
    }
}
