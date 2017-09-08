package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_loss_main", schema = "spm", catalog = "")
public class SpLossMainEntity {
    private String lossMainId;
    private String storeCodeFrom;
    private String storeCodeTo;
    private String lossNo;
    private String logisNo;
    private String logisName;
    private Integer spareKindCount;
    private Timestamp lossDatetime;
    private String lossPeopleId;
    private Timestamp auditorDatetime;
    private String auditorPeopleId;
    private Timestamp outDatetime;
    private String outPeopleId;
    private Timestamp inDatetime;
    private String inPeopleId;
    private String lossStatus;
    private String lossPno;
    private String remark;
    private String backRemark;
    private String backRecRemark;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;
    private String delFlag;

    @Id
    @Column(name = "loss_main_id")
    public String getLossMainId() {
        return lossMainId;
    }

    public void setLossMainId(String lossMainId) {
        this.lossMainId = lossMainId;
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
    @Column(name = "loss_no")
    public String getLossNo() {
        return lossNo;
    }

    public void setLossNo(String lossNo) {
        this.lossNo = lossNo;
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
    @Column(name = "loss_datetime")
    public Timestamp getLossDatetime() {
        return lossDatetime;
    }

    public void setLossDatetime(Timestamp lossDatetime) {
        this.lossDatetime = lossDatetime;
    }

    @Basic
    @Column(name = "loss_people_id")
    public String getLossPeopleId() {
        return lossPeopleId;
    }

    public void setLossPeopleId(String lossPeopleId) {
        this.lossPeopleId = lossPeopleId;
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
    @Column(name = "loss_status")
    public String getLossStatus() {
        return lossStatus;
    }

    public void setLossStatus(String lossStatus) {
        this.lossStatus = lossStatus;
    }

    @Basic
    @Column(name = "loss_pno")
    public String getLossPno() {
        return lossPno;
    }

    public void setLossPno(String lossPno) {
        this.lossPno = lossPno;
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
    @Column(name = "back_rec_remark")
    public String getBackRecRemark() {
        return backRecRemark;
    }

    public void setBackRecRemark(String backRecRemark) {
        this.backRecRemark = backRecRemark;
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

        SpLossMainEntity that = (SpLossMainEntity) o;

        if (lossMainId != null ? !lossMainId.equals(that.lossMainId) : that.lossMainId != null) return false;
        if (storeCodeFrom != null ? !storeCodeFrom.equals(that.storeCodeFrom) : that.storeCodeFrom != null)
            return false;
        if (storeCodeTo != null ? !storeCodeTo.equals(that.storeCodeTo) : that.storeCodeTo != null) return false;
        if (lossNo != null ? !lossNo.equals(that.lossNo) : that.lossNo != null) return false;
        if (logisNo != null ? !logisNo.equals(that.logisNo) : that.logisNo != null) return false;
        if (logisName != null ? !logisName.equals(that.logisName) : that.logisName != null) return false;
        if (spareKindCount != null ? !spareKindCount.equals(that.spareKindCount) : that.spareKindCount != null)
            return false;
        if (lossDatetime != null ? !lossDatetime.equals(that.lossDatetime) : that.lossDatetime != null) return false;
        if (lossPeopleId != null ? !lossPeopleId.equals(that.lossPeopleId) : that.lossPeopleId != null) return false;
        if (auditorDatetime != null ? !auditorDatetime.equals(that.auditorDatetime) : that.auditorDatetime != null)
            return false;
        if (auditorPeopleId != null ? !auditorPeopleId.equals(that.auditorPeopleId) : that.auditorPeopleId != null)
            return false;
        if (outDatetime != null ? !outDatetime.equals(that.outDatetime) : that.outDatetime != null) return false;
        if (outPeopleId != null ? !outPeopleId.equals(that.outPeopleId) : that.outPeopleId != null) return false;
        if (inDatetime != null ? !inDatetime.equals(that.inDatetime) : that.inDatetime != null) return false;
        if (inPeopleId != null ? !inPeopleId.equals(that.inPeopleId) : that.inPeopleId != null) return false;
        if (lossStatus != null ? !lossStatus.equals(that.lossStatus) : that.lossStatus != null) return false;
        if (lossPno != null ? !lossPno.equals(that.lossPno) : that.lossPno != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (backRemark != null ? !backRemark.equals(that.backRemark) : that.backRemark != null) return false;
        if (backRecRemark != null ? !backRecRemark.equals(that.backRecRemark) : that.backRecRemark != null)
            return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lossMainId != null ? lossMainId.hashCode() : 0;
        result = 31 * result + (storeCodeFrom != null ? storeCodeFrom.hashCode() : 0);
        result = 31 * result + (storeCodeTo != null ? storeCodeTo.hashCode() : 0);
        result = 31 * result + (lossNo != null ? lossNo.hashCode() : 0);
        result = 31 * result + (logisNo != null ? logisNo.hashCode() : 0);
        result = 31 * result + (logisName != null ? logisName.hashCode() : 0);
        result = 31 * result + (spareKindCount != null ? spareKindCount.hashCode() : 0);
        result = 31 * result + (lossDatetime != null ? lossDatetime.hashCode() : 0);
        result = 31 * result + (lossPeopleId != null ? lossPeopleId.hashCode() : 0);
        result = 31 * result + (auditorDatetime != null ? auditorDatetime.hashCode() : 0);
        result = 31 * result + (auditorPeopleId != null ? auditorPeopleId.hashCode() : 0);
        result = 31 * result + (outDatetime != null ? outDatetime.hashCode() : 0);
        result = 31 * result + (outPeopleId != null ? outPeopleId.hashCode() : 0);
        result = 31 * result + (inDatetime != null ? inDatetime.hashCode() : 0);
        result = 31 * result + (inPeopleId != null ? inPeopleId.hashCode() : 0);
        result = 31 * result + (lossStatus != null ? lossStatus.hashCode() : 0);
        result = 31 * result + (lossPno != null ? lossPno.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (backRemark != null ? backRemark.hashCode() : 0);
        result = 31 * result + (backRecRemark != null ? backRecRemark.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
