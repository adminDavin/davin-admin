package com.kingword.entity.email;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmailSendTempletParam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EMAIL_SEND_TEMPLET_PARAM", schema = "EMAIL")
public class EmailSendTempletParam implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1321477197848022541L;
	private Integer templetParamId;
	private String templetParamName;
	private String templetParamContent;
	private Boolean templetParamState;
	private Timestamp templetParamCreateDate;
	private Timestamp templetParamModifyDate;
	private String templetParamRemark;

	// Constructors

	/** default constructor */
	public EmailSendTempletParam() {
	}

	/** minimal constructor */
	public EmailSendTempletParam(Integer templetParamId) {
		this.templetParamId = templetParamId;
	}

	/** full constructor */
	public EmailSendTempletParam(Integer templetParamId,
			String templetParamName, String templetParamContent,
			Boolean templetParamState, Timestamp templetParamCreateDate,
			Timestamp templetParamModifyDate, String templetParamRemark) {
		this.templetParamId = templetParamId;
		this.templetParamName = templetParamName;
		this.templetParamContent = templetParamContent;
		this.templetParamState = templetParamState;
		this.templetParamCreateDate = templetParamCreateDate;
		this.templetParamModifyDate = templetParamModifyDate;
		this.templetParamRemark = templetParamRemark;
	}

	// Property accessors
	@Id
	@Column(name = "TEMPLET_PARAM_ID", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getTempletParamId() {
		return this.templetParamId;
	}

	public void setTempletParamId(Integer templetParamId) {
		this.templetParamId = templetParamId;
	}

	@Column(name = "TEMPLET_PARAM_NAME", length = 100)
	public String getTempletParamName() {
		return this.templetParamName;
	}

	public void setTempletParamName(String templetParamName) {
		this.templetParamName = templetParamName;
	}

	@Column(name = "TEMPLET_PARAM_CONTENT", length = 500)
	public String getTempletParamContent() {
		return this.templetParamContent;
	}

	public void setTempletParamContent(String templetParamContent) {
		this.templetParamContent = templetParamContent;
	}

	@Column(name = "TEMPLET_PARAM_STATE", precision = 1, scale = 0)
	public Boolean getTempletParamState() {
		return this.templetParamState;
	}

	public void setTempletParamState(Boolean templetParamState) {
		this.templetParamState = templetParamState;
	}

	@Column(name = "TEMPLET_PARAM_CREATE_DATE", length = 11)
	public Timestamp getTempletParamCreateDate() {
		return this.templetParamCreateDate;
	}

	public void setTempletParamCreateDate(Timestamp templetParamCreateDate) {
		this.templetParamCreateDate = templetParamCreateDate;
	}

	@Column(name = "TEMPLET_PARAM_MODIFY_DATE", length = 11)
	public Timestamp getTempletParamModifyDate() {
		return this.templetParamModifyDate;
	}

	public void setTempletParamModifyDate(Timestamp templetParamModifyDate) {
		this.templetParamModifyDate = templetParamModifyDate;
	}

	@Column(name = "TEMPLET_PARAM_REMARK", length = 300)
	public String getTempletParamRemark() {
		return this.templetParamRemark;
	}

	public void setTempletParamRemark(String templetParamRemark) {
		this.templetParamRemark = templetParamRemark;
	}

}