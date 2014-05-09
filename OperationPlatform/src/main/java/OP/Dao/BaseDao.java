package OP.Dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-28
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDao<T>  {
    public Serializable Save(T u);
    public T get (String hql);
    public T get(String hql,Map<String,Object> params);
    public void delete(T u);
    public void update(T u);
    public List<T> find(String hql);
    public List<T> find(String hql,int pageNow,int pageRows);
    public List<T> find(String hql,Map<String,Object> params);
    public List<T> find(String hql,Map<String,Object> params,int pageNow,int pageRows);
    public Long count(String hql);
    public Long count(String hql,Map<String,Object> params);
    public void saveOrUpdate(T o);

}
