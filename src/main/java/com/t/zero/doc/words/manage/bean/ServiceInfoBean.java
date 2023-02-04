package com.t.zero.doc.words.manage.bean;

import java.sql.Timestamp;

import jodd.json.JsonObject;

public class ServiceInfoBean {
	private int serviceId;
	private String name;
	private String description;
	private String state;
	private Timestamp createDate;
	private Timestamp modifyDate;

	public JsonObject getJsonInfo() {
		JsonObject item = new JsonObject();
		item.put("serviceId", serviceId);
		item.put("desc", description);
		item.put("name", name);
		item.put("state", state);
		item.put("createDate", createDate.toInstant().toString());
		item.put("modifyDate", modifyDate.toInstant().toString());
		return item;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
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
