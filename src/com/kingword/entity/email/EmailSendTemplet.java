package com.kingword.entity.email;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmailSendTemplet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "EMAIL_SEND_TEMPLET", schema = "EMAIL")
public class EmailSendTemplet implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7020268284548771593L;
	private Short sendTempletId;
	private String sendTempletName;
	private String sendTempletContent;
	private Boolean sendTempletState;
	private Timestamp sendTempletCreateDate;
	private Timestamp sendTempletModifyDate;
	private String sendTempletRemark;

	// Constructors

	/** default constructor */
	public EmailSendTemplet() {
	}

	/** minimal constructor */
	public EmailSendTemplet(Short sendTempletId) {
		this.sendTempletId = sendTempletId;
	}

	/** full constructor */
	public EmailSendTemplet(Short sendTempletId, String sendTempletName,
			String sendTempletContent, Boolean sendTempletState,
			Timestamp sendTempletCreateDate, Timestamp sendTempletModifyDate,
			String sendTempletRemark) {
		this.sendTempletId = sendTempletId;
		this.sendTempletName = sendTempletName;
		this.sendTempletContent = sendTempletContent;
		this.sendTempletState = sendTempletState;
		this.sendTempletCreateDate = sendTempletCreateDate;
		this.sendTempletModifyDate = sendTempletModifyDate;
		this.sendTempletRemark = sendTempletRemark;
	}

	// Property accessors
	@Id
	@Column(name = "SEND_TEMPLET_ID", unique = true, nullable = false, precision = 3, scale = 0)
	public Short getSendTempletId() {
		return this.sendTempletId;
	}

	public void setSendTempletId(Short sendTempletId) {
		this.sendTempletId = sendTempletId;
	}

	@Column(name = "SEND_TEMPLET_NAME", length = 200)
	public String getSendTempletName() {
		return this.sendTempletName;
	}

	public void setSendTempletName(String sendTempletName) {
		this.sendTempletName = sendTempletName;
	}

	@Column(name = "SEND_TEMPLET_CONTENT", length = 2000)
	public String getSendTempletContent() {
		return this.sendTempletContent;
	}

	public void setSendTempletContent(String sendTempletContent) {
		this.sendTempletContent = sendTempletContent;
	}

	@Column(name = "SEND_TEMPLET_STATE", precision = 1, scale = 0)
	public Boolean getSendTempletState() {
		return this.sendTempletState;
	}

	public void setSendTempletState(Boolean sendTempletState) {
		this.sendTempletState = sendTempletState;
	}

	@Column(name = "SEND_TEMPLET_CREATE_DATE", length = 11)
	public Timestamp getSendTempletCreateDate() {
		return this.sendTempletCreateDate;
	}

	public void setSendTempletCreateDate(Timestamp sendTempletCreateDate) {
		this.sendTempletCreateDate = sendTempletCreateDate;
	}

	@Column(name = "SEND_TEMPLET_MODIFY_DATE", length = 11)
	public Timestamp getSendTempletModifyDate() {
		return this.sendTempletModifyDate;
	}

	public void setSendTempletModifyDate(Timestamp sendTempletModifyDate) {
		this.sendTempletModifyDate = sendTempletModifyDate;
	}

	@Column(name = "SEND_TEMPLET_REMARK", length = 300)
	public String getSendTempletRemark() {
		return this.sendTempletRemark;
	}

	public void setSendTempletRemark(String sendTempletRemark) {
		this.sendTempletRemark = sendTempletRemark;
	}

}