package OP.Dao.DaoIpml;

import OP.Dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-28
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
@Repository(value = "baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    @Override
    public Serializable Save(T u) {


        return this.sessionFactory.getCurrentSession().save(u);
    }

    @Override
    public T get(String hql) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        List<T> list = q.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public T get(String hql, Map<String, Object> params) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        List<T> list = q.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void delete(T u) {
        this.sessionFactory.getCurrentSession().delete(u);
    }

    @Override
    public void update(T u) {
        this.sessionFactory.getCurrentSession().update(u);
    }

    @Override
    public List<T> find(String hql) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);

        List<T> list = q.list();

        return list;
    }

    @Override
    public List<T> find(String hql, int pageNow, int pageRows) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        List<T> list = q.setFirstResult((pageNow - 1) * pageRows).setMaxResults(pageRows).list();
        return list;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        List<T> list = q.list();
        return list;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params, int pageNow, int pageRows) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        List<T> list = q.setFirstResult((pageNow - 1) * pageRows).setMaxResults(pageRows).list();
        return list;
    }

    @Override
    public Long count(String hql) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        return (Long) q.uniqueResult();
    }

    @Override
    public Long count(String hql, Map<String, Object> params) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }

        }
        return (Long) q.uniqueResult();

    }

    @Override
    public void saveOrUpdate(T o) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    /*
    public T get(String hql,Object[] params) {
        Query q = this.sessionFactory.getCurrentSession().createQuery(hql);
        if(params!=null &&params.length>0){
            for(int i=0;i<params.length;i++){
              q.setParameter(i, params[i]);
            }
        }
        List<T> list=q.list();
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
    */
}
