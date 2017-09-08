package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_type_spare", schema = "spm", catalog = "")
public class SpTypeSpareEntity {
    private String typeSpareId;
    private String deviceTypeCode;
    private String spareCode;
    private Timestamp createDate;

    @Id
    @Column(name = "type_spare_id")
    public String getTypeSpareId() {
        return typeSpareId;
    }

    public void setTypeSpareId(String typeSpareId) {
        this.typeSpareId = typeSpareId;
    }

    @Basic
    @Column(name = "device_type_code")
    public String getDeviceTypeCode() {
        return deviceTypeCode;
    }

    public void setDeviceTypeCode(String deviceTypeCode) {
        this.deviceTypeCode = deviceTypeCode;
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

        SpTypeSpareEntity that = (SpTypeSpareEntity) o;

        if (typeSpareId != null ? !typeSpareId.equals(that.typeSpareId) : that.typeSpareId != null) return false;
        if (deviceTypeCode != null ? !deviceTypeCode.equals(that.deviceTypeCode) : that.deviceTypeCode != null)
            return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeSpareId != null ? typeSpareId.hashCode() : 0;
        result = 31 * result + (deviceTypeCode != null ? deviceTypeCode.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
