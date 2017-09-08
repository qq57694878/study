package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_back_repair_main", schema = "spm", catalog = "")
public class SpBackRepairMainEntity {
    private String backRepairMainId;
    private String storeCode;
    private String backRepairNo;
    private Integer spareKindCount;
    private String remark;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;
    private String delFlag;

    @Id
    @Column(name = "back_repair_main_id")
    public String getBackRepairMainId() {
        return backRepairMainId;
    }

    public void setBackRepairMainId(String backRepairMainId) {
        this.backRepairMainId = backRepairMainId;
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
    @Column(name = "back_repair_no")
    public String getBackRepairNo() {
        return backRepairNo;
    }

    public void setBackRepairNo(String backRepairNo) {
        this.backRepairNo = backRepairNo;
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

        SpBackRepairMainEntity that = (SpBackRepairMainEntity) o;

        if (backRepairMainId != null ? !backRepairMainId.equals(that.backRepairMainId) : that.backRepairMainId != null)
            return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (backRepairNo != null ? !backRepairNo.equals(that.backRepairNo) : that.backRepairNo != null) return false;
        if (spareKindCount != null ? !spareKindCount.equals(that.spareKindCount) : that.spareKindCount != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = backRepairMainId != null ? backRepairMainId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (backRepairNo != null ? backRepairNo.hashCode() : 0);
        result = 31 * result + (spareKindCount != null ? spareKindCount.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        return result;
    }
}
