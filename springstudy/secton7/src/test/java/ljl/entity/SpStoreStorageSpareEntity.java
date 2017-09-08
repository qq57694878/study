package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_store_storage_spare", schema = "spm", catalog = "")
public class SpStoreStorageSpareEntity {
    private String storeStorageSpareId;
    private String storeCode;
    private String storageCode;
    private String spareCode;
    private int spareCount;
    private int imReplaceCount;
    private int imUseCount;
    private Timestamp createDate;
    private Timestamp updateDate;

    @Id
    @Column(name = "store_storage_spare_id")
    public String getStoreStorageSpareId() {
        return storeStorageSpareId;
    }

    public void setStoreStorageSpareId(String storeStorageSpareId) {
        this.storeStorageSpareId = storeStorageSpareId;
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
    @Column(name = "storage_code")
    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
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
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpStoreStorageSpareEntity that = (SpStoreStorageSpareEntity) o;

        if (spareCount != that.spareCount) return false;
        if (imReplaceCount != that.imReplaceCount) return false;
        if (imUseCount != that.imUseCount) return false;
        if (storeStorageSpareId != null ? !storeStorageSpareId.equals(that.storeStorageSpareId) : that.storeStorageSpareId != null)
            return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (storageCode != null ? !storageCode.equals(that.storageCode) : that.storageCode != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeStorageSpareId != null ? storeStorageSpareId.hashCode() : 0;
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (storageCode != null ? storageCode.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + spareCount;
        result = 31 * result + imReplaceCount;
        result = 31 * result + imUseCount;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
