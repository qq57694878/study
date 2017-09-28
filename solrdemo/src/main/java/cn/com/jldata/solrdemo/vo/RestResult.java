package cn.com.jldata.solrdemo.vo;


import cn.com.jldata.solrdemo.common.Constants;

/**
 * api 返回结果
 */
public class RestResult {

    private int errcode;

    private String errmsg;

    private Object data;

    public RestResult() {
        this.errcode = Constants.ERROR_CODE_200;
        this.errmsg="";
    }


    public RestResult(int errcode, String errmsg, Object data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public RestResult(Object data) {
        this.errcode = Constants.ERROR_CODE_200;
        this.errmsg="";
        this.data = data;
    }
    public RestResult(int errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = new Object();
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
