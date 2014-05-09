package OP.PageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-2-8.
 */
public class DataGrid {
    private Long total=0L;
    private List rows =new ArrayList();

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
