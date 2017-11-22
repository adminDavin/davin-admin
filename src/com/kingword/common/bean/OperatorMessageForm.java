package com.kingword.common.bean;

import java.sql.Timestamp;

public class OperatorMessageForm {
//操作原信息
	private Integer operatorMessId;//操作员表中的操作员ID
	private Integer     staffMassId;//用户ID
	private String 		staffName;//用户名称
	private String operatorMessCode;//登录账号名
	private String operatorMessPass;//登录密码
	private int operatorMessState;//账号状态
	private Timestamp operatorApplyDate;//账号申请时间
	private Timestamp operatorPassModifyDate;//账号修改时间
	private Timestamp operatorAcceptDate;//账号审核通过时间
	private String operatorAcceptId; //审核人
	private String operatorRemark;  //审核备注
	
//操作员和角色的绑定关系
	private Integer operatorRoleState;  //绑定的角色状态
	private Timestamp operatorRoleApplyDate;//绑定时间
	private Timestamp operatorRoleModifyDate;//绑定修改时间
	private Timestamp operatorRoleAcceptDate;//绑定的审核通过时间
	private String operatorRoleAcceptId; //绑定审核人  
	private String operatorRoleRemark;  //绑定备注
//角色相关信息
	private Integer roleMessId;  //角色ID
	private String roleMessName;  //角色名称
	public Integer getOperatorMessId() {
		return operatorMessId;
	}
	public void setOperatorMessId(Integer operatorMessId) {
		this.operatorMessId = operatorMessId;
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
	public int getOperatorMessState() {
		return operatorMessState;
	}
	public void setOperatorMessState(int operatorMessState) {
		this.operatorMessState = operatorMessState;
	}
	public Timestamp getOperatorApplyDate() {
		return operatorApplyDate;
	}
	public void setOperatorApplyDate(Timestamp operatorApplyDate) {
		this.operatorApplyDate = operatorApplyDate;
	}
	public Timestamp getOperatorPassModifyDate() {
		return operatorPassModifyDate;
	}
	public void setOperatorPassModifyDate(Timestamp operatorPassModifyDate) {
		this.operatorPassModifyDate = operatorPassModifyDate;
	}
	public Timestamp getOperatorAcceptDate() {
		return operatorAcceptDate;
	}
	public void setOperatorAcceptDate(Timestamp operatorAcceptDate) {
		this.operatorAcceptDate = operatorAcceptDate;
	}
	public String getOperatorAcceptId() {
		return operatorAcceptId;
	}
	public void setOperatorAcceptId(String operatorAcceptId) {
		this.operatorAcceptId = operatorAcceptId;
	}
	public String getOperatorRemark() {
		return operatorRemark;
	}
	public void setOperatorRemark(String operatorRemark) {
		this.operatorRemark = operatorRemark;
	}
	public Integer getOperatorRoleState() {
		return operatorRoleState;
	}
	public void setOperatorRoleState(Integer operatorRoleState) {
		this.operatorRoleState = operatorRoleState;
	}
	public Timestamp getOperatorRoleApplyDate() {
		return operatorRoleApplyDate;
	}
	public void setOperatorRoleApplyDate(Timestamp operatorRoleApplyDate) {
		this.operatorRoleApplyDate = operatorRoleApplyDate;
	}
	public Timestamp getOperatorRoleModifyDate() {
		return operatorRoleModifyDate;
	}
	public void setOperatorRoleModifyDate(Timestamp operatorRoleModifyDate) {
		this.operatorRoleModifyDate = operatorRoleModifyDate;
	}
	public Timestamp getOperatorRoleAcceptDate() {
		return operatorRoleAcceptDate;
	}
	public void setOperatorRoleAcceptDate(Timestamp operatorRoleAcceptDate) {
		this.operatorRoleAcceptDate = operatorRoleAcceptDate;
	}
	public String getOperatorRoleAcceptId() {
		return operatorRoleAcceptId;
	}
	public void setOperatorRoleAcceptId(String operatorRoleAcceptId) {
		this.operatorRoleAcceptId = operatorRoleAcceptId;
	}
	public String getOperatorRoleRemark() {
		return operatorRoleRemark;
	}
	public void setOperatorRoleRemark(String operatorRoleRemark) {
		this.operatorRoleRemark = operatorRoleRemark;
	}
	public Integer getRoleMessId() {
		return roleMessId;
	}
	public void setRoleMessId(Integer roleMessId) {
		this.roleMessId = roleMessId;
	}
	public String getRoleMessName() {
		return roleMessName;
	}
	public void setRoleMessName(String roleMessName) {
		this.roleMessName = roleMessName;
	}
	public Integer getStaffMassId() {
		return staffMassId;
	}
	public void setStaffMassId(Integer staffMassId) {
		this.staffMassId = staffMassId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	
	
	
	
}
