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
	JSONObject getUserDetail(Long userId);

	/**
	 * Insan kaynaklari modulunde personel izin/raporlarini listeler.
	 * Personel listesinden secilen personelin izin bilgileri personel bilgileri->izin rapor sekmesinde goruntulenir.
	 * @param userId
	 * @return
	 */
	JSONObject getUserLeave(Long userId);

	/**
	 * Insan kaynaklari modulunde personel bilgilerini kaydeder ve gunceller.
	 * @param data
	 * @return
	 * @throws MException
	 */
	JSONObject saveOrUpdateEmployee(JSONObject subInfoWest,JSONObject subInfoEast,JSONObject subInfoCenter,JSONObject infoWest,JSONObject infoEast,JSONObject infoCenter) throws MException;

}
