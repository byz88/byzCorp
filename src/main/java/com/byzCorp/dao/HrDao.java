package com.byzCorp.dao;

import com.byzCorp.login.model.UserLeave;
import com.byzCorp.login.model.Users;
import com.byzCorp.util.GenericDao;
import com.byzCorp.util.MException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HrDao extends GenericDao {

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
    public Users getUserByIdetntityNo(Long idetntityNo) throws MException {
        Criteria criteria = getCurrentSession().createCriteria(Users.class);
        criteria.add(Restrictions.eq("idetntityNo", idetntityNo));
        return (Users) criteria.uniqueResult();
    }
    public List<UserLeave> getUserLeave(Long userId) {
        String hql = "Select new map(";
        hql += " ul.users.userId as userId," +
                " ul.recordTypeId as recordTypeId," +
                " (select lud.name from LookUpDetail lud where lud.value = ul.recordTypeId and lud.lookUp.lookUpId = 20) as recordTypeName," +
                " case when ul.recordTypeId = 1 then (select lud.name from LookUpDetail lud where lud.value = ul.typeId and lud.lookUp.lookUpId = 21)" +
                " else (select lud.name from LookUpDetail lud where lud.value = ul.typeId and lud.lookUp.lookUpId = 22) end as typeName," +
                " ul.typeId as reportTypeId," +
                " ul.typeId as leaveTypeId," +
                " to_char(ul.startDate,'dd/mm/yyyy') as startDate," +
                " to_char(ul.endDate,'dd/mm/yyyy') as endDate," +
                " to_char(ul.startWorkDate,'dd/mm/yyyy') as leaveStartWorkDate," +
                " ul.time as time," +
                " ul.leaveYear as leaveYear," +
                " ul.status as leaveStatus" +
                ")";
        hql += " From UserLeave ul " +
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

}
