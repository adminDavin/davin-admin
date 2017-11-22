package com.kingword.entity.security;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * StaffMessage entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "STAFF_MESSAGE", schema = "SECURITY")
@SequenceGenerator(name="SQECagegory",sequenceName="SEQ_STAFF_MESSAGE_ID",allocationSize=1)  
public class StaffMessage implements java.io.Serializable {

	// Fields

	private Integer staffMassId;
	private Integer staffOrganizeId;
	private String staffName;
	private String staffNamePin;
	private String staffSex;
	private String staffNum;
	private String staffEmail;
	private String staffPhone;
	private String staffZoneqq;
	private String staffAddress;
	private byte[] staffPhoto;
	private int staffState;
	private Timestamp staffApplyDate;
	private Timestamp staffAcceptDate;
	private Integer staffAcceptId;
	private String staffRemark;
	private Set<OperatorMessage> operatorMessages = new HashSet<OperatorMessage>(
			0);

	// Constructors

	/** default constructor */
	public StaffMessage() {
	}

	/** minimal constructor */
	public StaffMessage(Integer staffMassId) {
		this.staffMassId = staffMassId;
	}

	/** full constructor */
	
	public StaffMessage(Integer staffMassId, Integer staffOrganizeId,
			String staffName, String staffNamePin, String staffSex,
			String staffNum, String staffEmail, String staffPhone,
			String staffZoneqq, String staffAddress, byte[] staffPhoto,
			int staffState, Timestamp staffApplyDate,
			Timestamp staffAcceptDate, Integer staffAcceptId,
			String staffRemark, Set<OperatorMessage> operatorMessages) {
		this.staffMassId = staffMassId;
		this.staffOrganizeId = staffOrganizeId;
		this.staffName = staffName;
		this.staffNamePin = staffNamePin;
		this.staffSex = staffSex;
		this.staffNum = staffNum;
		this.staffEmail = staffEmail;
		this.staffPhone = staffPhone;
		this.staffZoneqq = staffZoneqq;
		this.staffAddress = staffAddress;
		this.staffPhoto = staffPhoto;
		this.staffState = staffState;
		this.staffApplyDate = staffApplyDate;
		this.staffAcceptDate = staffAcceptDate;
		this.staffAcceptId = staffAcceptId;
		this.staffRemark = staffRemark;
		this.operatorMessages = operatorMessages;
	}

	// Property accessors
	@Id
	@Column(name = "STAFF_MASS_ID", unique = true, nullable = false, precision = 6, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQECagegory")  
	public Integer getStaffMassId() {
		return this.staffMassId;
	}

	public void setStaffMassId(Integer staffMassId) {
		this.staffMassId = staffMassId;
	}

	@Column(name = "STAFF_ORGANIZE_ID", precision = 6, scale = 0)
	public Integer getStaffOrganizeId() {
		return this.staffOrganizeId;
	}

	public void setStaffOrganizeId(Integer staffOrganizeId) {
		this.staffOrganizeId = staffOrganizeId;
	}

	@Column(name = "STAFF_NAME", length = 100)
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Column(name = "STAFF_NAME_PIN", length = 150)
	public String getStaffNamePin() {
		return this.staffNamePin;
	}

	public void setStaffNamePin(String staffNamePin) {
		this.staffNamePin = staffNamePin;
	}

	@Column(name = "STAFF_SEX", length = 2)
	public String getStaffSex() {
		return this.staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	@Column(name = "STAFF_NUM", length = 20)
	public String getStaffNum() {
		return this.staffNum;
	}

	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}

	@Column(name = "STAFF_EMAIL", length = 100)
	public String getStaffEmail() {
		return this.staffEmail;
	}

	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}

	@Column(name = "STAFF_PHONE", length = 20)
	public String getStaffPhone() {
		return this.staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	@Column(name = "STAFF_ZONEQQ", length = 20)
	public String getStaffZoneqq() {
		return this.staffZoneqq;
	}

	public void setStaffZoneqq(String staffZoneqq) {
		this.staffZoneqq = staffZoneqq;
	}

	@Column(name = "STAFF_ADDRESS", length = 200)
	public String getStaffAddress() {
		return this.staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	@Lob
	@Column(name = "STAFF_PHOTO")
	public byte[] getStaffPhoto() {
		return this.staffPhoto;
	}

	public void setStaffPhoto(byte[] staffPhoto) {
		this.staffPhoto = staffPhoto;
	}

	@Column(name = "STAFF_STATE", precision = 1, scale = 0)
	public int getStaffState() {
		return this.staffState;
	}

	public void setStaffState(int i) {
		this.staffState = i;
	}

	@Column(name = "STAFF_APPLY_DATE", length = 11)
	public Timestamp getStaffApplyDate() {
		return this.staffApplyDate;
	}

	public void setStaffApplyDate(Timestamp staffApplyDate) {
		this.staffApplyDate = staffApplyDate;
	}

	@Column(name = "STAFF_ACCEPT_DATE", length = 11)
	public Timestamp getStaffAcceptDate() {
		return this.staffAcceptDate;
	}

	public void setStaffAcceptDate(Timestamp staffAcceptDate) {
		this.staffAcceptDate = staffAcceptDate;
	}

	@Column(name = "STAFF_ACCEPT_ID", precision = 6, scale = 0)
	public Integer getStaffAcceptId() {
		return this.staffAcceptId;
	}

	public void setStaffAcceptId(Integer staffAcceptId) {
		this.staffAcceptId = staffAcceptId;
	}

	@Column(name = "STAFF_REMARK", length = 300)
	public String getStaffRemark() {
		return this.staffRemark;
	}

	public void setStaffRemark(String staffRemark) {
		this.staffRemark = staffRemark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staffMessage")
	public Set<OperatorMessage> getOperatorMessages() {
		return this.operatorMessages;
	}

	public void setOperatorMessages(Set<OperatorMessage> operatorMessages) {
		this.operatorMessages = operatorMessages;
	}

}