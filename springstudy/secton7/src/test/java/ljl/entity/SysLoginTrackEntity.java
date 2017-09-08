package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sys_login_track", schema = "spm", catalog = "")
public class SysLoginTrackEntity {
    private int id;
    private int userId;
    private String ipAddress;
    private Timestamp lastLoginTime;
    private Timestamp lockEndTime;
    private boolean locked;
    private boolean invalid;
    private byte loginCount;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "ip_address")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "lock_end_time")
    public Timestamp getLockEndTime() {
        return lockEndTime;
    }

    public void setLockEndTime(Timestamp lockEndTime) {
        this.lockEndTime = lockEndTime;
    }

    @Basic
    @Column(name = "locked")
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
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
    @Column(name = "login_count")
    public byte getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(byte loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysLoginTrackEntity that = (SysLoginTrackEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (locked != that.locked) return false;
        if (invalid != that.invalid) return false;
        if (loginCount != that.loginCount) return false;
        if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(that.lastLoginTime) : that.lastLoginTime != null)
            return false;
        if (lockEndTime != null ? !lockEndTime.equals(that.lockEndTime) : that.lockEndTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (lockEndTime != null ? lockEndTime.hashCode() : 0);
        result = 31 * result + (locked ? 1 : 0);
        result = 31 * result + (invalid ? 1 : 0);
        result = 31 * result + (int) loginCount;
        return result;
    }
}
