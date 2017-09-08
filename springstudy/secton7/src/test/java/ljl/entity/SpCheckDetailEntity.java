package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_check_detail", schema = "spm", catalog = "")
public class SpCheckDetailEntity {
    private String checkDetailId;
    private String spareCode;
    private String checkMainId;
    private String storageCode;
    private Integer totalSpareCount;
    private Integer checkSpareCount;
    private Integer checkDiffCount;
    private String checkResult;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;
    private Integer modifyCount;

    @Id
    @Column(name = "check_detail_id")
    public String getCheckDetailId() {
        return checkDetailId;
    }

    public void setCheckDetailId(String checkDetailId) {
        this.checkDetailId = checkDetailId;
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
    @Column(name = "check_main_id")
    public String getCheckMainId() {
        return checkMainId;
    }

    public void setCheckMainId(String checkMainId) {
        this.checkMainId = checkMainId;
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
    @Column(name = "total_spare_count")
    public Integer getTotalSpareCount() {
        return totalSpareCount;
    }

    public void setTotalSpareCount(Integer totalSpareCount) {
        this.totalSpareCount = totalSpareCount;
    }

    @Basic
    @Column(name = "check_spare_count")
    public Integer getCheckSpareCount() {
        return checkSpareCount;
    }

    public void setCheckSpareCount(Integer checkSpareCount) {
        this.checkSpareCount = checkSpareCount;
    }

    @Basic
    @Column(name = "check_diff_count")
    public Integer getCheckDiffCount() {
        return checkDiffCount;
    }

    public void setCheckDiffCount(Integer checkDiffCount) {
        this.checkDiffCount = checkDiffCount;
    }

    @Basic
    @Column(name = "check_result")
    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
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
    @Column(name = "modify_count")
    public Integer getModifyCount() {
        return modifyCount;
    }

    public void setModifyCount(Integer modifyCount) {
        this.modifyCount = modifyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpCheckDetailEntity that = (SpCheckDetailEntity) o;

        if (checkDetailId != null ? !checkDetailId.equals(that.checkDetailId) : that.checkDetailId != null)
            return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (checkMainId != null ? !checkMainId.equals(that.checkMainId) : that.checkMainId != null) return false;
        if (storageCode != null ? !storageCode.equals(that.storageCode) : that.storageCode != null) return false;
        if (totalSpareCount != null ? !totalSpareCount.equals(that.totalSpareCount) : that.totalSpareCount != null)
            return false;
        if (checkSpareCount != null ? !checkSpareCount.equals(that.checkSpareCount) : that.checkSpareCount != null)
            return false;
        if (checkDiffCount != null ? !checkDiffCount.equals(that.checkDiffCount) : that.checkDiffCount != null)
            return false;
        if (checkResult != null ? !checkResult.equals(that.checkResult) : that.checkResult != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;
        if (modifyCount != null ? !modifyCount.equals(that.modifyCount) : that.modifyCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkDetailId != null ? checkDetailId.hashCode() : 0;
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (checkMainId != null ? checkMainId.hashCode() : 0);
        result = 31 * result + (storageCode != null ? storageCode.hashCode() : 0);
        result = 31 * result + (totalSpareCount != null ? totalSpareCount.hashCode() : 0);
        result = 31 * result + (checkSpareCount != null ? checkSpareCount.hashCode() : 0);
        result = 31 * result + (checkDiffCount != null ? checkDiffCount.hashCode() : 0);
        result = 31 * result + (checkResult != null ? checkResult.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (modifyCount != null ? modifyCount.hashCode() : 0);
        return result;
    }
}
