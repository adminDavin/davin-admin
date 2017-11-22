package com.kingword.common.bean;

import java.sql.Timestamp;

public class UserListForm {

	private Integer     staffMassId;//用户ID
	private String 		staffName;//用户名称
	private String 		staffNamePin;//用户名称拼音
	private String 		staffSex;//性别
	private String 		staffNum;//生日
	private String 		staffEmail;//邮箱
	private String 		staffPhone;//电话
	private String 		staffZoneqq;//WQQ号
	private String 		staffAddress;//联系地址
 	private String 		staffState;//用户状态
	private Timestamp 	staffApplyDate;//用户申请时间
	private Timestamp 	staffAcceptDate;//用户审核通过时间
	private String 		staffAccept;//审核人
	private String 		staffRemark;//审核说明
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffNamePin() {
		return staffNamePin;
	}
	public void setStaffNamePin(String staffNamePin) {
		this.staffNamePin = staffNamePin;
	}
	public String getStaffSex() {
		return staffSex;
	}
	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}
	public String getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffPhone() {
		return staffPhone;
	}
	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	public String getStaffZoneqq() {
		return staffZoneqq;
	}
	public void setStaffZoneqq(String staffZoneqq) {
		this.staffZoneqq = staffZoneqq;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public String getStaffState() {
		return staffState;
	}
	public void setStaffState(String staffState) {
		this.staffState = staffState;
	}
	public Timestamp getStaffApplyDate() {
		return staffApplyDate;
	}
	public void setStaffApplyDate(Timestamp staffApplyDate) {
		this.staffApplyDate = staffApplyDate;
	}
	public Timestamp getStaffAcceptDate() {
		return staffAcceptDate;
	}
	public void setStaffAcceptDate(Timestamp staffAcceptDate) {
		this.staffAcceptDate = staffAcceptDate;
	}
	public String getStaffAccept() {
		return staffAccept;
	}
	public void setStaffAccept(String staffAccept) {
		this.staffAccept = staffAccept;
	}
	public String getStaffRemark() {
		return staffRemark;
	}
	public void setStaffRemark(String staffRemark) {
		this.staffRemark = staffRemark;
	}
	public Integer getStaffMassId() {
		return staffMassId;
	}
	public void setStaffMassId(Integer integer) {
		this.staffMassId = integer;
	}
 	
}
