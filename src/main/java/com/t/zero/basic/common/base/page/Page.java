package com.t.zero.basic.common.base.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Page<T> implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;
    private Pagination pagination;
	private List<T> list;

	public Page(Integer pageNo, Integer pageSize) {
		this.pagination = new Pagination(pageNo, pageSize);
	}

	public static<T> Page<T> build(Integer pageNo, Integer pageSize) {
		return new Page<T>(pageNo, pageSize);
	}
	
	public int getOffset() {
		return (pagination.getCurrentPage() - 1) * pagination.getPageSize();
	}

	public int getPageSize() {
		return pagination.getPageSize();
	}

	public Page<T> setList(List<T> list,long totalCount) {
		this.list = list;
		pagination.setTotalCount(totalCount);
		return this;
	}
	private static final Integer ZERO = 0;
	public Page<T> empty(){
		return this.setList(new ArrayList<>(0), ZERO);
	}

	public long getTotalPages(){
		return this.pagination.getTotalPageSize();
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setTotalCount(long totalCount) {
		pagination.setTotalCount(totalCount);
	}
	public long getTotalCount() {
		return pagination.getTotalCount();
	}


	@Override
	public String toString() {
		return list != null?pagination.toString() + list.toString():pagination.toString();

	}
}