package com.example.HiberTest.Repositories;

import com.example.HiberTest.Entities.strStat;
import com.example.HiberTest.Entities.subStr;
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
public class strStatRepoImpl implements CrudRepo<strStat>{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<strStat> findAll() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<strStat> query = builder.createQuery(strStat.class);
        Root<strStat> root = query.from(strStat.class);
        query.select(root);
        Query<strStat> strQuery = sessionFactory.getCurrentSession().createQuery(query);
        return  strQuery.getResultList();
    }

    @Override
    @Transactional
    public Integer save(strStat element) {
        return (Integer) sessionFactory.getCurrentSession().save(element);
    }

    @Override
    @Transactional
    public void deleteAll() {
        String hql = "delete from strStat";
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<Object[]> getSumAndGroupByStats() {
        /*CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root<strStat> product = query.from(strStat.class);
        query.multiselect(
                product.get("strId"),
                //product.get("count"),
                //product.get("maxCount"),
                builder.<Integer>sum(product.<Integer> get("count")),
                builder.<Integer>sum(product.<Integer> get("maxCount")));

        query.groupBy(product.get("strId"));
        query.groupBy(product.get("count"));
        query.groupBy(product.get("maxCount"));
        return sessionFactory.getCurrentSession().createQuery(query).getResultList();*/
        javax.persistence.Query query = sessionFactory.getCurrentSession().createQuery("select str.strId, sum(str.count),sum(str.maxCount) from strStat str group by str.strId order by sum(str.count) desc ");
        //, str.count, str.maxCount
        return query.getResultList();
    }
}

//"select str.strId, sum(str.count),sum(str.maxCount) from strStat str group by str.strId order by str.strId "