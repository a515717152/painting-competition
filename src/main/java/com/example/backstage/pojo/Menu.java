package com.example.backstage.pojo;

import com.example.backstage.common.Basic;

import java.util.Objects;

public class Menu extends Basic {

    private String id;
    private String title;
    private String introduction;
    private String href;
    private String target;
    private String icon;
    private String parent_id;
    private String sort;
    private String menu_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(title, menu.title) &&
                Objects.equals(introduction, menu.introduction) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(target, menu.target) &&
                Objects.equals(icon, menu.icon) &&
                Objects.equals(parent_id, menu.parent_id) &&
                Objects.equals(sort, menu.sort) &&
                Objects.equals(menu_type, menu.menu_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, title, introduction, href, target, icon, parent_id, sort, menu_type);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                ", href='" + href + '\'' +
                ", target='" + target + '\'' +
                ", icon='" + icon + '\'' +
                ", parent_id='" + parent_id + '\'' +
                ", sort='" + sort + '\'' +
                ", menu_type='" + menu_type + '\'' +
                '}';
    }
}
