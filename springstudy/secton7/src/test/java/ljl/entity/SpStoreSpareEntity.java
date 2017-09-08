package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_store_spare", schema = "spm", catalog = "")
public class SpStoreSpareEntity {
    private String storeSpareId;
    private String storeCode;
    private String spareCode;
    private int totalCount;
    private int completeCount;
    private int imperfectCount;
    private int completeOnwayCount;
    private int imperfectOnwayCount;
    private int imReplaceCount;
    private int imUseCount;
    private Integer storeLimit;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;

    @Id
    @Column(name = "store_spare_id")
    public String getStoreSpareId() {
        return storeSpareId;
    }

    public void setStoreSpareId(String storeSpareId) {
        this.storeSpareId = storeSpareId;
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
    @Column(name = "total_count")
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Basic
    @Column(name = "complete_count")
    public int getCompleteCount() {
        return completeCount;
    }

    public void setCompleteCount(int completeCount) {
        this.completeCount = completeCount;
    }

    @Basic
    @Column(name = "imperfect_count")
    public int getImperfectCount() {
        return imperfectCount;
    }

    public void setImperfectCount(int imperfectCount) {
        this.imperfectCount = imperfectCount;
    }

    @Basic
    @Column(name = "complete_onway_count")
    public int getCompleteOnwayCount() {
        return completeOnwayCount;
    }

    public void setCompleteOnwayCount(int completeOnwayCount) {
        this.completeOnwayCount = completeOnwayCount;
    }

    @Basic
    @Column(name = "imperfect_onway_count")
    public int getImperfectOnwayCount() {
        return imperfectOnwayCount;
    }

    public void setImperfectOnwayCount(int imperfectOnwayCount) {
        this.imperfectOnwayCount = imperfectOnwayCount;
    }

    @Basic
    @Column(name = "im_replace_count")
    public int getImReplaceCount() {
        return imReplaceCount;
    }

    public void setImReplaceCount(int imReplaceCount) {
        this.imReplaceCount = imReplaceCount;
    }

    @Basic
    @Column(name = "im_use_count")
    public int getImUseCount() {
        return imUseCount;
    }

    public void setImUseCount(int imUseCount) {
        this.imUseCount = imUseCount;
    }

    @Basic
    @Column(name = "store_limit")
    public Integer getStoreLimit() {
        return storeLimit;
    }

    public void setStoreLimit(Integer storeLimit) {
        this.storeLimit = storeLimit;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpStoreSpareEntity that = (SpStoreSpareEntity) o;

        if (totalCount != that.totalCount) return false;
        if (completeCount != that.completeCount) return false;
        if (imperfectCount != that.imperfectCount) return false;
        if (completeOnwayCount != that.completeOnwayCount) return false;
        if (imperfectOnwayCount != that.imperfectOnwayCount) return false;
        if (imReplaceCount != that.imReplaceCount) return false;
        if (imUseCount != that.imUseCount) return false;
        if (storeSpareId != null ? !storeSpareId.equals(that.storeSpareId) : that.storeSpareId != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (storeLimit != null ? !storeLimit.equals(that.storeLimit) : that.storeLimit != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeSpareId != null ? storeSpareId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + totalCount;
        result = 31 * result + completeCount;
        result = 31 * result + imperfectCount;
        result = 31 * result + completeOnwayCount;
        result = 31 * result + imperfectOnwayCount;
        result = 31 * result + imReplaceCount;
        result = 31 * result + imUseCount;
        result = 31 * result + (storeLimit != null ? storeLimit.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        return result;
    }
}
