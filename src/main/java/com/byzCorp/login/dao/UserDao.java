package com.byzCorp.login.dao;

import com.byzCorp.login.model.*;
import com.byzCorp.model.HrLeave;
import com.byzCorp.util.GenericDao;
import com.byzCorp.util.MException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserDao extends GenericDao {

    public List<Map<String, Object>> getUser(String userName, String password) throws MException {
        String hql = "Select new map(";
        hql += " u.userId as userId," +
                " u.userName as userName," +
                " u.titleId as titleId," +
                " (select lud.name from LookUpDetail lud where lud.lookUp.lookUpId =43 and lud.value = u.titleId) as titleName" +
                " )";
        hql += " From Users u " +
                " where 1=1";

        if(userName!=null){
            hql += " and u.userName = :userName";
        }

        if(password!=null){
            hql += " and u.password = :password";
        }
        Query q = getCurrentSession().createQuery(hql);
        if(userName!=null){
            q.setString("userName",userName);
        }

        if(password!=null){
            q.setString("password",password);
        }
        return q.list();
    }

    public Users getUserByUserName(String userName) throws MException {
        Criteria criteria = getCurrentSession().createCriteria(Users.class);
        criteria.add(Restrictions.eq("userName", userName));
        return (Users) criteria.uniqueResult();
    }

    public List<Users> getUserDetail(Long userId) {
        String hql = "Select new map(";
        hql += " u.userId as userId," +
                " u.userName as userName," +
                " u.managerId as managerId," +
                " u.branchId as branchId," +
                " u.departmentId as departmentId," +
                " u.titleId as titleId," +
                " u.workTypeId as workTypeId," +
                " u.identityNo as identityNo," +
                " u.firstName ||' '|| u.lastName as firstAndLastName," +
                " u.firstName as firstName," +
                " u.lastName as lastName," +
                " u.email as email," +
                " u.mobilePhone as mobilePhone," +
                " u.roleId as roleId," +
                " to_char(u.startWorkDate,'dd/mm/yyyy') as startWorkDate," +
                " to_char(u.insuranceDate,'dd/mm/yyyy') as insuranceDate," +
                " u.citizenId as citizenId," +
                " u.genderId as genderId," +
                " u.boodTypeId as boodTypeId," +
                " u.maritialStatusId as maritialStatusId," +
                " u.childCount as childCount," +
                " u.birthPlace as birthPlace," +
                " to_char(u.birthDate,'dd/mm/yyyy') as birthDate," +
                " u.fatherName as fatherName," +
                " u.motherName as motherName," +
                " u.classId as classId," +
                " u.licenceNo as licenceNo," +
                " to_char(u.issuedDate,'dd/mm/yyyy') as issuedDate," +
                " u.issuedProvinceId as issuedProvinceId," +
                " u.issuedCountryId as issuedCountryId," +
                " u.disabledId as disabledId," +
                " u.countryId as countryId," +
                " u.provinceId as provinceId," +
                " u.village as village," +
                " u.zipCode as zipCode," +
                " u.addressDescription as addressDescription," +
                " u.homePhone as homePhone," +
                " u.emergencyPerson as emergencyPerson," +
                " u.relationShipId as relationShipId," +
                " u.emergencyPhoneFirst as emergencyPhoneFirst," +
                " u.emergencyPhoneSecond as emergencyPhoneSecond," +
                " u.accountTypeId as accountTypeId," +
                " u.bankId as bankId," +
                " u.bankBranchId as bankBranchId," +
                " u.bankBranchCode as bankBranchCode," +
                " u.accountNo as accountNo," +
                " u.iban as iban," +
                " u.bankDescription as bankDescription," +
                " u.status as status" +
                ")";
        hql += " From Users u " +
                " where 1=1";

        if(userId!=null){
            hql += " and u.userId = :userId";
        }
        Query q = getCurrentSession().createQuery(hql);
        if(userId!=null){
            q.setLong("userId",userId);
        }
        return q.list();
    }

    public List<HrLeave> getUserLeave(Long userId) {
        String hql = "Select new map(";
        hql += " ul.users.userId as userId," +
                " ul.recordTypeId as recordTypeId," +
                " ul.typeId as typeId," +
                " to_char(ul.startDate,'dd/mm/yyyy') as startDate," +
                " to_char(ul.endDate,'dd/mm/yyyy') as endDate," +
                " to_char(ul.startWorkDate,'dd/mm/yyyy') as startWorkDate," +
                " ul.time as time," +
                " ul.leaveYear as leaveYear," +
                " ul.status as status" +
                ")";
        hql += " From HrLeave ul " +
                " where 1=1";

        if(userId!=null){
            hql += " and ul.users.userId = :userId";
        }
        Query q = getCurrentSession().createQuery(hql);
        if(userId!=null){
            q.setLong("userId",userId);
        }
        return q.list();
    }

   /* public List<LookUp> getUsersTree(Long userId) {
        Criteria criteria = getCurrentSession().createCriteria(LookUp.class);
        if(userId!=null){
            if(userId!=0){
                criteria.add(Restrictions.eq("lookUpParentId", userId));
            }s

        }
        return criteria.list();
    }*/

    public List<Map<String, Object>> getUserHql(String query, Integer start, Integer limit, Boolean isCount) {
        String hql = "";
        hql += "Select new map(";
        if (isCount) {
            hql += " count(*) as count)";
        } else {
            hql += " i.identityNo as identityNo," +
                   " i.identityFirstName as identityFirstName," +
                   " i.identityLastName as identityLastName," +
                   " u.userName as userName," +
                    "u.status as status," +
                    "u.userId as userId)";
        }

        hql += " From Users u, IdentityInfo i";

        if (query != null) {
            hql += " where u.userId=i.users.userId and (" +
                    " i.identityFirstName like :query" +
                    " or i.identityLastName like lower :query" +
                    " or i.identityFatherName like lower :query" +
                    " or i.identityNo like lower :query" +
                    ")";
        }
        Query q = getCurrentSession().createQuery(hql);
        if(query!=null){
            q.setString("query","lower(%"+query+"%)");
        }
        if (!isCount) {
            q.setFirstResult(start);
            q.setMaxResults(limit);
        }
        return q.list();
    }
}
