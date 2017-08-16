package ljl.importsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
f();
	}
	public static void f(){

		String s =
				"v_10010000,业务类型(国检|扩展1),sg_bszy,业务类型(国检|扩展1)\n"+
				"v_10008367,业务类型(商备),sg_ywlx,业务类型(商备)\n" +
				"v_10008684,申报单位(商备),sg_sbdw,申报单位(商备)\n" +
				"v_10008686,货号(商备),sg_sbhh,货号(商备)\n" +
				"v_10008689,物资序号(商备),sg_wzxh,物资序号(商备)\n" +
				"v_10008889,归并序号,sg_gbxh,归并序号\n" +
				"v_10012144,订单申报单位,djsbdw,订单申报单位\n" +
				"v_10009893,产地-国别(国检&前台),cargoplace,产地(国别)\n" +
				"v_10008792,电商主体备案状态,sg_dsztbazt,电商主体备案状态\n" +
				"v_10009894,商品经营范围区域(311000:上海洋山局本部),busregion\n" +
				"v_10008701,适用标准国别(国家三字码)(国检),sg_sybzgb\n" +
				"v_10008366,申报关区,sg_sbgq\n" +
				"v_10008369,海关一线备案状态(2:通过),sg_hgzt\n" +
				"v_10008368,国检备案状态(0:未备案),sg_gjzt\n" +
				"v_10008692,商品内部货号(国检),sg_spnbhh\n" +
				"v_10008693,第一计量单位(国检),sg_dyjldw\n" +
				"v_10008694,备注(国检),sg_gjbz\n" +
				"v_10008695,商品数量(国检),sg_spslgj\n" +
				"v_10008699,备案单价(国检),sg_badj\n" +
				"v_10008700,第二计量单位(国检),sg_dejldw\n" +
				"v_10008702,转基因产品标识(国检),sg_zjycpbz\n" +
				"v_10008703,商品备案编号(国检),sg_spbabh\n" +
				"v_10008704,商品物资id(国检),sg_spwzid\n" +
				"v_10008705,限制类商品标志(国检),sg_xzlspbz\n" +
				"v_10008706,重点审价标记(国检),sg_zdsjbj\n" +
				"v_10008707,商品单位(国检),sg_spdwgj\n" +
				"v_10008708,生产厂家(国检),sg_sccj\n" +
				"v_10008709,是否禁止进境物标识(国检)0:允许进境,sg_sfjzjjbs\n" +
				"v_10012192,3c证书(国检-扩展2),sg_3czs";
		StringBuffer sb = new StringBuffer();
		String[] ss = s.split("\n");
		int k=0;
		for(int i=0;i<ss.length;i++){
			k++;
			String[] ss1 = ss[i].split(",");
			sb.append(("'"+ss1[2]+"'").toUpperCase());
			if(i!=ss.length-1){
				sb.append(",");
			}
		}
		System.out.println("总字段数："+k);
		System.out.println(sb.toString());

		//生成参数字符串和参数注释
		String template ="\t                                                  ${v}        IN VARCHAR2 DEFAULT NULL, --${comment}\n";
		StringBuffer paramSb = new StringBuffer();
		for(int i=0;i<ss.length;i++){
			String[] ss1 = ss[i].split(",");
			String comment = ss1[1]+","+ss1[2]+" 自";
			paramSb.append(template.replaceAll("\\$\\{v\\}",ss1[0]).replaceAll("\\$\\{comment\\}",comment));
		}

		System.out.println("存储过程参数:");
		System.out.println(paramSb.toString());



		//生成mybatis参数
		String mybatisTempate="\t\t\t\t #{${tt},mode=IN,jdbcType=VARCHAR},\n";
		StringBuffer mybatisParamSb = new StringBuffer();
		for(int i=0;i<ss.length;i++){
			String[] ss1 = ss[i].split(",");
			mybatisParamSb.append(mybatisTempate.replaceAll("\\$\\{tt\\}",ss1[0].toUpperCase()));
		}

		System.out.println("mybatis参数:");
		System.out.println(mybatisParamSb.toString());


		//修改TDY_TS_SP_INFO表语句
		String updateSql = "UPDATE TDY_TS_SP_INFO SET ${set} WHERE TDY_ID = V_TDY_TS_SP_INFO_ID;";
		StringBuffer setSb = new StringBuffer();
		for(int i=0;i<ss.length;i++){
			String[] ss1 = ss[i].split(",");
			setSb.append(ss1[2].toUpperCase()+" = "+ss1[0]);
			if(i!=ss.length-1){
				setSb.append(", ");
			}
		}
		System.out.println("update语句:");
		System.out.println(updateSql.replaceAll("\\$\\{set\\}",setSb.toString()));


		//生成mybatis参数

		StringBuffer columnSb = new StringBuffer();
		for(int i=0;i<ss.length;i++){
			String[] ss1 = ss[i].split(",");
			columnSb.append("'"+ss1[2].toUpperCase()+"'");
			if(i!=ss.length-1){
				columnSb.append(",");
			}
		}

		System.out.println("columnSelect参数:");
		System.out.println(columnSb.toString());
		//生成mybatis参数

		StringBuffer columnSb1 = new StringBuffer();
		for(int i=0;i<ss.length;i++){
			String[] ss1 = ss[i].split(",");
			columnSb1.append(ss1[2].toUpperCase());
			if(i!=ss.length-1){
				columnSb1.append(",");
			}
		}

		System.out.println("columnSelect参数:");
		System.out.println(columnSb1.toString());

	}






