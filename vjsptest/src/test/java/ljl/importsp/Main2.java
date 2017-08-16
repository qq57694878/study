package ljl.importsp;

/**
 * Created by Administrator on 2017/4/13.
 */
public class Main2 {
    public static void  main(String[]args){
        String s1 = "A,B,"
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
        /*******************修改2017-04-14**********************/
        String s2 ="A,B,C,V_TB_SP_D_TYPE_ID,E,V_TB_SP_TYPE_ID,G,V_TB_SP_MTYPE,v_BANO,V_SPU,K,L,V_TS_PP_INFO_ID,V_BANAME,V_TS_SP_NAME,V_TS_SP_ENAME,V_10008343,V_TS_SP_XH,V_TS_SP_GG,V_scd,V_10008363,V_10008347,V_10008348,V_10008349,V_10008344,V_10008345,V_10008365,V_10008346,V_10012023,V_TS_SP_BZ_QX,V_10008350,V_10008351,V_10008352,AF,V_TS_SP_BZ,V_TS_SP_XSJ,V_10008353,V_10008354,V_10008364,V_10008355,V_10008356,V_10008357,V_10008358,V_10008359,V_10008360,V_10008361,V_10008362,v_TS_SP_ABC,v_TS_SP_DISCOUNT,v_TS_SP_QY,V_10008690,V_10008698,V_10008691,V_10008697,V_10008367,V_10008684,V_10008686,V_10008689,V_10008889,V_10012144,V_10009893,V_10008792,V_10009894,V_10008701,V_10008366,V_10008369,V_10008368,V_10008692,V_10008693,V_10008694,V_10008695,V_10008699,V_10008700,V_10008702,V_10008703,V_10008704,V_10008705,V_10008706,V_10008707,V_10008708,V_10008709,V_10010000,V_10012192";
        String[] ss1 = s1.split(",");
        String[] ss2 = s2.split(",");
        for(int i=0;i<ss1.length;i++){
            String a2 = ss2[i];
            if (i>27){
                a2 =ss2[i+1];
            }
            String a1= ss1[i];
            a1 =a1.trim();
            a2 =a2.trim();
            if(a1.compareTo(a2)!=0){
                System.out.println(a1+":"+a2);
            }
        }
        System.out.println(ss2[28]);
    }
}
