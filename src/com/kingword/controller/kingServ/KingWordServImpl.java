package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.kingword.entity.kingword.KingWord;
import com.kingword.repository.kingword.KingWordRepos;
 
@Component("kingWordServImpl")
public class KingWordServImpl implements KingWordServ{

	
	@Resource(name="kingWordRepos")
    private KingWordRepos kingWordRepos;
	
	@Override
	public void deleteKingWord(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KingWord> findAllKingWord() {
		List<KingWord> listKingWord=(List<KingWord>) kingWordRepos.findAllKingWord();
		System.out.println(listKingWord.size());
    	for (KingWord kingWord : listKingWord) {
			System.out.println(kingWord.getWordName());
		}
		return listKingWord;
	}

	@Override
	public Page<KingWord> findAllKWByPage(PageRequest page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public KingWord findAllKingWordId(BigDecimal kwId) {
		// TODO Auto-generated method stub
		return kingWordRepos.findAllKingWordId(kwId);
	}
	
	@Override
	public void save(KingWord kingWord) {
		// TODO Auto-generated method stub
		kingWordRepos.save(kingWord);
		System.out.println(kingWord.getWordName());
	}

}
