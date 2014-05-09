package OP.Services.ServiceImpl;

import OP.Dao.ConfigurationHandbookDao;
import OP.Enum.ConfigurationhandbookEnum;
import OP.Model.ConfigurationhandbookEntity;
import OP.PageModel.DataGrid;
import OP.PageModel.HandBook;
import OP.Services.ConfigurationHandbookServiceI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.util.*;


/**
 * Created by Administrator on 14-2-11.
 */
@Service(value = "configurationHandbookServiceI")
public class ConfigurationHandbookServiceImpl implements ConfigurationHandbookServiceI {

    @Autowired
    private ConfigurationHandbookDao configurationHandbookDao;

    @Override
    public void upLoad(HandBook handBook) {
        ConfigurationhandbookEntity configurationhandbookEntity = new ConfigurationhandbookEntity();

        configurationhandbookEntity.setUrl(handBook.getUrl());
        configurationhandbookEntity.setCreatTime(handBook.getCreatTime());
        configurationhandbookEntity.setDocumentFileName(handBook.getDocumentNameFileName());
        configurationhandbookEntity.setDucumentSize((handBook.getDucumentNameContentLength()).intValue());
        configurationHandbookDao.Save(configurationhandbookEntity);

    }

    @Override
    public DataGrid datagrid(HandBook handBook) {
        DataGrid dataGrid = new DataGrid();
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("isEffective", 1);
        String hql = "select count(*) from ConfigurationhandbookEntity c where c.isEffective=:isEffective";

        List<ConfigurationhandbookEntity> configurationhandbookEntityList =
                configurationHandbookDao.find("from ConfigurationhandbookEntity c where c.isEffective=:isEffective", m, handBook.getPage(), handBook.getRows());
        Long total = configurationHandbookDao.count(hql, m);
        List<HandBook> handBookList = new ArrayList<HandBook>();
        for (ConfigurationhandbookEntity configurationhandbookEntity : configurationhandbookEntityList) {
            HandBook handBookToPage = new HandBook();
            handBookToPage.setDocumentNameFileName(configurationhandbookEntity.getDocumentFileName());
            handBookToPage.setUrl(configurationhandbookEntity.getUrl());
            handBookToPage.setDucumentNameContentLength(configurationhandbookEntity.getDucumentSize().longValue());
            handBookToPage.setCreatTime(configurationhandbookEntity.getCreatTime());
            handBookToPage.setId(configurationhandbookEntity.getId());
            handBookToPage.setLength(configurationhandbookEntity.getDucumentSize().longValue());
            handBookList.add(handBookToPage);
        }
        dataGrid.setTotal(total);
        dataGrid.setRows(handBookList);
        return dataGrid;
    }

    @Override
    public ConfigurationhandbookEntity search(int id) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("id", id);
        ConfigurationhandbookEntity configurationhandbookEntity = configurationHandbookDao.get("from ConfigurationhandbookEntity c where c.id=:id", m);
        return configurationhandbookEntity;

    }

    @Override
    public void delete(String ids) {
        if (ids.length() > 0) {
            for (String id : ids.split(",")) {
                ConfigurationhandbookEntity configurationhandbookEntity = search(Integer.parseInt(id));
                if(configurationhandbookEntity!=null){
                configurationhandbookEntity.setIsEffective(ConfigurationhandbookEnum.UNEFFECTIVE_STATUS.getCode());
                configurationHandbookDao.update(configurationhandbookEntity);
                }
                String url = configurationhandbookEntity.getUrl();
                File targetDeleteFile = new File(url);
                if(targetDeleteFile.exists()){
                    targetDeleteFile.delete();
                }
            }
        }
    }
}
