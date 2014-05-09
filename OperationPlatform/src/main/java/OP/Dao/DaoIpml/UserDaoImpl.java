package OP.Dao.DaoIpml;

import OP.Dao.UserDao;
import OP.Model.UserEntity;
import org.springframework.stereotype.Repository;


@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl<UserEntity>  implements UserDao  {



}
