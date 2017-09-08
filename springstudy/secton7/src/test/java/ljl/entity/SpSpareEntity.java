package ljl.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "sp_spare", schema = "spm", catalog = "")
public class SpSpareEntity {
    private String spareId;
    private String spareCode;
    private String spareName;
    private BigDecimal sparePrice;
    private String remark;
    private Timestamp createDate;
    private Timestamp updateDate;
    private String delFlag;
    private String materialBarcode;
    private String materialMnecode;
    private String materialShortname;
    private String materialSpec;
    private String materialType;
    private String unitHeight;
    private String unitLength;
    private String unitWidth;
    private BigDecimal unitVolume;
    private BigDecimal unitWeight;
    private Integer version;

    @Id
    @Column(name = "spare_id")
    public String getSpareId() {
        return spareId;
    }

    public void setSpareId(String spareId) {
        this.spareId = spareId;
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
    @Column(name = "spare_name")
    public String getSpareName() {
        return spareName;
    }

    public void setSpareName(String spareName) {
        this.spareName = spareName;
    }

    @Basic
    @Column(name = "spare_price")
    public BigDecimal getSparePrice() {
        return sparePrice;
    }

    public void setSparePrice(BigDecimal sparePrice) {
        this.sparePrice = sparePrice;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Basic
    @Column(name = "del_flag")
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Basic
    @Column(name = "material_barcode")
    public String getMaterialBarcode() {
        return materialBarcode;
    }

    public void setMaterialBarcode(String materialBarcode) {
        this.materialBarcode = materialBarcode;
    }

    @Basic
    @Column(name = "material_mnecode")
    public String getMaterialMnecode() {
        return materialMnecode;
    }

    public void setMaterialMnecode(String materialMnecode) {
        this.materialMnecode = materialMnecode;
    }

    @Basic
    @Column(name = "material_shortname")
    public String getMaterialShortname() {
        return materialShortname;
    }

    public void setMaterialShortname(String materialShortname) {
        this.materialShortname = materialShortname;
    }

    @Basic
    @Column(name = "material_spec")
    public String getMaterialSpec() {
        return materialSpec;
    }

    public void setMaterialSpec(String materialSpec) {
        this.materialSpec = materialSpec;
    }

    @Basic
    @Column(name = "material_type")
    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    @Basic
    @Column(name = "unit_height")
    public String getUnitHeight() {
        return unitHeight;
    }

    public void setUnitHeight(String unitHeight) {
        this.unitHeight = unitHeight;
    }

    @Basic
    @Column(name = "unit_length")
    public String getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(String unitLength) {
        this.unitLength = unitLength;
    }

    @Basic
    @Column(name = "unit_width")
    public String getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(String unitWidth) {
        this.unitWidth = unitWidth;
    }

    @Basic
    @Column(name = "unit_volume")
    public BigDecimal getUnitVolume() {
        return unitVolume;
    }

    public void setUnitVolume(BigDecimal unitVolume) {
        this.unitVolume = unitVolume;
    }

    @Basic
    @Column(name = "unit_weight")
    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(BigDecimal unitWeight) {
        this.unitWeight = unitWeight;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpSpareEntity that = (SpSpareEntity) o;

        if (spareId != null ? !spareId.equals(that.spareId) : that.spareId != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (spareName != null ? !spareName.equals(that.spareName) : that.spareName != null) return false;
        if (sparePrice != null ? !sparePrice.equals(that.sparePrice) : that.sparePrice != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;
        if (materialBarcode != null ? !materialBarcode.equals(that.materialBarcode) : that.materialBarcode != null)
            return false;
        if (materialMnecode != null ? !materialMnecode.equals(that.materialMnecode) : that.materialMnecode != null)
            return false;
        if (materialShortname != null ? !materialShortname.equals(that.materialShortname) : that.materialShortname != null)
            return false;
        if (materialSpec != null ? !materialSpec.equals(that.materialSpec) : that.materialSpec != null) return false;
        if (materialType != null ? !materialType.equals(that.materialType) : that.materialType != null) return false;
        if (unitHeight != null ? !unitHeight.equals(that.unitHeight) : that.unitHeight != null) return false;
        if (unitLength != null ? !unitLength.equals(that.unitLength) : that.unitLength != null) return false;
        if (unitWidth != null ? !unitWidth.equals(that.unitWidth) : that.unitWidth != null) return false;
        if (unitVolume != null ? !unitVolume.equals(that.unitVolume) : that.unitVolume != null) return false;
        if (unitWeight != null ? !unitWeight.equals(that.unitWeight) : that.unitWeight != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spareId != null ? spareId.hashCode() : 0;
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (spareName != null ? spareName.hashCode() : 0);
        result = 31 * result + (sparePrice != null ? sparePrice.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        result = 31 * result + (materialBarcode != null ? materialBarcode.hashCode() : 0);
        result = 31 * result + (materialMnecode != null ? materialMnecode.hashCode() : 0);
        result = 31 * result + (materialShortname != null ? materialShortname.hashCode() : 0);
        result = 31 * result + (materialSpec != null ? materialSpec.hashCode() : 0);
        result = 31 * result + (materialType != null ? materialType.hashCode() : 0);
        result = 31 * result + (unitHeight != null ? unitHeight.hashCode() : 0);
        result = 31 * result + (unitLength != null ? unitLength.hashCode() : 0);
        result = 31 * result + (unitWidth != null ? unitWidth.hashCode() : 0);
        result = 31 * result + (unitVolume != null ? unitVolume.hashCode() : 0);
        result = 31 * result + (unitWeight != null ? unitWeight.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
