package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.kingword.entity.kingword.DocuMessage;
import com.kingword.repository.kingword.DocuMessRepos;
 
@Component("docuMessServImpl")
public class DocuMessServImpl implements DocuMessServ{
	
	@Resource(name="docuMessRepos")
    private DocuMessRepos docuMessageRepos;
	
	@Override
	public DocuMessage saveDocuMessage(DocuMessage docuMessage) {
		return docuMessageRepos.save(docuMessage);
		
	}

	@Override
	public void deleteDocuMessage(Long id) {
		docuMessageRepos.delete(id);
		
	}

	@Override
	public List<DocuMessage> findAllDocuMessages() {
		return (List<DocuMessage>) docuMessageRepos.findAll();
	}

	@Override
	public Page<DocuMessage> findAllUserByPage(PageRequest page) {
		return (Page<DocuMessage>) docuMessageRepos.findAll(page);
	}
	
	@Override
	public DocuMessage findById(BigDecimal id) {
		return  docuMessageRepos.findById(id);
	}

	@Override
	public void findByName(DocuMessage docuMessage) {
		// TODO Auto-generated method stub
		docuMessageRepos.save(docuMessage);
	}

	@Override
	public List<DocuMessage> findAllDocuMessages(String userCode) {
		// TODO Auto-generated method stub
		return (List<DocuMessage>) docuMessageRepos.findbyUserCode(userCode);
	}

	@Override
	public int findByIdCount(BigDecimal docuWordId) {
		// TODO Auto-generated method stub
		return docuMessageRepos.findByIdCount(docuWordId);
	}
	
	

	

	

}
