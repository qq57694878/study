package com.ljl.importsp.import1;

import java.util.HashMap;
import java.util.Map;


public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Map<String,Map<String,String>>codeTable=new HashMap<String,Map<String,String>>();
		 Map<String,String> m1 = new HashMap<String,String>();
		 m1.put("非转基因", "0");
		 m1.put("转基因", "1");
		 m1.put("0", "0");
		 m1.put("1", "1");
		 codeTable.put("V_10008702", m1);//转基因产品标识(国检)
		 
		 Map<String,String> m2 = new HashMap<String,String>();
		 m2.put("非限制", "0");
		 m2.put("限制", "1");
		 m2.put("0", "0");
		 m2.put("1", "1");
		 codeTable.put("V_10008705", m2);//限制类商品标志(国检)
		 
		 Map<String,String> m3 = new HashMap<String,String>();
		 m3.put("允许进境", "0");
		 m3.put("禁止进境", "1");
		 m3.put("0", "0");
		 m3.put("1", "1");
		 codeTable.put("V_10008709", m3);//是否禁止进境物标识(国检)
		 
		 
		 Map<String,String> m4 = new HashMap<String,String>();
		 m4.put("直邮", "0");
		 m4.put("保税", "1");
		 m4.put("0", "0");
		 m4.put("1", "1");
		 codeTable.put("V_10010000", m4);//业务类型(国检|扩展1)

  
	}

}
