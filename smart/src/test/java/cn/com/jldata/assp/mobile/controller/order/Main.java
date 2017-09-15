package cn.com.jldata.assp.mobile.controller.order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class Main {
  /*  public static void main(String[] args) throws Exception {
        // 重新生成参数list
        String paramJsonStr = readJsonFile("F:/ideaworkspace/assp/assp-parent/assp-web-s/src/main/java/cn/com/jldata/assp/mobile/controller/order/param.json");
        Map paramMapList = JSON.parseObject(paramJsonStr, Map.class);
        String orderId = String.valueOf(paramMapList.get("orderId"));
        JSONArray finishPlanList =  (JSONArray)paramMapList.get("finishPlanList");
        if(finishPlanList!=null){
            for(int i=0;i<finishPlanList.size();i++){
                JSONObject jsonObject =  finishPlanList.getJSONObject(i);
            }
        }

        System.out.println(paramMapList);
        FinishPlanParamBean bean = JSON.parseObject(paramJsonStr,FinishPlanParamBean.class);
        System.out.println(bean);
        Timestamp t =  new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(t)); ;

    }
    public static String readJsonFile(String filePath){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String s="";
            while((s=reader.readLine())!=null){
                sb.append(s).append("\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return sb.toString();
    }

    static class FinishPlanParamBean{
        private String orderId;
        private List<SOrderDetailInfo> finishPlanList;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if(finishPlanList!=null){
                for(SOrderDetailInfo info:finishPlanList){
                    sb.append("{ mCode:"+info.getmCode()
                            +",orderDetailRemark:"+info.getOrderDetailRemark()
                            +",orderDetailUrl:"+info.getOrderDetailUrl()
                            +",orderDetailUrl1:"+info.getOrderDetailUrl1()
                            +",orderDetailUrl2:"+info.getOrderDetailUrl2()
                            +",orderDetailUrl3:"+info.getOrderDetailUrl3()
                            +",orderDetailUrl4:"+info.getOrderDetailUrl4()
                            +"}");
                }
            }

            return "FinishPlanParamInfo{" +
                    "orderId='" + orderId + '\'' +
                    ", finishPlanList=[" +
                    sb.toString()
                    +
                    "}";
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public List<SOrderDetailInfo> getFinishPlanList() {
            return finishPlanList;
        }

        public void setFinishPlanList(List<SOrderDetailInfo> finishPlanList) {
            this.finishPlanList = finishPlanList;
        }
    }*/
}
