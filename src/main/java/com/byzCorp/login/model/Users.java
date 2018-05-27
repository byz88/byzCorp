package com.byzCorp.login.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "USERS", schema = "BYZ", uniqueConstraints = @UniqueConstraint(columnNames = { "USER_ID", "USER_NAME" }))
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name = "USERS_SEQ", sequenceName = "BYZ.USERS_SEQ", allocationSize = 1)
public class Users implements Serializable {

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 12, scale = 0)
	//@GeneratedValue(strategy = GenerationType.IDENTITY) for mySql
	@GeneratedValue(generator = "USERS_SEQ", strategy = GenerationType.SEQUENCE)
	private long userId;
	@Column(name = "USER_NAME", length = 255, nullable = false)
	private String userName;
	@Column(name = "PASSWORD", length = 255, nullable = false)
	private String password;
	@Column(name = "IDENTITY_NO", length = 12, nullable = false)
	private Long identityNo;
	@Column(name = "FIRST_NAME", length = 255, nullable = true)
	private String firstName;
	@Column(name = "LAST_NAME", length = 255, nullable = true)
	private String lastName;
	@Column(name = "MANAGER_ID",length = 12, nullable = true)
	private Long managerId;
	@Column(name = "BRANCH_ID",length = 12, nullable = true)
	private Long branchId;
	@Column(name = "DEPARTMENT_ID",length = 12, nullable = true)
	private Long departmentId;
	@Column(name = "TITLE_ID",length = 12, nullable = true)
	private Long titleId;
	@Column(name = "WORK_TYPE_ID",length = 12, nullable = true)
	private Long workTypeId;
	@Column(name = "EMAIL", length = 255, nullable = true)
	private String email;
	@Column(name = "MOBILE_PHONE", length = 255, nullable = true)
	private String mobilePhone;
	@Column(name = "ROLE_ID",length = 12, nullable = true)
	private Long roleId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_WORK_DATE", nullable = true)
	private Date startWorkDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INSURANCE_DATE", nullable = true)
	private Date insuranceDate;
	@Column(name = "CITIZEN_ID",length = 12, nullable = true)
	private Long citizenId;
	@Column(name = "GENDER_ID",length = 12, nullable = true)
	private Long genderId;
	@Column(name = "BLOOD_TYPE_ID",length = 12, nullable = true)
	private Long boodTypeId;
	@Column(name = "MARITIAL_STATUS_ID",length = 12, nullable = true)
	private Long maritialStatusId;
	@Column(name = "CHILD_COUNT", length = 2, nullable = true)
	private Integer childCount;
	@Column(name = "BIRTH_PLACE", length = 255, nullable = true)
	private String birthPlace;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTH_DATE", nullable = true)
	private Date birthDate;
	@Column(name = "FATHER_NAME", length = 255, nullable = true)
	private String fatherName;
	@Column(name = "MOTHER_NAME", length = 255, nullable = true)
	private String motherName;
	@Column(name = "CLASS_ID", length = 12, nullable = true)
	private Long classId;
	@Column(name = "LICENCE_NO", length = 255, nullable = true)
	private String licenceNo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ISSUED_DATE", nullable = true)
	private Date issuedDate;
	@Column(name = "ISSUED_PROVINCE_ID", length = 12, nullable = true)
	private Long issuedProvinceId;
	@Column(name = "ISSUED_COUNTRY_ID", length = 12, nullable = true)
	private Long issuedCountryId;
	@Column(name = "DISABLED_ID", length = 12, nullable = true)
	private Long disabledId;
	@Column(name = "COUNTRY_ID", length = 12, nullable = true)
	private Long countryId;
	@Column(name = "PROVINCE_ID", length = 12, nullable = true)
	private Long provinceId;
	@Column(name = "VILLAGE", length = 255, nullable = true)
	private String village;
	@Column(name = "ZIP_CODE", length = 255, nullable = true)
	private String zipCode;
	@Column(name = "ADDRESS_DESCRIPTION", length = 500, nullable = true)
	private String addressDescription;
	@Column(name = "HOME_PHONE", length = 255, nullable = true)
	private String homePhone;
	@Column(name = "EMERGENCY_PERSON", length = 255, nullable = true)
	private String emergencyPerson;
	@Column(name = "RELATIONSHIP_ID", length = 12, nullable = true)
	private Long relationShipId;
	@Column(name = "EMERGENCY_PHONE_FIRST", length = 255, nullable = true)
	private String emergencyPhoneFirst;
	@Column(name = "EMERGENCY_PHONE_SECOND", length = 255, nullable = true)
	private String emergencyPhoneSecond;
	@Column(name = "ACCOUNT_TYPE_ID", length = 12, nullable = true)
	private Long accountTypeId;
	@Column(name = "BANK_ID", length = 12, nullable = true)
	private Long bankId;
	@Column(name = "BANK_BRANCH_ID", length = 12, nullable = true)
	private Long bankBranchId;
	@Column(name = "BANK_BRANCH_CODE", length = 255, nullable = true)
	private String bankBranchCode;
	@Column(name = "ACCOUNT_NO", length = 255, nullable = true)
	private String accountNo;
	@Column(name = "IBAN", length = 255, nullable = true)
	private String iban;
	@Column(name = "BANK_DESCRIPTION", length = 255, nullable = true)
	private String bankDescription;
	@Column(name = "STATUS", length = 1, nullable = false)
	private Integer status = 1;
	@Column(name = "IMAGE")
	@Basic(fetch = FetchType.LAZY)
	private Blob image;

	public Users(){

	}
	public Users(long userId) {
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(Long identityNo) {
		this.identityNo = identityNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getTitleId() {
		return titleId;
	}

	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}

	public Long getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(Long workTypeId) {
		this.workTypeId = workTypeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Date getStartWorkDate() {
		return startWorkDate;
	}

	public void setStartWorkDate(Date startWorkDate) {
		this.startWorkDate = startWorkDate;
	}

	public Date getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(Date insuranceDate) {
		this.insuranceDate = insuranceDate;
	}

	public Long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Long citizenId) {
		this.citizenId = citizenId;
	}

	public Long getGenderId() {
		return genderId;
	}

	public void setGenderId(Long genderId) {
		this.genderId = genderId;
	}

	public Long getBoodTypeId() {
		return boodTypeId;
	}

	public void setBoodTypeId(Long boodTypeId) {
		this.boodTypeId = boodTypeId;
	}

	public Long getMaritialStatusId() {
		return maritialStatusId;
	}

	public void setMaritialStatusId(Long maritialStatusId) {
		this.maritialStatusId = maritialStatusId;
	}

	public Integer getChildCount() {
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Long getIssuedProvinceId() {
		return issuedProvinceId;
	}

	public void setIssuedProvinceId(Long issuedProvinceId) {
		this.issuedProvinceId = issuedProvinceId;
	}

	public Long getIssuedCountryId() {
		return issuedCountryId;
	}

	public void setIssuedCountryId(Long issuedCountryId) {
		this.issuedCountryId = issuedCountryId;
	}

	public Long getDisabledId() {
		return disabledId;
	}

	public void setDisabledId(Long disabledId) {
		this.disabledId = disabledId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddressDescription() {
		return addressDescription;
	}

	public void setAddressDescription(String addressDescription) {
		this.addressDescription = addressDescription;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getEmergencyPerson() {
		return emergencyPerson;
	}

	public void setEmergencyPerson(String emergencyPerson) {
		this.emergencyPerson = emergencyPerson;
	}

	public Long getRelationShipId() {
		return relationShipId;
	}

	public void setRelationShipId(Long relationShipId) {
		this.relationShipId = relationShipId;
	}

	public String getEmergencyPhoneFirst() {
		return emergencyPhoneFirst;
	}

	public void setEmergencyPhoneFirst(String emergencyPhoneFirst) {
		this.emergencyPhoneFirst = emergencyPhoneFirst;
	}

	public String getEmergencyPhoneSecond() {
		return emergencyPhoneSecond;
	}

	public void setEmergencyPhoneSecond(String emergencyPhoneSecond) {
		this.emergencyPhoneSecond = emergencyPhoneSecond;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Long getBankBranchId() {
		return bankBranchId;
	}

	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	public String getBankBranchCode() {
		return bankBranchCode;
	}

	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBankDescription() {
		return bankDescription;
	}

	public void setBankDescription(String bankDescription) {
		this.bankDescription = bankDescription;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
