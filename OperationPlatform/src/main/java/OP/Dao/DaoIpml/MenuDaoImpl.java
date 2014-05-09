package OP.Dao.DaoIpml;

import OP.Dao.MenuDao;
import OP.Model.MenuEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 14-2-6.
 */
@Repository(value = "menuDao")
public class MenuDaoImpl extends BaseDaoImpl<MenuEntity> implements MenuDao {
}
