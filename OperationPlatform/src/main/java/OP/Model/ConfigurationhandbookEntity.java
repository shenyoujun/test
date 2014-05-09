package OP.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Administrator on 14-2-11.
 */
@Entity
@Table(name = "configurationhandbook", schema = "", catalog = "test")
public class ConfigurationhandbookEntity {

    private int id;
    private String documentFileName;
    private String documentOwner;
    private Date creatTime;
    private Date updateTime;
    private String url;
    private Integer ducumentSize;
    private String documentName;
    private Integer isEffective =1;

    @Basic
    @Column(name = "documentFileName")
    public String getDocumentFileName() {
        return documentFileName;
    }

    public void setDocumentFileName(String documentFileName) {
        this.documentFileName = documentFileName;
    }


    @Basic
    @Column(name = "updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "documentName")
    public String getDocumentName() {
        return documentFileName;
    }

    public void setDocumentName(String documentName) {
        this.documentFileName = documentName;
    }

    @Basic
    @Column(name = "documentOwner")
    public String getDocumentOwner() {
        return documentOwner;
    }

    public void setDocumentOwner(String documentOwner) {
        this.documentOwner = documentOwner;
    }

    @Basic
    @Column(name = "creatTime")
    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigurationhandbookEntity that = (ConfigurationhandbookEntity) o;

        if (id != that.id) return false;
        if (creatTime != null ? !creatTime.equals(that.creatTime) : that.creatTime != null) return false;
        if (documentFileName != null ? !documentFileName.equals(that.documentFileName) : that.documentFileName != null) return false;
        if (documentOwner != null ? !documentOwner.equals(that.documentOwner) : that.documentOwner != null)
            return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (documentFileName != null ? documentFileName.hashCode() : 0);
        result = 31 * result + (documentOwner != null ? documentOwner.hashCode() : 0);
        result = 31 * result + (creatTime != null ? creatTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "ducumentSize")
    public Integer getDucumentSize() {
        return ducumentSize;
    }

    public void setDucumentSize(Integer ducumentSize) {
        this.ducumentSize = ducumentSize;
    }

    @Basic
    @Column(name = "isEffective")
    public Integer getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Integer isEffective) {
        this.isEffective = isEffective;
    }
}
