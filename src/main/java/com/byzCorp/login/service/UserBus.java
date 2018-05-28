/**
 * 
 */
package com.byzCorp.login.service;

import com.byzCorp.login.dao.UserDao;
import com.byzCorp.login.model.*;
import com.byzCorp.model.HrLeave;
import com.byzCorp.util.MException;
import com.byzCorp.util.Session;
import com.byzCorp.util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserBus implements IUserBus {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private Session scd;


	public JSONObject getUser(JSONObject data) throws MException {
			JSONObject jsonObject = new JSONObject();
		String userName = Util.getString(data, "userName", null);
		String password = Util.getString(data, "password", null);

		if (userName == null) {
			throw new MException("Kullanıcı Adı giriniz.", "Uyarı", false);
		}
		if (password == null) {
			throw new MException("Şifre giriniz.", "Uyarı", false);
		}

		List<Map<String, Object>> users =  userDao.getUser(userName,password);

		if(users.size()==0){
			throw new MException("Kullanıcı Adı veya Şifre hatalı","Uyarı",false);
		}
		//scd.setUsers(null);
		//scd.setUsers(users);
		jsonObject.put("data", users);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject getUserDetail(Long userId) {
		JSONObject jsonObject = new JSONObject();
		List<Users> userDetails = userDao.getUserDetail(userId);
		jsonObject.put("data", userDetails);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject getUserLeave(Long userId) {
		JSONObject jsonObject = new JSONObject();
		List<HrLeave> userLeaves = userDao.getUserLeave(userId);
		jsonObject.put("data", userLeaves);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject saveOrUpdateUser(JSONObject data) throws MException {
		JSONObject jsonObject = new JSONObject();
		Users user = null;
		Long userId = Util.getLong(data, "userId", null);
		String userName = Util.getString(data, "userName", null);
		String firstName = Util.getString(data, "firstName", null);
		String lastName = Util.getString(data, "lastName", null);
		String email = Util.getString(data, "email", null);
		Long identityNo = Util.getLong(data, "identityNo", null);
		Integer status = Util.getInteger(data, "status", 0);
		user = userDao.getUserByUserName(userName);
		if(user!=null){
			throw new MException("Eklemek istediğiniz kullanıcı adı sistemde kayıtlı görünüyor. " +
					"Aktif ve pasif kullanıcı listelerinden kontrol ediniz","Uyarı",false);
		}
		jsonObject.put("success", true);
		return jsonObject;
	}
	public JSONObject getSession() throws MException {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArrays = JSONArray.fromObject(scd.getUsers());
		jsonObject.put("data", jsonArrays);
		jsonObject.put("success", true);
		return jsonObject;
	}
	public JSONObject getUsersHql(String query, Integer start, Integer limit) {
		JSONObject jsonObject = new JSONObject();
		List<Map<String, Object>> user =  userDao.getUserHql(query, start, limit, false);
		List<Map<String, Object>> userCount =  userDao.getUserHql(query, start, limit, true);
		JSONArray jsonArray = JSONArray.fromObject(user);
		jsonObject.put("data", jsonArray);
		jsonObject.put("total", userCount.get(0).get("count"));
		jsonObject.put("success", true);
		return jsonObject;
	}
	/*@Override
	public JSONArray getUsersTree(Long userId) {
		*//*JSONArray jsonArr = new JSONArray();
		JSONObject o = null;
		JSONObject root = new JSONObject();
		JSONArray jsonChildArr = new JSONArray();*//*

		JSONObject obj = new JSONObject();
		JSONObject jsonChildObj = new JSONObject();
		JSONArray arr = new JSONArray();

		List<LookUp> users = userDao.getUsersTree(userId);

		if(users.size()>0) {
			//List<LookUp> konumList = userDao.getUsersTree(userId);
			for (LookUp obje : users) {

				if(obje.getLookUpParentId()==0){
					obj.put("id",obje.getLookUpId());
					obj.put("text",obje.getLookUpName());
					//obj.put("leaf", false);
				}else{
					jsonChildObj.clear();
					jsonChildObj.put("id", obje.getLookUpId());
					jsonChildObj.put("text", obje.getLookUpName());
					jsonChildObj.put("leaf",true);
					obj.put("children", jsonChildObj);
				}
				List<LookUp> atcList = userDao.getUsersTree(obje.getLookUpParentId());

				if (atcList.size() == 0) {
					obj.put("leaf", true);
				}
				arr.add(obj);
			}
		}

		return arr;
	}*/

}
