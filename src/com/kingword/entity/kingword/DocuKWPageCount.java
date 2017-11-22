package com.kingword.entity.kingword;
// default package

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * DocuKWPageCount entity. @author MyEclipse Persistence Tools
 */
@Entity
@SequenceGenerator(name="seqDocuKWPageCount",sequenceName="seqDocuKWPageCountid",allocationSize=1)  
@Table(name = "DOCUKWPAGECOUNT", schema = "KINGWORD")
public class DocuKWPageCount implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4619361866940565912L;
	private BigDecimal docuKWPageId;
	private RelationDocuWord relationDocuWord;
	private BigDecimal docuId;
	private String docuName;
	private Long kingWordId;
	private String kingWordName;
	private String docuFileName;
	private Long pageCode;
	private Long pageKWCount;
	private String state;
	private String remark;

	// Constructors

	/** default constructor */
	public DocuKWPageCount() {
	}

	/** minimal constructor */
	public DocuKWPageCount(BigDecimal docuKWPageId) {
		this.docuKWPageId = docuKWPageId;
	}

	/** full constructor */
	public DocuKWPageCount(BigDecimal docuKWPageId,
			RelationDocuWord relationDocuWord, BigDecimal docuId, String docuName,
			Long kingWordId, String kingWordName, String docuFileName,
			Long pageCode, Long pageKWCount, String state, String remark) {
		this.docuKWPageId = docuKWPageId;
		this.relationDocuWord = relationDocuWord;
		this.docuId = docuId;
		this.docuName = docuName;
		this.kingWordId = kingWordId;
		this.kingWordName = kingWordName;
		this.docuFileName = docuFileName;
		this.pageCode = pageCode;
		this.pageKWCount = pageKWCount;
		this.state = state;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqDocuKWPageCount")  
	@Column(name = "DOCUKWPAGEID", unique = true, nullable = false, precision = 20, scale = 0)
	public BigDecimal getDocuKWPageId() {
		return this.docuKWPageId;
	}

	public void setDocuKWPageId(BigDecimal docuKWPageId) {
		this.docuKWPageId = docuKWPageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RELDOCUKINGWORD")
	public RelationDocuWord getRelationDocuWord() {
		return this.relationDocuWord;
	}

	public void setRelationDocuWord(RelationDocuWord relationDocuWord) {
		this.relationDocuWord = relationDocuWord;
	}
	@Column(name = "DOCUID", precision = 10, scale = 0)
	public BigDecimal getDocuId() {
		return this.docuId;
	}

	public void setDocuId(BigDecimal bigDecimal) {
		this.docuId = bigDecimal;
	}

	@Column(name = "DOCUNAME", length = 200)
	public String getDocuName() {
		return this.docuName;
	}

	public void setDocuName(String docuName) {
		this.docuName = docuName;
	}

	@Column(name = "KINGWORDID", precision = 10, scale = 0)
	public Long getKingWordId() {
		return this.kingWordId;
	}

	public void setKingWordId(Long kingWordId) {
		this.kingWordId = kingWordId;
	}

	@Column(name = "KINGWORDNAME", length = 500)
	public String getKingWordName() {
		return this.kingWordName;
	}

	public void setKingWordName(String kingWordName) {
		this.kingWordName = kingWordName;
	}

	@Column(name = "DOCUFILENAME", length = 500)
	public String getDocuFileName() {
		return this.docuFileName;
	}

	public void setDocuFileName(String docuFileName) {
		this.docuFileName = docuFileName;
	}

	@Column(name = "PAGECODE", precision = 10, scale = 0)
	public Long getPageCode() {
		return this.pageCode;
	}

	public void setPageCode(Long pageCode) {
		this.pageCode = pageCode;
	}

	@Column(name = "PAGECOUNT", precision = 10, scale = 0)
	public Long getPageKWCount() {
		return this.pageKWCount;
	}

	public void setPageKWCount(Long pageKWCount) {
		this.pageKWCount = pageKWCount;
	}

	@Column(name = "STATE", length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "REMARK", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}