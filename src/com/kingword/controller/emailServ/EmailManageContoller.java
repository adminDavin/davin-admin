package com.kingword.controller.emailServ;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingword.common.bean.DatatablesViewPage;
import com.kingword.entity.email.EmailConfig;
import com.kingword.entity.email.EmailSendTemplet;
import com.kingword.entity.email.EmailSendTempletParam;
import com.kingword.entity.email.EmailType;
import com.kingword.entitycommon.ManegersForm;

@Controller
@RequestMapping(value = "/KW/")
public class EmailManageContoller {

	// 文档信息表
	@Resource(name = "emailConfigServImpl")
	private EmailConfigServ emailConfigServ;

	// 文档信息表
	@Resource(name = "emailSTempParamServImpl")
	private EmailSTempParamServ EmailSTempParamServ;

	// 文档信息表
	@Resource(name = "emailSTempServImpl")
	private EmailSTempServ emailSTempServ;

	// 文档信息表
	@Resource(name = "emailTypeServImpl")
	private EmailTypeServ emailTypeServ;

	public List<EmailConfig> getKingWords() {
		return emailConfigServ.findAllEmailConfigs();
	}

	@RequestMapping(value = "/getKingWordscount")
	@ResponseBody
	public List<EmailConfig> getKingWordscount(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return emailConfigServ.findAllEmailConfigs();
	}

	@RequestMapping(value = "/getEmailSTempParam")
	@ResponseBody
	public List<EmailSendTempletParam> getEmailSTempParam(
			HttpServletRequest request, ModelMap model, HttpSession session) {
		return EmailSTempParamServ.findAllEmailSTempParam();
	}

	@RequestMapping(value = "/getEmailSTemp")
	@ResponseBody
	public List<EmailSendTemplet> getEmailSTemp(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return emailSTempServ.findAllEmailSTemp();
	}

	@RequestMapping(value = "/getEmailType")
	@ResponseBody
	public List<EmailType> getEmailType(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return emailTypeServ.findAllEmailType();
	}

	@RequestMapping(value = "security/sec/getManagers")
	@ResponseBody
	public DatatablesViewPage<ManegersForm> getManagers(
			HttpServletRequest request, ModelMap model, HttpSession session) {
		// 获取分页控件的信息
		int rowcount = 0;
		int iDisplayStart = 0;
		int iDisplayLength = 0;
		int roleListflag = 0;
		String iDisplayStartS = request.getParameter("iDisplayStart");
		String iDisplayLengthS = request.getParameter("iDisplayLength");
		String roleListAll = request.getParameter("roleListAll");
		System.out.println(iDisplayStartS + iDisplayLengthS);
		iDisplayStart = Integer.valueOf(iDisplayStartS).intValue();
		iDisplayLength = Integer.valueOf(iDisplayLengthS).intValue();
		roleListflag = Integer.valueOf(roleListAll).intValue();
		rowcount = emailConfigServ.getAllCount(roleListflag);
		Pageable pageable = new PageRequest(iDisplayStart / iDisplayLength,
				iDisplayLength);
		Iterable<ManegersForm> roleList = emailConfigServ.findAllemailConfig(
				pageable, roleListflag);
		DatatablesViewPage<ManegersForm> view = new DatatablesViewPage<ManegersForm>();
		view.setiTotalDisplayRecords(rowcount);
		view.setiTotalRecords(rowcount);
		view.setAaData((List<ManegersForm>) roleList);

		return view;
	}
}
