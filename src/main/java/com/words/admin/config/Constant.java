package com.words.admin.config;

public class Constant {

	public static String STATE = "state";

	public static String NAME = "name";
	public static String NAMEPIN = "namepin";
	public static String ORGANIZE = "Organize";
	public static String SEX = "sex";
	public static String EMAIL = "email";
	public static String PHONE = "phone";
	public static String ZONEQQ = "qq";
	public static String REMARK = "remark";
	public static String ADDRESS = "address";
	public static String[] USERINFO = { NAME, NAMEPIN, ORGANIZE, SEX, EMAIL, PHONE, ZONEQQ, REMARK, ADDRESS };

	public static String ROLENAME = "name";
	public static String ROLEDESC = "desc";
	public static String ROLESERVICE = "service";
	public static String USERID = "userId";
	public static String[] ROLEINFO = { ROLENAME, ROLEDESC, ROLESERVICE, USERID };

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

	public static String PDFPATH = "C:\\Temp\\pdf-store\\";
	public static final String LOCATION = "C:\\Temp\\";
	public static final String EXPORTDOC = "doc";
	public static final String[] DOCUTYTE = { "pdf", "doc" };

	public static final long MAX_FILE_SIZE = 1000 * 1024 * 1024; // 5MB : Max file size.
	public static final long MAX_REQUEST_SIZE = 1000 * 1024 * 1024; // 20MB : Total request size containing Multi part
	public static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
	public static final int FILESAVEDAYS = 1; // 文件保留时间

}
