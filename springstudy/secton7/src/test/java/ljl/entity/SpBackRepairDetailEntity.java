package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_back_repair_detail", schema = "spm", catalog = "")
public class SpBackRepairDetailEntity {
    private String backRepairDetailId;
    private String backRepairMainId;
    private String spareCode;
    private int spareCount;
    private int spareOutCount;
    private Timestamp createDate;

    @Id
    @Column(name = "back_repair_detail_id")
    public String getBackRepairDetailId() {
        return backRepairDetailId;
    }

    public void setBackRepairDetailId(String backRepairDetailId) {
        this.backRepairDetailId = backRepairDetailId;
    }

    @Basic
    @Column(name = "back_repair_main_id")
    public String getBackRepairMainId() {
        return backRepairMainId;
    }

    public void setBackRepairMainId(String backRepairMainId) {
        this.backRepairMainId = backRepairMainId;
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
    @Column(name = "spare_out_count")
    public int getSpareOutCount() {
        return spareOutCount;
    }

    public void setSpareOutCount(int spareOutCount) {
        this.spareOutCount = spareOutCount;
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

        SpBackRepairDetailEntity that = (SpBackRepairDetailEntity) o;

        if (spareCount != that.spareCount) return false;
        if (spareOutCount != that.spareOutCount) return false;
        if (backRepairDetailId != null ? !backRepairDetailId.equals(that.backRepairDetailId) : that.backRepairDetailId != null)
            return false;
        if (backRepairMainId != null ? !backRepairMainId.equals(that.backRepairMainId) : that.backRepairMainId != null)
            return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = backRepairDetailId != null ? backRepairDetailId.hashCode() : 0;
        result = 31 * result + (backRepairMainId != null ? backRepairMainId.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + spareCount;
        result = 31 * result + spareOutCount;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
