package com.kingword.controller.emailServ;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.kingword.entity.email.EmailSendTempletParam;
import com.kingword.repository.email.EmailSTempParamRepos;
@Component("emailSTempParamServImpl")

public class EmailSTempParamServImpl  implements EmailSTempParamServ{
	@Resource(name="emailSTempParamRepos")
    private EmailSTempParamRepos emailSTempParamRepos;

	@Override
	public List<EmailSendTempletParam> findAllEmailSTempParam() {
		// TODO Auto-generated method stub
		return emailSTempParamRepos.findAllEmailSTempParam();
	}

}
