package com.kingword.entity.kingword;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * KingWord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "KINGWORD", schema = "KINGWORD")
public class KingWord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6806575922392672051L;
	private Long kingWordId;
	private String wordName;
	private String wordType;
	private String wordDesc;
	private String wordState;
	private Timestamp wordCreateDate;
	private String wordCreator;
	private String remark;

	// Constructors

	/** default constructor */
	public KingWord() {
	}

	/** minimal constructor */
	public KingWord(Long kingWordId, String wordName) {
		this.kingWordId = kingWordId;
		this.wordName = wordName;
	}

	/** full constructor */
	public KingWord(Long kingWordId, String wordName, String wordType,
			String wordDesc, String wordState, Timestamp wordCreateDate,
			String wordCreator, String remark) {
		this.kingWordId = kingWordId;
		this.wordName = wordName;
		this.wordType = wordType;
		this.wordDesc = wordDesc;
		this.wordState = wordState;
		this.wordCreateDate = wordCreateDate;
		this.wordCreator = wordCreator;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "KINGWORDID", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getKingWordId() {
		return this.kingWordId;
	}

	public void setKingWordId(Long kingWordId) {
		this.kingWordId = kingWordId;
	}

	@Column(name = "WORDNAME", nullable = false, length = 100)
	public String getWordName() {
		return this.wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	@Column(name = "WORDTYPE", length = 100)
	public String getWordType() {
		return this.wordType;
	}

	public void setWordType(String wordType) {
		this.wordType = wordType;
	}

	@Column(name = "WORDDESC", length = 500)
	public String getWordDesc() {
		return this.wordDesc;
	}

	public void setWordDesc(String wordDesc) {
		this.wordDesc = wordDesc;
	}

	@Column(name = "WORDSTATE", length = 2)
	public String getWordState() {
		return this.wordState;
	}

	public void setWordState(String wordState) {
		this.wordState = wordState;
	}

	@Column(name = "WORDCREATEDATE", length = 11)
	public Timestamp getWordCreateDate() {
		return this.wordCreateDate;
	}

	public void setWordCreateDate(Timestamp wordCreateDate) {
		this.wordCreateDate = wordCreateDate;
	}

	@Column(name = "WORDCREATOR", length = 100)
	public String getWordCreator() {
		return this.wordCreator;
	}

	public void setWordCreator(String wordCreator) {
		this.wordCreator = wordCreator;
	}

	@Column(name = "REMARK", length = 200)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}