package com.kingword.entity.email;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmailConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EMAIL_CONFIG", schema = "EMAIL")
public class EmailConfig implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4404020613685614023L;
	private Integer emailCfgId;
	private Short emailCfgPort;
	private String emailCfgTypeName;
	private int emailCfgType;
	private String emailLoginName;
	private String emailLoginPass;
	private String emailSendAddr;
	private String emailAcceptAddr;
	private int eamailSendState;
	private Boolean emailAcceptState;
	private Timestamp emailCfgCreateDate;
	private Timestamp emailCfgModifyDate;
	private String emailCfgRemark;

	// Constructors

	/** default constructor */
	public EmailConfig() {
	}

	/** minimal constructor */
	public EmailConfig(Integer emailCfgId) {
		this.emailCfgId = emailCfgId;
	}

	/** full constructor */
	public EmailConfig(Integer emailCfgId, Short emailCfgType,
			String emailLoginName, String emailLoginPass, String emailSendAddr,
			String emailAcceptAddr, int eamailSendState,
			Boolean emailAcceptState, Timestamp emailCfgCreateDate,
			Timestamp emailCfgModifyDate, String emailCfgRemark) {
		this.emailCfgId = emailCfgId;
		this.emailCfgType = emailCfgType;
		this.emailLoginName = emailLoginName;
		this.emailLoginPass = emailLoginPass;
		this.emailSendAddr = emailSendAddr;
		this.emailAcceptAddr = emailAcceptAddr;
		this.eamailSendState = eamailSendState;
		this.emailAcceptState = emailAcceptState;
		this.emailCfgCreateDate = emailCfgCreateDate;
		this.emailCfgModifyDate = emailCfgModifyDate;
		this.emailCfgRemark = emailCfgRemark;
	}

	// Property accessors
	@Id
	@Column(name = "EMAIL_CFG_ID", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getEmailCfgId() {
		return this.emailCfgId;
	}

	public void setEmailCfgId(Integer emailCfgId) {
		this.emailCfgId = emailCfgId;
	}

	@Column(name = "EMAIL_CFG_TYPE", precision = 3, scale = 0)
	public int getEmailCfgType() {
		return this.emailCfgType;
	}

	public void setEmailCfgType(int emailCfgType) {
		this.emailCfgType = emailCfgType;
	}

	@Column(name = "EMAIL_LOGIN_NAME", length = 100)
	public String getEmailLoginName() {
		return this.emailLoginName;
	}

	public void setEmailLoginName(String emailLoginName) {
		this.emailLoginName = emailLoginName;
	}

	@Column(name = "EMAIL_LOGIN_PASS", length = 100)
	public String getEmailLoginPass() {
		return this.emailLoginPass;
	}

	public void setEmailLoginPass(String emailLoginPass) {
		this.emailLoginPass = emailLoginPass;
	}

	@Column(name = "EMAIL_SEND_ADDR", length = 100)
	public String getEmailSendAddr() {
		return this.emailSendAddr;
	}

	public void setEmailSendAddr(String emailSendAddr) {
		this.emailSendAddr = emailSendAddr;
	}

	@Column(name = "EMAIL_ACCEPT_ADDR", length = 100)
	public String getEmailAcceptAddr() {
		return this.emailAcceptAddr;
	}

	public void setEmailAcceptAddr(String emailAcceptAddr) {
		this.emailAcceptAddr = emailAcceptAddr;
	}

	@Column(name = "EAMAIL_SEND_STATE", precision = 1, scale = 0)
	public int getEamailSendState() {
		return this.eamailSendState;
	}

	public void setEamailSendState(int eamailSendState) {
		this.eamailSendState = eamailSendState;
	}

	@Column(name = "EMAIL_ACCEPT_STATE", precision = 1, scale = 0)
	public Boolean getEmailAcceptState() {
		return this.emailAcceptState;
	}

	public void setEmailAcceptState(Boolean emailAcceptState) {
		this.emailAcceptState = emailAcceptState;
	}

	@Column(name = "EMAIL_CFG_CREATE_DATE", length = 11)
	public Timestamp getEmailCfgCreateDate() {
		return this.emailCfgCreateDate;
	}

	public void setEmailCfgCreateDate(Timestamp emailCfgCreateDate) {
		this.emailCfgCreateDate = emailCfgCreateDate;
	}

	@Column(name = "EMAIL_CFG_MODIFY_DATE", length = 11)
	public Timestamp getEmailCfgModifyDate() {
		return this.emailCfgModifyDate;
	}

	public void setEmailCfgModifyDate(Timestamp emailCfgModifyDate) {
		this.emailCfgModifyDate = emailCfgModifyDate;
	}

	@Column(name = "EMAIL_CFG_REMARK", length = 300)
	public String getEmailCfgRemark() {
		return this.emailCfgRemark;
	}

	public void setEmailCfgRemark(String emailCfgRemark) {
		this.emailCfgRemark = emailCfgRemark;
	}

	@Column(name = "EMAIL_CFG_PORT", precision = 1, scale = 0)
	public Short getEmailCfgPort() {
		return emailCfgPort;
	}

	public void setEmailCfgPort(Short emailCfgPort) {
		this.emailCfgPort = emailCfgPort;
	}

	@Column(name = "EMAIL_CFG_TYPE_NAME", precision = 1, scale = 0)
	public String getEmailCfgTypeName() {
		return emailCfgTypeName;
	}

	public void setEmailCfgTypeName(String emailCfgTypeName) {
		this.emailCfgTypeName = emailCfgTypeName;
	}

}