package OP.action;

import com.alibaba.fastjson.JSON;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-27
 * Time: 下午2:25
 * To change this template use File | Settings | File Templates.
 */
@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction {
     public void writeJson(Object object){
         try{
         String json = JSON.toJSONStringWithDateFormat(object,"yyyy-MM-dd HH:mm:ss");
         ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
         ServletActionContext.getResponse().getWriter().write(json);
         ServletActionContext.getResponse().getWriter().flush();
         ServletActionContext.getResponse().getWriter().close();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
}
