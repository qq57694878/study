package ljl.thinking.design.factorymethod;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String s="高级查询\n" +
            "售后单详情\n" +
            "售后单明细\n" +
            "收件验货\n" +
            "订单支付明细\n" +
            "订单配送明细\n" +
            "订单日志\n" +
            "商品明细\n" +
            "申请说明\n" +
            "审核\n" +
            "返件物流信息\n" +
            "收件记录\n" +
            "包裹1\n" +
            "进度详情\n" +
            "售后单号\n" +
            "订单编号\n" +
            "外部订单来源编号\n" +
            "外部售后单号\n" +
            "售后类型\n" +
            "售后单状态\n" +
            "寄回状态\n" +
            "退货配送商\n" +
            "退回物流单号\n" +
            "申请时间\n" +
            "售后完成时间\n" +
            "寄回方式\n" +
            "销售渠道\n" +
            "销售商家\n" +
            "下单会员账号\n" +
            "退货门店\n" +
            "退货自提点\n" +
            "退货地址\n" +
            "商品名称\n" +
            "商品编码\n" +
            "订单收货人手机\n" +
            "订单收货人姓名\n" +
            "售后单编号\n" +
            "售后类型\n" +
            "售后申请时间\n" +
            "售后单状态\n" +
            "寄回方式\n" +
            "寄回状态\n" +
            "订单编号\n" +
            "外部订单号\n" +
            "退货门店\n" +
            "退货地址\n" +
            "下单会员账号\n" +
            "订单收货人手机号\n" +
            "订单收货人姓名\n" +
            "销售渠道\n" +
            "销售商家\n" +
            "售后单详情\n" +
            "售后单号\n" +
            "售后类型\n" +
            "渠道售后单号\n" +
            "售后单申请时间\n" +
            "申请人\n" +
            "申请来源\n" +
            "售后状态\n" +
            "审核时间\n" +
            "客户名称\n" +
            "客户编码\n" +
            "下单会员账号\n" +
            "商家名称\n" +
            "寄回方式\n" +
            "寄回状态\n" +
            "退货门店\n" +
            "退货自提点\n" +
            "订单编号\n" +
            "订单状态\n" +
            "外部订单编号\n" +
            "订单创建时间\n" +
            "订单类型\n" +
            "订单支付状态\n" +
            "订单支付类型\n" +
            "销售渠道\n" +
            "订单收货人手机\n" +
            "订单收货人姓名\n" +
            "订单收货人姓名\n" +
            "售后单完成时间\n" +
            "订单收货地址\n" +
            "商品主图\n" +
            "商品名称\n" +
            "商品编码\n" +
            "规格属性\n" +
            "订购单位\n" +
            "购买数量\n" +
            "购买金额\n" +
            "本次售后申请数量\n" +
            "本次售后商品购买金额\n" +
            "申请退款金额\n" +
            "售后商品税费\n" +
            "收起\n" +
            "展开\n" +
            "售后单类型\n" +
            "售后原因\n" +
            "申请描述\n" +
            "凭证\n" +
            "寄回方式\n" +
            "联系人\n" +
            "联系人手机\n" +
            "取件地址\n" +
            "是否寄回商品\n" +
            "寄回方式\n" +
            "取件地址\n" +
            "取件联系人\n" +
            "联系人手机\n" +
            "选择退货仓\n" +
            "商家收件地址\n" +
            "商家收件人\n" +
            "联系手机\n" +
            "退换货商品金额合计\n" +
            "运费退款金额\n" +
            "商品税费退款金额合计\n" +
            "售后单退款金额合计\n" +
            "补偿金额\n" +
            "审核人备注\n" +
            "附件\n" +
            "运单运费\n" +
            "运费可退金额\n" +
            "商品主图\n" +
            "商品名称\n" +
            "商品编码\n" +
            "规格属性\n" +
            "计件单位\n" +
            "购买数量\n" +
            "购买金额（元）\n" +
            "本次售后申请数量\n" +
            "本次售后商品购买金额\n" +
            "本次售后商品申请退款金额\n" +
            "本次售后商品税费\n" +
            "仓库实际收货数量\n" +
            "实收商品退款金额\n" +
            "收货门店\n" +
            "收货子库存\n" +
            "寄回方式\n" +
            "取件联系人\n" +
            "取件联系人手机\n" +
            "取件地址\n" +
            "售后单类型\n" +
            "验货结果\n" +
            "收件图片\n" +
            "客服验货描述\n" +
            "退货原因\n" +
            "商品实退金额\n" +
            "运费退款金额\n" +
            "售后单退款金额合计\n" +
            "补偿金额\n" +
            "运单运费\n" +
            "运费可退金额\n" +
            "支付方式\n" +
            "支付金额\n" +
            "支付时间\n" +
            "支付流水号\n" +
            "应付金额\n" +
            "已付金额\n" +
            "支付类型\n" +
            "支付状态\n" +
            "订单行号\n" +
            "商品名称\n" +
            "商品编码\n" +
            "规格属性\n" +
            "货号\n" +
            "订购单位\n" +
            "发货数量\n" +
            "发货门店\n" +
            "子库存\n" +
            "包裹ID\n" +
            "交货单号\n" +
            "配送商\n" +
            "配送方式\n" +
            "物流单号\n" +
            "包裹状态\n" +
            "收货人\n" +
            "收货地址\n" +
            "操作时间\n" +
            "操作账号\n" +
            "操作内容\n" +
            "操作账号\n" +
            "操作内容\n" +
            "btn_查询\n" +
            "btn_重置\n" +
            "btn_导出\n" +
            "btn_审核通过\n" +
            "btn_审核不通过\n" +
            "btn_验货通过\n" +
            "btn_验货不通过\n" +
            "btn_返回\n";
    public static void test1() {
       String ss[]=  s.split("\\n");
       List<String> aa = new ArrayList<String>();
       for(int i=0;i<ss.length;i++){
           if(aa.contains(ss[i]))continue;
           aa.add(ss[i].replaceAll("btn_",""));
       }
       for(int i=0;i<aa.size();i++){
           System.out.println(aa.get(i));
       }
    }
    public static String s1="btn_查询\n" +
            "btn_重置\n" +
            "btn_导入\n" +
            "btn_导出\n" +
            "btn_批量发货\n" +
            "btn_发货\n" +
            "高级查询\n" +
            "查询\n" +
            "全选\n" +
            "btn_修改收货信息\n" +
            "btn_确认发货\n" +
            "btn_返回\n" +
            "订单快速发货\n" +
            "订单编号\n" +
            "外部订单号\n" +
            "下单账号\n" +
            "商品名称\n" +
            "商品编码\n" +
            "销售商家\n" +
            "支付类型\n" +
            "下单日期\n" +
            "订单类型\n" +
            "配送方式\n" +
            "收货人\n" +
            "收货人手机\n" +
            "收货地址\n" +
            "订单号\n" +
            "下单时间\n" +
            "商品编码\n" +
            "收货信息\n" +
            "配送方式\n" +
            "发货状态\n" +
            "发货商家\n" +
            "订单类型\n" +
            "来源渠道\n" +
            "用户备注\n" +
            "商家备注\n" +
            "展开\n" +
            "收起\n" +
            "订单编号\n" +
            "收货人\n" +
            "收货手机\n" +
            "座机\n" +
            "邮编\n" +
            "收货地址\n" +
            "物流公司\n" +
            "物流跟踪号\n" +
            "无需物流\n" +
            "商品图片\n" +
            "商品编码\n" +
            "商品名称\n" +
            "购买数量\n" +
            "未发货数\n" +
            "本次发货数\n";
    public static void test2() {
        String ss[]=  s1.split("\\n");
        List<String> aa = new ArrayList<String>();
        for(int i=0;i<ss.length;i++){
            if(aa.contains(ss[i]))continue;
            aa.add(ss[i].replaceAll("btn_",""));
        }
        for(int i=0;i<aa.size();i++){
            System.out.println(aa.get(i));
        }
    }

    public static void main(String[] args) {
        test2();
    }

}
