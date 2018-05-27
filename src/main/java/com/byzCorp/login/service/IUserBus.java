/**
 * 
 */
package com.byzCorp.login.service;

import com.byzCorp.util.MException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface IUserBus {

	JSONObject getUser(JSONObject data) throws MException;
	JSONObject getUserDetail(Long userId);
	JSONObject getUserLeave(Long userId);
	JSONObject saveOrUpdateUser(JSONObject data) throws MException;
	JSONObject getSession() throws MException;
	JSONObject getUsersHql(String query,Integer start,Integer limit);
	//JSONArray getUsersTree(Long userId);
}
