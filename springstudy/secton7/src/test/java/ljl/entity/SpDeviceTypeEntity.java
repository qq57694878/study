package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_device_type", schema = "spm", catalog = "")
public class SpDeviceTypeEntity {
    private String deviceTypeId;
    private String deviceTypeCode;
    private String deviceTypeName;
    private String deviceClassCode;
    private String deviceClassName;
    private String remark;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String delFlag;

    @Id
    @Column(name = "device_type_id")
    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    @Basic
    @Column(name = "device_type_code")
    public String getDeviceTypeCode() {
        return deviceTypeCode;
    }

    public void setDeviceTypeCode(String deviceTypeCode) {
        this.deviceTypeCode = deviceTypeCode;
    }

    @Basic
    @Column(name = "device_type_name")
    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    @Basic
    @Column(name = "device_class_code")
    public String getDeviceClassCode() {
        return deviceClassCode;
    }

    public void setDeviceClassCode(String deviceClassCode) {
        this.deviceClassCode = deviceClassCode;
    }

    @Basic
    @Column(name = "device_class_name")
    public String getDeviceClassName() {
        return deviceClassName;
    }

    public void setDeviceClassName(String deviceClassName) {
        this.deviceClassName = deviceClassName;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "del_flag")
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

        SpDeviceTypeEntity that = (SpDeviceTypeEntity) o;

        if (deviceTypeId != null ? !deviceTypeId.equals(that.deviceTypeId) : that.deviceTypeId != null) return false;
        if (deviceTypeCode != null ? !deviceTypeCode.equals(that.deviceTypeCode) : that.deviceTypeCode != null)
            return false;
        if (deviceTypeName != null ? !deviceTypeName.equals(that.deviceTypeName) : that.deviceTypeName != null)
            return false;
        if (deviceClassCode != null ? !deviceClassCode.equals(that.deviceClassCode) : that.deviceClassCode != null)
            return false;
        if (deviceClassName != null ? !deviceClassName.equals(that.deviceClassName) : that.deviceClassName != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceTypeId != null ? deviceTypeId.hashCode() : 0;
        result = 31 * result + (deviceTypeCode != null ? deviceTypeCode.hashCode() : 0);
        result = 31 * result + (deviceTypeName != null ? deviceTypeName.hashCode() : 0);
        result = 31 * result + (deviceClassCode != null ? deviceClassCode.hashCode() : 0);
        result = 31 * result + (deviceClassName != null ? deviceClassName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
