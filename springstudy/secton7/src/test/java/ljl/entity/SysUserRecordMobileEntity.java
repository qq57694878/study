package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sys_user_record_mobile", schema = "spm", catalog = "")
public class SysUserRecordMobileEntity {
    private int unid;
    private int userId;
    private String token;
    private Timestamp loginTime;
    private Timestamp logoutTime;
    private String ipAddress;
    private String clientType;
    private boolean invalid;
    private Timestamp lastActiveTime;
    private long timeInterval;
    private Timestamp expireTime;
    private String deviceName;
    private String appVersion;

    @Id
    @Column(name = "unid")
    public int getUnid() {
        return unid;
    }

    public void setUnid(int unid) {
        this.unid = unid;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "login_time")
    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    @Basic
    @Column(name = "logout_time")
    public Timestamp getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Timestamp logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Basic
    @Column(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "client_type")
    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    @Basic
    @Column(name = "invalid")
    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    @Basic
    @Column(name = "last_active_time")
    public Timestamp getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Timestamp lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    @Basic
    @Column(name = "time_interval")
    public long getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(long timeInterval) {
        this.timeInterval = timeInterval;
    }

    @Basic
    @Column(name = "expire_time")
    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    @Basic
    @Column(name = "device_name")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "app_version")
    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUserRecordMobileEntity that = (SysUserRecordMobileEntity) o;

        if (unid != that.unid) return false;
        if (userId != that.userId) return false;
        if (invalid != that.invalid) return false;
        if (timeInterval != that.timeInterval) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (loginTime != null ? !loginTime.equals(that.loginTime) : that.loginTime != null) return false;
        if (logoutTime != null ? !logoutTime.equals(that.logoutTime) : that.logoutTime != null) return false;
        if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;
        if (clientType != null ? !clientType.equals(that.clientType) : that.clientType != null) return false;
        if (lastActiveTime != null ? !lastActiveTime.equals(that.lastActiveTime) : that.lastActiveTime != null)
            return false;
        if (expireTime != null ? !expireTime.equals(that.expireTime) : that.expireTime != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (appVersion != null ? !appVersion.equals(that.appVersion) : that.appVersion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unid;
        result = 31 * result + userId;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (logoutTime != null ? logoutTime.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (clientType != null ? clientType.hashCode() : 0);
        result = 31 * result + (invalid ? 1 : 0);
        result = 31 * result + (lastActiveTime != null ? lastActiveTime.hashCode() : 0);
        result = 31 * result + (int) (timeInterval ^ (timeInterval >>> 32));
        result = 31 * result + (expireTime != null ? expireTime.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (appVersion != null ? appVersion.hashCode() : 0);
        return result;
    }
}
