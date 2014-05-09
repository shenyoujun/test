package OP.action;


import OP.Model.UserEntity;
import OP.PageModel.DataGrid;
import OP.PageModel.Json;
import OP.PageModel.User;
import OP.Services.UserServiceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "UserAction")
public class UserAction extends BaseAction implements ModelDriven<User> {
    private User user = new User();
    @Autowired
    private UserServiceI userServiceI;


    private static final Logger logger = Logger.getLogger(String.valueOf(UserAction.class));


    @Override
    public User getModel() {
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void reg() {
        Json json = new Json();
        try {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user, userEntity);
            userEntity.setCreatTime(new Date());
            userServiceI.save(userEntity);
            json.setSuccess(true);
            json.setMsg("注册成功");
        } catch (Exception e) {
            json.setMsg("注册失败"+e.toString());

        }
        super.writeJson(json);
    }

    public void login() {
    Json json = new Json();
    UserEntity userEntity =userServiceI.loginCheck(user);
    if(userEntity!=null){
        json.setSuccess(true);
        json.setMsg("登入成功");
    }else{
        json.setMsg("登入失败，账号密码错误");
    }
        super.writeJson(json);
    }

    public void dataGrid(){

        super.writeJson(userServiceI.dataGrid(user));
    }


}
