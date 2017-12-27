package cn.com.jldata.search.spmsearch.controller;

public class CreateData {
public static String s=".doc\tapplication/msword\n" +
        ".dot\tapplication/msword\n" +
        ".docx\tapplication/vnd.openxmlformats-officedocument.wordprocessingml.document\n" +
        ".dotx\tapplication/vnd.openxmlformats-officedocument.wordprocessingml.template\n" +
        ".docm\tapplication/vnd.ms-word.document.macroEnabled.12\n" +
        ".dotm\tapplication/vnd.ms-word.template.macroEnabled.12\n" +
        ".xls\tapplication/vnd.ms-excel\n" +
        ".xlt\tapplication/vnd.ms-excel\n" +
        ".xla\tapplication/vnd.ms-excel\n" +
        ".xlsx\tapplication/vnd.openxmlformats-officedocument.spreadsheetml.sheet\n" +
        ".xltx\tapplication/vnd.openxmlformats-officedocument.spreadsheetml.template\n" +
        ".xlsm\tapplication/vnd.ms-excel.sheet.macroEnabled.12\n" +
        ".xltm\tapplication/vnd.ms-excel.template.macroEnabled.12\n" +
        ".xlam\tapplication/vnd.ms-excel.addin.macroEnabled.12\n" +
        ".xlsb\tapplication/vnd.ms-excel.sheet.binary.macroEnabled.12\n" +
        ".ppt\tapplication/vnd.ms-powerpoint\n" +
        ".pot\tapplication/vnd.ms-powerpoint\n" +
        ".pps\tapplication/vnd.ms-powerpoint\n" +
        ".ppa\tapplication/vnd.ms-powerpoint\n" +
        ".pptx\tapplication/vnd.openxmlformats-officedocument.presentationml.presentation\n" +
        ".potx\tapplication/vnd.openxmlformats-officedocument.presentationml.template\n" +
        ".ppsx\tapplication/vnd.openxmlformats-officedocument.presentationml.slideshow\n" +
        ".ppam\tapplication/vnd.ms-powerpoint.addin.macroEnabled.12\n" +
        ".pptm\tapplication/vnd.ms-powerpoint.presentation.macroEnabled.12\n" +
        ".potm\tapplication/vnd.ms-powerpoint.presentation.macroEnabled.12\n" +
        ".ppsm\tapplication/vnd.ms-powerpoint.slideshow.macroEnabled.12";

    public static void main(String[] args) {
       String[] ss = s.split("\n");
       for(String s:ss){
           String[] ss1 =s.split("\t");
           System.out.println("{\""+ss1[0]+"\","+"\""+ss1[1]+"\"},");
       }
    }
}
