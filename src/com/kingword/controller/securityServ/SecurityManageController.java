package com.kingword.controller.securityServ;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kingword.common.EmailSendModel;
import com.kingword.common.EmailSendUtil;
import com.kingword.common.bean.DatatablesViewPage;
import com.kingword.common.bean.OperatorMessageForm;
import com.kingword.common.bean.RegisterAddForm;
import com.kingword.common.bean.StringObj;
import com.kingword.common.bean.UserListForm;
import com.kingword.common.util.SecurityUtil;
import com.kingword.controller.emailServ.EmailConfigServ;
import com.kingword.controller.emailServ.EmailSTempParamServ;
import com.kingword.controller.emailServ.EmailSTempServ;
import com.kingword.controller.emailServ.EmailTypeServ;
import com.kingword.entity.email.EmailConfig;
import com.kingword.entity.security.AuthorityMessage;
import com.kingword.entity.security.OperatorMessage;
import com.kingword.entity.security.OperatorRoleManage;
import com.kingword.entity.security.RoleAuthManage;
import com.kingword.entity.security.RoleMessage;
import com.kingword.entity.security.StaffMessage;
import com.kingword.entitycommon.AuthListForm;
import com.kingword.entitycommon.RoleListForm;

@Controller
@RequestMapping(value = "/KW/security")
public class SecurityManageController {

	// 文档信息表
	@Resource(name = "authorityMessServImpl")
	private AuthorityMessServ AuthorityMessServ;
	// 文档信息表
	@Resource(name = "operatorMessServImpl")
	private OperatorMessServ operatorMessServ;
	// 文档信息表
	@Resource(name = "operatorRManServImpl")
	private OperatorRManServ operatorRManServ;

	// 文档信息表
	@Resource(name = "roleAuthManServImpl")
	private RoleAuthManServ roleAuthManServ;
	// 文档信息表
	@Resource(name = "roleMessServImpl")
	private RoleMessServ roleMessServ;
	// 文档信息表
	@Resource(name = "staffMessServImpl")
	private StaffMessServ staffMessServ;

	// 获取邮箱配置信息
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

	/**
	 * 用户注册
	 * 
	 * @param registerAdd
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/re", method = RequestMethod.POST)
	@ResponseBody
	public String getsave(RegisterAddForm registerAdd,
			HttpServletRequest request, ModelMap model, HttpSession session) {

		StaffMessage staffConfig = staffMessServ.getStaffByEmail(registerAdd
				.getStaffEmail());
		if (staffConfig != null) {
			return "Fail";
		}
		StaffMessage staffMessage = new StaffMessage();// 录入用户信息
		OperatorMessage operatorMessage = new OperatorMessage();
		staffMessage.setStaffName(registerAdd.getStaffName()); // 获取用户名称
		staffMessage.setStaffNamePin(registerAdd.getStaffNamePin());// 获取用户名称拼音
		staffMessage.setStaffSex(registerAdd.getStaffSex()); // 获取用户性别
		staffMessage.setStaffNum(registerAdd.getStaffNum());//
		staffMessage.setStaffEmail(registerAdd.getStaffEmail());
		staffMessage.setStaffPhone(registerAdd.getStaffPhone());
		staffMessage.setStaffZoneqq(registerAdd.getStaffZoneqq());
		staffMessage.setStaffAddress(registerAdd.getStaffAddress());
		staffMessage.setStaffPhoto(registerAdd.getStaffPhoto());
		staffMessage.setStaffState(1);// 用户状态 1 未审核 2 审核中 3 审核成功 4 审核失败
		staffMessage.setStaffApplyDate(new Timestamp(new Date().getTime()));
		staffMessage.setStaffRemark(registerAdd.getStaffRemark());
		StaffMessage staffMessage1 = staffMessServ.savestaff(staffMessage);
		// 录入操作员信息
		System.out
				.println("---------------------------------------------------------------");
		System.out.println(registerAdd.getStaffSex());
		operatorMessage.setStaffMessage(staffMessage1);
		operatorMessage.setOperatorMessCode(registerAdd.getStaffEmail());
		operatorMessage.setOperatorMessState(1);
		operatorMessage.setOperatorMessPass(registerAdd.getMessPass());
		operatorMessage
				.setOperatorApplyDate(new Timestamp(new Date().getTime()));
		operatorMessage.setOperatorPassModifyDate(new Timestamp(new Date()
				.getTime()));
		operatorMessage.setOperatorAcceptDate(new Timestamp(new Date()
				.getTime()));
		operatorMessServ.saveOperator(operatorMessage);

		return "Success";
	}

	/**
	 * 用户注册完成后，由超级管理管发送邮件给普通管理员，提醒普通操作员进行审核
	 * */
	@RequestMapping(value = "/alertwarn")
	@ResponseBody
	public String getalertwarn(HttpServletRequest request, ModelMap model,
			HttpSession session) {
		int countNum = staffMessServ.getAllCount(1);
		System.out.println(countNum);
		if (countNum >= 1) { // 邮箱管理员：emailCfgType=1，超级邮箱管理员：2（只有一个超级邮箱管理员）
			this.sendEmailToManage(emailConfigServ.findAllEmailConfig(1),
					"索引家系统审核提醒", "你好,待审核的用户已经达到了" + countNum + "个，请尽快审核！");
		}
		return "security/index.jsp";
	}

