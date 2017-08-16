CREATE OR REPLACE PROCEDURE PROC_SYS_INSERT_MK_16(v_TB_SP_D_TYPE_ID IN VARCHAR2 DEFAULT NULL, --1级分类编码 主
                                                  v_TB_SP_TYPE_ID   IN VARCHAR2 DEFAULT NULL, --2级分类编码 主
                                                  v_TB_SP_MTYPE     IN VARCHAR2 DEFAULT NULL, --3级分类编码 主
                                                  v_TS_PP_INFO_ID   IN VARCHAR2 DEFAULT NULL, --品牌编码 主
                                                  V_BANAME          IN VARCHAR2,
                                                  v_TS_SP_NAME      IN VARCHAR2 DEFAULT NULL, --商品名称中文 主
                                                  v_TS_SP_ENAME     IN VARCHAR2 DEFAULT NULL, --商品名称英文 主
                                                  v_10008343        IN VARCHAR2 DEFAULT NULL, --其他名称 自
                                                  v_TS_SP_XH        IN VARCHAR2 DEFAULT NULL, --型号 主
                                                  v_TS_SP_GG        IN VARCHAR2 DEFAULT NULL, --规格 主
                                                  v_10008363        IN VARCHAR2 DEFAULT NULL, --产地 自
                                                  v_10008347        IN VARCHAR2 DEFAULT NULL, --功能 自
                                                  v_10008348        IN VARCHAR2 DEFAULT NULL, --用途 自
                                                  v_10008349        IN VARCHAR2 DEFAULT NULL, --成分 自
                                                  v_10008344        IN VARCHAR2 DEFAULT NULL, --出厂日期 自
                                                  v_10008345        IN VARCHAR2 DEFAULT NULL, --批号 自
                                                  v_10008365        IN VARCHAR2 DEFAULT NULL, --供应商名称 自
                                                  v_10008346        IN VARCHAR2 DEFAULT NULL, --商户编号
                                                  v_TS_SP_BZ_QX     IN VARCHAR2 DEFAULT NULL, --保质期限 主
                                                  v_10008350        IN VARCHAR2 DEFAULT NULL, --材质 自
                                                  v_10008351        IN VARCHAR2 DEFAULT NULL, --体积 自
                                                  v_10008352        IN VARCHAR2 DEFAULT NULL, --包装 自
                                                  v_TS_SP_BZ        IN VARCHAR2 DEFAULT NULL, --备注 主
                                                  v_TS_SP_XSJ       IN NUMBER DEFAULT NULL, --商品单价 主
                                                  v_10008353        IN NUMBER DEFAULT NULL, --毛重 自
                                                  v_10008354        IN NUMBER DEFAULT NULL, --净重 自
                                                  v_10008364        IN NUMBER DEFAULT NULL, --商品数量 自
                                                  v_10008355        IN VARCHAR2 DEFAULT NULL, --商品编码 自
                                                  v_10008356        IN VARCHAR2 DEFAULT NULL, --一线法定单位 自
                                                  v_10008357        IN VARCHAR2 DEFAULT NULL, --线申报单位 自
                                                  v_10008358        IN VARCHAR2 DEFAULT NULL, --海关监管条件 自
                                                  v_10008359        IN VARCHAR2 DEFAULT NULL, --国家监管条件 自
                                                  v_10008360        IN VARCHAR2 DEFAULT NULL, --申报要素 自
                                                  v_10008361        IN VARCHAR2 DEFAULT NULL, --商品单位 自
                                                  v_10008362        IN VARCHAR2 DEFAULT NULL, --税则号 自
                                                  v_BANO            IN VARCHAR2 DEFAULT NULL, --备案编号 自
                                                  v_TS_SP_ABC       IN VARCHAR2 DEFAULT 0, --是否独立包装TS_SP_ABC 主
                                                  v_TS_SP_DISCOUNT  IN VARCHAR2 DEFAULT 0, --是否需要外包装 主
                                                  v_TS_SP_QY        IN VARCHAR2 DEFAULT 0, --启用 主
                                                  v_10008690        IN VARCHAR2 DEFAULT NULL, --商品归类码 自
                                                  v_10008698        IN VARCHAR2 DEFAULT NULL, --HS-CODE 自
                                                  v_10008691        IN VARCHAR2 DEFAULT NULL, --商品描述 自
                                                  v_10008697        IN VARCHAR2 DEFAULT NULL, --品牌备案编号 自
                                                   --增加的字段start
                                                    v_10010000        IN VARCHAR2 DEFAULT NULL, --业务类型(国检|扩展1),sg_bszy 自
                                                    v_10008367        IN VARCHAR2 DEFAULT NULL, --业务类型(商备),sg_ywlx 自
                                                    v_10008684        IN VARCHAR2 DEFAULT NULL, --申报单位(商备),sg_sbdw 自
                                                    v_10008686        IN VARCHAR2 DEFAULT NULL, --货号(商备),sg_sbhh 自
                                                    v_10008689        IN VARCHAR2 DEFAULT NULL, --物资序号(商备),sg_wzxh 自
                                                    v_10008889        IN VARCHAR2 DEFAULT NULL, --归并序号,sg_gbxh 自
                                                    v_10012144        IN VARCHAR2 DEFAULT NULL, --订单申报单位,djsbdw 自
                                                    v_10009893        IN VARCHAR2 DEFAULT NULL, --产地-国别(国检&前台),cargoplace 自
                                                    v_10008792        IN VARCHAR2 DEFAULT NULL, --电商主体备案状态,sg_dsztbazt 自
                                                    v_10009894        IN VARCHAR2 DEFAULT NULL, --商品经营范围区域(311000:上海洋山局本部),busregion 自
                                                    v_10008701        IN VARCHAR2 DEFAULT NULL, --适用标准国别(国家三字码)(国检),sg_sybzgb 自
                                                    v_10008366        IN VARCHAR2 DEFAULT NULL, --申报关区,sg_sbgq 自
                                                    v_10008369        IN VARCHAR2 DEFAULT NULL, --海关一线备案状态(2:通过),sg_hgzt 自
                                                    v_10008368        IN VARCHAR2 DEFAULT NULL, --国检备案状态(2:通过),sg_gjzt 自
                                                    v_10008692        IN VARCHAR2 DEFAULT NULL, --商品内部货号(国检),sg_spnbhh 自
                                                    v_10008693        IN VARCHAR2 DEFAULT NULL, --第一计量单位(国检),sg_dyjldw 自
                                                    v_10008694        IN VARCHAR2 DEFAULT NULL, --备注(国检),sg_gjbz 自
                                                    v_10008695        IN VARCHAR2 DEFAULT NULL, --商品数量(国检),sg_spslgj 自
                                                    v_10008699        IN VARCHAR2 DEFAULT NULL, --备案单价(国检),sg_badj 自
                                                    v_10008700        IN VARCHAR2 DEFAULT NULL, --第二计量单位(国检),sg_dejldw 自
                                                    v_10008702        IN VARCHAR2 DEFAULT NULL, --转基因产品标识(国检),sg_zjycpbz 自
                                                    v_10008703        IN VARCHAR2 DEFAULT NULL, --商品备案编号(国检),sg_spbabh 自
                                                    v_10008704        IN VARCHAR2 DEFAULT NULL, --商品物资id(国检),sg_spwzid 自
                                                    v_10008705        IN VARCHAR2 DEFAULT NULL, --限制类商品标志(国检),sg_xzlspbz 自
                                                    v_10008706        IN VARCHAR2 DEFAULT NULL, --重点审价标记(国检),sg_zdsjbj 自
                                                    v_10008707        IN VARCHAR2 DEFAULT NULL, --商品单位(国检),sg_spdwgj 自
                                                    v_10008708        IN VARCHAR2 DEFAULT NULL, --生产厂家(国检),sg_sccj 自
                                                    v_10008709        IN VARCHAR2 DEFAULT NULL, --是否禁止进境物标识(国检)0:允许进境,sg_sfjzjjbs 自
                                                    v_10012192        IN VARCHAR2 DEFAULT NULL, --3c证书(国检-扩展2),sg_3czs 自                                     
                                                     --增加的字段end
                                                  v_topywid         IN NUMBER,
                                                  v_cuserid         IN VARCHAR2) AS
  v_TS_SP_INFO_ID      CHAR(40); --产品主表主键
  BANO                 VARCHAR2(200);
  v_TS_SP_ABC_VAL      VARCHAR2(200);
  v_TS_SP_DISCOUNT_VAL VARCHAR2(200);
  REPEAT               NUMBER;
  V_NTXM               VARCHAR2(200);
  V_YXDW               VARCHAR2(200);
  V_LBID               NUMBER;
  V_SHBZ               VARCHAR2(200);
  V_TDY_TS_SP_INFO_ID  CHAR(40); --TDY_TS_SP_INFO表主键
  BEGIN
    IF V_TOPYWID = 1
    THEN
      V_LBID := 2000100;
    ELSIF V_TOPYWID = 2
      THEN
        V_LBID := 100100;
    ELSIF V_TOPYWID = 3
      THEN
        V_LBID := 3000100;
    ELSE
      V_LBID := 4000100;
    END IF;
    IF v_TS_SP_ABC_VAL = '是'
    THEN
      v_TS_SP_ABC_VAL := 1;
    ELSE
      v_TS_SP_ABC_VAL := 0;
    END IF;

    IF v_TS_SP_ABC_VAL = '是'
    THEN
      v_TS_SP_DISCOUNT_VAL := 1;
    ELSE
      v_TS_SP_DISCOUNT_VAL := 0;
    END IF;

    IF V_TOPYWID = 1
    THEN
      V_NTXM := v_10008357;
      V_YXDW := v_10008361;
    ELSE
      V_NTXM := NULL;
      V_YXDW := v_10008357;
    END IF;

    v_TS_SP_INFO_ID := F_GETNID();
    IF v_BANO IS NOT NULL
    THEN
      BANO := v_BANO;
    ELSE
      BANO := FUN_GENERATE_SKU_CODE(v_TB_SP_D_TYPE_ID || v_TB_SP_TYPE_ID ||
                                    v_TB_SP_MTYPE, v_10008363, v_TS_PP_INFO_ID);
    END IF;

    SELECT COUNT(1)
    INTO REPEAT
    FROM TS_SP_INFO ljl.section1_6.A
      INNER JOIN TDY_TS_SP_INFO ljl.section1_6.B ON ljl.section1_6.A.TS_SP_INFO_ID = ljl.section1_6.B.TDY_ZID
    WHERE ljl.section1_6.A.TS_SP_TXM = BANO AND ljl.section1_6.B.SG_SHBZ = v_10008346;

    IF REPEAT = 0
    THEN
      INSERT INTO TS_SP_INFO --产品主表
      (TS_SP_INFO_ID, TS_SP_TXM, TS_SP_TH, TS_SP_MUSER, TS_GS_NM, TS_SP_AB, TS_SP_DQ_ZW, TS_SP_CUSER, TS_SP_CDATE, TS_SP_MDATE, TS_MK_LTDATE, TS_LB_ID, TS_MK_QC_LB_ID, TB_SP_D_TYPE_ID, TB_SP_MTYPE, TB_SP_TYPE_ID, TS_PP_INFO_ID, TS_SP_NAME, TS_SP_ENAME, TS_SP_XH, TS_SP_GG, TS_SP_BZQ, TS_SP_BZ_QX, TS_SP_BZ, TS_SP_XSJ, TS_PH_SF, TS_SP_QY, TS_SP_ABC, TS_SP_DISCOUNT, TS_SP_ZT, TS_SP_ZX_ZT, TS_NTXM, SYSYWID, SYSSHOPID)
      VALUES
        (v_TS_SP_INFO_ID, BANO, BANO, '0000000000000000000000000000000000000000',
                          'DB1212071954787447DF6BCCE0530100007FE98C', '1', '系统管理员',
                          '0000000000000000000000000000000000000000', SYSDATE, SYSDATE, SYSDATE, V_LBID, V_LBID,
                                                                                                 (SELECT MAX(TB_SP_D_ID)
                                                                                                  FROM TB_SP_D_TYPE
                                                                                                  WHERE tb_type_bh =
                                                                                                        v_TB_SP_D_TYPE_ID),
                                                                                                 (SELECT
                                                                                                    MAX(TB_SP_TYPE_ID)
                                                                                                  FROM TB_SP_TYPE
                                                                                                  WHERE tb_type_bh =
                                                                                                        v_TB_SP_D_TYPE_ID
                                                                                                        ||
                                                                                                        v_TB_SP_TYPE_ID),
                                                                                                 (SELECT
                                                                                                    MAX(TB_SP_TYPE_ID)
                                                                                                  FROM TB_SP_TYPE
                                                                                                  WHERE tb_type_bh =
                                                                                                        v_TB_SP_D_TYPE_ID
                                                                                                        ||
                                                                                                        v_TB_SP_TYPE_ID
                                                                                                        ||
                                                                                                        v_TB_SP_MTYPE),
                                                                                                 (SELECT
                                                                                                    MAX(TS_PP_INFO_ID)
                                                                                                  FROM TS_SP_PP_INFO
                                                                                                  WHERE TS_PP_BH =
                                                                                                        v_TS_PP_INFO_ID),
                                                                                                 v_TS_SP_NAME,
                                                                                                 v_TS_SP_ENAME,
                                                                                                 v_TS_SP_XH, v_TS_SP_GG,
          0, v_TS_SP_BZ_QX, v_TS_SP_BZ, v_TS_SP_XSJ, 0, 0, v_TS_SP_ABC_VAL, v_TS_SP_DISCOUNT_VAL, 2, 2, V_NTXM,
         V_TOPYWID, F_DPID(V_CUSERID));

      V_TDY_TS_SP_INFO_ID := F_GETNID();
      INSERT INTO TDY_TS_SP_INFO --产品自定义表
      (TDY_ID, TDY_ZID, SG_OTHNAME, SG_SPCD, SG_SPGN, SG_SPYT, SG_SPCF, SG_CCDATE, SG_SPPH, SG_GYSNAME, SG_SHBZ, SG_SPCZ, SG_SPTJ, SG_SPPACK, SG_SPMZ, SG_SPJZ, SG_SPNUM, SG_SPBM, SG_YXFDDW, SG_YXSBDW, SG_HGJGTJ, SG_GJJGTJ, SG_SBYS, SG_SPDW, SG_SZH, SG_BANAME, SG_SPGLM, SG_HSCODE, SG_SPMS, SG_PPBAM)
      VALUES
        (V_TDY_TS_SP_INFO_ID, v_TS_SP_INFO_ID, v_10008343, v_10008363, v_10008347, v_10008348, v_10008349, v_10008344,
                              v_10008345, v_10008365, v_10008346, v_10008350, v_10008351, v_10008352, v_10008353,
                                                                  v_10008354, v_10008364, v_10008355, v_10008356,
                                                                  V_YXDW, v_10008358, v_10008359, v_10008360,
         v_10008361, v_10008362, V_BANAME, v_10008690, v_10008698, v_10008691, v_10008697);
         --对新增加的字段采取更新的方式，减少原insert语句的更改
         UPDATE TDY_TS_SP_INFO SET SG_BSZY = v_10010000, SG_YWLX = v_10008367, SG_SBDW = v_10008684, SG_SBHH = v_10008686, SG_WZXH = v_10008689, SG_GBXH = v_10008889, DJSBDW = v_10012144, CARGOPLACE = v_10009893, SG_DSZTBAZT = '2', BUSREGION = '311000', SG_SYBZGB = v_10008701, SG_SBGQ = v_10008366, SG_HGZT = '2', SG_GJZT = '0', SG_SPNBHH = v_10008692, SG_DYJLDW = v_10008693, SG_GJBZ = v_10008694, SG_SPSLGJ = v_10008695, SG_BADJ = v_10008699, SG_DEJLDW = v_10008700, SG_ZJYCPBZ = v_10008702, SG_SPBABH = v_10008703, SG_SPWZID = v_10008704, SG_XZLSPBZ = v_10008705, SG_ZDSJBJ = v_10008706, SG_SPDWGJ = v_10008707, SG_SCCJ = v_10008708, SG_SFJZJJBS = v_10008709, SG_3CZS = v_10012192 WHERE TDY_ID = V_TDY_TS_SP_INFO_ID;


      INSERT INTO TS_SP_HS --核算表 省份管理
      (TS_SP_HS_ID, TS_SP_ID, TB_SYSTEM_HS_ID, TB_SYSTEM_HS_TYPE, TS_SP_HS_VALUE)
      VALUES
        (F_GETNID(), v_TS_SP_INFO_ID, 22, 0, 'DB1212071954787447DF6BCCE0530100007FE98C');
    END IF;
  END;
