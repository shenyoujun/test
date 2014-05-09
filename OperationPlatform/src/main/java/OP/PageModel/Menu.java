package OP.PageModel;

import OP.Model.MenuEntity;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Administrator on 14-2-6.
 */
public class Menu {

    private String id;
    private String text;

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public void setGetParentId(String getParentId) {
        this.getParentId = getParentId;
    }

    private Map<String, Object> attributes;
    private String menuIcon;
    private String getParentId;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getGetParentId() {
        return getParentId;
    }

    public void setGetParentId(MenuEntity menuEntity) {
        this.getParentId = getParentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
