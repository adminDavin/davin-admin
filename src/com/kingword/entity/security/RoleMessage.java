package com.kingword.entity.security;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RoleMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ROLE_MESSAGE", schema = "SECURITY")
public class RoleMessage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6234085336006926895L;
	private Integer roleMessId;
	private String roleMessName;
	private String roleMessDescript;
	private Boolean roleState;
	private Timestamp roleCreateDate;
	private Timestamp roleModifyDate;
	private Set<RoleAuthManage> roleAuthManages = new HashSet<RoleAuthManage>(0);
	private Set<OperatorRoleManage> operatorRoleManages = new HashSet<OperatorRoleManage>(
			0);

	// Constructors

	/** default constructor */
	public RoleMessage() {
	}

	/** minimal constructor */
	public RoleMessage(Integer roleMessId) {
		this.roleMessId = roleMessId;
	}

	/** full constructor */
	public RoleMessage(Integer roleMessId, String roleMessName,
			String roleMessDescript, Boolean roleState,
			Timestamp roleCreateDate, Timestamp roleModifyDate,
			Set<RoleAuthManage> roleAuthManages,
			Set<OperatorRoleManage> operatorRoleManages) {
		this.roleMessId = roleMessId;
		this.roleMessName = roleMessName;
		this.roleMessDescript = roleMessDescript;
		this.roleState = roleState;
		this.roleCreateDate = roleCreateDate;
		this.roleModifyDate = roleModifyDate;
		this.roleAuthManages = roleAuthManages;
		this.operatorRoleManages = operatorRoleManages;
	}

	// Property accessors
	@Id
	@Column(name = "ROLE_MESS_ID", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getRoleMessId() {
		return this.roleMessId;
	}

	public void setRoleMessId(Integer roleMessId) {
		this.roleMessId = roleMessId;
	}

	@Column(name = "ROLE_MESS_NAME", length = 100)
	public String getRoleMessName() {
		return this.roleMessName;
	}

	public void setRoleMessName(String roleMessName) {
		this.roleMessName = roleMessName;
	}

	@Column(name = "ROLE_MESS_DESCRIPT", length = 200)
	public String getRoleMessDescript() {
		return this.roleMessDescript;
	}

	public void setRoleMessDescript(String roleMessDescript) {
		this.roleMessDescript = roleMessDescript;
	}

	@Column(name = "ROLE_STATE", precision = 1, scale = 0)
	public Boolean getRoleState() {
		return this.roleState;
	}

	public void setRoleState(Boolean roleState) {
		this.roleState = roleState;
	}

	@Column(name = "ROLE_CREATE_DATE", length = 11)
	public Timestamp getRoleCreateDate() {
		return this.roleCreateDate;
	}

	public void setRoleCreateDate(Timestamp roleCreateDate) {
		this.roleCreateDate = roleCreateDate;
	}

	@Column(name = "ROLE_MODIFY_DATE", length = 11)
	public Timestamp getRoleModifyDate() {
		return this.roleModifyDate;
	}

	public void setRoleModifyDate(Timestamp roleModifyDate) {
		this.roleModifyDate = roleModifyDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleMessage")
	public Set<RoleAuthManage> getRoleAuthManages() {
		return this.roleAuthManages;
	}

	public void setRoleAuthManages(Set<RoleAuthManage> roleAuthManages) {
		this.roleAuthManages = roleAuthManages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roleMessage")
	public Set<OperatorRoleManage> getOperatorRoleManages() {
		return this.operatorRoleManages;
	}

	public void setOperatorRoleManages(
			Set<OperatorRoleManage> operatorRoleManages) {
		this.operatorRoleManages = operatorRoleManages;
	}

}