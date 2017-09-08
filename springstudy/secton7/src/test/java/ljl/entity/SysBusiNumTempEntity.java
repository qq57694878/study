package ljl.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_busi_num_temp", schema = "spm", catalog = "")
public class SysBusiNumTempEntity {
    private String busiNumTempId;
    private String prefix;
    private String numRule;

    @Id
    @Column(name = "busi_num_temp_id")
    public String getBusiNumTempId() {
        return busiNumTempId;
    }

    public void setBusiNumTempId(String busiNumTempId) {
        this.busiNumTempId = busiNumTempId;
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
    @Column(name = "num_rule")
    public String getNumRule() {
        return numRule;
    }

    public void setNumRule(String numRule) {
        this.numRule = numRule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysBusiNumTempEntity that = (SysBusiNumTempEntity) o;

        if (busiNumTempId != null ? !busiNumTempId.equals(that.busiNumTempId) : that.busiNumTempId != null)
            return false;
        if (prefix != null ? !prefix.equals(that.prefix) : that.prefix != null) return false;
        if (numRule != null ? !numRule.equals(that.numRule) : that.numRule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = busiNumTempId != null ? busiNumTempId.hashCode() : 0;
        result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
        result = 31 * result + (numRule != null ? numRule.hashCode() : 0);
        return result;
    }
}
