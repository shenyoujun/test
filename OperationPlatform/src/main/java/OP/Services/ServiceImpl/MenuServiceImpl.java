package OP.Services.ServiceImpl;

import OP.Dao.MenuDao;
import OP.Model.MenuEntity;
import OP.PageModel.Menu;
import OP.Services.MenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-2-6.
 */
@Service(value = "menuService")
public class MenuServiceImpl implements MenuServiceI {
    @Autowired
    private MenuDao menuDao;


    @Override
    public List<Menu> getTree(String id) {
        List<Menu> menus = new ArrayList<Menu>();
        Map<String, Object> params = new HashMap<String, Object>();
        String hql = null;
        if (id == null) {
            hql = "from MenuEntity m where ParentId is null";
        } else {
            params.put("id", id);
            hql = "from MenuEntity m where m.menuByParentId.id =:id";
        }
        List<MenuEntity> menuEntities = menuDao.find(hql, params);
        if (menuEntities != null && !menuEntities.isEmpty()) {
            for (MenuEntity m : menuEntities) {
                Menu menu = new Menu();
                menu.setId(m.getId());
                menu.setGetParentId(m.getMenuByParentId());
                menu.setMenuIcon(m.getMenuIcon());
                Map<String,Object> attributes =new HashMap<String, Object>();
                attributes.put("url",m.getMenuUrl());
                menu.setAttributes(attributes);
                menu.setText(m.getMenuName());
                if (m.getMenusById() != null && !m.getMenusById().isEmpty()) {
                    menu.setState("closed");
                }
                menus.add(menu);
            }
        }
        return menus;
    }
}
