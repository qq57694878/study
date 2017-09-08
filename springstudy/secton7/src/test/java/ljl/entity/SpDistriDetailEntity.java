package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_distri_detail", schema = "spm", catalog = "")
public class SpDistriDetailEntity {
    private String distriDetailId;
    private String distriMainId;
    private String spareCode;
    private int spareNeedCount;
    private Integer spareCount;
    private Timestamp createDate;

    @Id
    @Column(name = "distri_detail_id")
    public String getDistriDetailId() {
        return distriDetailId;
    }

    public void setDistriDetailId(String distriDetailId) {
        this.distriDetailId = distriDetailId;
    }

    @Basic
    @Column(name = "distri_main_id")
    public String getDistriMainId() {
        return distriMainId;
    }

    public void setDistriMainId(String distriMainId) {
        this.distriMainId = distriMainId;
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
    @Column(name = "spare_need_count")
    public int getSpareNeedCount() {
        return spareNeedCount;
    }

    public void setSpareNeedCount(int spareNeedCount) {
        this.spareNeedCount = spareNeedCount;
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

        SpDistriDetailEntity that = (SpDistriDetailEntity) o;

        if (spareNeedCount != that.spareNeedCount) return false;
        if (distriDetailId != null ? !distriDetailId.equals(that.distriDetailId) : that.distriDetailId != null)
            return false;
        if (distriMainId != null ? !distriMainId.equals(that.distriMainId) : that.distriMainId != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (spareCount != null ? !spareCount.equals(that.spareCount) : that.spareCount != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = distriDetailId != null ? distriDetailId.hashCode() : 0;
        result = 31 * result + (distriMainId != null ? distriMainId.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + spareNeedCount;
        result = 31 * result + (spareCount != null ? spareCount.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
