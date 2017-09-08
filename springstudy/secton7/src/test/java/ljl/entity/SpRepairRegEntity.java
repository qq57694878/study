package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_repair_reg", schema = "spm", catalog = "")
public class SpRepairRegEntity {
    private String repairRegId;
    private String storeCode;
    private String spareCode;
    private int spareCount;
    private String repairType;
    private String repairPeopleId;
    private String repairRemark;
    private Timestamp repairDatetime;
    private String lossNo;
    private String repairNo;
    private String repairOrg;
    private String repairTel;
    private String deviceNo;
    private String isOutWarranty;

    @Id
    @Column(name = "repair_reg_id")
    public String getRepairRegId() {
        return repairRegId;
    }

    public void setRepairRegId(String repairRegId) {
        this.repairRegId = repairRegId;
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
    @Column(name = "spare_count")
    public int getSpareCount() {
        return spareCount;
    }

    public void setSpareCount(int spareCount) {
        this.spareCount = spareCount;
    }

    @Basic
    @Column(name = "repair_type")
    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    @Basic
    @Column(name = "repair_people_id")
    public String getRepairPeopleId() {
        return repairPeopleId;
    }

    public void setRepairPeopleId(String repairPeopleId) {
        this.repairPeopleId = repairPeopleId;
    }

    @Basic
    @Column(name = "repair_remark")
    public String getRepairRemark() {
        return repairRemark;
    }

    public void setRepairRemark(String repairRemark) {
        this.repairRemark = repairRemark;
    }

    @Basic
    @Column(name = "repair_datetime")
    public Timestamp getRepairDatetime() {
        return repairDatetime;
    }

    public void setRepairDatetime(Timestamp repairDatetime) {
        this.repairDatetime = repairDatetime;
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
    @Column(name = "repair_no")
    public String getRepairNo() {
        return repairNo;
    }

    public void setRepairNo(String repairNo) {
        this.repairNo = repairNo;
    }

    @Basic
    @Column(name = "repair_org")
    public String getRepairOrg() {
        return repairOrg;
    }

    public void setRepairOrg(String repairOrg) {
        this.repairOrg = repairOrg;
    }

    @Basic
    @Column(name = "repair_tel")
    public String getRepairTel() {
        return repairTel;
    }

    public void setRepairTel(String repairTel) {
        this.repairTel = repairTel;
    }

    @Basic
    @Column(name = "device_no")
    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    @Basic
    @Column(name = "is_out_warranty")
    public String getIsOutWarranty() {
        return isOutWarranty;
    }

    public void setIsOutWarranty(String isOutWarranty) {
        this.isOutWarranty = isOutWarranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpRepairRegEntity that = (SpRepairRegEntity) o;

        if (spareCount != that.spareCount) return false;
        if (repairRegId != null ? !repairRegId.equals(that.repairRegId) : that.repairRegId != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (repairType != null ? !repairType.equals(that.repairType) : that.repairType != null) return false;
        if (repairPeopleId != null ? !repairPeopleId.equals(that.repairPeopleId) : that.repairPeopleId != null)
            return false;
        if (repairRemark != null ? !repairRemark.equals(that.repairRemark) : that.repairRemark != null) return false;
        if (repairDatetime != null ? !repairDatetime.equals(that.repairDatetime) : that.repairDatetime != null)
            return false;
        if (lossNo != null ? !lossNo.equals(that.lossNo) : that.lossNo != null) return false;
        if (repairNo != null ? !repairNo.equals(that.repairNo) : that.repairNo != null) return false;
        if (repairOrg != null ? !repairOrg.equals(that.repairOrg) : that.repairOrg != null) return false;
        if (repairTel != null ? !repairTel.equals(that.repairTel) : that.repairTel != null) return false;
        if (deviceNo != null ? !deviceNo.equals(that.deviceNo) : that.deviceNo != null) return false;
        if (isOutWarranty != null ? !isOutWarranty.equals(that.isOutWarranty) : that.isOutWarranty != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = repairRegId != null ? repairRegId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + spareCount;
        result = 31 * result + (repairType != null ? repairType.hashCode() : 0);
        result = 31 * result + (repairPeopleId != null ? repairPeopleId.hashCode() : 0);
        result = 31 * result + (repairRemark != null ? repairRemark.hashCode() : 0);
        result = 31 * result + (repairDatetime != null ? repairDatetime.hashCode() : 0);
        result = 31 * result + (lossNo != null ? lossNo.hashCode() : 0);
        result = 31 * result + (repairNo != null ? repairNo.hashCode() : 0);
        result = 31 * result + (repairOrg != null ? repairOrg.hashCode() : 0);
        result = 31 * result + (repairTel != null ? repairTel.hashCode() : 0);
        result = 31 * result + (deviceNo != null ? deviceNo.hashCode() : 0);
        result = 31 * result + (isOutWarranty != null ? isOutWarranty.hashCode() : 0);
        return result;
    }
}
