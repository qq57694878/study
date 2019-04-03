package com.ljl.algorithm;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by zejian on 2017/6/21.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class FilesClassLoader extends ClassLoader {
	private String rootDir;

    public FilesClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    /**
     * 编写findClass方法的逻辑
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 编写获取class文件并转换为字节码流的逻辑
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 类文件的完全路径
     * @param className
     * @return
     */
    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String rootDir="F:\\ideaworkspace\\w\\aigs\\aigs-wechat\\target\\classes\\";
        String classPackage="cn.com.jldata.aigs.wechat.controller";
        //创建自定义文件类加载器
        FilesClassLoader loader = new FilesClassLoader(rootDir);
        StringBuilder sb = new StringBuilder();
        Arrays.asList(classPackage.split("\\.")).forEach(item->{sb.append(item).append("\\");});
        try {
            File toot = new File(rootDir+sb.toString());
           String[] fileNames =  toot.list(new FilenameFilter() {
                @Override public boolean accept(File dir, String name) {
                  if(name.split("\\.")[1].equals("class"))  return true;
                    return false;
                }
            });
            //加载指定的class文件
            for (int i = 0; i <fileNames.length ; i++) {
                Class<?> c=loader.loadClass(classPackage+"."+fileNames[i].split("\\.")[0]);
                String aa[]=c.getName().split("\\.");
                System.out.println(aa[aa.length-1]);

//               for(Method m:c.getMethods()) {
//                   System.out.println(c.getSimpleName()+"."+m.getName());
//               }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void test1(String[] args) throws ClassNotFoundException {
        String rootDir="F:\\ideaworkspace\\m\\study\\springstudy\\base\\target\\classes\\";
        //创建自定义文件类加载器
        FilesClassLoader loader = new FilesClassLoader(rootDir);

        try {
            //加载指定的class文件
            Class<?> object1=loader.loadClass("com.ljl.algorithm.DemoObj");
            System.out.println(object1.getConstructor(String.class).newInstance("1111"));

            //输出结果:I am DemoObj
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
