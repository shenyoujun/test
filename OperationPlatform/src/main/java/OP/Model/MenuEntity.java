package OP.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 14-2-6.
 */
@Entity
@Table(name = "menu", schema = "", catalog = "test")
public class MenuEntity {
    private String id;
    private String menuIcon;
    private String menuName;
    private String menuUrl;
    private MenuEntity menuByParentId;
    private Collection<MenuEntity> menusById;

    @Id
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MenuIcon")
    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    @Basic
    @Column(name = "MenuName")
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "MenuUrl")
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuEntity that = (MenuEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (menuIcon != null ? !menuIcon.equals(that.menuIcon) : that.menuIcon != null) return false;
        if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;
        if (menuUrl != null ? !menuUrl.equals(that.menuUrl) : that.menuUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (menuIcon != null ? menuIcon.hashCode() : 0);
        result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
        result = 31 * result + (menuUrl != null ? menuUrl.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ParentId", referencedColumnName = "Id")
    public MenuEntity getMenuByParentId() {
        return menuByParentId;
    }

    public void setMenuByParentId(MenuEntity menuByParentId) {
        this.menuByParentId = menuByParentId;
    }

    @OneToMany(mappedBy = "menuByParentId")
    public Collection<MenuEntity> getMenusById() {
        return menusById;
    }

    public void setMenusById(Collection<MenuEntity> menusById) {
        this.menusById = menusById;
    }
}
