package com.byzCorp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class GenericDao {

    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Deprecated
    protected Session getCurrentSession()  {
        return (Session) entityManager.getDelegate();
    }

    public void saveOrUpdate(Object o) {
        getCurrentSession().saveOrUpdate(o);
        getCurrentSession().flush();
       // getHibernateTemplate().saveOrUpdate(o);
        //getHibernateTemplate().flush();
    }
    public <T> T loadObject(Class<T> clazz, Serializable id) {
        return (T) getCurrentSession().get(clazz,id);
        //return (T) getHibernateTemplate().get(clazz, id);
    }
    /*public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
        //return getHibernateTemplate().getSessionFactory().getCurrentSession();
    }*/

    public void removeObject(Object o) { //Object almaz
        getCurrentSession().delete(o);
        getCurrentSession().flush();
    }

    public Session getSession() {
        return getCurrentSession();
        //return getHibernateTemplate().getSessionFactory().getCurrentSession();
    }

}
