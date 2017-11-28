package com.web.response;

public enum ErrorCode {
	ACCOUNT_NOT_FOUND(ResultCode.CODE_NOTFOUND, "InvalidAccountName.NotFound",
			"Specified account name does not exist.");

	private int code;
	private String summary;
	private String desc;

	private ErrorCode(int code, String summary, String desc) {
		this.code = code;
		this.summary = summary;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getSummary() {
		return summary;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static void main(String[] args) {
		ErrorCode errorCodeBakup = ErrorCode.ACCOUNT_NOT_FOUND;
		errorCodeBakup.setDesc("123");
		System.out.println(errorCodeBakup.getDesc());
		System.out.println(ErrorCode.ACCOUNT_NOT_FOUND.getDesc());
	}
}
