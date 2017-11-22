package com.kingword.repository.kingword;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kingword.entity.kingword.DocuMessage;

public interface SubjectTypeRepos extends PagingAndSortingRepository<DocuMessage, Long>{

}
