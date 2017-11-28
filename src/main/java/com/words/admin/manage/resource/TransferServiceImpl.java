package com.words.admin.manage.resource;

import org.springframework.stereotype.Component;

@Component("transferService")
public class TransferServiceImpl implements TransferService {

	private int count = 0;

	@Override
	public int counter() {
		count++;
		System.out.println("the counter is :" + count);
		return count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
