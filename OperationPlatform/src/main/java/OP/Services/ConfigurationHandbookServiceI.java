package OP.Services;

import OP.Model.ConfigurationhandbookEntity;
import OP.PageModel.DataGrid;
import OP.PageModel.HandBook;

/**
 * Created by Administrator on 14-2-11.
 */
public interface ConfigurationHandbookServiceI {
    public void upLoad(HandBook handBook);
    public DataGrid datagrid(HandBook handBook);
    public ConfigurationhandbookEntity search(int id);
    public void delete(String ids);
}
