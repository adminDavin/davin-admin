package com.kingword.entitycommon;

import java.sql.Timestamp;

public class RelDocuKingWordForm {
	private Long relDocuKingWord;
	private String wordName;
	private String realFileName;
	private String kingWordName;
	private Long kingWordCount;
	public Long getRelDocuKingWord() {
		return relDocuKingWord;
	}
	public void setRelDocuKingWord(Long relDocuKingWord) {
		this.relDocuKingWord = relDocuKingWord;
	}
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	public String getKingWordName() {
		return kingWordName;
	}
	public void setKingWordName(String kingWordName) {
		this.kingWordName = kingWordName;
	}
	public Long getKingWordCount() {
		return kingWordCount;
	}
	public void setKingWordCount(Long kingWordCount) {
		this.kingWordCount = kingWordCount;
	}
	public Byte getState() {
		return state;
	}
	public void setState(Byte state) {
		this.state = state;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	private Byte state;
	private Timestamp createDate;
}
