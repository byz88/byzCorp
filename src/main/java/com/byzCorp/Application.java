package com.byzCorp;

import com.byzCorp.login.dao.UserDao;
import com.byzCorp.login.model.*;
import com.byzCorp.login.service.UserBus;
import com.byzCorp.model.LookUp;
import com.byzCorp.model.LookUpDetail;
import com.byzCorp.util.Util;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

    /*@Autowired
    private UserBus userBus;
    @Autowired
    private UserDao userDao;*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    InitializingBean insertDatabase(){
        //region identityInfo
        Long identityNo = 67216200846L;
        String identityFirstName = "Bayram";
        String identityLastName = "Beyaz";
        String identitySerialText = "V09";
        String identitySerialNumber = "830680";
        String identityFatherName = "Ömer";
        String identityMotherName = "Hafize";
        String identityBirthPlace = "Boğazlıyan";
        Date identityBirthDate = Util.reqDate("20/01/1983",null,Util.dateFormat);
        Date identityIssuedDate = Util.reqDate("11/06/2008",null,Util.dateFormat);
        Long identityMaritialStatusId =1L;
        Long identityReligiousId = 1L;
        Long identityGenderId = 1L;
        Long identityBloodTypeId = 1L;
        Long identityRegCountryId = 1L;
        Long identityRegProvinceId = 1L;
        Long identityIssuedReasonId = 1L;
        String identitySaveNo = "740";
        String identityIssuedCountry = "Boğazlıyan";
        String identityOrderNo = "0037";
        String identityFamilyNo = "00116";
        String identitySkinNo = "0033";
        String identityRegVillage = "KaymakamKemalBey Mahallesi";
        //endregion
        //region driveInfo
        Long driveClassId = 1L;
        Long driveIssueProvinceId = 1L;
        Long driveIssueCountryId = 1L;
        String driveLicenceNo = "001590-09.07.2001";
        Date driveIssuedDate = Util.reqDate("12/07/2001",null,Util.dateFormat);
        String driveSerialText ="T";
        String driveSerialNumber = "431014";
        Long driveSavedDriveId = 1L;
        Long driveDisabledId = 2L;
        //endregion
        //region addressInfo
        String email = "byrmbyz@outlook.com";
        String mobilePhone ="5495431983";
        String homePhone ="5495431983";
        String addressVillage ="Öveçler";
        String addressStreet ="1325 Sokak";
        String addressApartmentInfo ="Işıl Apartman";
        String addressDoorNo = "11/9";
        String addressDescription ="Aşağı Öveçler-ComboLunch altinda";
        Long addressCountryId =1L;
        Long addressProvinceId =1L;
        //endregion
        //region staffInfo
        Long staffDepartmentId =1L;
        Long staffPositionId =1L;
        Long staffTitleId =1L;
        Long staffTypeId =1L;
        Date staffStartWorkDate = Util.reqDate("14/05/2007",null,Util.dateFormat);
        Date staffDepartureDate = Util.reqDate("14/05/2022",null,Util.dateFormat);
        Long staffMilitaryStatusId =1L;
        Long staffStudyStatusId =1L;
        Date staffGraduationDate = Util.reqDate("13/09/1999",null,Util.dateFormat);
        Date staffInsuranceDate =Util.reqDate("14/06/2018",null,Util.dateFormat);
        //endregion
        //region users
        String userName = "byz";
        String password = "1";
        //endregion
        return () ->{
            //region saveIdentityInfo
            IdentityInfo identityInfo = userDao.loadObject(IdentityInfo.class,1);
            if(identityInfo == null){
                identityInfo = new IdentityInfo();
                identityInfo.setIdentityNo(identityNo);
                identityInfo.setIdentityFirstName(identityFirstName);
                identityInfo.setIdentityLastName(identityLastName);
                identityInfo.setIdentitySerialText(identitySerialText);
                identityInfo.setIdentitySerialNumber(identitySerialNumber);
                identityInfo.setIdentityFatherName(identityFatherName);
                identityInfo.setIdentityMotherName(identityMotherName);
                identityInfo.setIdentityBirthPlace(identityBirthPlace);
                identityInfo.setIdentityBirthDate(identityBirthDate);
                identityInfo.setIdentityIssuedDate(identityIssuedDate);
                identityInfo.setIdentityMaritialStatusId(identityMaritialStatusId);
                identityInfo.setIdentityReligiousId(identityReligiousId);
                identityInfo.setIdentityGenderId(identityGenderId);
                identityInfo.setIdentityBloodTypeId(identityBloodTypeId);
                identityInfo.setIdentityRegCountryId(identityRegCountryId);
                identityInfo.setIdentityRegProvinceId(identityRegProvinceId);
                identityInfo.setIdentityIssuedReasonId(identityIssuedReasonId);
                identityInfo.setIdentitySaveNo(identitySaveNo);
                identityInfo.setIdentityIssuedCountry(identityIssuedCountry);
                identityInfo.setIdentityOrderNo(identityOrderNo);
                identityInfo.setIdentityFamilyNo(identityFamilyNo);
                identityInfo.setIdentitySkinNo(identitySkinNo);
                identityInfo.setIdentityRegVillage(identityRegVillage);
                userDao.saveOrUpdate(identityInfo);
            }
            //endregion
            //region saveDriveInfo
            DriveInfo driveInfo = userDao.loadObject(DriveInfo.class,1);
            if(driveInfo==null){
                driveInfo.setDriveClassId(driveClassId);
                driveInfo.setDriveIssueProvinceId(driveIssueProvinceId);
                driveInfo.setDriveIssueCountryId(driveIssueCountryId);
                driveInfo.setDriveLicenceNo(driveLicenceNo);
                driveInfo.setDriveIssuedDate(driveIssuedDate);
                driveInfo.setDriveSerialText(driveSerialText);
                driveInfo.setDriveSerialNumber(driveSerialNumber);
                driveInfo.setDriveSavedDriveId(driveSavedDriveId);
                driveInfo.setDriveDisabledId(driveDisabledId);
                userDao.saveOrUpdate(driveInfo);
            }
            //endregion
            //region saveAddressInfo
            AddressInfo addressInfo = userDao.loadObject(AddressInfo.class,1);
            if(addressInfo==null){
                addressInfo.setEmail(email);
                addressInfo.setMobilePhone(mobilePhone);
                addressInfo.setHomePhone(homePhone);
                addressInfo.setAddressVillage(addressVillage);
                addressInfo.setAddressStreet(addressStreet);
                addressInfo.setAddressApartmentInfo(addressApartmentInfo);
                addressInfo.setAddressDoorNo(addressDoorNo);
                addressInfo.setAddressDescription(addressDescription);
                addressInfo.setAddressCountryId(addressCountryId);
                addressInfo.setAddressProvinceId(addressProvinceId);
                userDao.saveOrUpdate(addressInfo);
            }
            //endregion
            //region saveStaffInfo
            StaffInfo staffInfo = userDao.loadObject(StaffInfo.class,1);
            if(staffInfo==null){
                staffInfo.setStaffDepartmentId(staffDepartmentId);
                staffInfo.setStaffPositionId(staffPositionId);
                staffInfo.setStaffTitleId(staffTitleId);
                staffInfo.setStaffTypeId(staffTypeId);
                staffInfo.setStaffStartWorkDate(staffStartWorkDate);
                staffInfo.setStaffDepartureDate(staffDepartureDate);
                staffInfo.setStaffMilitaryStatusId(staffMilitaryStatusId);
                staffInfo.setStaffStudyStatusId(staffStudyStatusId);
                staffInfo.setStaffGraduationDate(staffGraduationDate);
                staffInfo.setStaffInsuranceDate(staffInsuranceDate);
                userDao.saveOrUpdate(staffInfo);
            }
            //endregion
            //region saveUsers
            Users users = userDao.loadObject(Users.class,1);
            if(users==null){
                users = new Users();
                users.setUserName(userName);
                users.setPassword(password);
                users.setAddressInfo(userDao.loadObject(AddressInfo.class,1));
                users.setDriveInfo(userDao.loadObject(DriveInfo.class,1));
                users.setIdentityInfo(userDao.loadObject(IdentityInfo.class,1));
                users.setStaffInfo(userDao.loadObject(StaffInfo.class,1));
                userDao.saveOrUpdate(users);
            }
            //endregion
            //region saveLookUp&LookUpDetailStatus
            LookUp lookUp = userDao.loadObject(LookUp.class,1);
            if(lookUp==null){
                lookUp.setLookUpName("Statüler");
                userDao.saveOrUpdate(lookUp);
                LookUpDetail lookUpDetail = new LookUpDetail();
                lookUpDetail.setLookUp(lookUp);
                lookUpDetail.setLookUpDetailName("Aktif");
                lookUpDetail.setLookUpDetailValue(1);
                lookUpDetail.setLookUpDetailOrderNo(1);
                userDao.saveOrUpdate(lookUpDetail);
            }
            //endregion
        };
    }*/
}