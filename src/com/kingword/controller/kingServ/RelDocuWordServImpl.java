package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.kingword.entity.kingword.DocuMessage;
import com.kingword.entity.kingword.RelationDocuWord;
import com.kingword.repository.kingword.RelDocuWordRepos;


@Component("relDocuWordServImpl")
public class RelDocuWordServImpl implements RelDocuWordServ {

	@Resource(name="relDocuWordRepos")
    private RelDocuWordRepos relationDocuWordRepos;
	
	@Override
	public void deleterkd(Long id) {
		
		
	}

	@Override
	public List<RelationDocuWord> findAllrkd() {
		
		return (List<RelationDocuWord>) relationDocuWordRepos.findAll();
	}

	@Override
	public Page<RelationDocuWord> findAllKWByPage(PageRequest page) {
		
		return null;
	}

	

	@Override
	public RelationDocuWord save(RelationDocuWord rkd) {
		return relationDocuWordRepos.save(rkd);
	}

	@Override
	public List<RelationDocuWord> finddocumass(DocuMessage docuMessage) {
		return relationDocuWordRepos.findbydocuMessage(docuMessage.getDocuId());
	}

	@Override
	public List<RelationDocuWord> findAllrkdbywordid(BigDecimal docuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RelationDocuWord findbByKWNameAndDocuId(BigDecimal docuId,
			String onhandkingword) {
		return relationDocuWordRepos.findbydocuMessage(docuId,onhandkingword);
	}

	@Override
	public DocuMessage findById(long relDocuKingWord) {
		// TODO Auto-generated method stub
		return relationDocuWordRepos.findByID(relDocuKingWord);
	}
	

}
