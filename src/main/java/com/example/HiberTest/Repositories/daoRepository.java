package com.example.HiberTest.Repositories;

import com.example.HiberTest.Entities.textTable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository("daoRepository")
public class daoRepository implements simpleDao{


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional(readOnly = true)
    public List<textTable> findAll() {

        return sessionFactory.getCurrentSession().createQuery("from textTable t").list();
        //return null;
    }

    @Override
    @Transactional
    public Integer save(textTable text) {
        return (Integer) sessionFactory.getCurrentSession().save(text);
        //session.flush()
    }

    @Override
    @Transactional
    public Boolean deleteById(Integer id) {
        String hqlDeleteRequest = "delete textTable where id = :id";
        Query query = sessionFactory.getCurrentSession().
                                     createQuery(hqlDeleteRequest).
                                     setParameter("id",id);
        int count  = query.executeUpdate();
        if(count>0)
            return true;
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public textTable findById(Integer id) {
        return sessionFactory.getCurrentSession().get(textTable.class,id);
    }
}