/*




	public static void e(){
		String s ="v_10008367 业务类型(商备)     sg_ywlx  业务类型(商备)\n" +
				"v_10008684 申报单位  sg_sbdw   申报单位(商备)\n" +
				"v_10008686  货号    sg_sbhh   货号(商备)\n" +
				"v_10008689  物资序号    sg_wzxh  物资序号(商备)\n" +
				"v_10008697 品牌备案码(国检)    sg_ppbam  品牌备案码(国检)\n" +
				"v_10008889  归并序号    sg_gbxh  归并序号\n" +
				"v_10012144  订单申报单位    djsbdw  订单申报单位\n" +
				"v_10009893  产地-国别(国检&前台)    cargoplace  产地(国别)\n" +
				"v_10008424  备案名称    sg_baname  备案名称\n" +
				"v_10008792  电商主体备案状态    sg_dsztbazt  电商主体备案状态\n" +
				"v_10009894  商品经营范围区域 busregion\n" +
				"v_10008701  适用标准国别(国家三字码)(国检) sg_sybzgb\n" +
				"v_10008366 申报关区 sg_sbgq\n" +
				"v_10008369 海关一线备案状态 sg_hgzt\n" +
				"v_10008368 国检备案状态   sg_gjzt\n" +
				"v_10008692 商品内部货号(国检)    sg_spnbhh\n" +
				"v_10008693 第一计量单位(国检)    sg_dyjldw\n" +
				"v_10008694 备注(国检)    sg_gjbz\n" +
				"v_10008695 商品数量(国检)    sg_spslgj\n" +
				"v_10008699 备案单价(国检)    sg_badj\n" +
				"v_10008700 第二计量单位(国检)    sg_dejldw\n" +
				"v_10008702 转基因产品标识(国检)    sg_zjycpbz\n" +
				"v_10008703 商品备案编号(国检)    sg_spbabh\n" +
				"v_10008704 商品物资id(国检)    sg_spwzid\n" +
				"v_10008705 限制类商品标志(国检)    sg_xzlspbz\n" +
				"v_10008706 重点审价标记(国检)    sg_zdsjbj\n" +
				"v_10008707 商品单位(国检)    sg_spdwgj\n" +
				"v_10008708 生产厂家(国检)    sg_sccj\n" +
				"v_10008709 是否禁止进境物标识(国检)  sg_sfjzjjbs\n" +
				"v_10012192 3c证书(国检-扩展2)    sg_3czs\n";
		s =s.replace(' ','#');
		//s=s.replaceAll("[#]",",");
		StringBuffer sb = new StringBuffer();
		//编译正则表达式到模式对象
		Pattern p= Pattern.compile("(#)+");
//得到匹配器
		Matcher m=p.matcher(s);
//通过find方法查找匹配，找到就返回true，否则返回false

		while(m.find()){
			m.appendReplacement(sb,",");
		}
		m.appendTail(sb);
		System.out.println(sb.toString());

	}*/
    @Test
	public  void d(){
		String columns="A\tB\tC\tV_TB_SP_D_TYPE_ID\tE\tV_TB_SP_TYPE_ID\tG\tV_TB_SP_MTYPE\tv_BANO\tV_SPU\tK\tL\tV_TS_PP_INFO_ID\tV_BANAME\tV_TS_SP_NAME\tV_TS_SP_ENAME\tV_10008343\tV_TS_SP_XH\tV_TS_SP_GG\tV_scd\tV_10008363\tV_10008347\tV_10008348\tV_10008349\tV_10008344\tV_10008345\tV_10008365\tV_10008346\tV_10012023\tV_TS_SP_BZ_QX\tV_10008350\tV_10008351\tV_10008352\tAF\tV_TS_SP_BZ\tV_TS_SP_XSJ\tV_10008353\tV_10008354\tV_10008364\tV_10008355\tV_10008356\tV_10008357\tV_10008358\tV_10008359\tV_10008360\tV_10008361\tV_10008362\tv_TS_SP_ABC\tv_TS_SP_DISCOUNT\tv_TS_SP_QY\tV_10008690\tV_10008698\tV_10008691\tV_10008697\tV_10008367\tV_10008684\tV_10008686\tV_10008689\tV_10008889\tV_10012144\tV_10009893\tV_10008792\tV_10009894\tV_10008701\tV_10008366\tV_10008369\tV_10008368\tV_10008692\tV_10008693\tV_10008694\tV_10008695\tV_10008699\tV_10008700\tV_10008702\tV_10008703\tV_10008704\tV_10008705\tV_10008706\tV_10008707\tV_10008708\tV_10008709\tV_10010000\tV_10012192";
		String cs[]=columns.split("\t");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cs.length;i++){
			sb.append(cs[i].trim()).append(",");
		}
		System.out.println(sb.toString());
	}

	/**
	 */
	public static void a() {
	String EXCEL_COLUMN = "A,B,"
						+ "C,V_TB_SP_D_TYPE_ID ,"
						+ "E,V_TB_SP_TYPE_ID,"
						+ "G,V_TB_SP_MTYPE,"
						+ "v_BANO,V_SPU,K,L,V_TS_PP_INFO_ID,V_BANAME,"
						+ "V_TS_SP_NAME,V_TS_SP_ENAME ,"
						+ "V_10008343, V_TS_SP_XH, V_TS_SP_GG,  V_scd,V_10008363,V_10008347,"
						+ " V_10008348,V_10008349, V_10008344, V_10008345,V_10008365,V_10008346, "
						+ "V_TS_SP_BZ_QX, V_10008350,V_10008351, V_10008352, AF, V_TS_SP_BZ,"
						+ " V_TS_SP_XSJ,  V_10008353,  V_10008354,V_10008364, V_10008355, "
						+ "V_10008356, V_10008357,  V_10008358, V_10008359, V_10008360, V_10008361, V_10008362, v_TS_SP_ABC, v_TS_SP_DISCOUNT,v_TS_SP_QY,"
						+ "V_10008690,V_10008698,V_10008691,V_10008697";
		String[] cs = EXCEL_COLUMN.split(",");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cs.length;i++){
			sb.append(cs[i].trim()).append("\t");
			if(i ==27){
				sb.append("").append("\t");
			}
		}
		System.out.println(sb.toString());
		
	}
	public static void b(){
		String[] cs = columns.split("\t");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<cs.length;i++){
			sb.append(cs[i].trim()).append("\t");
			if(i ==27){
				sb.append("").append("\t");
			}
		}
		System.out.println(sb.toString());
	}

	public static String columns ="A\tB\tC\tV_TB_SP_D_TYPE_ID \tE\tV_TB_SP_TYPE_ID\tG\tV_TB_SP_MTYPE\tv_BANO\tV_SPU\tK\tL\tV_TS_PP_INFO_ID\tV_BANAME\tV_TS_SP_NAME\tV_TS_SP_ENAME \tV_10008343\t V_TS_SP_XH\t V_TS_SP_GG\t  V_scd\tV_10008363\tV_10008347\t V_10008348\tV_10008349\t V_10008344\t V_10008345\tV_10008365\tV_10008346\tAC\t V_TS_SP_BZ_QX\t V_10008350\tV_10008351\t V_10008352\t AF\t V_TS_SP_BZ\t V_TS_SP_XSJ\t  V_10008353\t  V_10008354\tV_10008364\t V_10008355\t V_10008356\t V_10008357\t  V_10008358\t V_10008359\t V_10008360\t V_10008361\t V_10008362\t v_TS_SP_ABC\t v_TS_SP_DISCOUNT\tv_TS_SP_QY\tV_10008690\tV_10008698\tV_10008691\tV_10008697";
	public static void c(){
		String e1 = "A,B,"
		+ "C,V_TB_SP_D_TYPE_ID ,"
		+ "E,V_TB_SP_TYPE_ID,"
		+ "G,V_TB_SP_MTYPE,"  
		+ "v_BANO,V_SPU,K,L,V_TS_PP_INFO_ID,V_BANAME," 
		+ "V_TS_SP_NAME,V_TS_SP_ENAME ," 
		+ "V_10008343, V_TS_SP_XH, V_TS_SP_GG,  V_scd,V_10008363,V_10008347,"  
		+ " V_10008348,V_10008349, V_10008344, V_10008345,V_10008365,V_10008346, "  
		+ "V_TS_SP_BZ_QX, V_10008350,V_10008351, V_10008352, AF, V_TS_SP_BZ,"   
		+ " V_TS_SP_XSJ,  V_10008353,  V_10008354,V_10008364, V_10008355, "  
		+ "V_10008356, V_10008357,  V_10008358, V_10008359, V_10008360, V_10008361, V_10008362, v_TS_SP_ABC, v_TS_SP_DISCOUNT,v_TS_SP_QY,"
		+ "V_10008690,V_10008698,V_10008691,V_10008697";
		String e2 ="A,B,C,V_TB_SP_D_TYPE_ID ,E,V_TB_SP_TYPE_ID,G,V_TB_SP_MTYPE,v_BANO,V_SPU,K,V_TS_PP_INFO_ID,V_BANAME,V_TS_SP_NAME,V_TS_SP_ENAME ,V_10008343,V_TS_SP_XH,V_TS_SP_GG,  V_scd,V_10008363,V_10008347, V_10008348,V_10008349, V_10008344, V_10008345,V_10008365,V_10008367,V_10012023,V_TS_SP_BZ_QX,V_10008350,V_10008351, V_10008352,V_10008680, V_TS_SP_BZ, V_TS_SP_XSJ,  V_10008353,  V_10008354,V_10008364, V_10008355, V_10008356, V_10008357,  V_10008358, V_10008359, V_10008360, V_10008361, V_10008362, v_TS_SP_ABC, v_TS_SP_DISCOUNT,v_TS_SP_QY,V_10008690,V_10008698,V_10008691,V_10008697,V_10009894,V_10008701,V_10008366,V_10008369,V_10008368,V_10008692,V_10008693,V_10008694,V_10008695,V_10008699,V_10008700,V_10008702,V_10008703,V_10008704,V_10008705,V_10008706,V_10008707,V_10008708,V_10008709,BU,V_10012192";
        List<String> list1 = Arrays.asList(e1.split(","));
        trim(list1);
        List<String> list2 = Arrays.asList(e2.split(","));
        trim(list2);
        List<String> r = new ArrayList<String>();
        for(String s:list1){
        	if(!list2.contains(s)){
        		r.add(s);
        	}
        }
        print(r);
	}
	public static String print(List<String> list){
		StringBuilder sb = new StringBuilder();
		if(list!=null){
			for(String s:list){
				sb.append(s).append(",");
			}
			if(sb.length()>0){
				sb.deleteCharAt(sb.length()-1);
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	public static void trim(List<String> list){
		if(list!=null){
			for(int i=0;i<list.size();i++){
			 list.set(i, list.get(i).trim());
			}
		}
	 
	}
	
	
	
}