	private String sendEmailToManage(List<EmailConfig> list,
			String messageText, String subject) {
		String flagDesc = "准备发送邮件";
		EmailSendModel emailSendModel = new EmailSendModel();
		List<EmailConfig> listSuper = emailConfigServ.findAllEmailConfig(2);
		EmailConfig emailConfig = listSuper.get(0);
		List<String> liTo = new ArrayList<String>();
		String[] to = new String[listSuper.size()];
		// 邮箱收件人
		int i = 0;
		for (EmailConfig emailto : list) {
			liTo.add(emailto.getEmailSendAddr());
			i = i++;
			to[i] = emailto.getEmailSendAddr();
			System.out.println(emailto.getEmailSendAddr());
			System.out.println(emailto.getEmailCfgId());
		}

		emailSendModel.setFrom(emailConfig.getEmailSendAddr());
		emailSendModel.setFromUserName(emailConfig.getEmailLoginName());
		emailSendModel.setFromUserPassword(emailConfig.getEmailLoginPass());
		emailSendModel.setMessageText(messageText);
		emailSendModel.setSmtpHost(emailConfig.getEmailCfgTypeName());
		emailSendModel.setSubject(subject);
		emailSendModel.setTo(to);
		emailSendModel.setSmtpport(emailConfig.getEmailCfgPort());

		// 邮箱发送中。。。。。。。。。。。。。。。。。。。。。。。
		try {
			EmailSendUtil.emailSend(emailSendModel);
			flagDesc = "邮件发送成功";
		} catch (AuthenticationFailedException e) {
			System.out.println("用户名或者密码错误");
			flagDesc = "用户名或者密码错误";
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("邮件发送失败");
			flagDesc = "邮件发送失败";
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("其他异常，导致邮件发送失败");
			flagDesc = "其他异常，导致邮件发送失败";
			e.printStackTrace();
		}

		return flagDesc;

	}

