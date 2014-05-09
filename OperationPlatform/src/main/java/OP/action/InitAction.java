package OP.action;

import OP.Dao.MenuDao;
import OP.PageModel.Menu;
import OP.Services.InitSerciceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Administrator on 14-2-6.
 */
@Action(value="InitAction")
public class InitAction extends  BaseAction implements ModelDriven<Menu>{
    @Autowired
    public void setInitSerciceI(InitSerciceI initSerciceI) {
        this.initSerciceI = initSerciceI;
    }


   private InitSerciceI initSerciceI;
    @Override
    public Menu getModel() {
        return null;
    }
    private Menu menu =new Menu();

    public void init(){
        initSerciceI.init();

    }

}
