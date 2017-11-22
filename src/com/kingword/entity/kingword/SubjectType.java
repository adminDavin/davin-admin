package com.kingword.entity.kingword;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SubjectType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SUBJECTTYPE", schema = "KINGWORD")
public class SubjectType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -530426806243024635L;
	private Long subjectTypeId;
	private String wordName;
	private String description;
	private Long parentTypeId;
	private Timestamp createDate;
	private String remark;

	// Constructors

	/** default constructor */
	public SubjectType() {
	}

	/** minimal constructor */
	public SubjectType(Long subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	/** full constructor */
	public SubjectType(Long subjectTypeId, String wordName, String description,
			Long parentTypeId, Timestamp createDate, String remark) {
		this.subjectTypeId = subjectTypeId;
		this.wordName = wordName;
		this.description = description;
		this.parentTypeId = parentTypeId;
		this.createDate = createDate;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "SUBJECTTYPEID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getSubjectTypeId() {
		return this.subjectTypeId;
	}

	public void setSubjectTypeId(Long subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	@Column(name = "WORDNAME", length = 100)
	public String getWordName() {
		return this.wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	@Column(name = "DESCRIPTION", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PARENTTYPEID", precision = 10, scale = 0)
	public Long getParentTypeId() {
		return this.parentTypeId;
	}

	public void setParentTypeId(Long parentTypeId) {
		this.parentTypeId = parentTypeId;
	}

	@Column(name = "CREATEDATE", length = 11)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "REMARK", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}