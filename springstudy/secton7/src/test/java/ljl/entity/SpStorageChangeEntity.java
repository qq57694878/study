package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_storage_change", schema = "spm", catalog = "")
public class SpStorageChangeEntity {
    private String storageChangeId;
    private String storeCode;
    private String spareCode;
    private String storageCodeOld;
    private String storageCodeNew;
    private Integer changeCount;
    private String changeRemark;
    private Timestamp createDate;
    private String createBy;

    @Id
    @Column(name = "storage_change_id")
    public String getStorageChangeId() {
        return storageChangeId;
    }

    public void setStorageChangeId(String storageChangeId) {
        this.storageChangeId = storageChangeId;
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
    @Column(name = "spare_code")
    public String getSpareCode() {
        return spareCode;
    }

    public void setSpareCode(String spareCode) {
        this.spareCode = spareCode;
    }

    @Basic
    @Column(name = "storage_code_old")
    public String getStorageCodeOld() {
        return storageCodeOld;
    }

    public void setStorageCodeOld(String storageCodeOld) {
        this.storageCodeOld = storageCodeOld;
    }

    @Basic
    @Column(name = "storage_code_new")
    public String getStorageCodeNew() {
        return storageCodeNew;
    }

    public void setStorageCodeNew(String storageCodeNew) {
        this.storageCodeNew = storageCodeNew;
    }

    @Basic
    @Column(name = "change_count")
    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    @Basic
    @Column(name = "change_remark")
    public String getChangeRemark() {
        return changeRemark;
    }

    public void setChangeRemark(String changeRemark) {
        this.changeRemark = changeRemark;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpStorageChangeEntity that = (SpStorageChangeEntity) o;

        if (storageChangeId != null ? !storageChangeId.equals(that.storageChangeId) : that.storageChangeId != null)
            return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (storageCodeOld != null ? !storageCodeOld.equals(that.storageCodeOld) : that.storageCodeOld != null)
            return false;
        if (storageCodeNew != null ? !storageCodeNew.equals(that.storageCodeNew) : that.storageCodeNew != null)
            return false;
        if (changeCount != null ? !changeCount.equals(that.changeCount) : that.changeCount != null) return false;
        if (changeRemark != null ? !changeRemark.equals(that.changeRemark) : that.changeRemark != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storageChangeId != null ? storageChangeId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (storageCodeOld != null ? storageCodeOld.hashCode() : 0);
        result = 31 * result + (storageCodeNew != null ? storageCodeNew.hashCode() : 0);
        result = 31 * result + (changeCount != null ? changeCount.hashCode() : 0);
        result = 31 * result + (changeRemark != null ? changeRemark.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        return result;
    }
}
