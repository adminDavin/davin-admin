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
 * AuthorityMessage entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "AUTHORITY_MESSAGE", schema = "SECURITY")
public class AuthorityMessage implements java.io.Serializable {

	// Fields

	private Integer authorityMessId;
	private String authorityMessName;
	private String authorityMessDescript;
	private String authorityCode;
	private Boolean authorityState;
	private Timestamp authorityCreateDate;
	private Timestamp authorityModifyDate;
	private Set<RoleAuthManage> roleAuthManages = new HashSet<RoleAuthManage>(0);

	// Constructors

	/** default constructor */
	public AuthorityMessage() {
	}

	/** minimal constructor */
	public AuthorityMessage(Integer authorityMessId) {
		this.authorityMessId = authorityMessId;
	}

	/** full constructor */
	public AuthorityMessage(Integer authorityMessId, String authorityMessName,
			String authorityMessDescript, String authorityCode,
			Boolean authorityState, Timestamp authorityCreateDate,
			Timestamp authorityModifyDate, Set<RoleAuthManage> roleAuthManages) {
		this.authorityMessId = authorityMessId;
		this.authorityMessName = authorityMessName;
		this.authorityMessDescript = authorityMessDescript;
		this.authorityCode = authorityCode;
		this.authorityState = authorityState;
		this.authorityCreateDate = authorityCreateDate;
		this.authorityModifyDate = authorityModifyDate;
		this.roleAuthManages = roleAuthManages;
	}

	// Property accessors
	@Id
	@Column(name = "AUTHORITY_MESS_ID", unique = true, nullable = false, precision = 6, scale = 0)
	public Integer getAuthorityMessId() {
		return this.authorityMessId;
	}

	public void setAuthorityMessId(Integer authorityMessId) {
		this.authorityMessId = authorityMessId;
	}

	@Column(name = "AUTHORITY_MESS_NAME", length = 100)
	public String getAuthorityMessName() {
		return this.authorityMessName;
	}

	public void setAuthorityMessName(String authorityMessName) {
		this.authorityMessName = authorityMessName;
	}

	@Column(name = "AUTHORITY_MESS_DESCRIPT", length = 300)
	public String getAuthorityMessDescript() {
		return this.authorityMessDescript;
	}

	public void setAuthorityMessDescript(String authorityMessDescript) {
		this.authorityMessDescript = authorityMessDescript;
	}

	@Column(name = "AUTHORITY_CODE", length = 200)
	public String getAuthorityCode() {
		return this.authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}

	@Column(name = "AUTHORITY_STATE", precision = 1, scale = 0)
	public Boolean getAuthorityState() {
		return this.authorityState;
	}

	public void setAuthorityState(Boolean authorityState) {
		this.authorityState = authorityState;
	}

	@Column(name = "AUTHORITY_CREATE_DATE", length = 11)
	public Timestamp getAuthorityCreateDate() {
		return this.authorityCreateDate;
	}

	public void setAuthorityCreateDate(Timestamp authorityCreateDate) {
		this.authorityCreateDate = authorityCreateDate;
	}

	@Column(name = "AUTHORITY_MODIFY_DATE", length = 11)
	public Timestamp getAuthorityModifyDate() {
		return this.authorityModifyDate;
	}

	public void setAuthorityModifyDate(Timestamp authorityModifyDate) {
		this.authorityModifyDate = authorityModifyDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authorityMessage")
	public Set<RoleAuthManage> getRoleAuthManages() {
		return this.roleAuthManages;
	}

	public void setRoleAuthManages(Set<RoleAuthManage> roleAuthManages) {
		this.roleAuthManages = roleAuthManages;
	}

}