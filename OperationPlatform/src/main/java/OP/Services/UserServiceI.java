package OP.Services;

import OP.Model.UserEntity;
import OP.PageModel.DataGrid;
import OP.PageModel.User;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-20
 * Time: 下午9:35
 * To change this template use File | Settings | File Templates.
 */
public interface UserServiceI {
    public void test();

    public void save(UserEntity userEntity);

    public UserEntity  loginCheck(User user);

    public DataGrid dataGrid(User user);
}
