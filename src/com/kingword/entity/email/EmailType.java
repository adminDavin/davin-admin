package com.kingword.entity.email;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmailType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EMAIL_TYPE", schema = "EMAIL")
public class EmailType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4642025902585040905L;
	private Short emailTypeId;
	private Integer emailCfgId;
	private String emailTypeName;
	private String acceptService;
	private String sendService;
	private Boolean confirmation;
	private Boolean emailTypeState;
	private Timestamp emailTypeCreateDate;
	private Timestamp emailTypeModifyDate;
	private String emailTypeRemark;

	// Constructors

	/** default constructor */
	public EmailType() {
	}

	/** minimal constructor */
	public EmailType(Short emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	/** full constructor */
	public EmailType(Short emailTypeId, Integer emailCfgId,
			String emailTypeName, String acceptService, String sendService,
			Boolean confirmation, Boolean emailTypeState,
			Timestamp emailTypeCreateDate, Timestamp emailTypeModifyDate,
			String emailTypeRemark) {
		this.emailTypeId = emailTypeId;
		this.emailCfgId = emailCfgId;
		this.emailTypeName = emailTypeName;
		this.acceptService = acceptService;
		this.sendService = sendService;
		this.confirmation = confirmation;
		this.emailTypeState = emailTypeState;
		this.emailTypeCreateDate = emailTypeCreateDate;
		this.emailTypeModifyDate = emailTypeModifyDate;
		this.emailTypeRemark = emailTypeRemark;
	}

	// Property accessors
	@Id
	@Column(name = "EMAIL_TYPE_ID", unique = true, nullable = false, precision = 3, scale = 0)
	public Short getEmailTypeId() {
		return this.emailTypeId;
	}

	public void setEmailTypeId(Short emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	@Column(name = "EMAIL_CFG_ID", precision = 6, scale = 0)
	public Integer getEmailCfgId() {
		return this.emailCfgId;
	}

	public void setEmailCfgId(Integer emailCfgId) {
		this.emailCfgId = emailCfgId;
	}

	@Column(name = "EMAIL_TYPE_NAME", length = 100)
	public String getEmailTypeName() {
		return this.emailTypeName;
	}

	public void setEmailTypeName(String emailTypeName) {
		this.emailTypeName = emailTypeName;
	}

	@Column(name = "ACCEPT_SERVICE", length = 50)
	public String getAcceptService() {
		return this.acceptService;
	}

	public void setAcceptService(String acceptService) {
		this.acceptService = acceptService;
	}

	@Column(name = "SEND_SERVICE", length = 50)
	public String getSendService() {
		return this.sendService;
	}

	public void setSendService(String sendService) {
		this.sendService = sendService;
	}

	@Column(name = "CONFIRMATION", precision = 1, scale = 0)
	public Boolean getConfirmation() {
		return this.confirmation;
	}

	public void setConfirmation(Boolean confirmation) {
		this.confirmation = confirmation;
	}

	@Column(name = "EMAIL_TYPE_STATE", precision = 1, scale = 0)
	public Boolean getEmailTypeState() {
		return this.emailTypeState;
	}

	public void setEmailTypeState(Boolean emailTypeState) {
		this.emailTypeState = emailTypeState;
	}

	@Column(name = "EMAIL_TYPE_CREATE_DATE", length = 11)
	public Timestamp getEmailTypeCreateDate() {
		return this.emailTypeCreateDate;
	}

	public void setEmailTypeCreateDate(Timestamp emailTypeCreateDate) {
		this.emailTypeCreateDate = emailTypeCreateDate;
	}

	@Column(name = "EMAIL_TYPE_MODIFY_DATE", length = 11)
	public Timestamp getEmailTypeModifyDate() {
		return this.emailTypeModifyDate;
	}

	public void setEmailTypeModifyDate(Timestamp emailTypeModifyDate) {
		this.emailTypeModifyDate = emailTypeModifyDate;
	}

	@Column(name = "EMAIL_TYPE_REMARK", length = 200)
	public String getEmailTypeRemark() {
		return this.emailTypeRemark;
	}

	public void setEmailTypeRemark(String emailTypeRemark) {
		this.emailTypeRemark = emailTypeRemark;
	}

}