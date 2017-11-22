package com.kingword.repository.kingword;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.kingword.DocuKWPageCount;

public interface DocuKWPCRepos extends PagingAndSortingRepository<DocuKWPageCount, Long> {
	@Query("select rkd from RelationDocuWord rkd")
	public List<DocuKWPageCount> findAllrkd();
	@Query("select rkd from RelationDocuWord rkd where docuId in ?1")
	public List<DocuKWPageCount> findAllrkdbywordid(BigDecimal docuId);
	 @SuppressWarnings("unchecked")
	public DocuKWPageCount save(DocuKWPageCount docuMessage);
	 @Query("select s from DocuKWPageCount s where s.relationDocuWord.relDocuKingWord in ?1"
	 		+ " and s.pageCode in ?2 and rownum=1")  
	public DocuKWPageCount findByrkdRelDWAndPageCode(Long relDocuKingWord,Long pageId);
	@Query("select rkd from DocuKWPageCount rkd where relDocuKingWord in ?1")
	public  List<DocuKWPageCount> findById(long relDocuKingWord); 
}	
