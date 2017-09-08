package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_store_io_log", schema = "spm", catalog = "")
public class SpStoreIoLogEntity {
    private String storeIoLogId;
    private String storeCode;
    private String spareCode;
    private Integer changeCount;
    private Integer storeCount;
    private String busiType;
    private String busiNum;
    private Timestamp createDate;
    private String createBy;

    @Id
    @Column(name = "store_io_log_id")
    public String getStoreIoLogId() {
        return storeIoLogId;
    }

    public void setStoreIoLogId(String storeIoLogId) {
        this.storeIoLogId = storeIoLogId;
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
    @Column(name = "change_count")
    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
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
    @Column(name = "busi_type")
    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
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

        SpStoreIoLogEntity that = (SpStoreIoLogEntity) o;

        if (storeIoLogId != null ? !storeIoLogId.equals(that.storeIoLogId) : that.storeIoLogId != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (changeCount != null ? !changeCount.equals(that.changeCount) : that.changeCount != null) return false;
        if (storeCount != null ? !storeCount.equals(that.storeCount) : that.storeCount != null) return false;
        if (busiType != null ? !busiType.equals(that.busiType) : that.busiType != null) return false;
        if (busiNum != null ? !busiNum.equals(that.busiNum) : that.busiNum != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeIoLogId != null ? storeIoLogId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (changeCount != null ? changeCount.hashCode() : 0);
        result = 31 * result + (storeCount != null ? storeCount.hashCode() : 0);
        result = 31 * result + (busiType != null ? busiType.hashCode() : 0);
        result = 31 * result + (busiNum != null ? busiNum.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        return result;
    }
}
