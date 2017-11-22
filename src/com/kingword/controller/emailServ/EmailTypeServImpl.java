package com.kingword.controller.emailServ;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kingword.entity.email.EmailType;
import com.kingword.repository.email.EmailTypeRepos;
@Component("emailTypeServImpl")

public class EmailTypeServImpl implements EmailTypeServ{
	@Resource(name="emailTypeRepos")
    private EmailTypeRepos emailTypeRepos;

	@Override
	public List<EmailType> findAllEmailType() {
		// TODO Auto-generated method stub
		return emailTypeRepos.findAllEmailType();
	}

}
