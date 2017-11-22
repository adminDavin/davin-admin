package com.kingword.entitycommon;

import java.sql.Timestamp;

public class ManegersForm {
	private Integer manegersId;
	private String manegersMEmail;
	private String manegersMSeEmail;
	private int manegersMState;
	private int manegersType;

	private String manegersName;
	private String manegersPin;
	private String manegersEmail;
	private String manegersPhone;
	private String manegersZoneqq;
	private String manegersAddress;
	private int manegersState;
	private Timestamp manegersAcceptDate;
	private String manegersRemark;

	public String getManegersMSeEmail() {
		return this.manegersMSeEmail;
	}

	public void setManegersMSeEmail(String manegersMSeEmail) {
		this.manegersMSeEmail = manegersMSeEmail;
	}

	public Integer getManegersId() {
		return this.manegersId;
	}

	public void setManegersId(Integer manegersId) {
		this.manegersId = manegersId;
	}

	public String getManegersName() {
		return this.manegersName;
	}

	public void setManegersName(String manegersName) {
		this.manegersName = manegersName;
	}

	public String getManegersPin() {
		return this.manegersPin;
	}

	public void setManegersPin(String manegersPin) {
		this.manegersPin = manegersPin;
	}

	public String getManegersEmail() {
		return this.manegersEmail;
	}

	public void setManegersEmail(String manegersEmail) {
		this.manegersEmail = manegersEmail;
	}

	public int getManegersType() {
		return this.manegersType;
	}

	public void setManegersType(int manegersType) {
		this.manegersType = manegersType;
	}

	public String getManegersMEmail() {
		return this.manegersMEmail;
	}

	public void setManegersMEmail(String manegersMEmail) {
		this.manegersMEmail = manegersMEmail;
	}

	public int getManegersMState() {
		return this.manegersMState;
	}

	public void setManegersMState(int manegersMState) {
		this.manegersMState = manegersMState;
	}

	public String getManegersPhone() {
		return this.manegersPhone;
	}

	public void setManegersPhone(String manegersPhone) {
		this.manegersPhone = manegersPhone;
	}

	public String getManegersZoneqq() {
		return this.manegersZoneqq;
	}

	public void setManegersZoneqq(String manegersZoneqq) {
		this.manegersZoneqq = manegersZoneqq;
	}

	public String getManegersAddress() {
		return this.manegersAddress;
	}

	public void setManegersAddress(String manegersAddress) {
		this.manegersAddress = manegersAddress;
	}

	public int getManegersState() {
		return this.manegersState;
	}

	public void setManegersState(int manegersState) {
		this.manegersState = manegersState;
	}

	public Timestamp getManegersAcceptDate() {
		return this.manegersAcceptDate;
	}

	public void setManegersAcceptDate(Timestamp manegersAcceptDate) {
		this.manegersAcceptDate = manegersAcceptDate;
	}

	public String getManegersRemark() {
		return this.manegersRemark;
	}

	public void setManegersRemark(String manegersRemark) {
		this.manegersRemark = manegersRemark;
	}

	@Override
	public String toString() {
		return "ManegersForm [manegersId=" + this.manegersId
				+ ", manegersMEmail=" + this.manegersMEmail
				+ ", manegersMSeEmail=" + this.manegersMSeEmail
				+ ", manegersMState=" + this.manegersMState + ", manegersType="
				+ this.manegersType + ", manegersName=" + this.manegersName
				+ ", manegersPin=" + this.manegersPin + ", manegersEmail="
				+ this.manegersEmail + ", manegersPhone=" + this.manegersPhone
				+ ", manegersZoneqq=" + this.manegersZoneqq
				+ ", manegersAddress=" + this.manegersAddress
				+ ", manegersState=" + this.manegersState
				+ ", manegersAcceptDate=" + this.manegersAcceptDate
				+ ", manegersRemark=" + this.manegersRemark + "]";
	}

}
