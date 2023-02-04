package com.t.zero.doc.words.manage.bean;

public enum UserStatusEnum {
	AUDITING(1, "auditing"), UNAUDIT(0, "unaudit"), UPDATEEDUSERMESSAGE(6, "updatedStatus"), AGREE(2,
			"agree"), REJECT(3, "reject"), MANAGER(5, "manager");

	private int value;
	private String status;

	public int getValue() {
		return value;
	}

	public String getStatus() {
		return status;
	}

	// 普通方法
	public static int getName(String status) {
		for (UserStatusEnum c : UserStatusEnum.values()) {
			if (c.getStatus().equals(status)) {
				return c.getValue();
			}
		}
		return -1;
	}

	// 普通方法
	public static UserStatusEnum getName(int value) {
		for (UserStatusEnum c : UserStatusEnum.values()) {
			if (c.getValue() == value) {
				return c;
			}
		}
		return null;
	}

	UserStatusEnum(int value, String status) {
		this.value = value;
		this.status = status;
	}

}
