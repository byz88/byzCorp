/**
 * 
 */
package com.byzCorp.service;

import com.byzCorp.dao.LookUpDao;
import com.byzCorp.model.LookUp;
import com.byzCorp.model.LookUpDetail;
import com.byzCorp.util.MException;
import com.byzCorp.util.Session;
import com.byzCorp.util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LookUpBus implements ILookUpBus {

	@Autowired
	private LookUpDao lookUpDao;

	@Autowired
	private Session scd;

	public JSONObject getLookUps(JSONObject data, String query, Integer start, Integer limit) {
		JSONObject jsonObject = new JSONObject();
		List<LookUp> lookUps = lookUpDao.getLookUps(query, start,limit,false);
		List<LookUp> lookUpCount = lookUpDao.getLookUps(query, start,limit,true);
		jsonObject.put("data", lookUps);
		jsonObject.put("total", lookUpCount.get(0));
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject getLookUpDetails(Long lookUpId, String query,  Integer start, Integer limit) {
		JSONObject jsonObject = new JSONObject();
		List<LookUpDetail> lookUpDetails = lookUpDao.getLookUpDetails(lookUpId, query, start, limit, false);
		List<LookUpDetail> lookUpDetailCount = lookUpDao.getLookUpDetails(lookUpId, query,  start, limit, true);
		jsonObject.put("data", lookUpDetails);
		jsonObject.put("total", lookUpDetailCount.get(0));
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject saveOrUpdateLookUpDetail(JSONObject data, Long lookUpId) throws MException {
		JSONObject jsonObject = new JSONObject();
		LookUp lookUp = null;
		LookUpDetail lookUpDetail = null;
		Long lookUpDetailId = Util.getLong(data, "lookUpDetailId-inputEl", null);
		String lookUpDetailName = Util.getString(data, "name-inputEl", null);
		Integer lookUpDetailValue = Util.getInteger(data, "value-inputEl", null);
		Integer lookUpDetailOrderNo = Util.getInteger(data, "orderNo-inputEl", null);
		Integer lookUpDetailStatus = Util.getInteger(data, "status-inputEl", null);
		if(lookUpId!=null){
			lookUp = lookUpDao.loadObject(LookUp.class,lookUpId);
		}
		if(lookUpDetailId==null){
			lookUpDetail = new LookUpDetail();
		}else{
			lookUpDetail = lookUpDao.loadObject(LookUpDetail.class,lookUpDetailId);
		}
		lookUpDetail.setLookUp(lookUp);
		lookUpDetail.setName(lookUpDetailName);
		lookUpDetail.setValue(lookUpDetailValue);
		lookUpDetail.setOrderNo(lookUpDetailOrderNo);
		lookUpDetail.setStatus(lookUpDetailStatus);
		lookUpDao.saveOrUpdate(lookUpDetail);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject removeLookUpDetail(Long lookUpDetailId) throws MException {
		JSONObject jsonObject = new JSONObject();
		LookUpDetail lookUpDetail = null;
		if(lookUpDetailId!=null){
			lookUpDetail = lookUpDao.loadObject(LookUpDetail.class,lookUpDetailId);
		}
		lookUpDao.removeObject(lookUpDetail);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject removeLookUp(Long lookUpId) throws MException {
		JSONObject jsonObject = new JSONObject();
		LookUp lookUp = null;
		if(lookUpId!=null){
			lookUp = lookUpDao.loadObject(LookUp.class,lookUpId);
		}
		lookUpDao.removeObject(lookUp);
		jsonObject.put("success", true);
		return jsonObject;
	}

	public JSONObject saveOrUpdateLookUp(JSONObject data) throws MException {
		JSONObject jsonObject = new JSONObject();
		LookUp lookUp = null;
		Long lookUpId = Util.getLong(data, "lookUpId-inputEl", null);
		String lookUpName = Util.getString(data, "lookUpName-inputEl", null);
		Long lookUpParentId = Util.getLong(data, "lookUpParent-inputEl", null);
		Integer lookUpStatus = Util.getInteger(data, "lookUpStatus-inputEl", null);
		if(lookUpId!=null){
			lookUp = lookUpDao.loadObject(LookUp.class,lookUpId);
		}else{
			lookUp = new LookUp();
		}
		lookUp.setName(lookUpName);
		lookUp.setParentId(lookUpParentId);
		lookUp.setStatus(lookUpStatus);
		try {

			lookUpDao.saveOrUpdate(lookUp);

		} catch (Exception e) {
			throw new MException(e.getCause().toString(),"Hata",false);
		}

		jsonObject.put("success", true);
		return jsonObject;
	}
}
