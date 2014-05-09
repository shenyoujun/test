package OP.action;

import OP.Enum.ConfigurationhandbookEnum;
import OP.Model.ConfigurationhandbookEntity;
import OP.PageModel.HandBook;
import OP.PageModel.Json;
import OP.Services.ConfigurationHandbookServiceI;
import OP.Services.UserServiceI;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Administrator on 14-2-11.
 */
@Action(value = "ConfigurationHandbookAction")
public class ConfigurationHandbookAction extends BaseAction implements ModelDriven<HandBook> {
    private HandBook handBook = new HandBook();

    @Autowired
    private ConfigurationHandbookServiceI configurationHandbookServiceI;

    @Override
    public HandBook getModel() {
        return handBook;
    }

    public void upload() {
        Json json = new Json();
        File uploadFile = handBook.getDocumentName();
        String uploadFileFileName = handBook.getDocumentNameFileName();
        String msg = handBook.getMsg();
        try {
            String extName = "";
            String newFileName = "";
            if (uploadFileFileName.lastIndexOf(".") >= 0) {
                extName = uploadFileFileName.substring(uploadFileFileName
                        .lastIndexOf("."));
            }
            File targetFile = new File("f:/", uploadFileFileName);
            if(targetFile.exists()){
                targetFile=new File("f:/", (DateFormat.getDateInstance().format(new Date()))+uploadFileFileName);
            }
            save(targetFile.getPath(),targetFile.getName());
            FileUtils.copyFile(uploadFile, targetFile);
            //打印测试数据
            //System.out.println(uploadFileFileName+" "+uploadFile.length()+" "+targetFile.getPath());
            msg = "文件上传成功";
            json.setMsg(msg);
            json.setSuccess(true);
        } catch (Exception e) {
            msg = "文件上传失败!";
            e.printStackTrace();
            json.setMsg(msg + e.toString());
        }
        super.writeJson(json);
    }
    public void save(String path,String documentFileName){
        handBook.setCreatTime(new Date());
        handBook.setUodateTime(new Date());
        handBook.setUrl(path);
        handBook.setDocumentNameFileName(documentFileName);
        handBook.setDucumentNameContentLength(handBook.getDocumentName().length());
        configurationHandbookServiceI.upLoad(handBook);
    }

    public void delete(){
        Json json = new Json();
        String msg=handBook.getMsg();
        try{
        configurationHandbookServiceI.delete(handBook.getIds());
        json.setSuccess(true);
        json.setMsg("删除成功");
        }
        catch (Exception e){
        json.setMsg("删除失败"+e.toString());
        }
        super.writeJson(json);
    }

    public void dataGrid(){

        super.writeJson(configurationHandbookServiceI.datagrid(handBook));
    }

}
