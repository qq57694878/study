package cn.com.jldata.solrdemo.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

public class TestIKAnalyzer {
    public static void main(String[] args){
        //构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true);

        //获取Lucene的TokenStream对象
        TokenStream ts = null;
        try {
            ts = analyzer.tokenStream("myfield", new StringReader("我爱你我的祖国 hello world!"));
            //获取词元位置属性
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //获取词元文本属性
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            //获取词元文本属性
            TypeAttribute type = ts.addAttribute(TypeAttribute.class);


            //重置TokenStream（重置StringReader）
            ts.reset();
            //迭代获取分词结果
            StringBuilder sb = new StringBuilder();
            while (ts.incrementToken()) {
               // System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + term.toString() + " | " + type.type());
                sb.append(term.toString()).append(" ");
            }
            //关闭TokenStream（关闭StringReader）
            ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放TokenStream的所有资源
            if(ts != null){
                try {
                    ts.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
