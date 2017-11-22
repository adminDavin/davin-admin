package com.kingword.repository.kingword;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kingword.entity.kingword.DocuMessage;
import com.kingword.entity.kingword.RelationDocuWord;

public interface RelDocuWordRepos extends CrudRepository<RelationDocuWord,Integer>{

	 @SuppressWarnings("unchecked")
	public RelationDocuWord save(RelationDocuWord docuMessage); 
	
	@Query("select s from RelationDocuWord s where s.docuMessage.docuId in ?1")  
	public List<RelationDocuWord> findbydocuMessage(BigDecimal bigDecimal);
	
	@Query("select s from RelationDocuWord s where s.docuMessage.docuId in ?1 and s.kingWordName in ?2 and rownum=1")  
	public RelationDocuWord findbydocuMessage(BigDecimal docuId,
			String onhandkingword);
	@Query("select s from RelationDocuWord s where s.relDocuKingWord in ?1 and rownum=1")  
	public DocuMessage findByID(long relDocuKingWord); 
}
