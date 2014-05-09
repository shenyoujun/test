package OP.Services;

import OP.Model.MenuEntity;
import OP.PageModel.Menu;

import java.util.List;

/**
 * Created by Administrator on 14-2-6.
 */
public interface MenuServiceI  {

    public List<Menu> getTree(String id);
}
