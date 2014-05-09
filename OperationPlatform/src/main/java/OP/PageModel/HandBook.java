package OP.PageModel;


import java.io.File;
import java.util.Date;

/**
 * Created by Administrator on 14-2-11.
 */
public class HandBook {
    private int id;
    private File documentName;
    private String documentNameFileName;
    private Date creatTime;
    private Date uodateTime;
    private String msg;
    private Long ducumentNameContentLength;
    private String url;
    private int page;
    private int rows;
    private String ids;
    private String Length;

    public String getLength() {
        return Length;
    }

    public void setLength(Long ducumentNameContentLength) {
        if (ducumentNameContentLength / 1024 / 1024 > 1) {
            Long l = ducumentNameContentLength / 1024 / 1024;
            Length = l.toString() + "M";
        } else {
            Long l = ducumentNameContentLength / 1024;
            Length = l.toString() + "k";
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File getDocumentName() {
        return documentName;
    }

    public void setDocumentName(File documentName) {
        this.documentName = documentName;
    }

    public String getDocumentNameFileName() {
        return documentNameFileName;
    }

    public void setDocumentNameFileName(String documentNameFileName) {
        this.documentNameFileName = documentNameFileName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUodateTime() {
        return uodateTime;
    }

    public void setUodateTime(Date uodateTime) {
        this.uodateTime = uodateTime;
    }

    public Long getDucumentNameContentLength() {
        return ducumentNameContentLength;
    }

    public void setDucumentNameContentLength(Long ducumentNameContentLength) {
        this.ducumentNameContentLength = ducumentNameContentLength;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
