package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kingword.entity.kingword.DocuMessage;
import com.kingword.entity.kingword.RelationDocuWord;


public interface RelDocuWordServ {
	public void deleterkd(Long id);
	public List<RelationDocuWord> findAllrkd();
	public Page<RelationDocuWord> findAllKWByPage(PageRequest page);
	public RelationDocuWord save(RelationDocuWord rkd);
	List<RelationDocuWord> findAllrkdbywordid(BigDecimal docuId);
	List<RelationDocuWord> finddocumass(DocuMessage docuMessage);
	public RelationDocuWord findbByKWNameAndDocuId(BigDecimal bigDecimal,
			String onhandkingword);
	public DocuMessage findById(long relDocuKingWord);
}
