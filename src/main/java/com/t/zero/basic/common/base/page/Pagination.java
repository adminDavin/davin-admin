package com.t.zero.basic.common.base.page;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Pagination implements Serializable {
	/**
     *
     */
    private static final long serialVersionUID = 1L;
    private long totalCount;
	private long totalPageSize;
	private int pageSize;
	private int currentPage;

	public Pagination(Integer pageNo, Integer pageSize) {

		if (null == pageSize || pageSize <= 0) {
			this.pageSize = 20;
		} else {
			this.pageSize = pageSize;
		}
		if (null == pageNo || pageNo <= 0) {
			this.currentPage = 1;
		} else {
			this.currentPage = pageNo;
		}
		totalCount = 0;
		totalPageSize = 1;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		if (totalCount > 0 && pageSize > 0) {
			this.totalPageSize = ((totalCount + pageSize - 1) / pageSize);
		}
	}

	public long getOffset() {
		return (this.currentPage - 1) * this.pageSize;
	}

	@Override
	public String toString() {
		return Long.toString(totalCount) + Long.toString(totalPageSize) + Long.toString(pageSize) + Long.toString(currentPage);
	}
}
