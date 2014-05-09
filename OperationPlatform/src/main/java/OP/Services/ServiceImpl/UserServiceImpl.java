package OP.Services.ServiceImpl;

import OP.Dao.UserDao;
import OP.Model.UserEntity;
import OP.PageModel.DataGrid;
import OP.PageModel.User;
import OP.Services.UserServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service(value = "userService")

public class UserServiceImpl implements UserServiceI {

    public UserDao getUserDao() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;
    private static Logger logger = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    @Override
    public void test() {
        logger.info("HelloWorld");
    }

    @Override
    public void save(UserEntity userEntity) {

        userDao.Save(userEntity);

    }

    @Override
    public UserEntity loginCheck(User user) {
        Map<String ,Object> params = new HashMap<String,Object>();
        params.put("loginName",user.getLoginName());
        UserEntity u =userDao.get("from UserEntity u where u.loginName= :loginName",params);
        if(u!=null){
            if(u.getPassWord().equals(user.getPassWord())){
                return u;
            }
            else return null;
        }
        return null;
    }
    public DataGrid dataGrid(User user){
        DataGrid dataGrid =new DataGrid();
        String hql ="select count(*) from UserEntity u";
        List<UserEntity> UserEntity =userDao.find("from UserEntity u ",user.getPage(),user.getRows());
        List<User> u = new ArrayList<User>();
        if(UserEntity!=null&&UserEntity.size()>0){
            for(UserEntity userEntity :UserEntity ){
                User us =new User();
                BeanUtils.copyProperties(userEntity,us);
                u.add(us);
            }
        }
        dataGrid.setRows(u);
        dataGrid.setTotal(userDao.count(hql));
        return  dataGrid;
    }
}
