package com.javalec.ex.dto;

import java.io.Serializable;
import java.sql.Date;

public class BMemberDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mId;
	private String mName;
	private Date mBirthday;
	private String mPhone;
	private Date mJoindate;
	private String mPassword;// 회원 비밀번호 : 실제 테이블에 들어갈때에는 다른 테이블로 들어간다.
	public String getmId() {
		return mId;
	}
	public void setMId(String mId) {
		this.mId = mId;
	}
	public String getMName() {
		return mName;
	}
	public void setMName(String mName) {
		this.mName = mName;
	}
	public Date getMBirthday() {
		return mBirthday;
	}
	public void setMBirthday(Date mBirthday) {
		this.mBirthday = mBirthday;
	}
	public String getMPhone() {
		return mPhone;
	}
	public void setMPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public Date getMJoindate() {
		return mJoindate;
	}
	public void setMJoindate(Date mJoindate) {
		this.mJoindate = mJoindate;
	}
	public String getMPassword() {
		return mPassword;
	}
	public void setMPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	
	
}