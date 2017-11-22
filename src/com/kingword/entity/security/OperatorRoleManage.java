package com.kingword.entity.security;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OperatorRoleManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "OPERATOR_ROLE_MANAGE", schema = "SECURITY")
public class OperatorRoleManage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4369545692144105108L;
	private Integer operatorRoleId;
	private RoleMessage roleMessage;
	private OperatorMessage operatorMessage;
	private Integer operatorId;
	private Integer roleOpId;
	private Boolean operatorRoleState;
	private Timestamp operatorRoleApplyDate;
	private Timestamp operatorRoleModifyDate;
	private Timestamp operatorRoleAcceptDate;
	private Integer operatorRoleAcceptId;
	private String operatorRoleRemark;

	// Constructors

	/** default constructor */
	public OperatorRoleManage() {
	}

	/** minimal constructor */
	public OperatorRoleManage(Integer operatorRoleId) {
		this.operatorRoleId = operatorRoleId;
	}

	/** full constructor */
	public OperatorRoleManage(Integer operatorRoleId, RoleMessage roleMessage,
			OperatorMessage operatorMessage, Integer operatorId,
			Integer roleOpId, Boolean operatorRoleState,
			Timestamp operatorRoleApplyDate, Timestamp operatorRoleModifyDate,
			Timestamp operatorRoleAcceptDate, Integer operatorRoleAcceptId,
			String operatorRoleRemark) {
		this.operatorRoleId = operatorRoleId;
		this.roleMessage = roleMessage;
		this.operatorMessage = operatorMessage;
		this.operatorId = operatorId;
		this.roleOpId = roleOpId;
		this.operatorRoleState = operatorRoleState;
		this.operatorRoleApplyDate = operatorRoleApplyDate;
		this.operatorRoleModifyDate = operatorRoleModifyDate;
		this.operatorRoleAcceptDate = operatorRoleAcceptDate;
		this.operatorRoleAcceptId = operatorRoleAcceptId;
		this.operatorRoleRemark = operatorRoleRemark;
	}

	// Property accessors
	@Id
	@Column(name = "OPERATOR_ROLE_ID", unique = true, nullable = false, precision = 8, scale = 0)
	public Integer getOperatorRoleId() {
		return this.operatorRoleId;
	}

	public void setOperatorRoleId(Integer operatorRoleId) {
		this.operatorRoleId = operatorRoleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_MESS_ID")
	public RoleMessage getRoleMessage() {
		return this.roleMessage;
	}

	public void setRoleMessage(RoleMessage roleMessage) {
		this.roleMessage = roleMessage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPERATOR_MESS_ID")
	public OperatorMessage getOperatorMessage() {
		return this.operatorMessage;
	}

	public void setOperatorMessage(OperatorMessage operatorMessage) {
		this.operatorMessage = operatorMessage;
	}

	@Column(name = "OPERATOR_ID", precision = 7, scale = 0)
	public Integer getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	@Column(name = "ROLE_OP_ID", precision = 6, scale = 0)
	public Integer getRoleOpId() {
		return this.roleOpId;
	}

	public void setRoleOpId(Integer roleOpId) {
		this.roleOpId = roleOpId;
	}

	@Column(name = "OPERATOR_ROLE_STATE", precision = 1, scale = 0)
	public Boolean getOperatorRoleState() {
		return this.operatorRoleState;
	}

	public void setOperatorRoleState(Boolean operatorRoleState) {
		this.operatorRoleState = operatorRoleState;
	}

	@Column(name = "OPERATOR_ROLE_APPLY_DATE", length = 11)
	public Timestamp getOperatorRoleApplyDate() {
		return this.operatorRoleApplyDate;
	}

	public void setOperatorRoleApplyDate(Timestamp operatorRoleApplyDate) {
		this.operatorRoleApplyDate = operatorRoleApplyDate;
	}

	@Column(name = "OPERATOR_ROLE_MODIFY_DATE", length = 11)
	public Timestamp getOperatorRoleModifyDate() {
		return this.operatorRoleModifyDate;
	}

	public void setOperatorRoleModifyDate(Timestamp operatorRoleModifyDate) {
		this.operatorRoleModifyDate = operatorRoleModifyDate;
	}

	@Column(name = "OPERATOR_ROLE_ACCEPT_DATE", length = 11)
	public Timestamp getOperatorRoleAcceptDate() {
		return this.operatorRoleAcceptDate;
	}

	public void setOperatorRoleAcceptDate(Timestamp operatorRoleAcceptDate) {
		this.operatorRoleAcceptDate = operatorRoleAcceptDate;
	}

	@Column(name = "OPERATOR_ROLE_ACCEPT_ID", precision = 6, scale = 0)
	public Integer getOperatorRoleAcceptId() {
		return this.operatorRoleAcceptId;
	}

	public void setOperatorRoleAcceptId(Integer operatorRoleAcceptId) {
		this.operatorRoleAcceptId = operatorRoleAcceptId;
	}

	@Column(name = "OPERATOR_ROLE_REMARK", length = 300)
	public String getOperatorRoleRemark() {
		return this.operatorRoleRemark;
	}

	public void setOperatorRoleRemark(String operatorRoleRemark) {
		this.operatorRoleRemark = operatorRoleRemark;
	}

}