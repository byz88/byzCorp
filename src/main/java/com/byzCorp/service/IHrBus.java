/**
 * 
 */
package com.byzCorp.service;

import com.byzCorp.util.MException;
import net.sf.json.JSONObject;

public interface IHrBus {

	/**
	 * Insan kaynaklari modulunde personelleri listeler.
	 * personel listesi ve personel bilgileri ekraninda kullanilmaktadir.
	 * @param userId
	 * @return
	 */
	JSONObject getHrDetail(Long userId);

	/**
	 * Insan kaynaklari modulunde personel izin/raporlarini listeler.
	 * Personel listesinden secilen personelin izin bilgileri personel bilgileri->izin rapor sekmesinde goruntulenir.
	 * @param userId
	 * @return
	 */
	JSONObject getHrLeave(Long userId);
	JSONObject getHrLeaveDetail(Long userId);

	/**
	 * Insan kaynaklari modulunde personel bilgilerini kaydeder ve gunceller.
	 * @param data
	 * @param employeeLeave
     * @return
	 * @throws MException
	 */
	JSONObject saveOrUpdateHr(JSONObject subInfoWest, JSONObject subInfoEast, JSONObject subInfoCenter, JSONObject infoWest, JSONObject infoEast, JSONObject infoCenter) throws MException;

	JSONObject saveOrUpdateHrLeave(JSONObject subInfoWest, JSONObject subInfoEast, JSONObject subInfoCenter, JSONObject hrLeave) throws MException;

	JSONObject saveOrUpdateHrLeaveDetail(Long leaveDetailId,Integer leaveDetailYear,Integer leaveDetailDay,Long userId) throws MException;

	JSONObject removeHrLeaveDetail(Long hrLeaveDetailId) throws MException;
}
