package com.kingword.controller.kingServ;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kingword.entity.kingword.DocuMessage;


public interface DocuMessServ {
	public void deleteDocuMessage(Long id);
	public List<DocuMessage> findAllDocuMessages();
	public Page<DocuMessage> findAllUserByPage(PageRequest page);
	public DocuMessage saveDocuMessage(DocuMessage docuMessage);
	public void findByName(DocuMessage docuMessage);
	public  DocuMessage findById(BigDecimal id);
	public List<DocuMessage> findAllDocuMessages(String userCode);
	public int findByIdCount(BigDecimal docuWordId);
}
