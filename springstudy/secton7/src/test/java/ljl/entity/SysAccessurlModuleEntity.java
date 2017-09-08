package ljl.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_accessurl_module", schema = "spm", catalog = "")
public class SysAccessurlModuleEntity {
    private int id;
    private String url;
    private String module;
    private String operation;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "module")
    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Basic
    @Column(name = "operation")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysAccessurlModuleEntity that = (SysAccessurlModuleEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (module != null ? !module.equals(that.module) : that.module != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}
