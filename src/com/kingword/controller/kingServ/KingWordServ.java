package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kingword.entity.kingword.KingWord;

public interface KingWordServ {
	public void deleteKingWord(Long id);
	public List<KingWord> findAllKingWord();
	public Page<KingWord> findAllKWByPage(PageRequest page);
	public void save(KingWord kingWord);
	KingWord findAllKingWordId(BigDecimal kwId);
	
	
}
