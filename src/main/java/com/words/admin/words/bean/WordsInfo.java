package com.words.admin.words.bean;

import java.sql.Timestamp;

import jodd.json.JsonObject;

public class WordsInfo {

	private int wordsId;
	private int docId;
	private int userId;
	private int state;
	private int initPage;
	private int pageNum;
	private String textContent;
	private Timestamp createTime;
	private Timestamp updateTime;

	public JsonObject getJsonInfo() {
		JsonObject obj = new JsonObject();
		obj.put("wordsId", wordsId);
		obj.put("docId", docId);
		obj.put("userId", userId);
		obj.put("state", state);
		obj.put("initPage", initPage);
		obj.put("pageNum", pageNum);
		obj.put("textContent", textContent);
		if (createTime == null) {
			obj.put("createTime", "");
		} else {
			obj.put("createTime", createTime.toInstant().toString());
		}
		if (updateTime == null) {
			obj.put("updateTime", "");
		} else {
			obj.put("updateTime", updateTime.toInstant().toString());
		}
		return obj;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getWordsId() {
		return wordsId;
	}

	public void setWordsId(int wordsId) {
		this.wordsId = wordsId;
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

	public int getInitPage() {
		return initPage;
	}

	public void setInitPage(int initPage) {
		this.initPage = initPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
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

}
