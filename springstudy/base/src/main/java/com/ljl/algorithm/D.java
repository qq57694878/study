package com.ljl.algorithm;

import java.io.File;

/**
 * Title: D
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/3/27 16:12
 */
public class D {
	public static void main(String[] args) {
	/*	File root = new File("F:\\w\\xcx\\pgsWeChat\\pgsWeChat\\page");
		listFiles(root,0);*/
		File root = new File("F:\\w\\xcx\\pgsWeChat\\pgsWeChat\\utils");
		listFiles(root,0);
	}

	public static void listFiles(File root,int black){
		black++;
		File[] fs = root.listFiles();
		for(File f:fs){
			System.out.println(getBlackStr(black)+f.getName());
			if(f.isDirectory()){
				//System.out.println(getBlackStr(black)+f.getName());
				listFiles(f,black);
		   }else{

		   }
		}
	}
	public static String getBlackStr(int i){
		StringBuilder sb = new StringBuilder();
		while(i-->0){
			sb.append("\t");
		}
		return sb.toString();
	}
}
