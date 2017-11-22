package com.kingword.repository.kingword;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.kingword.KingWord;

public interface KingWordRepos extends PagingAndSortingRepository<KingWord, Long>{
	@Modifying  
    @Query("delete from KingWord s where s.kingWordId in ?1")  
	public void deleteByIds(List<BigDecimal> id); 
	
	@Query("select kingWord from KingWord kingWord where kingWord.wordName = :wordName and kingWord.wordState = 0")
	public KingWord findByKW(String wordName);
	
	@Query("select kingWord from KingWord kingWord")
	public List<KingWord> findAllKingWord();
	
	@Query("select s from KingWord s  where kingWordId in ?1")
	public KingWord findAllKingWordId(BigDecimal kwId);
	
	@SuppressWarnings("unchecked")
	public KingWord save(KingWord kingWord); 
	
	
}
