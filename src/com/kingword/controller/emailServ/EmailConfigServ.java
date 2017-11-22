package com.kingword.controller.emailServ;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kingword.entity.email.EmailConfig;
import com.kingword.entitycommon.ManegersForm;

public interface EmailConfigServ {
	public List<EmailConfig> findAllEmailConfigs();

	public EmailConfig findById(Integer staffAcceptId);

	public int[] findAllEmailConfigID();

	public List<EmailConfig> findAllEmailConfig(int i);

	public int getAllCount(int roleListflag);

	public Iterable<ManegersForm> findAllemailConfig(Pageable pageable,
			int roleListflag);

}
