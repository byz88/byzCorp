/**
 * 
 */
package com.byzCorp.service;

import com.byzCorp.dao.HrDao;
import com.byzCorp.dao.LookUpDao;
import com.byzCorp.login.model.UserLeave;
import com.byzCorp.login.model.Users;
import com.byzCorp.model.LookUp;
import com.byzCorp.model.LookUpDetail;
import com.byzCorp.util.MException;
import com.byzCorp.util.Session;
import com.byzCorp.util.Util;
import net.sf.json.JSONObject;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HrBus implements IHrBus {

	@Autowired
	private HrDao hrDao;

	@Autowired
	private Session scd;

	public JSONObject getUserDetail(Long userId) {
		JSONObject jsonObject = new JSONObject();
		List<Users> userDetails = hrDao.getUserDetail(userId);
		jsonObject.put("data", userDetails);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject getUserLeave(Long userId) {
		JSONObject jsonObject = new JSONObject();
		List<UserLeave> userLeaves = hrDao.getUserLeave(userId);
		jsonObject.put("data", userLeaves);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject saveOrUpdateEmployee(JSONObject subInfoWest,JSONObject subInfoEast,JSONObject subInfoCenter,JSONObject infoWest,JSONObject infoEast,JSONObject infoCenter) throws MException {
		JSONObject jsonObject = new JSONObject();
		Users user = null;

		Long userId = Util.getLong(subInfoWest, "userId-inputEl", null);
		Long managerId = Util.getLong(subInfoWest,"managerId-inputEl",null);
		Long branchId = Util.getLong(subInfoWest,"branchId-inputEl",null);
		Long departmentId = Util.getLong(subInfoWest,"departmentId-inputEl",null);
		Long titleId = Util.getLong(subInfoWest,"titleId-inputEl",null);
		Long workTypeId = Util.getLong(subInfoWest,"workTypeId-inputEl",null);

		Long idetntityNo = Util.getLong(subInfoCenter, "identityNo-inputEl", null);
		String firstName = Util.getString(subInfoCenter, "firstName-inputEl", null);
		String lastName = Util.getString(subInfoCenter, "lastName-inputEl", null);
		String email = Util.getString(subInfoCenter, "email-inputEl", null);
		Long roleId = Util.getLong(subInfoCenter, "roleId-inputEl", null);

		Date startWorkDate = Util.getDate(subInfoEast, "startWorkDate-inputEl",null, Util.dateFormat);
		Date insuranceDate = Util.getDate(subInfoEast, "insuranceDate-inputEl",null, Util.dateFormat);
		Long citizenId = Util.getLong(subInfoEast, "citizenId-inputEl", null);
		Long genderId = Util.getLong(subInfoEast, "genderId-inputEl", null);
		Long boodTypeId = Util.getLong(subInfoEast, "boodTypeId-inputEl", null);

		Long maritialStatusId = Util.getLong(infoWest, "maritialStatusId-inputEl", null);
		Integer childCount = Util.getInteger(infoWest, "childCount-inputEl", null);
		String birthPlace = Util.getString(infoWest, "birthPlace-inputEl", null);
		Date birthDate = Util.getDate(infoWest, "birthDate-inputEl", null,Util.dateFormat);
		String motherName = Util.getString(infoWest, "motherName-inputEl", null);
		String fatherName = Util.getString(infoWest, "fatherName-inputEl", null);
		Long classId = Util.getLong(infoWest, "classId-inputEl", null);
		String licenceNo = Util.getString(infoWest, "licenceNo-inputEl", null);
		Date issuedDate = Util.getDate(infoWest, "issuedDate-inputEl", null,Util.dateFormat);
		Long issuedProvinceId = Util.getLong(infoWest, "issuedProvinceId-inputEl", null);
		Long issuedCountryId = Util.getLong(infoWest, "issuedCountryId-inputEl", null);
		Long disabledId = Util.getLong(infoWest, "disabledId-inputEl", null);

		Long accountTypeId = Util.getLong(infoEast, "accountTypeId-inputEl", null);
		Long bankId = Util.getLong(infoEast, "bankId-inputEl", null);
		Long bankBranchId = Util.getLong(infoEast, "bankBranchId-inputEl", null);
		String bankBranchCode = Util.getString(infoEast, "bankBranchCode-inputEl", null);
		String accountNo = Util.getString(infoEast, "accountNo-inputEl", null);
		String iban = Util.getString(infoEast, "iban-inputEl", null);
		String bankDescription = Util.getString(infoEast, "bankDescription-inputEl", null);

		Long countryId = Util.getLong(infoCenter, "countryId-inputEl", null);
		Long provinceId = Util.getLong(infoCenter, "provinceId-inputEl", null);
		String zipCode = Util.getString(infoCenter, "zipCode-inputEl", null);
		String village = Util.getString(infoCenter, "village-inputEl", null);
		String addressDescription = Util.getString(infoCenter, "addressDescription-inputEl", null);
		String mobilePhone = Util.getString(infoCenter, "mobilePhone-inputEl", null);
		String homePhone = Util.getString(infoCenter, "homePhone-inputEl", null);
		String emergencyPerson = Util.getString(infoCenter, "emergencyPerson-inputEl", null);
		Long relationShipId = Util.getLong(infoEast, "relationShipId-inputEl", null);
		String emergencyPhoneFirst = Util.getString(infoCenter, "emergencyPhoneFirst-inputEl", null);
		String emergencyPhoneSecond = Util.getString(infoCenter, "emergencyPhoneSecond-inputEl", null);
	//Integer status = Util.getInteger(data, "status", 0);

		if(userId !=null){
			user = hrDao.loadObject(Users.class,userId);
		}else{
			Users userControl = hrDao.getUserByIdetntityNo(idetntityNo);
			if(userControl.getIdentityNo()==idetntityNo){
				throw new MException("Eklemek istediğiniz T.C. Kimlik no sistemde kayıtlı görünüyor. " +
						"Aktif ve pasif kullanıcı listelerinden kontrol ediniz.","Uyarı",false);
			}
			user = new Users();
		}
		//subInfoWest
		user.setManagerId(managerId);
		user.setBranchId(branchId);
		user.setDepartmentId(departmentId);
		user.setTitleId(titleId);
		user.setWorkTypeId(workTypeId);

		//subInfoCenter
		user.setIdentityNo(idetntityNo);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setRoleId(roleId);

		//subInfoEast
		user.setStartWorkDate(startWorkDate);
		user.setInsuranceDate(insuranceDate);
		user.setCitizenId(citizenId);
		user.setGenderId(genderId);
		user.setBoodTypeId(boodTypeId);

		//infoWest
		user.setMaritialStatusId(maritialStatusId);
		user.setChildCount(childCount);
		user.setBirthPlace(birthPlace);
		user.setBirthDate(birthDate);
		user.setMotherName(motherName);
		user.setFatherName(fatherName);
		user.setClassId(classId);
		user.setLicenceNo(licenceNo);
		user.setIssuedDate(issuedDate);
		user.setIssuedProvinceId(issuedProvinceId);
		user.setIssuedCountryId(issuedCountryId);
		user.setDisabledId(disabledId);

		//infoEest
		user.setAccountTypeId(accountTypeId);
		user.setBankId(bankId);
		user.setBankBranchId(bankBranchId);
		user.setBankBranchCode(bankBranchCode);
		user.setAccountNo(accountNo);
		user.setIban(iban);
		user.setBankDescription(bankDescription);

		//infoCenter
		user.setCountryId(countryId);
		user.setProvinceId(provinceId);
		user.setZipCode(zipCode);
		user.setVillage(village);
		user.setAddressDescription(addressDescription);
		user.setMobilePhone(mobilePhone);
		user.setHomePhone(homePhone);
		user.setEmergencyPerson(emergencyPerson);
		user.setRelationShipId(relationShipId);
		user.setEmergencyPhoneFirst(emergencyPhoneFirst);
		user.setEmergencyPhoneSecond(emergencyPhoneSecond);

		hrDao.saveOrUpdate(user);

		jsonObject.put("success", true);
		return jsonObject;
	}
}
