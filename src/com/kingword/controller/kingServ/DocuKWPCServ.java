package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kingword.entity.kingword.DocuKWPageCount;
import com.kingword.entity.kingword.DocuMessage;

public interface DocuKWPCServ {

	void deleterkd(Long id);

	List<DocuKWPageCount> findAllrkd();

	Page<DocuKWPageCount> findAllKWByPage(PageRequest page);


	List<DocuKWPageCount> finddocumass(DocuMessage docuMessage);

	List<DocuKWPageCount> findAllrkdbywordid(BigDecimal docuId);


	void save(DocuKWPageCount rkd);

	DocuKWPageCount findByrkdRelDWAndPageCode(Long relDocuKingWord, Long pageId);

	List<DocuKWPageCount> findById(long relDocuKingWord);


}
