package com.kingword.controller.emailServ;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kingword.entity.email.EmailSendTemplet;
import com.kingword.repository.email.EmailSTempRepos;
@Component("emailSTempServImpl")
public class EmailSTempServImpl implements EmailSTempServ{
	@Resource(name="emailSTempRepos")
    private EmailSTempRepos emailSTempRepos;

	@Override
	public List<EmailSendTemplet> findAllEmailSTemp() {
		// TODO Auto-generated method stub
		return emailSTempRepos.findAllEmailSTemp();
	}

}
