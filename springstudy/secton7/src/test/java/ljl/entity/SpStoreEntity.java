package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_store", schema = "spm", catalog = "")
public class SpStoreEntity {
    private String storeId;
    private String storeCode;
    private String storePid;
    private String storeLevel;
    private String storeName;
    private String storeStatus;
    private String areaCode;
    private String areaAddress;
    private String managePeople;
    private String managePeopleMobile;
    private String storeLon;
    private String storeLat;
    private String remark;
    private String limitFlag;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;
    private String delFlag;

    @Id
    @Column(name = "store_id")
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "store_code")
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    @Basic
    @Column(name = "store_pid")
    public String getStorePid() {
        return storePid;
    }

    public void setStorePid(String storePid) {
        this.storePid = storePid;
    }

    @Basic
    @Column(name = "store_level")
    public String getStoreLevel() {
        return storeLevel;
    }

    public void setStoreLevel(String storeLevel) {
        this.storeLevel = storeLevel;
    }

    @Basic
    @Column(name = "store_name")
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "store_status")
    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }

    @Basic
    @Column(name = "area_code")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Basic
    @Column(name = "area_address")
    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    @Basic
    @Column(name = "manage_people")
    public String getManagePeople() {
        return managePeople;
    }

    public void setManagePeople(String managePeople) {
        this.managePeople = managePeople;
    }

    @Basic
    @Column(name = "manage_people_mobile")
    public String getManagePeopleMobile() {
        return managePeopleMobile;
    }

    public void setManagePeopleMobile(String managePeopleMobile) {
        this.managePeopleMobile = managePeopleMobile;
    }

    @Basic
    @Column(name = "store_lon")
    public String getStoreLon() {
        return storeLon;
    }

    public void setStoreLon(String storeLon) {
        this.storeLon = storeLon;
    }

    @Basic
    @Column(name = "store_lat")
    public String getStoreLat() {
        return storeLat;
    }

    public void setStoreLat(String storeLat) {
        this.storeLat = storeLat;
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
    @Column(name = "limit_flag")
    public String getLimitFlag() {
        return limitFlag;
    }

    public void setLimitFlag(String limitFlag) {
        this.limitFlag = limitFlag;
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
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

        SpStoreEntity that = (SpStoreEntity) o;

        if (storeId != null ? !storeId.equals(that.storeId) : that.storeId != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (storePid != null ? !storePid.equals(that.storePid) : that.storePid != null) return false;
        if (storeLevel != null ? !storeLevel.equals(that.storeLevel) : that.storeLevel != null) return false;
        if (storeName != null ? !storeName.equals(that.storeName) : that.storeName != null) return false;
        if (storeStatus != null ? !storeStatus.equals(that.storeStatus) : that.storeStatus != null) return false;
        if (areaCode != null ? !areaCode.equals(that.areaCode) : that.areaCode != null) return false;
        if (areaAddress != null ? !areaAddress.equals(that.areaAddress) : that.areaAddress != null) return false;
        if (managePeople != null ? !managePeople.equals(that.managePeople) : that.managePeople != null) return false;
        if (managePeopleMobile != null ? !managePeopleMobile.equals(that.managePeopleMobile) : that.managePeopleMobile != null)
            return false;
        if (storeLon != null ? !storeLon.equals(that.storeLon) : that.storeLon != null) return false;
        if (storeLat != null ? !storeLat.equals(that.storeLat) : that.storeLat != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (limitFlag != null ? !limitFlag.equals(that.limitFlag) : that.limitFlag != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeId != null ? storeId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (storePid != null ? storePid.hashCode() : 0);
        result = 31 * result + (storeLevel != null ? storeLevel.hashCode() : 0);
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (storeStatus != null ? storeStatus.hashCode() : 0);
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        result = 31 * result + (areaAddress != null ? areaAddress.hashCode() : 0);
        result = 31 * result + (managePeople != null ? managePeople.hashCode() : 0);
        result = 31 * result + (managePeopleMobile != null ? managePeopleMobile.hashCode() : 0);
        result = 31 * result + (storeLon != null ? storeLon.hashCode() : 0);
        result = 31 * result + (storeLat != null ? storeLat.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (limitFlag != null ? limitFlag.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
