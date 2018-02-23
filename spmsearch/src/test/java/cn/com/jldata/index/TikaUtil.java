package cn.com.jldata.index;

        import org.apache.tika.metadata.Metadata;
        import org.apache.tika.parser.AutoDetectParser;
        import org.apache.tika.parser.ParseContext;
        import org.apache.tika.parser.Parser;
        import org.apache.tika.sax.BodyContentHandler;
        import org.xml.sax.ContentHandler;
        import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: lianan
 * Date: 14-3-3
 * Time: 上午10:05
 * To change this template use File | Settings | File Templates.
 */
public class TikaUtil {
    public static void main(String[] args) {
        //parseFile(new File("F:/download/2017国庆、中秋双节假期值班表.doc"));
        parseFile(new File("F:\\programtool\\tool\\ideaw1\\jeesite\\doc\\6.工作流的应用实例.docx"));
    }

    public static String parseFile(File file) {
        Parser parser = new AutoDetectParser();
        InputStream input = null;
        try {
            Metadata metadata = new Metadata();
            metadata.set(Metadata.CONTENT_ENCODING, "utf-8");
            metadata.set(Metadata.RESOURCE_NAME_KEY, file.getName());
            input = new FileInputStream(file);
            ContentHandler handler = new BodyContentHandler();//当文件大于100000时，new BodyContentHandler(1024*1024*10);
            ParseContext context = new ParseContext();
            context.set(Parser.class, parser);
            parser.parse(input, handler, metadata, context);
            for (String name : metadata.names()) {
                System.out.println(name + ":" + metadata.get(name));
            }
            System.out.println(handler.toString());
            return handler.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }
}