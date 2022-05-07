package com.example.HiberTest.Repositories;

import com.example.HiberTest.Entities.subStr;
import com.example.HiberTest.Entities.textTable;
import com.example.HiberTest.Statistics.characterStats;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class subStrRepoImpl implements subStringRepo{

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<subStr> findALL() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<subStr> query = builder.createQuery(subStr.class);
        Root<subStr> root = query.from(subStr.class);
        query.select(root);
        Query<subStr> strQuery = sessionFactory.getCurrentSession().createQuery(query);
        return  strQuery.getResultList();

    }

    @Override
    @Transactional
    public Integer save(subStr str) {
        return (Integer) sessionFactory.getCurrentSession().save(str);
    }

    @Override
    @Transactional
    public void deleteAll() {
        String hql = "delete from subStr";
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();

        sessionFactory.getCurrentSession().createNativeQuery("ALTER SEQUENCE sub_str_str_id_seq RESTART WITH 1").executeUpdate();
        //ALTER TABLE sub_str  ALTER COLUMN str_id RESTART WITH 1
    }

    @Override
    @Transactional
    public void addSubStringFromText(List<String> recordings) {

        for(String e:recordings){
            this.save(new subStr(e));
        }

    }

    @Override
    @Transactional(readOnly = true)
    public subStr findByValue(String str) {
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("from subStr s where s.str = :str ");
        query.setParameter("str",str);
        return (subStr) query.getResultList().get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public subStr findById(Integer id) {
        return sessionFactory.getCurrentSession().get(subStr.class,id);
    }
}
