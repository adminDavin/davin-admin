package com.words.admin.words.bean;

import java.sql.Timestamp;

import jodd.json.JsonObject;

public class DocumentInfo {

	private int docId;
	private String name;
	private String originalName;
	private String uuid;
	private int userId;
	private int state;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp expireTime;
	private String Remark;

	public JsonObject getJsonInfo() {
		JsonObject obj = new JsonObject();
		obj.put("docId", docId);
		obj.put("name", name);
		obj.put("originalName", originalName);
		obj.put("uuid", uuid);
		obj.put("userId", userId);
		obj.put("state", state);
		obj.put("createDate", createTime.toInstant().toString());
		obj.put("modifyDate", updateTime.toInstant().toString());
		if (expireTime == null) {
			obj.put("expireTime", "");
		} else {
			obj.put("expireTime", expireTime.toInstant().toString());
		}
		return obj;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}
}
