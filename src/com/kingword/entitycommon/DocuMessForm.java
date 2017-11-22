package com.kingword.entitycommon;
// default package

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * DocuMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DOCUMESSAGE", schema = "KINGWORD")
@SequenceGenerator(name="SQECagegory",sequenceName="seqDocuMessageid",allocationSize=1)  
public class DocuMessForm implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1601236810450727209L;
	private BigDecimal docuId;
	private String wordName;
	private Long subjectTypeId;
	private String type;
	private String writer;
	private String realFileName;
	private String servFilePath;
	private Timestamp submitDate;
	private String submitor;
	private String submitorPhone;
	private String writerPhone;
	private String remark;

	// Constructors

	/** default constructor */
	public DocuMessForm() {
	}

	/** minimal constructor */
	public DocuMessForm(BigDecimal docuId) {
		this.docuId = docuId;
	}

	/** full constructor */
	public DocuMessForm(BigDecimal docuId, String wordName, Long subjectTypeId,
			String type, String writer, String realFileName,
			String servFilePath, Timestamp submitDate, String submitor,
			String submitorPhone, String writerPhone, String remark) {
		this.docuId = docuId;
		this.wordName = wordName;
		this.subjectTypeId = subjectTypeId;
		this.type = type;
		this.writer = writer;
		this.realFileName = realFileName;
		this.servFilePath = servFilePath;
		this.submitDate = submitDate;
		this.submitor = submitor;
		this.submitorPhone = submitorPhone;
		this.writerPhone = writerPhone;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQECagegory")  
	@Column(name = "DOCUID", unique = true, nullable = false, precision = 10, scale = 0)
	public BigDecimal getDocuId() {
		return this.docuId;
	}

	public void setDocuId(BigDecimal docuId) {
		this.docuId = docuId;
	}

	@Column(name = "WORDNAME", length = 100)
	public String getWordName() {
		return this.wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	@Column(name = "SUBJECTTYPEID", precision = 10, scale = 0)
	public Long getSubjectTypeId() {
		return this.subjectTypeId;
	}

	public void setSubjectTypeId(Long subjectTypeId) {
		this.subjectTypeId = subjectTypeId;
	}

	@Column(name = "TYPE", length = 200)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "WRITER", length = 100)
	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Column(name = "REALFILENAME", length = 500)
	public String getRealFileName() {
		return this.realFileName;
	}

	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}

	@Column(name = "SERVFILEPATH", length = 600)
	public String getServFilePath() {
		return this.servFilePath;
	}

	public void setServFilePath(String servFilePath) {
		this.servFilePath = servFilePath;
	}

	@Column(name = "SUBMITDATE", length = 11)
	public Timestamp getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	@Column(name = "SUBMITOR", length = 200)
	public String getSubmitor() {
		return this.submitor;
	}

	public void setSubmitor(String submitor) {
		this.submitor = submitor;
	}

	@Column(name = "SUBMITORPHONE", length = 20)
	public String getSubmitorPhone() {
		return this.submitorPhone;
	}

	public void setSubmitorPhone(String submitorPhone) {
		this.submitorPhone = submitorPhone;
	}

	@Column(name = "WRITERPHONE", length = 20)
	public String getWriterPhone() {
		return this.writerPhone;
	}

	public void setWriterPhone(String writerPhone) {
		this.writerPhone = writerPhone;
	}

	@Column(name = "REMARK", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}