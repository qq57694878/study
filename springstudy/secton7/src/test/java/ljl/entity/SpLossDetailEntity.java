package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_loss_detail", schema = "spm", catalog = "")
public class SpLossDetailEntity {
    private String lossDetailId;
    private String lossMainId;
    private String spareCode;
    private Integer spareCount;
    private Integer imRepairCount;
    private Integer imUseCount;
    private Timestamp createDate;

    @Id
    @Column(name = "loss_detail_id")
    public String getLossDetailId() {
        return lossDetailId;
    }

    public void setLossDetailId(String lossDetailId) {
        this.lossDetailId = lossDetailId;
    }

    @Basic
    @Column(name = "loss_main_id")
    public String getLossMainId() {
        return lossMainId;
    }

    public void setLossMainId(String lossMainId) {
        this.lossMainId = lossMainId;
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
    public Integer getSpareCount() {
        return spareCount;
    }

    public void setSpareCount(Integer spareCount) {
        this.spareCount = spareCount;
    }

    @Basic
    @Column(name = "im_repair_count")
    public Integer getImRepairCount() {
        return imRepairCount;
    }

    public void setImRepairCount(Integer imRepairCount) {
        this.imRepairCount = imRepairCount;
    }

    @Basic
    @Column(name = "im_use_count")
    public Integer getImUseCount() {
        return imUseCount;
    }

    public void setImUseCount(Integer imUseCount) {
        this.imUseCount = imUseCount;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpLossDetailEntity that = (SpLossDetailEntity) o;

        if (lossDetailId != null ? !lossDetailId.equals(that.lossDetailId) : that.lossDetailId != null) return false;
        if (lossMainId != null ? !lossMainId.equals(that.lossMainId) : that.lossMainId != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (spareCount != null ? !spareCount.equals(that.spareCount) : that.spareCount != null) return false;
        if (imRepairCount != null ? !imRepairCount.equals(that.imRepairCount) : that.imRepairCount != null)
            return false;
        if (imUseCount != null ? !imUseCount.equals(that.imUseCount) : that.imUseCount != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lossDetailId != null ? lossDetailId.hashCode() : 0;
        result = 31 * result + (lossMainId != null ? lossMainId.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (spareCount != null ? spareCount.hashCode() : 0);
        result = 31 * result + (imRepairCount != null ? imRepairCount.hashCode() : 0);
        result = 31 * result + (imUseCount != null ? imUseCount.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
