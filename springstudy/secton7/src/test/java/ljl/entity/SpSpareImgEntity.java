package ljl.entity;

import javax.persistence.*;

@Entity
@Table(name = "sp_spare_img", schema = "spm", catalog = "")
public class SpSpareImgEntity {
    private String spareImgId;
    private String spareCode;
    private String imgUrl;

    @Id
    @Column(name = "spare_img_id")
    public String getSpareImgId() {
        return spareImgId;
    }

    public void setSpareImgId(String spareImgId) {
        this.spareImgId = spareImgId;
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
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpSpareImgEntity that = (SpSpareImgEntity) o;

        if (spareImgId != null ? !spareImgId.equals(that.spareImgId) : that.spareImgId != null) return false;
        if (spareCode != null ? !spareCode.equals(that.spareCode) : that.spareCode != null) return false;
        if (imgUrl != null ? !imgUrl.equals(that.imgUrl) : that.imgUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spareImgId != null ? spareImgId.hashCode() : 0;
        result = 31 * result + (spareCode != null ? spareCode.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }
}
