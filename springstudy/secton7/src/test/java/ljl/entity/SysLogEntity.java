package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sys_log", schema = "spm", catalog = "")
public class SysLogEntity {
    private String id;
    private String loginName;
    private String logisId;
    private String logIp;
    private String logUrl;
    private String logModule;
    private String logOperate;
    private String logParam;
    private String logType;
    private Timestamp createDate;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login_name")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Basic
    @Column(name = "logis_id")
    public String getLogisId() {
        return logisId;
    }

    public void setLogisId(String logisId) {
        this.logisId = logisId;
    }

    @Basic
    @Column(name = "log_ip")
    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    @Basic
    @Column(name = "log_url")
    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    @Basic
    @Column(name = "log_module")
    public String getLogModule() {
        return logModule;
    }

    public void setLogModule(String logModule) {
        this.logModule = logModule;
    }

    @Basic
    @Column(name = "log_operate")
    public String getLogOperate() {
        return logOperate;
    }

    public void setLogOperate(String logOperate) {
        this.logOperate = logOperate;
    }

    @Basic
    @Column(name = "log_param")
    public String getLogParam() {
        return logParam;
    }

    public void setLogParam(String logParam) {
        this.logParam = logParam;
    }

    @Basic
    @Column(name = "log_type")
    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysLogEntity that = (SysLogEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (loginName != null ? !loginName.equals(that.loginName) : that.loginName != null) return false;
        if (logisId != null ? !logisId.equals(that.logisId) : that.logisId != null) return false;
        if (logIp != null ? !logIp.equals(that.logIp) : that.logIp != null) return false;
        if (logUrl != null ? !logUrl.equals(that.logUrl) : that.logUrl != null) return false;
        if (logModule != null ? !logModule.equals(that.logModule) : that.logModule != null) return false;
        if (logOperate != null ? !logOperate.equals(that.logOperate) : that.logOperate != null) return false;
        if (logParam != null ? !logParam.equals(that.logParam) : that.logParam != null) return false;
        if (logType != null ? !logType.equals(that.logType) : that.logType != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (logisId != null ? logisId.hashCode() : 0);
        result = 31 * result + (logIp != null ? logIp.hashCode() : 0);
        result = 31 * result + (logUrl != null ? logUrl.hashCode() : 0);
        result = 31 * result + (logModule != null ? logModule.hashCode() : 0);
        result = 31 * result + (logOperate != null ? logOperate.hashCode() : 0);
        result = 31 * result + (logParam != null ? logParam.hashCode() : 0);
        result = 31 * result + (logType != null ? logType.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
