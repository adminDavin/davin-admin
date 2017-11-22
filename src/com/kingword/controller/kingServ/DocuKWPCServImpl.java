package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.kingword.entity.kingword.DocuKWPageCount;
import com.kingword.entity.kingword.DocuMessage;
import com.kingword.repository.kingword.DocuKWPCRepos;
 

@Component("docuKWPCServImpl")
public class DocuKWPCServImpl implements DocuKWPCServ {

	@Resource(name="docuKWPCRepos")
    private DocuKWPCRepos docuKWPCRepos;
	
	@Override
	public void deleterkd(Long id) {
		
		
	}

	@Override
	public List<DocuKWPageCount> findAllrkd() {
		
		return (List<DocuKWPageCount>) docuKWPCRepos.findAll();
	}

	@Override
	public Page<DocuKWPageCount> findAllKWByPage(PageRequest page) {
		
		return null;
	}

	

	@Override
	public void save(DocuKWPageCount rkd) {
		docuKWPCRepos.save(rkd);
	}

	@Override
	public List<DocuKWPageCount> finddocumass(DocuMessage docuMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DocuKWPageCount> findAllrkdbywordid(BigDecimal docuId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocuKWPageCount findByrkdRelDWAndPageCode(Long relDocuKingWord,
			Long pageId) {
		// TODO Auto-generated method stub
		return docuKWPCRepos.findByrkdRelDWAndPageCode(relDocuKingWord,pageId);
	}

	@Override
	public List<DocuKWPageCount> findById(long relDocuKingWord) {
		// TODO Auto-generated method stub
		return docuKWPCRepos.findById(relDocuKingWord);
	}



	

}
