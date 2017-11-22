package com.kingword.entity.kingword;
// default package

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
 * RelationDocuWord entity. @author MyEclipse Persistence Tools
 */
@Entity
@SequenceGenerator(name="seqRelationDocuWord",sequenceName="seqRelationDocuWordid",allocationSize=1)  
@Table(name = "RELATION_DOCU_WORD", schema = "KINGWORD")
public class RelationDocuWord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1343545951824566671L;
	private Long relDocuKingWord;
	private DocuMessage docuMessage;
	private Long kingWordId;
	private String kingWordName;
	private Long kingWordCount;
	private Byte state;
	private Timestamp createDate;
	private Set<DocuKWPageCount> docuKWPageCounts = new HashSet<DocuKWPageCount>(0);

	// Constructors

	/** default constructor */
	public RelationDocuWord() {
	}

	/** minimal constructor */
	public RelationDocuWord(Long relDocuKingWord) {
		this.relDocuKingWord = relDocuKingWord;
	}

	/** full constructor */
	public RelationDocuWord(Long relDocuKingWord, DocuMessage docuMessage,
			Long kingWordId, String kingWordName, Long kingWordCount,
			Byte state, Timestamp createDate,
			Set<DocuKWPageCount> docuKWPageCounts) {
		this.relDocuKingWord = relDocuKingWord;
		this.docuMessage = docuMessage;
		this.kingWordId = kingWordId;
		this.kingWordName = kingWordName;
		this.kingWordCount = kingWordCount;
		this.state = state;
		this.createDate = createDate;
		this.docuKWPageCounts = docuKWPageCounts;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqRelationDocuWord")  
	@Column(name = "RELDOCUKINGWORD", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getRelDocuKingWord() {
		return this.relDocuKingWord;
	}

	

	public void setRelDocuKingWord(Long relDocuKingWord) {
		this.relDocuKingWord = relDocuKingWord;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCUID")
	public DocuMessage getDocuMessage() {
		return this.docuMessage;
	}

	public void setDocuMessage(DocuMessage docuMessage) {
		this.docuMessage = docuMessage;
	}

	@Column(name = "KINGWORDID", precision = 10, scale = 0)
	public Long getKingWordId() {
		return this.kingWordId;
	}

	public void setKingWordId(Long kingWordId) {
		this.kingWordId = kingWordId;
	}

	@Column(name = "KINGWORDNAME", length = 200)
	public String getKingWordName() {
		return this.kingWordName;
	}

	public void setKingWordName(String kingWordName) {
		this.kingWordName = kingWordName;
	}

	@Column(name = "KINGWORDCOUNT", precision = 10, scale = 0)
	public Long getKingWordCount() {
		return this.kingWordCount;
	}

	public void setKingWordCount(Long kingWordCount) {
		this.kingWordCount = kingWordCount;
	}

	@Column(name = "STATE", precision = 2, scale = 0)
	public Byte getState() {
		return this.state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	@Column(name = "CREATEDATE", length = 11)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "relationDocuWord")
	public Set<DocuKWPageCount> getDocuKWPageCounts() {
		return this.docuKWPageCounts;
	}

	public void setDocuKWPageCounts(Set<DocuKWPageCount> docuKWPageCounts) {
		this.docuKWPageCounts = docuKWPageCounts;
	}

}