	/**
	 * 用户登录
	 * 
	 * @param sUserName
	 * @param sPassword
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public String getKingWordscount(
			@RequestParam(value = "sUserName", required = false) String sUserName,
			@RequestParam(value = "sPassword", required = false) String sPassword,
			@RequestParam(value = "sLoginType", required = false) String sLoginType,
			HttpServletRequest request, ModelMap model, HttpSession session) {

		session.setAttribute("currentUserCode", sUserName);
		String returnString = "";
		OperatorMessage operatorMessage = operatorMessServ.findlogin(sUserName,
				sPassword, 3);

		if (operatorMessage == null) {
			System.out.println("operatorMessage");
			returnString = "nameorpasswrong";

		} else if (operatorMessage.getOperatorMessState() == 3) {
			session.setAttribute("currentUserid", operatorMessage
					.getStaffMessage().getStaffMassId());
			session.setAttribute("currentUserOperid",
					operatorMessage.getOperatorMessId());
			returnString = SecurityUtil.ManagerConfirm(session, operatorMessage
					.getStaffMessage().getStaffMassId());
		} else {
			System.out.println("用户已经登录成功，但是还未审核通过！");
			returnString = "applying";
		}

		System.out.println(session.getAttribute("currentUserCode"));
		System.out.println(session.getAttribute("returnString"));
		return returnString;
	}

	/**
	 * 用户状态检查
	 * 
	 * @param staffMassId1
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "sec/flagapplycheck")
	@ResponseBody
	public StringObj getFlagapplycheck(
			@RequestParam(value = "staffMass", required = false) String staffMassId1,
			HttpServletRequest request, ModelMap model, HttpSession session) {
		StringObj applyState = new StringObj();
		int staffMassId = 0;
		if (session.getAttribute("currentUserid") == null) {
			applyState.setRespouseTest("loginning_expired");
			return applyState;
		}
		if (session.getAttribute("managerType") == null) {
			applyState.setRespouseTest("notManager");
			return applyState;
		}
		if (staffMassId1 != null) {
			staffMassId = Integer.parseInt(staffMassId1);
		}// 用户状态 1 未审核 2 审核中 3 审核成功 4 审核失败
		StaffMessage staffMessage1 = staffMessServ
				.findByStaffMassId(staffMassId);
		if (staffMessage1 != null) {
			if (staffMessage1.getStaffState() == 1) {// 未审核
				applyState.setRespouseTest("unapply");
				staffMessage1.setStaffState(2);// 审核中
				@SuppressWarnings("unused")
				StaffMessage savestaff = staffMessServ.savestaff(staffMessage1);
			} else {
				applyState.setRespouseTest("applying");
			}
		}
		System.out.println(applyState.getRespouseTest());
		return applyState;
	}

	/**
	 * 用户审核处理函数
	 * 
	 * @param staffMassId1
	 * @param flag
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "sec/flagapplySecc")
	@ResponseBody
	public StringObj getFlagapplySecc(
			@RequestParam(value = "staffMass", required = false) String staffMassId1,
			@RequestParam(value = "flag", required = false) String flag,
			HttpServletRequest request, ModelMap model, HttpSession session) {

		/*
		 * flag=6 将正在审核的用户改为待审核 flag=5 将审核失败的用户删除 flag=1 将待审核的用户审核通过 flag=2
		 * 将待审核的用户改为审核失败
		 * 
		 * applyState loginning_expired 登录用户已失效 或者未登录 no_auth 用户已登录但用户没有审核权限
		 * apply_secc 审核处理成功 apply_fail 审核处理失败
		 */
		StringObj applyState = new StringObj();
		session.getAttribute("currentUserCode");
		String emailcontext;
		if (session.getAttribute("currentUserid") == null) {
			applyState.setRespouseTest("loginning_expired");
			return applyState;
		}
		if (session.getAttribute("managerType") == null) {
			applyState.setRespouseTest("notManager");
			return applyState;
		}
		int currentUserid = (int) session.getAttribute("currentUserid");

		EmailConfig emailConfig = emailConfigServ.findById(currentUserid);
		if (emailConfig == null) {
			applyState.setRespouseTest("no_auth");
			return applyState;
		}
		int staffMassId = 0;// 用户状态 1 未审核 2 审核中 3 审核成功 4 审核失败
		if (staffMassId1 != null) {
			staffMassId = Integer.parseInt(staffMassId1);
			System.out.println(staffMassId);
		}
		StaffMessage staffMessage1 = staffMessServ
				.findByStaffMassId(staffMassId);
		if (flag.equals("1")) {
			staffMessage1.setStaffState(3);// 审核通过
			staffMessage1.setStaffAcceptId(currentUserid);
			staffMessServ.savestaff(staffMessage1);
			emailcontext = "你好,恭喜你已经注册成功，并审核成功，成为索引家系统中的一员，你的";
			for (OperatorMessage iterable_element : operatorMessServ
					.getOperatorbystaffid(staffMessage1)) {
				iterable_element.setOperatorMessState(3);
				operatorMessServ.saveOperator(iterable_element);
				emailcontext = emailcontext + "登录名是："
						+ iterable_element.getOperatorMessCode() + ",密码是："
						+ iterable_element.getOperatorMessPass();
				emailcontext = emailcontext + "请妥善保管";
			}
			this.sendEmailToUser(staffMessage1, "索引家系统用户注册反馈，恭喜你已经被审核通过",
					emailcontext);
			applyState.setRespouseTest("apply_secc");

		} else if (flag.equals("2")) {
			staffMessage1.setStaffState(4);// 审核失败
			staffMessage1.setStaffAcceptId(currentUserid);
			staffMessServ.savestaff(staffMessage1);

			emailcontext = "你好，你注册的索引家用户审核审核失败。";
			this.sendEmailToUser(staffMessage1, "索引家系统用户注册反馈，你的注册未被审核通过",
					emailcontext);
			applyState.setRespouseTest("apply_secc");

		} else if (flag.equals("6")) {
			staffMessage1.setStaffState(1);//
			staffMessage1.setStaffAcceptId(currentUserid);
			staffMessServ.savestaff(staffMessage1);
			applyState.setRespouseTest("apply_secc");

		} else if (flag.equals("7")) {
			String returnString;
			returnString = SecurityUtil.ManagerConfirm(session,
					staffMessage1.getStaffMassId());
			String dolResult;
			if (returnString == "notManagers") {
				staffMessage1.setStaffState(1);//
				staffMessage1.setStaffAcceptId(currentUserid);
				staffMessServ.savestaff(staffMessage1);
				dolResult = "apply_secc";
			} else {
				dolResult = "apply_Fail_On_managers";
			}
			applyState.setRespouseTest(dolResult);

		} else if (flag.equals("5")) {
			staffMessage1.setStaffState(4);//
			staffMessage1.setStaffAcceptId(currentUserid);

			String dolResult = operatorMessServ
					.deleteOperbystaffId(staffMessage1);
			staffMessServ.deletestaffid(staffMessage1.getStaffMassId());
			applyState.setRespouseTest(dolResult);

		} else {
			applyState.setRespouseTest("unknow flag");

		}

