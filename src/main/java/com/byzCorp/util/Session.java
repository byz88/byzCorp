package com.byzCorp.util;

import com.byzCorp.login.model.Users;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@SuppressWarnings("serial")
@Component(value = "scd")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class Session implements Serializable {

	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Session.class);
//kullanicinin sisteme giris zamanini login sirasinda bir tabloya yaz. burada logout olana kadar yada yeniden login olana
	//kadar bu bilgileri tut. logout sirasinda bilgileri sifirla
	//ekrani refresh ederse login bilgilerini guncelleyecegin icin sorun olmayacak..

	private Users users;
	private Long sistemGirisZamani;
	private String sessionId;
	private long isno;
	private String key;
	private String ipAddress;
	private String macAddress;
	private String hostName;
	private String keyPad;
	private String csrf;

	public Session(){

	}

	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

	public long getIsno() {
		return isno;
	}

	public void setIsno(long isno) {
		this.isno = isno;
	}

	public Long getSistemGirisZamani() {
		return sistemGirisZamani;
	}

	public void setSistemGirisZamani(Long sistemGirisZamani) {
		this.sistemGirisZamani = sistemGirisZamani;
		this.csrf = String.valueOf(sistemGirisZamani);
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostName() {
		return hostName;
	}

	public void setKeyPad(String keyPad) {
		this.keyPad = keyPad;
	}

	public String getKeyPad() {
		return keyPad;
	}


	public String getCsrf() {
		return csrf;
	}

	public void setCsrf(String csrf) {
		this.csrf = csrf;
	}


}
