package com.t.zero.doc.words.manage.bean;

import java.sql.Timestamp;

import jodd.json.JsonObject;

public class RoleInfoBean {
	private Integer roleId;
	private String name;
	private String desc;
	private int service;
	private int userId;
	private int state;
	private Timestamp createDate;
	private Timestamp modifyDate;

	public JsonObject getJsonInfo() {
		JsonObject obj = new JsonObject();
		obj.put("roleId", roleId);
		obj.put("name", name);
		obj.put("desc", desc);
		obj.put("service", service);
		obj.put("userId", userId);
		obj.put("state", state);
		obj.put("createDate", createDate.toInstant().toString());
		obj.put("modifyDate", modifyDate.toInstant().toString());
		return obj;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getService() {
		return service;
	}

	public void setService(int service) {
		this.service = service;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

}
