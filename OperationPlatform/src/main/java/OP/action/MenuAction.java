package OP.action;


import OP.Model.MenuEntity;
import OP.PageModel.Menu;
import OP.Services.MenuServiceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-2-6.
 */
@Action(value="MenuAction")
public class MenuAction extends  BaseAction implements ModelDriven<Menu>{
    @Autowired
    private MenuServiceI menuServiceI;

    private Menu menu =new Menu();
    @Override
    public Menu getModel() {
        return menu;
    }

    public void getTree(){
        List<Menu> menuEntities = menuServiceI.getTree(menu.getId());

        super.writeJson(menuEntities);
    }
}
