package OP.Services.ServiceImpl;

import OP.Dao.MenuDao;
import OP.Model.MenuEntity;
import OP.Services.InitSerciceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 14-2-6.
 */
@Service(value="initService")
public class InitServiceImpl implements InitSerciceI {
    @Autowired
    private MenuDao menuDao;
    @Override
    public void init() {
        MenuEntity easyQuery =new MenuEntity();
        easyQuery.setId("0");
        easyQuery.setMenuName("简单查询");
        easyQuery.setMenuUrl("");
        menuDao.saveOrUpdate(easyQuery);

        MenuEntity ContractQuery =new MenuEntity();
        ContractQuery.setId("1");
        ContractQuery.setMenuName ("合同查询");
        ContractQuery.setMenuByParentId(easyQuery);
        menuDao.saveOrUpdate(ContractQuery);

        MenuEntity DealGroupQuery =new MenuEntity();
        DealGroupQuery.setId("2");
        DealGroupQuery.setMenuName("订单查询");
        DealGroupQuery.setMenuByParentId(easyQuery);
        DealGroupQuery.setMenuUrl("/DealGroupQuery.jsp");
        menuDao.saveOrUpdate(DealGroupQuery);

        MenuEntity documentQuery =new MenuEntity();
        documentQuery.setId("3");
        documentQuery.setMenuName("配置手册");
        menuDao.saveOrUpdate(documentQuery);

        MenuEntity CRM =new MenuEntity();
        CRM.setId("4");
        CRM.setMenuName("CRM");
        CRM.setMenuByParentId(documentQuery);
        CRM.setMenuUrl("/ConfigurationHandbook/ConfigurationHandbookForCrm.jsp");
        menuDao.saveOrUpdate(CRM);

        MenuEntity BS =new MenuEntity();
        BS.setId("5");
        BS.setMenuName("BS");
        BS.setMenuByParentId(documentQuery);
        menuDao.saveOrUpdate(BS);

        MenuEntity knowledge =new MenuEntity();
        knowledge.setId("6");
        knowledge.setMenuName("knowledge");
        knowledge.setMenuByParentId(documentQuery);
        menuDao.saveOrUpdate(knowledge);

        MenuEntity OperationDocuments =new MenuEntity();
        OperationDocuments.setId("7");
        OperationDocuments.setMenuName("操作手册");
        menuDao.saveOrUpdate(OperationDocuments);

        MenuEntity utils =new MenuEntity();
        utils.setId("8");
        utils.setMenuName("脚本工具");
        menuDao.saveOrUpdate(utils);

        MenuEntity systemManage =new MenuEntity();
        systemManage.setId("9");
        systemManage.setMenuName("系统管理");
        menuDao.saveOrUpdate(systemManage);

        MenuEntity userManage =new MenuEntity();
        userManage.setId("10");
        userManage.setMenuName("用户管理");
        userManage.setMenuByParentId(systemManage);
        userManage.setMenuUrl("/SystemManager/UserManager.jsp");
        menuDao.saveOrUpdate(userManage);

    }
}
