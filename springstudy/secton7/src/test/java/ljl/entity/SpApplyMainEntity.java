package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_apply_main", schema = "spm", catalog = "")
public class SpApplyMainEntity {
    private String applyMainId;
    private String storeCodeFrom;
    private String storeCodeTo;
    private String applyNo;
    private Timestamp applyDatetime;
    private String applyPeopleId;
    private Timestamp auditorDatetime;
    private String auditorPeopleId;
    private Integer spareKindCount;
    private String applyStatus;
    private String remark;
    private String backRemark;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;
    private String delFlag;

    @Id
    @Column(name = "apply_main_id")
    public String getApplyMainId() {
        return applyMainId;
    }

    public void setApplyMainId(String applyMainId) {
        this.applyMainId = applyMainId;
    }

    @Basic
    @Column(name = "store_code_from")
    public String getStoreCodeFrom() {
        return storeCodeFrom;
    }

    public void setStoreCodeFrom(String storeCodeFrom) {
        this.storeCodeFrom = storeCodeFrom;
    }

    @Basic
    @Column(name = "store_code_to")
    public String getStoreCodeTo() {
        return storeCodeTo;
    }

    public void setStoreCodeTo(String storeCodeTo) {
        this.storeCodeTo = storeCodeTo;
    }

    @Basic
    @Column(name = "apply_no")
    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    @Basic
    @Column(name = "apply_datetime")
    public Timestamp getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Timestamp applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    @Basic
    @Column(name = "apply_people_id")
    public String getApplyPeopleId() {
        return applyPeopleId;
    }

    public void setApplyPeopleId(String applyPeopleId) {
        this.applyPeopleId = applyPeopleId;
    }

    @Basic
    @Column(name = "auditor_datetime")
    public Timestamp getAuditorDatetime() {
        return auditorDatetime;
    }

    public void setAuditorDatetime(Timestamp auditorDatetime) {
        this.auditorDatetime = auditorDatetime;
    }

    @Basic
    @Column(name = "auditor_people_id")
    public String getAuditorPeopleId() {
        return auditorPeopleId;
    }

    public void setAuditorPeopleId(String auditorPeopleId) {
        this.auditorPeopleId = auditorPeopleId;
    }

    @Basic
    @Column(name = "spare_kind_count")
    public Integer getSpareKindCount() {
        return spareKindCount;
    }

    public void setSpareKindCount(Integer spareKindCount) {
        this.spareKindCount = spareKindCount;
    }

    @Basic
    @Column(name = "apply_status")
    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
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
    @Column(name = "back_remark")
    public String getBackRemark() {
        return backRemark;
    }

    public void setBackRemark(String backRemark) {
        this.backRemark = backRemark;
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

        SpApplyMainEntity that = (SpApplyMainEntity) o;

        if (applyMainId != null ? !applyMainId.equals(that.applyMainId) : that.applyMainId != null) return false;
        if (storeCodeFrom != null ? !storeCodeFrom.equals(that.storeCodeFrom) : that.storeCodeFrom != null)
            return false;
        if (storeCodeTo != null ? !storeCodeTo.equals(that.storeCodeTo) : that.storeCodeTo != null) return false;
        if (applyNo != null ? !applyNo.equals(that.applyNo) : that.applyNo != null) return false;
        if (applyDatetime != null ? !applyDatetime.equals(that.applyDatetime) : that.applyDatetime != null)
            return false;
        if (applyPeopleId != null ? !applyPeopleId.equals(that.applyPeopleId) : that.applyPeopleId != null)
            return false;
        if (auditorDatetime != null ? !auditorDatetime.equals(that.auditorDatetime) : that.auditorDatetime != null)
            return false;
        if (auditorPeopleId != null ? !auditorPeopleId.equals(that.auditorPeopleId) : that.auditorPeopleId != null)
            return false;
        if (spareKindCount != null ? !spareKindCount.equals(that.spareKindCount) : that.spareKindCount != null)
            return false;
        if (applyStatus != null ? !applyStatus.equals(that.applyStatus) : that.applyStatus != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (backRemark != null ? !backRemark.equals(that.backRemark) : that.backRemark != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applyMainId != null ? applyMainId.hashCode() : 0;
        result = 31 * result + (storeCodeFrom != null ? storeCodeFrom.hashCode() : 0);
        result = 31 * result + (storeCodeTo != null ? storeCodeTo.hashCode() : 0);
        result = 31 * result + (applyNo != null ? applyNo.hashCode() : 0);
        result = 31 * result + (applyDatetime != null ? applyDatetime.hashCode() : 0);
        result = 31 * result + (applyPeopleId != null ? applyPeopleId.hashCode() : 0);
        result = 31 * result + (auditorDatetime != null ? auditorDatetime.hashCode() : 0);
        result = 31 * result + (auditorPeopleId != null ? auditorPeopleId.hashCode() : 0);
        result = 31 * result + (spareKindCount != null ? spareKindCount.hashCode() : 0);
        result = 31 * result + (applyStatus != null ? applyStatus.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (backRemark != null ? backRemark.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
