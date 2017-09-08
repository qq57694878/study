package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_check_main", schema = "spm", catalog = "")
public class SpCheckMainEntity {
    private String checkMainId;
    private String storeCode;
    private String checkNum;
    private String checkRemark;
    private Integer checkKindCount;
    private Integer totalKindCount;
    private String checkType;
    private String checkStatus;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;
    private String delFlag;

    @Id
    @Column(name = "check_main_id")
    public String getCheckMainId() {
        return checkMainId;
    }

    public void setCheckMainId(String checkMainId) {
        this.checkMainId = checkMainId;
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
    @Column(name = "check_num")
    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    @Basic
    @Column(name = "check_remark")
    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    @Basic
    @Column(name = "check_kind_count")
    public Integer getCheckKindCount() {
        return checkKindCount;
    }

    public void setCheckKindCount(Integer checkKindCount) {
        this.checkKindCount = checkKindCount;
    }

    @Basic
    @Column(name = "total_kind_count")
    public Integer getTotalKindCount() {
        return totalKindCount;
    }

    public void setTotalKindCount(Integer totalKindCount) {
        this.totalKindCount = totalKindCount;
    }

    @Basic
    @Column(name = "check_type")
    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    @Basic
    @Column(name = "check_status")
    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
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

        SpCheckMainEntity that = (SpCheckMainEntity) o;

        if (checkMainId != null ? !checkMainId.equals(that.checkMainId) : that.checkMainId != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (checkNum != null ? !checkNum.equals(that.checkNum) : that.checkNum != null) return false;
        if (checkRemark != null ? !checkRemark.equals(that.checkRemark) : that.checkRemark != null) return false;
        if (checkKindCount != null ? !checkKindCount.equals(that.checkKindCount) : that.checkKindCount != null)
            return false;
        if (totalKindCount != null ? !totalKindCount.equals(that.totalKindCount) : that.totalKindCount != null)
            return false;
        if (checkType != null ? !checkType.equals(that.checkType) : that.checkType != null) return false;
        if (checkStatus != null ? !checkStatus.equals(that.checkStatus) : that.checkStatus != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkMainId != null ? checkMainId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (checkNum != null ? checkNum.hashCode() : 0);
        result = 31 * result + (checkRemark != null ? checkRemark.hashCode() : 0);
        result = 31 * result + (checkKindCount != null ? checkKindCount.hashCode() : 0);
        result = 31 * result + (totalKindCount != null ? totalKindCount.hashCode() : 0);
        result = 31 * result + (checkType != null ? checkType.hashCode() : 0);
        result = 31 * result + (checkStatus != null ? checkStatus.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