		return applyState;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String sendEmailToUser(StaffMessage staffMessage1,
			String messageText, String subject) {

		EmailSendModel emailSendModel = new EmailSendModel();
		String flag = "false";
		EmailConfig emailConfig = emailConfigServ.findById(staffMessage1
				.getStaffAcceptId());

		// 邮箱收件人
		String[] to = new String[] { staffMessage1.getStaffEmail() };
		System.out.println(to.toString());
		System.out.println(emailConfig.getEmailSendAddr());
		System.out.println(emailConfig.getEmailLoginName());
		System.out.println(emailConfig.getEmailLoginPass());
		System.out.println(emailConfig.getEmailCfgTypeName());
		System.out.println(emailConfig.getEmailCfgPort());
		System.out.println(emailConfig.getEmailSendAddr());
		System.out.println(emailConfig.getEmailSendAddr());
		System.out.println(emailConfig.getEmailSendAddr());

		emailSendModel.setFrom(emailConfig.getEmailSendAddr());
		emailSendModel.setFromUserName(emailConfig.getEmailLoginName());
		emailSendModel.setFromUserPassword(emailConfig.getEmailLoginPass());
		emailSendModel.setMessageText(messageText);
		emailSendModel.setSmtpHost(emailConfig.getEmailCfgTypeName());
		emailSendModel.setSubject(subject);
		emailSendModel.setTo(to);
		emailSendModel.setSmtpport(emailConfig.getEmailCfgPort());
		try {
			EmailSendUtil.emailSend(emailSendModel);
		} catch (AuthenticationFailedException e) {
			System.out.println("用户名或者密码错误");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("邮件发送失败");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("其他异常，导致邮件发送失败");
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 获取用户信息 datatables 服务端的数据处理
	 * 
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "sec/userList")
	@ResponseBody
	public DatatablesViewPage<UserListForm> getUserList(
			HttpServletRequest request, ModelMap model, HttpSession session) {
		// 获取分页控件的信息
		int rowcount = 0;
		int iDisplayStart = 0;
		int iDisplayLength = 0;
		int userStatus = 0;
		String iDisplayStartS = request.getParameter("iDisplayStart");
		String iDisplayLengthS = request.getParameter("iDisplayLength");
		String userStatusS = request.getParameter("userStatus");
		System.out.println(iDisplayStartS + iDisplayLengthS);
		iDisplayStart = Integer.valueOf(iDisplayStartS).intValue();
		iDisplayLength = Integer.valueOf(iDisplayLengthS).intValue();
		userStatus = Integer.valueOf(userStatusS).intValue();
		List<UserListForm> list = new ArrayList<UserListForm>();

		rowcount = staffMessServ.getAllCount(userStatus);
		UserListForm user;
		Pageable pageable = new PageRequest(iDisplayStart / iDisplayLength,
				iDisplayLength);
		Iterable<StaffMessage> staffMessList = staffMessServ.findAllStaff(
				pageable, userStatus);
		for (StaffMessage staffMess : staffMessList) {
			user = new UserListForm();
			user.setStaffMassId(staffMess.getStaffMassId());
			user.setStaffName(staffMess.getStaffName());
			user.setStaffNamePin(staffMess.getStaffNamePin());
			user.setStaffSex(staffMess.getStaffSex());
			user.setStaffNum(staffMess.getStaffNum());
			user.setStaffEmail(staffMess.getStaffEmail());
			user.setStaffPhone(staffMess.getStaffPhone());
			user.setStaffZoneqq(staffMess.getStaffZoneqq());
			user.setStaffAddress(staffMess.getStaffAddress());
			user.setStaffState(Integer.toString(staffMess.getStaffState()));
			user.setStaffApplyDate(staffMess.getStaffApplyDate());
			user.setStaffAcceptDate(staffMess.getStaffAcceptDate());
			if (staffMess.getStaffAcceptId() == null) {
				user.setStaffAccept("o");
			} else {
				user.setStaffAccept(Integer.toString(staffMess
						.getStaffAcceptId()));
			}
			user.setStaffRemark(staffMess.getStaffRemark());
			list.add(user);
		}
		DatatablesViewPage<UserListForm> view = new DatatablesViewPage<UserListForm>();
		view.setiTotalDisplayRecords(rowcount);
		view.setiTotalRecords(rowcount);
		view.setAaData(list);
		// Enumeration<String> keys = request.getParameterNames();
		// while(keys.hasMoreElements()) {
		// String k = keys.nextElement();
		// System.out.println(k + " = " + request.getParameter(k) );
		// }
		return view;
	}

	/**
	 * 获取账号信息列表 datatables 服务端的数据处理
	 * 
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/OperateAndRole")
	@ResponseBody
	public DatatablesViewPage<OperatorMessageForm> getOperateAndRole(
			HttpServletRequest request, ModelMap model, HttpSession session) {
		// 获取分页控件的信息
		int rowcount = 0;
		int iDisplayStart = 0;
		int iDisplayLength = 0;
		String iDisplayStartS = request.getParameter("iDisplayStart");
		String iDisplayLengthS = request.getParameter("iDisplayLength");
		iDisplayStart = Integer.valueOf(iDisplayStartS).intValue();
		iDisplayLength = Integer.valueOf(iDisplayLengthS).intValue();
		List<OperatorMessageForm> list = new ArrayList<OperatorMessageForm>();

		rowcount = operatorRManServ.getAllCount();
		OperatorMessageForm user;
		Pageable pageable = new PageRequest(iDisplayStart / iDisplayLength,
				iDisplayLength);
		Iterable<OperatorMessage> operatorMessList = operatorMessServ
				.findAllOperators(pageable);
		for (OperatorMessage operatorMess : operatorMessList) {
			user = new OperatorMessageForm();
			operatorMess.getStaffMessage();
			user.setStaffMassId(operatorMess.getStaffMessage()
					.getStaffAcceptId());
			user.setStaffName(operatorMess.getStaffMessage().getStaffName());
			user.setOperatorMessId(operatorMess.getOperatorMessId());
			user.setOperatorMessCode(operatorMess.getOperatorMessCode());
			user.setOperatorMessPass(operatorMess.getOperatorMessPass());
			user.setOperatorMessState(operatorMess.getOperatorMessState());
			user.setOperatorApplyDate(operatorMess.getOperatorApplyDate());
			user.setOperatorPassModifyDate(operatorMess
					.getOperatorPassModifyDate());
			user.setOperatorAcceptDate(operatorMess.getOperatorAcceptDate());
			user.setOperatorAcceptId(Integer.toString(operatorMess
					.getOperatorAcceptId()));
			user.setOperatorRemark(operatorMess.getOperatorRemark());
			list.add(user);
		}

		DatatablesViewPage<OperatorMessageForm> view = new DatatablesViewPage<OperatorMessageForm>();
		view.setiTotalDisplayRecords(rowcount);
		view.setiTotalRecords(rowcount);
		view.setAaData(list);
		// Enumeration<String> keys = request.getParameterNames();
		// while(keys.hasMoreElements()) {
		// String k = keys.nextElement();
		// System.out.println(k + " = " + request.getParameter(k) );
		// }
		return view;
	}

	@RequestMapping(value = "/getAuthorityMesss")
	@ResponseBody
	public List<AuthorityMessage> getAuthorityMess(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return AuthorityMessServ.findAllAuthorityMess();
	}

	@RequestMapping(value = "/getOperatorMess")
	@ResponseBody
	public List<OperatorMessage> getOperatorMess(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return operatorMessServ.findAllOperatorMess();
	}

	@RequestMapping(value = "/getOperatorRMan")
	@ResponseBody
	public List<OperatorRoleManage> getOperatorRMan(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return operatorRManServ.findAllOperatorRMan();
	}

	@RequestMapping(value = "/getRoleAuthMan")
	@ResponseBody
	public List<RoleAuthManage> getRoleAuthMan(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return roleAuthManServ.findAllRoleAuthMan();
	}

	@RequestMapping(value = "/getRoleMess")
	@ResponseBody
	public List<RoleMessage> getRoleMess(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return roleMessServ.findAllRoleMess();
	}

	@RequestMapping(value = "/getStaffMess")
	@ResponseBody
	public List<StaffMessage> getStaffMess(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		return staffMessServ.findAllStaffMess();
	}

	@RequestMapping(value = "sec/roleList")
	@ResponseBody
	public DatatablesViewPage<RoleListForm> getrRoleList(
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
		List<RoleListForm> list = new ArrayList<RoleListForm>();
		rowcount = staffMessServ.getAllCount(roleListflag);
		RoleListForm user;
		Pageable pageable = new PageRequest(iDisplayStart / iDisplayLength,
				iDisplayLength);
		Iterable<RoleMessage> roleList = roleMessServ.findAllRole(pageable,
				roleListflag);
		for (RoleMessage role : roleList) {
			user = new RoleListForm();
			user.setRoleId(role.getRoleMessId());
			user.setRoleName(role.getRoleMessName());
			user.setRoleDesc(role.getRoleMessDescript());
			user.setCreateDate(role.getRoleCreateDate());
			list.add(user);
		}
		DatatablesViewPage<RoleListForm> view = new DatatablesViewPage<RoleListForm>();
		view.setiTotalDisplayRecords(rowcount);
		view.setiTotalRecords(rowcount);
		view.setAaData(list);
		return view;
	}

	@RequestMapping(value = "sec/authList")
	@ResponseBody
	public DatatablesViewPage<AuthListForm> getrAuthList(
			HttpServletRequest request, ModelMap model, HttpSession session) {
		// 获取分页控件的信息
		int rowcount = 0;
		int iDisplayStart = 0;
		int iDisplayLength = 0;
		int authListflag = 0;
		String iDisplayStartS = request.getParameter("iDisplayStart");
		String iDisplayLengthS = request.getParameter("iDisplayLength");
		String authListAll = request.getParameter("authListAll");
		System.out.println(iDisplayStartS + iDisplayLengthS);
		iDisplayStart = Integer.valueOf(iDisplayStartS).intValue();
		iDisplayLength = Integer.valueOf(iDisplayLengthS).intValue();
		authListflag = Integer.valueOf(authListAll).intValue();
		List<AuthListForm> list = new ArrayList<AuthListForm>();
		rowcount = staffMessServ.getAllCount(authListflag);
		AuthListForm user;
		Pageable pageable = new PageRequest(iDisplayStart / iDisplayLength,
				iDisplayLength);
		Iterable<AuthorityMessage> roleList = AuthorityMessServ.findAllRole(
				pageable, authListflag);
		for (AuthorityMessage auth : roleList) {
			user = new AuthListForm();
			user.setAuthId(auth.getAuthorityMessId());
			user.setAuthName(auth.getAuthorityMessName());
			user.setAuthCode(auth.getAuthorityCode());
			user.setAuthDesc(auth.getAuthorityMessDescript());
			user.setCreateDate(auth.getAuthorityCreateDate());
			list.add(user);
		}
		DatatablesViewPage<AuthListForm> view = new DatatablesViewPage<AuthListForm>();
		view.setiTotalDisplayRecords(rowcount);
		view.setiTotalRecords(rowcount);
		view.setAaData(list);
		return view;
	}

	@RequestMapping(value = "sec/getAuthByRole")
	@ResponseBody
	public List<AuthListForm> getAuthByRole(
			@RequestParam(value = "roleId", required = false) int roleId,
			HttpServletRequest request, ModelMap model, HttpSession session) {
		// 获取分页控件的信息
		List<AuthListForm> list = new ArrayList<AuthListForm>();
		AuthListForm user;
		Iterable<RoleMessage> roleList1 = roleMessServ.findByRoleId(roleId);
		Iterable<AuthorityMessage> roleList = AuthorityMessServ
				.findByRole(roleList1);
		for (AuthorityMessage auth : roleList) {
			user = new AuthListForm();

			System.out.println(auth.getAuthorityMessId());
			System.out.println(auth.getAuthorityMessName());
			System.out.println(auth.getAuthorityCode());

			user.setAuthId(auth.getAuthorityMessId());
			user.setAuthName(auth.getAuthorityMessName());
			user.setAuthCode(auth.getAuthorityCode());
			user.setAuthDesc(auth.getAuthorityMessDescript());
			user.setCreateDate(auth.getAuthorityCreateDate());
			list.add(user);
		}
		return list;
	}
}
