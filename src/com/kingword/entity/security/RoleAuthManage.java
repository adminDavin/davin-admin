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
 * RoleAuthManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ROLE_AUTH_MANAGE", schema = "SECURITY")
public class RoleAuthManage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5649645110366430835L;
	private Integer roleAuthId;
	private AuthorityMessage authorityMessage;
	private RoleMessage roleMessage;
	private Boolean roleAuthState;
	private Timestamp roleAuthCreateDate;
	private Timestamp roleAuthModifyDate;
	private String roleAuthRemark;

	// Constructors

	/** default constructor */
	public RoleAuthManage() {
	}

	/** minimal constructor */
	public RoleAuthManage(Integer roleAuthId) {
		this.roleAuthId = roleAuthId;
	}

	/** full constructor */
	public RoleAuthManage(Integer roleAuthId,
			AuthorityMessage authorityMessage, RoleMessage roleMessage,
			Boolean roleAuthState, Timestamp roleAuthCreateDate,
			Timestamp roleAuthModifyDate, String roleAuthRemark) {
		this.roleAuthId = roleAuthId;
		this.authorityMessage = authorityMessage;
		this.roleMessage = roleMessage;
		this.roleAuthState = roleAuthState;
		this.roleAuthCreateDate = roleAuthCreateDate;
		this.roleAuthModifyDate = roleAuthModifyDate;
		this.roleAuthRemark = roleAuthRemark;
	}

	// Property accessors
	@Id
	@Column(name = "ROLE_AUTH_ID", unique = true, nullable = false, precision = 7, scale = 0)
	public Integer getRoleAuthId() {
		return this.roleAuthId;
	}

	public void setRoleAuthId(Integer roleAuthId) {
		this.roleAuthId = roleAuthId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AUTHORITY_ID")
	public AuthorityMessage getAuthorityMessage() {
		return this.authorityMessage;
	}

	public void setAuthorityMessage(AuthorityMessage authorityMessage) {
		this.authorityMessage = authorityMessage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public RoleMessage getRoleMessage() {
		return this.roleMessage;
	}

	public void setRoleMessage(RoleMessage roleMessage) {
		this.roleMessage = roleMessage;
	}

	@Column(name = "ROLE_AUTH_STATE", precision = 1, scale = 0)
	public Boolean getRoleAuthState() {
		return this.roleAuthState;
	}

	public void setRoleAuthState(Boolean roleAuthState) {
		this.roleAuthState = roleAuthState;
	}

	@Column(name = "ROLE_AUTH_CREATE_DATE", length = 11)
	public Timestamp getRoleAuthCreateDate() {
		return this.roleAuthCreateDate;
	}

	public void setRoleAuthCreateDate(Timestamp roleAuthCreateDate) {
		this.roleAuthCreateDate = roleAuthCreateDate;
	}

	@Column(name = "ROLE_AUTH_MODIFY_DATE", length = 11)
	public Timestamp getRoleAuthModifyDate() {
		return this.roleAuthModifyDate;
	}

	public void setRoleAuthModifyDate(Timestamp roleAuthModifyDate) {
		this.roleAuthModifyDate = roleAuthModifyDate;
	}

	@Column(name = "ROLE_AUTH_REMARK", length = 300)
	public String getRoleAuthRemark() {
		return this.roleAuthRemark;
	}

	public void setRoleAuthRemark(String roleAuthRemark) {
		this.roleAuthRemark = roleAuthRemark;
	}

}