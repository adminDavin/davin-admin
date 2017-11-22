package com.kingword.repository.kingword;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.kingword.DocuMessage;


public interface DocuMessRepos extends PagingAndSortingRepository<DocuMessage, Long>{
	@Modifying  
    @Query("delete from DocuMessage s where s.docuId in ?1")  
	public void deleteByIds(List<BigDecimal> id);  
	
	
	 @SuppressWarnings("unchecked")
	public DocuMessage save(DocuMessage docuMessage); 

	 // ����Ҫ���ģ���������������һ�з������� 
	@Query("select s from DocuMessage s where s.docuId in ?1")  
	public DocuMessage findById(BigDecimal id);
	
	@Query("select s from DocuMessage s order by submitDate desc")  
	public List<DocuMessage> findAll();

	@Query("select s from DocuMessage s where s.submitor in ?1 order by submitDate desc")  
	public List<DocuMessage> findbyUserCode(String userCode);

	@Query("select count(s) from DocuMessage s where s.docuId in ?1")  
	public int findByIdCount(BigDecimal docuWordId);
	
	
}
