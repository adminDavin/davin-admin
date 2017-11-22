package com.kingword.common.bean;

import java.util.Arrays;

 
 
public class RegisterAddForm {
 	private String staffName;
	private String staffNamePin;
	private String staffSex;
	private String staffNum;
	private String staffEmail;
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
	public byte[] getStaffPhoto() {
		return staffPhoto;
	}
	public void setStaffPhoto(byte[] staffPhoto) {
		this.staffPhoto = staffPhoto;
	}
	public String getStaffRemark() {
		return staffRemark;
	}
	public void setStaffRemark(String staffRemark) {
		this.staffRemark = staffRemark;
	}
	public String getOperatorMessCode() {
		return operatorMessCode;
	}
	public void setOperatorMessCode(String operatorMessCode) {
		this.operatorMessCode = operatorMessCode;
	}
	public String getOperatorMessPass() {
		return operatorMessPass;
	}
	public void setOperatorMessPass(String operatorMessPass) {
		this.operatorMessPass = operatorMessPass;
	}
	private String staffPhone;
	private String messPass;
	private String staffZoneqq;
	public String getMessPass() {
		return messPass;
	}
	public void setMessPass(String messPass) {
		this.messPass = messPass;
	}
	private String staffAddress;
	private byte[] staffPhoto; 
 	private String staffRemark;
 	private String operatorMessCode;
	@Override
	public String toString() {
		return "RegisterAddForm [staffName=" + staffName + ", staffNamePin="
				+ staffNamePin + ", staffSex=" + staffSex + ", staffNum="
				+ staffNum + ", staffEmail=" + staffEmail + ", staffPhone="
				+ staffPhone + ", staffZoneqq=" + staffZoneqq
				+ ", staffAddress=" + staffAddress + ", staffPhoto="
				+ Arrays.toString(staffPhoto) + ", staffRemark=" + staffRemark
				+ ", operatorMessCode=" + operatorMessCode
				+ ", operatorMessPass=" + operatorMessPass + "]";
	}
	private String operatorMessPass;
 }
