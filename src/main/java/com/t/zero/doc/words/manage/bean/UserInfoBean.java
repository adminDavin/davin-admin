package com.t.zero.doc.words.manage.bean;

import java.sql.Timestamp;

import jodd.json.JsonObject;

public class UserInfoBean {
	private Integer userId;
	private String organize;
	private String name;
	private String namePin;
	private int sex;
	private String email;
	private String phone;
	private String zoneqq;
	private String address;
	private int state;
	private Timestamp applyDate;
	private Timestamp birthDate;
	private Timestamp acceptDate;
	private Integer accepterId;
	private String remark;
	private String accepter;

	public JsonObject getJsonInfo() {
		JsonObject user = new JsonObject();
		user.put("userId", userId);
		user.put("organize", organize);
		user.put("name", name);
		user.put("namePin", namePin);
		user.put("sex", sex);
		user.put("email", email);
		user.put("state", state);
		user.put("phone", phone);
		user.put("zoneqq", zoneqq);
		user.put("address", address);
		user.put("accepter", accepter);
		if (birthDate == null) {
			user.put("birthDate", "");
		} else {
			user.put("birthDate", birthDate.toInstant().toString());
		}
		if (applyDate == null) {
			user.put("applyDate", "");

		} else {
			user.put("applyDate", applyDate.toInstant().toString());

		}
		if (acceptDate == null) {
			user.put("acceptDate", "");

		} else {
			user.put("acceptDate", acceptDate.toInstant().toString());

		}
		user.put("accepterId", accepterId);
		user.put("remark", remark);
		return user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrganize() {
		return organize;
	}

	public void setOrganize(String organize) {
		this.organize = organize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamePin() {
		return namePin;
	}

	public void setNamePin(String namePin) {
		this.namePin = namePin;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZoneqq() {
		return zoneqq;
	}

	public void setZoneqq(String zoneqq) {
		this.zoneqq = zoneqq;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Timestamp getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Timestamp applyDate) {
		this.applyDate = applyDate;
	}

	public Timestamp getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Timestamp acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Integer getAccepterId() {
		return accepterId;
	}

	public void setAccepterId(Integer accepterId) {
		this.accepterId = accepterId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getAccepter() {
		return accepter;
	}

	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}

}
