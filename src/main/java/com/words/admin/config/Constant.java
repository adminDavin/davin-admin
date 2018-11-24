package com.words.admin.config;

public class Constant {

	public static String STATE = "state";

	public static String NAME = "name";
	public static String NAMEPIN = "namepin";
	public static String ORGANIZE = "organize";
	public static String SEX = "sex";
	public static String EMAIL = "email";
	public static String PHONE = "phone";
	public static String ZONEQQ = "qq";
	public static String REMARK = "remark";
	public static String ADDRESS = "address";
	public static String BIRTHDATE = "birthDate";
	public static String ACCEPTER = "accepter";
	public static String STATUSACTION = "statusAction";
	public static String MESSAGE = "massage";
	public static String USERID = "userId";

	public static String[] USERINFO = { NAME, NAMEPIN, ORGANIZE, SEX, EMAIL, PHONE, ZONEQQ, REMARK, ADDRESS,
			BIRTHDATE };
	public static String[] UPDATEUSERINFO = { NAME, NAMEPIN, ORGANIZE, PHONE, REMARK, ADDRESS, BIRTHDATE, SEX };
	public static String[] UPDATEUSERINFOSINGLE = { ORGANIZE, PHONE, REMARK, ADDRESS };
	public static String[] UPDATEUSERSTATUSPARAMS = { ACCEPTER, USERID, STATUSACTION, MESSAGE };

	public static String ROLENAME = "name";
	public static String ROLEDESC = "desc";
	public static String ROLESERVICE = "service";
	public static String MANAGEID = "manageId";
	public static String ROLEID = "roleId";

	public static String[] ROLEINFO = { ROLENAME, ROLEDESC, MANAGEID };
	public static String[] DELETEROLEINFO = { ROLEID, MANAGEID };

	public static String WORDSDOCID = "docId";
	public static String INITPAGE = "initPage";
	public static String PAGENUM = "pageNum";
	public static String TEXTCONTENT = "textContent";
	public static String[] WORDSINFO = { WORDSDOCID, USERID, INITPAGE, PAGENUM, TEXTCONTENT };
	public static String EXPORTTYPE = "type";
	public static String EXPORTNAME = "fileName";
	public static String[] EXPORTWORDS = { USERID, WORDSDOCID, EXPORTTYPE, EXPORTNAME };

	public static String SERVICENAME = "name";
	public static String SERVICEDESC = "description";
	public static String SERVICESTATE = "state";
	public static String CREATEDATE = "createDate";
	public static String MODIFYDATE = "modifyDate";
	public static String UPDATEDATE = "updateDate";
	public static String EXPIREDATE = "ExpireDate";

	public static String PDFPATH = "C:\\Temp\\pdf-store\\";

	public static String LOGINNAME = "userName";

	public static String PASSWORD = "password";
	public static final String LOCATION = "C:\\Temp\\";
	public static final String OFFICEHOME = "C:\\Program Files (x86)\\OpenOffice 4";
	public static final String OFFICEWORKER = "C:\\Temp\\office\\worker\\";
	// public static final String OFFICETEMP = "E:\\Temp\\office\\temp\\";
	public static final String EXPORTDOC = "doc";
	public static final String EXPORTPDF = "pdf";
	public static final String[] DOCUTYTE = { "pdf", "doc" };

	public static final long MAX_FILE_SIZE = 1000 * 1024 * 1024; // 5MB : Max file size.
	public static final long MAX_REQUEST_SIZE = 1000 * 1024 * 1024; // 20MB : Total request size containing Multi part
	public static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
	public static final int FILESAVEDAYS = 1; // 文件保留时间

	public static final String LOGINID = "loginId";

	public static final String EMAILMESSAGEFORPASS = "于2017年8月25号9:25:25发起了忘记密码请求，请确保是本人操作，验证码是:";

}
