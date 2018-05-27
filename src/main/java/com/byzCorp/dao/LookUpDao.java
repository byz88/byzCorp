package com.byzCorp.dao;

import com.byzCorp.model.LookUp;
import com.byzCorp.model.LookUpDetail;
import com.byzCorp.util.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LookUpDao extends GenericDao {

    public List<LookUp> getLookUps(String query, Integer start, Integer limit, Boolean isCount) {
        Criteria criteria = getCurrentSession().createCriteria(LookUp.class);
        if(query!=null){
            criteria.add(Restrictions.like("name", query, MatchMode.ANYWHERE).ignoreCase());
        }
        if(isCount){
            criteria.setProjection(Projections.rowCount());
        }else{
            if(start!=null && limit!=null){
                criteria.setFirstResult(start);
                criteria.setMaxResults(limit);
            }
        }
        criteria.addOrder(Order.asc("lookUpId"));
        return criteria.list();
    }

    public List<LookUpDetail> getLookUpDetails(Long lookUpId, String query, Integer start, Integer limit, Boolean isCount) {

        Criteria criteria = getCurrentSession().createCriteria(LookUpDetail.class);
        criteria.createAlias("lookUp", "lookUp");
        if(lookUpId!=null){
            criteria.add(Restrictions.eq("lookUp.lookUpId", lookUpId));
        }

        if(query!=null){
            criteria.add(Restrictions.like("name", query, MatchMode.ANYWHERE).ignoreCase());
        }
        if(isCount){
            criteria.setProjection(Projections.rowCount());
        }else{
            criteria.setFirstResult(start);
            criteria.setMaxResults(limit);
        }
        criteria.addOrder(Order.asc("orderNo"));
        return criteria.list();
    }

    public LookUpDetail getLookUpDetail(Long lookUpId, String lookUpDetailName) {
        Criteria criteria = getCurrentSession().createCriteria(LookUpDetail.class);
        if(lookUpId!=null){
            criteria.add(Restrictions.eq("lookUp.lookUpId", lookUpId));
        }
        if(lookUpDetailName!=null){
            criteria.add(Restrictions.eq("lookUpDetailName", lookUpDetailName));
        }
        return (LookUpDetail) criteria.uniqueResult();
    }

}
