package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_distri_main", schema = "spm", catalog = "")
public class SpDistriMainEntity {
    private String distriMainId;
    private String storeCodeFrom;
    private String storeCodeTo;
    private String applyNo;
    private String distriNo;
    private String logisNo;
    private String logisName;
    private Integer spareKindCount;
    private Timestamp outDatetime;
    private String outPeopleId;
    private Timestamp inDatetime;
    private String inPeopleId;
    private String distriStatus;
    private String remark;
    private String backRemark;
    private String superApplyNo;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;
    private String delFlag;

    @Id
    @Column(name = "distri_main_id")
    public String getDistriMainId() {
        return distriMainId;
    }

    public void setDistriMainId(String distriMainId) {
        this.distriMainId = distriMainId;
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
    @Column(name = "distri_no")
    public String getDistriNo() {
        return distriNo;
    }

    public void setDistriNo(String distriNo) {
        this.distriNo = distriNo;
    }

    @Basic
    @Column(name = "logis_no")
    public String getLogisNo() {
        return logisNo;
    }

    public void setLogisNo(String logisNo) {
        this.logisNo = logisNo;
    }

    @Basic
    @Column(name = "logis_name")
    public String getLogisName() {
        return logisName;
    }

    public void setLogisName(String logisName) {
        this.logisName = logisName;
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
    @Column(name = "out_datetime")
    public Timestamp getOutDatetime() {
        return outDatetime;
    }

    public void setOutDatetime(Timestamp outDatetime) {
        this.outDatetime = outDatetime;
    }

    @Basic
    @Column(name = "out_people_id")
    public String getOutPeopleId() {
        return outPeopleId;
    }

    public void setOutPeopleId(String outPeopleId) {
        this.outPeopleId = outPeopleId;
    }

    @Basic
    @Column(name = "in_datetime")
    public Timestamp getInDatetime() {
        return inDatetime;
    }

    public void setInDatetime(Timestamp inDatetime) {
        this.inDatetime = inDatetime;
    }

    @Basic
    @Column(name = "in_people_id")
    public String getInPeopleId() {
        return inPeopleId;
    }

    public void setInPeopleId(String inPeopleId) {
        this.inPeopleId = inPeopleId;
    }

    @Basic
    @Column(name = "distri_status")
    public String getDistriStatus() {
        return distriStatus;
    }

    public void setDistriStatus(String distriStatus) {
        this.distriStatus = distriStatus;
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
    @Column(name = "super_apply_no")
    public String getSuperApplyNo() {
        return superApplyNo;
    }

    public void setSuperApplyNo(String superApplyNo) {
        this.superApplyNo = superApplyNo;
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

        SpDistriMainEntity that = (SpDistriMainEntity) o;

        if (distriMainId != null ? !distriMainId.equals(that.distriMainId) : that.distriMainId != null) return false;
        if (storeCodeFrom != null ? !storeCodeFrom.equals(that.storeCodeFrom) : that.storeCodeFrom != null)
            return false;
        if (storeCodeTo != null ? !storeCodeTo.equals(that.storeCodeTo) : that.storeCodeTo != null) return false;
        if (applyNo != null ? !applyNo.equals(that.applyNo) : that.applyNo != null) return false;
        if (distriNo != null ? !distriNo.equals(that.distriNo) : that.distriNo != null) return false;
        if (logisNo != null ? !logisNo.equals(that.logisNo) : that.logisNo != null) return false;
        if (logisName != null ? !logisName.equals(that.logisName) : that.logisName != null) return false;
        if (spareKindCount != null ? !spareKindCount.equals(that.spareKindCount) : that.spareKindCount != null)
            return false;
        if (outDatetime != null ? !outDatetime.equals(that.outDatetime) : that.outDatetime != null) return false;
        if (outPeopleId != null ? !outPeopleId.equals(that.outPeopleId) : that.outPeopleId != null) return false;
        if (inDatetime != null ? !inDatetime.equals(that.inDatetime) : that.inDatetime != null) return false;
        if (inPeopleId != null ? !inPeopleId.equals(that.inPeopleId) : that.inPeopleId != null) return false;
        if (distriStatus != null ? !distriStatus.equals(that.distriStatus) : that.distriStatus != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (backRemark != null ? !backRemark.equals(that.backRemark) : that.backRemark != null) return false;
        if (superApplyNo != null ? !superApplyNo.equals(that.superApplyNo) : that.superApplyNo != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = distriMainId != null ? distriMainId.hashCode() : 0;
        result = 31 * result + (storeCodeFrom != null ? storeCodeFrom.hashCode() : 0);
        result = 31 * result + (storeCodeTo != null ? storeCodeTo.hashCode() : 0);
        result = 31 * result + (applyNo != null ? applyNo.hashCode() : 0);
        result = 31 * result + (distriNo != null ? distriNo.hashCode() : 0);
        result = 31 * result + (logisNo != null ? logisNo.hashCode() : 0);
        result = 31 * result + (logisName != null ? logisName.hashCode() : 0);
        result = 31 * result + (spareKindCount != null ? spareKindCount.hashCode() : 0);
        result = 31 * result + (outDatetime != null ? outDatetime.hashCode() : 0);
        result = 31 * result + (outPeopleId != null ? outPeopleId.hashCode() : 0);
        result = 31 * result + (inDatetime != null ? inDatetime.hashCode() : 0);
        result = 31 * result + (inPeopleId != null ? inPeopleId.hashCode() : 0);
        result = 31 * result + (distriStatus != null ? distriStatus.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (backRemark != null ? backRemark.hashCode() : 0);
        result = 31 * result + (superApplyNo != null ? superApplyNo.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
