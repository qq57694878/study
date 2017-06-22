package com.ljl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/20.
 */
public class FilterUnInvoice {

    public static void main(String[] args) {

        String s1="站内信\n" +
                "工作请示单\n" +
                "工作日报\n" +
                "工作周报\n" +
                "工作月报\n" +
                "\n" +
                "公告\n" +
                "通知\n" +
                "用印申请单\n" +
                "公章外借申请单\n" +
                "证照使用申请单\n" +
                "业务招待申请单\n" +
                "名片申请单\n" +
                "派车单\n" +
                "礼品申请单\n" +
                "物品请购单\n" +
                "资产、办公用品领用单\n" +
                "资产维修申请单\n" +
                "\n" +
                "\n" +
                "会议纪要\n" +
                "IT服务申请\n" +
                "\n" +
                "员工晋升申请\n" +
                "人员增补申请表\n" +
                "人事调整申请单\n" +
                "离职交接申请单\n" +
                "招聘录用申请单\n" +
                "转正申请单\n" +
                "\n" +
                "\n" +
                "加班申请单\n" +
                "出差申请单\n" +
                "请假申请单\n" +
                "调休申请单\n" +
                "补打卡申请单\n" +
                "外出申请单\n" +
                "薪酬调整申请表\n" +
                "\n" +
                "报销申请单\n" +
                "付款申请单\n" +
                "开票申请单\n";

        String s2="站内信\n" +
                "公告\n" +
                "通知\n" +
                "待办中心\n" +
                "工作请示单\n" +
                "名片申请单\n" +
                "会议纪要\n" +
                "证照使用申请单\n" +
                "IT服务申请\n" +
                "礼品申请单\n" +
                "联络单\n" +
                "资产、办公用品领用单\n" +
                "公章外借申请单\n" +
                "快递申请单\n" +
                "资产验收单\n" +
                "资产报废申请单\n" +
                "资产维修申请单\n" +
                "外出申请单\n" +
                "请假申请单\n" +
                "出差申请单\n" +
                "加班申请单\n" +
                "调休申请单\n" +
                "补打卡申请单\n" +
                "出差通知单\n" +
                "开票申请单\n" +
                "派车单\n" +
                "业务招待申请单\n" +
                "员工住宿申请表\n" +
                "员工解聘申请单\n" +
                "离职申请单\n" +
                "离职交接申请单\n" +
                "转正申请单\n" +
                "招骋需求申请单\n" +
                "薪酬调整申请表\n" +
                "招聘录用申请单\n" +
                "员工晋升申请\n" +
                "人事调整申请单\n" +
                "人员增补申请表\n" +
                "用印申请单\n" +
                "报销申请单\n" +
                "付款申请单\n" +
                "备用金申请单\n" +
                "日常费用报销申请\n" +
                "发票入账申请\n" +
                "采购申请单\n" +
                "物品申领单\n" +
                "物品请购单\n" +
                "工作日报\n" +
                "工作周报\n" +
                "工作月报\n";
        Map<String,String>m1 = mkMap(s1);
        Map<String,String>m2 = mkMap(s2);
       for(String key:m2.keySet()){
           if(!m1.containsKey(key)){
               System.out.println(key+'\t'+'F');
           }
           else
           {
               System.out.println(key+'\t'+'Y');
           }
       }

    }
    public static Map<String,String> mkMap(String s){
        String[] ss = s.split("\n");
        Map<String,String> result = new LinkedHashMap<String,String>();
        for(String s1:ss){
            if(s1.trim().length()>0){
                result.put(s1,s1);
            }else{

            }
        }
        return result;
    }

}
