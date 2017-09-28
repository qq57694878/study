package cn.com.jldata.modules.demo.vo;

import java.util.Date;

public class DemoRequest {

    private String id;

    private Date crateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date createTime) {
        this.crateTime = createTime;
    }
}
