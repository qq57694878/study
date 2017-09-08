package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_store_log", schema = "spm", catalog = "")
public class SpStoreLogEntity {
    private String storeLogId;
    private String storeCode;
    private String spareCode;
    private String storageCode;
    private Integer changeCount;
    private Integer storageCount;
    private Integer storeCount;
    private String changeType;
    private String busiNum;
    private Timestamp createDate;
    private String createBy;

    @Id
    @Column(name = "store_log_id")
    public String getStoreLogId() {
        return storeLogId;
    }

    public void setStoreLogId(String storeLogId) {
        this.storeLogId = storeLogId;
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
    @Column(name = "storage_code")
    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
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
    @Column(name = "storage_count")
    public Integer getStorageCount() {
        return storageCount;
    }

    public void setStorageCount(Integer storageCount) {
        this.storageCount = storageCount;
    }

    @Basic
    @Column(name = "store_count")
    public Integer getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount;
    }

    @Basic
    @Column(name = "change_type")
    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @Basic
    @Column(name = "busi_num")
    public String getBusiNum() {
        return busiNum;
    }

    public void setBusiNum(String busiNum) {
        this.busiNum = busiNum;
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

        SpStoreLogEntity that = (SpStoreLogEntity) o;

        if (storeLogId != null ? !storeLogId.equals(that.storeLogId) : that.storeLogId != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (storageCode != null ? !storageCode.equals(that.storageCode) : that.storageCode != null) return false;
        if (changeCount != null ? !changeCount.equals(that.changeCount) : that.changeCount != null) return false;
        if (storageCount != null ? !storageCount.equals(that.storageCount) : that.storageCount != null) return false;
        if (storeCount != null ? !storeCount.equals(that.storeCount) : that.storeCount != null) return false;
        if (changeType != null ? !changeType.equals(that.changeType) : that.changeType != null) return false;
        if (busiNum != null ? !busiNum.equals(that.busiNum) : that.busiNum != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeLogId != null ? storeLogId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (storageCode != null ? storageCode.hashCode() : 0);
        result = 31 * result + (changeCount != null ? changeCount.hashCode() : 0);
        result = 31 * result + (storageCount != null ? storageCount.hashCode() : 0);
        result = 31 * result + (storeCount != null ? storeCount.hashCode() : 0);
        result = 31 * result + (changeType != null ? changeType.hashCode() : 0);
        result = 31 * result + (busiNum != null ? busiNum.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        return result;
    }
}
