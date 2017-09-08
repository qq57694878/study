package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_apply_detail", schema = "spm", catalog = "")
public class SpApplyDetailEntity {
    private String applyDetailId;
    private String applyMainId;
    private String spareCode;
    private int spareApplyCount;
    private Timestamp createDate;

    @Id
    @Column(name = "apply_detail_id")
    public String getApplyDetailId() {
        return applyDetailId;
    }

    public void setApplyDetailId(String applyDetailId) {
        this.applyDetailId = applyDetailId;
    }

    @Basic
    @Column(name = "apply_main_id")
    public String getApplyMainId() {
        return applyMainId;
    }

    public void setApplyMainId(String applyMainId) {
        this.applyMainId = applyMainId;
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
    @Column(name = "spare_apply_count")
    public int getSpareApplyCount() {
        return spareApplyCount;
    }

    public void setSpareApplyCount(int spareApplyCount) {
        this.spareApplyCount = spareApplyCount;
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

        SpApplyDetailEntity that = (SpApplyDetailEntity) o;

        if (spareApplyCount != that.spareApplyCount) return false;
        if (applyDetailId != null ? !applyDetailId.equals(that.applyDetailId) : that.applyDetailId != null)
            return false;
        if (applyMainId != null ? !applyMainId.equals(that.applyMainId) : that.applyMainId != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applyDetailId != null ? applyDetailId.hashCode() : 0;
        result = 31 * result + (applyMainId != null ? applyMainId.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + spareApplyCount;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
