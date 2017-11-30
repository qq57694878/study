package cn.com.jldata.solrdemo.common.util;

import org.apache.lucene.analysis.Analyzer;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

public class SearchUtil {
	public static String splitWord(String word) {
		return splitWord(word,true);
	}
	public static String splitWord(String word,boolean f) {

		StringBuilder result = new StringBuilder();

		//构建IK分词器，使用smart分词模式
		Analyzer analyzer = new IKAnalyzer(f);

		//获取Lucene的TokenStream对象
		TokenStream ts = null;
		try {
			ts = analyzer.tokenStream("myfield", new StringReader(word));
			//获取词元位置属性
			OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
			//获取词元文本属性
			TypeAttribute type = ts.addAttribute(TypeAttribute.class);
			//获取词元文本属性
			CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);

			//重置TokenStream（重置StringReader）
			ts.reset();
			//迭代获取分词结果
			while (ts.incrementToken()) {
				//System.out.println(offset.startOffset() + " - " + offset.endOffset() + " : " + term.toString() + " | " + type.type());
				result.append(term.toString()).append(" ");
			}
			//关闭TokenStream（关闭StringReader）
			ts.end();   // Perform end-of-stream operations, e.g. set the final offset.

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//释放TokenStream的所有资源
			if (ts != null) {
				try {
					ts.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result.toString();
	}


	/*public static String splitKeyWord(String testString){
		StringBuffer sb = new StringBuffer();
		IKAnalyzer analyzer = new IKAnalyzer(true);
		StringReader r = new StringReader(testString);
		TokenStream tokenstream = analyzer.tokenStream("", r);
		tokenstream.
		Token t;
		try {
			while ((t = tokenstream.next()) != null) {
				sb.append(t.termText()).append(" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	//System.out.println(testString + " >>> " + sb.toString());
		return sb.toString();
	}
	public static String splitKeyWord1(String testString){
		StringBuffer sb = new StringBuffer();
		IKAnalyzer analyzer = new IKAnalyzer(false);
		StringReader r = new StringReader(testString);
		TokenStream tokenstream = analyzer.tokenStream("", r);
		Token t;
		try {
			while ((t = tokenstream.next()) != null) {
				sb.append(t.termText()).append(" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	//System.out.println(testString + " >>> " + sb.toString());
		return sb.toString();
	}*/
	public static void main(String[] args) {
		//String s  =SearchUtil.splitWord("这是一个中文分词的例子，你可以直接运行它！IKAnalyer can analysis english text too");
		String s  =SearchUtil.splitWord("因为年后");
		System.out.println(s);
	}

}
