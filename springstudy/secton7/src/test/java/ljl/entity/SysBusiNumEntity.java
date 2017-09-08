package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sys_busi_num", schema = "spm", catalog = "")
public class SysBusiNumEntity {
    private String busiNumId;
    private String prefix;
    private String storeCode;
    private String lastDate;
    private String lastNum;
    private String lastCount;
    private Timestamp createDate;
    private String createBy;
    private Timestamp updateDate;
    private String updateBy;

    @Id
    @Column(name = "busi_num_id")
    public String getBusiNumId() {
        return busiNumId;
    }

    public void setBusiNumId(String busiNumId) {
        this.busiNumId = busiNumId;
    }

    @Basic
    @Column(name = "prefix")
    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
    @Column(name = "last_date")
    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Basic
    @Column(name = "last_num")
    public String getLastNum() {
        return lastNum;
    }

    public void setLastNum(String lastNum) {
        this.lastNum = lastNum;
    }

    @Basic
    @Column(name = "last_count")
    public String getLastCount() {
        return lastCount;
    }

    public void setLastCount(String lastCount) {
        this.lastCount = lastCount;
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

        SysBusiNumEntity that = (SysBusiNumEntity) o;

        if (busiNumId != null ? !busiNumId.equals(that.busiNumId) : that.busiNumId != null) return false;
        if (prefix != null ? !prefix.equals(that.prefix) : that.prefix != null) return false;
        if (storeCode != null ? !storeCode.equals(that.storeCode) : that.storeCode != null) return false;
        if (lastDate != null ? !lastDate.equals(that.lastDate) : that.lastDate != null) return false;
        if (lastNum != null ? !lastNum.equals(that.lastNum) : that.lastNum != null) return false;
        if (lastCount != null ? !lastCount.equals(that.lastCount) : that.lastCount != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateBy != null ? !updateBy.equals(that.updateBy) : that.updateBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = busiNumId != null ? busiNumId.hashCode() : 0;
        result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
        result = 31 * result + (storeCode != null ? storeCode.hashCode() : 0);
        result = 31 * result + (lastDate != null ? lastDate.hashCode() : 0);
        result = 31 * result + (lastNum != null ? lastNum.hashCode() : 0);
        result = 31 * result + (lastCount != null ? lastCount.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        return result;
    }
}
