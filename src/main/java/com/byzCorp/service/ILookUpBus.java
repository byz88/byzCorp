/**
 * 
 */
package com.byzCorp.service;

import com.byzCorp.util.MException;
import net.sf.json.JSONObject;

public interface ILookUpBus {

	JSONObject getLookUps(JSONObject data, String query, Integer start, Integer limit);

	JSONObject getLookUpDetails(Long lookUpId, String query, Integer start, Integer limit);

	JSONObject saveOrUpdateLookUpDetail(JSONObject data, Long lookUpId) throws MException;

	JSONObject removeLookUpDetail(Long lookUpDetailId) throws MException;

	JSONObject removeLookUp(Long lookUpId) throws MException;

	JSONObject saveOrUpdateLookUp(JSONObject data) throws MException;

}
