package cn.com.jldata.common.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sys_role", schema = "smart", catalog = "")
public class SysRoleEntity {
    private Integer roleId;
    private String roleName;
    private String roleJob;
    private String roleRemark;
    private Timestamp updateDate;
    private String delFlag;

    @Id
    @Column(name = "role_id", nullable = false)
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_job", nullable = true, length = 50)
    public String getRoleJob() {
        return roleJob;
    }

    public void setRoleJob(String roleJob) {
        this.roleJob = roleJob;
    }

    @Basic
    @Column(name = "role_remark", nullable = true, length = 200)
    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    @Basic
    @Column(name = "update_date", nullable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "del_flag", nullable = false, length = 1)
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoleEntity that = (SysRoleEntity) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (roleJob != null ? !roleJob.equals(that.roleJob) : that.roleJob != null) return false;
        if (roleRemark != null ? !roleRemark.equals(that.roleRemark) : that.roleRemark != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleJob != null ? roleJob.hashCode() : 0);
        result = 31 * result + (roleRemark != null ? roleRemark.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
