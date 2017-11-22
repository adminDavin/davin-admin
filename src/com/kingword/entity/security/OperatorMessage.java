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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * OperatorMessage entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "OPERATOR_MESSAGE", schema = "SECURITY")
@SequenceGenerator(name = "SQECagegory", sequenceName = "SEQ_OPERATOR_MESSAGE_ID", allocationSize = 1)
public class OperatorMessage implements java.io.Serializable {

	// Fields

	private Integer operatorMessId;
	private StaffMessage staffMessage;
	private String operatorMessCode;
	private String operatorMessPass;
	private int operatorMessState;
	private Timestamp operatorApplyDate;
	private Timestamp operatorPassModifyDate;
	private Timestamp operatorAcceptDate;
	private Integer operatorAcceptId;
	private String operatorRemark;
	private Set<OperatorRoleManage> operatorRoleManages = new HashSet<OperatorRoleManage>(
			0);

	// Constructors

	/** default constructor */
	public OperatorMessage() {
	}

	/** minimal constructor */
	public OperatorMessage(Integer operatorMessId) {
		this.operatorMessId = operatorMessId;
	}

	/** full constructor */
	public OperatorMessage(Integer operatorMessId, StaffMessage staffMessage,
			String operatorMessCode, String operatorMessPass,
			int operatorMessState, Timestamp operatorApplyDate,
			Timestamp operatorPassModifyDate, Timestamp operatorAcceptDate,
			Integer operatorAcceptId, String operatorRemark,
			Set<OperatorRoleManage> operatorRoleManages) {
		this.operatorMessId = operatorMessId;
		this.staffMessage = staffMessage;
		this.operatorMessCode = operatorMessCode;
		this.operatorMessPass = operatorMessPass;
		this.operatorMessState = operatorMessState;
		this.operatorApplyDate = operatorApplyDate;
		this.operatorPassModifyDate = operatorPassModifyDate;
		this.operatorAcceptDate = operatorAcceptDate;
		this.operatorAcceptId = operatorAcceptId;
		this.operatorRemark = operatorRemark;
		this.operatorRoleManages = operatorRoleManages;
	}

	// Property accessors
	@Id
	@Column(name = "OPERATOR_MESS_ID", unique = true, nullable = false, precision = 7, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQECagegory")
	public Integer getOperatorMessId() {
		return this.operatorMessId;
	}

	public void setOperatorMessId(Integer operatorMessId) {
		this.operatorMessId = operatorMessId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OPERATOR_STAFF_ID")
	public StaffMessage getStaffMessage() {
		return this.staffMessage;
	}

	public void setStaffMessage(StaffMessage staffMessage) {
		this.staffMessage = staffMessage;
	}

	@Column(name = "OPERATOR_MESS_CODE", length = 150)
	public String getOperatorMessCode() {
		return this.operatorMessCode;
	}

	public void setOperatorMessCode(String operatorMessCode) {
		this.operatorMessCode = operatorMessCode;
	}

	@Column(name = "OPERATOR_MESS_PASS", length = 50)
	public String getOperatorMessPass() {
		return this.operatorMessPass;
	}

	public void setOperatorMessPass(String operatorMessPass) {
		this.operatorMessPass = operatorMessPass;
	}

	@Column(name = "OPERATOR_MESS_STATE", precision = 1, scale = 0)
	public int getOperatorMessState() {
		return this.operatorMessState;
	}

	public void setOperatorMessState(int i) {
		this.operatorMessState = i;
	}

	@Column(name = "OPERATOR_APPLY_DATE", length = 11)
	public Timestamp getOperatorApplyDate() {
		return this.operatorApplyDate;
	}

	public void setOperatorApplyDate(Timestamp operatorApplyDate) {
		this.operatorApplyDate = operatorApplyDate;
	}

	@Column(name = "OPERATOR_PASS_MODIFY_DATE", length = 11)
	public Timestamp getOperatorPassModifyDate() {
		return this.operatorPassModifyDate;
	}

	public void setOperatorPassModifyDate(Timestamp operatorPassModifyDate) {
		this.operatorPassModifyDate = operatorPassModifyDate;
	}

	@Column(name = "OPERATOR_ACCEPT_DATE", length = 11)
	public Timestamp getOperatorAcceptDate() {
		return this.operatorAcceptDate;
	}

	public void setOperatorAcceptDate(Timestamp operatorAcceptDate) {
		this.operatorAcceptDate = operatorAcceptDate;
	}

	@Column(name = "OPERATOR_ACCEPT_ID", precision = 6, scale = 0)
	public Integer getOperatorAcceptId() {
		return this.operatorAcceptId;
	}

	public void setOperatorAcceptId(Integer operatorAcceptId) {
		this.operatorAcceptId = operatorAcceptId;
	}

	@Column(name = "OPERATOR_REMARK", length = 300)
	public String getOperatorRemark() {
		return this.operatorRemark;
	}

	public void setOperatorRemark(String operatorRemark) {
		this.operatorRemark = operatorRemark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "operatorMessage")
	public Set<OperatorRoleManage> getOperatorRoleManages() {
		return this.operatorRoleManages;
	}

	public void setOperatorRoleManages(
			Set<OperatorRoleManage> operatorRoleManages) {
		this.operatorRoleManages = operatorRoleManages;
	}

}