package ljl.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "sys_menu", schema = "spm", catalog = "")
public class SysMenuEntity {
    private String menuId;
    private String menuName;
    private String menuPid;
    private String menuUrl;
    private Serializable menuType;
    private Timestamp updateDate;
    private String menuPermission;

    @Id
    @Column(name = "menu_id")
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "menu_name")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "menu_pid")
    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid;
    }

    @Basic
    @Column(name = "menu_url")
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Basic
    @Column(name = "menu_type")
    public Serializable getMenuType() {
        return menuType;
    }

    public void setMenuType(Serializable menuType) {
        this.menuType = menuType;
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
    @Column(name = "menu_permission")
    public String getMenuPermission() {
        return menuPermission;
    }

    public void setMenuPermission(String menuPermission) {
        this.menuPermission = menuPermission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysMenuEntity that = (SysMenuEntity) o;

        if (menuId != null ? !menuId.equals(that.menuId) : that.menuId != null) return false;
        if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;
        if (menuPid != null ? !menuPid.equals(that.menuPid) : that.menuPid != null) return false;
        if (menuUrl != null ? !menuUrl.equals(that.menuUrl) : that.menuUrl != null) return false;
        if (menuType != null ? !menuType.equals(that.menuType) : that.menuType != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (menuPermission != null ? !menuPermission.equals(that.menuPermission) : that.menuPermission != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = menuId != null ? menuId.hashCode() : 0;
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (menuPid != null ? menuPid.hashCode() : 0);
        result = 31 * result + (menuUrl != null ? menuUrl.hashCode() : 0);
        result = 31 * result + (menuType != null ? menuType.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (menuPermission != null ? menuPermission.hashCode() : 0);
        return result;
    }
}
