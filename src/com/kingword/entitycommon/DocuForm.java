package com.kingword.entitycommon;

import java.util.Date;

public class DocuForm {
	private String wordName;
	private int docuType;
	private String writer;
	private String writorPhoneNumber;
	private Date finishDate;
	private String upLoader;
	private Date upLoadDate;
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public int getDocuType() {
		return docuType;
	}
	public void setDocuType(int docuType) {
		this.docuType = docuType;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWritorPhoneNumber() {
		return writorPhoneNumber;
	}
	public void setWritorPhoneNumber(String writorPhoneNumber) {
		this.writorPhoneNumber = writorPhoneNumber;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getUpLoader() {
		return upLoader;
	}
	public void setUpLoader(String upLoader) {
		this.upLoader = upLoader;
	}
	public Date getUpLoadDate() {
		return upLoadDate;
	}
	public void setUpLoadDate(Date upLoadDate) {
		this.upLoadDate = upLoadDate;
	}
}
