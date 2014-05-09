package OP.Dao.DaoIpml;

import OP.Dao.ConfigurationHandbookDao;
import OP.Model.ConfigurationhandbookEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 14-2-11.
 */

@Repository(value="configurationHandbook")
public class ConfigurationHandbookDaoImpl extends BaseDaoImpl<ConfigurationhandbookEntity> implements ConfigurationHandbookDao {
}
