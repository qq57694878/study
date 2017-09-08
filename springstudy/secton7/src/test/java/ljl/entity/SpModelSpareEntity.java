package ljl.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_model_spare", schema = "spm", catalog = "")
public class SpModelSpareEntity {
    private String modelSpareId;
    private String deviceModelId;
    private String spareCode;
    private Timestamp createDate;

    @Id
    @Column(name = "model_spare_id")
    public String getModelSpareId() {
        return modelSpareId;
    }

    public void setModelSpareId(String modelSpareId) {
        this.modelSpareId = modelSpareId;
    }

    @Basic
    @Column(name = "device_model_id")
    public String getDeviceModelId() {
        return deviceModelId;
    }

    public void setDeviceModelId(String deviceModelId) {
        this.deviceModelId = deviceModelId;
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

        SpModelSpareEntity that = (SpModelSpareEntity) o;

        if (modelSpareId != null ? !modelSpareId.equals(that.modelSpareId) : that.modelSpareId != null) return false;
        if (deviceModelId != null ? !deviceModelId.equals(that.deviceModelId) : that.deviceModelId != null)
            return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = modelSpareId != null ? modelSpareId.hashCode() : 0;
        result = 31 * result + (deviceModelId != null ? deviceModelId.hashCode() : 0);
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
