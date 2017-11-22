package com.kingword.common;

import java.io.Serializable;
import java.util.List;

public class Pagination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4195988310151664459L;
	private int pageSize = 20;
	private int pageNumber = 1;
	private int maxPages;
	private int maxElements;
	private List<?> list;

	public Pagination(int maxElements, int pageSize, int pageNumber, List<?> list){
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		setMaxElements(maxElements);
		setMaxPages();
		setList(list);
		setPageNumber(pageNumber);
	}

	private void setMaxPages() {
		if ((this.maxElements != 0) && (this.maxElements % this.pageSize == 0))
			this.maxPages = (this.maxElements / this.pageSize);
		else
			this.maxPages = (this.maxElements / this.pageSize + 1);
	}

	public List<?> getList() throws Exception {
		return this.list;
	}

	public int getMaxElements() {
		return this.maxElements;
	}

	public int getMaxPages() {
		return this.maxPages;
	}

	public int getNext() {
		if (this.pageNumber + 1 >= getMaxPages()) {
			return getMaxPages();
		}
		return this.pageNumber + 1;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public int getPrevious() {
		if (this.pageNumber - 1 <= 1) {
			return 1;
		}
		return this.pageNumber - 1;
	}

	public boolean hasNext() {
		return this.pageNumber < getMaxPages();
	}

	public boolean hasPrevious() {
		return this.pageNumber > 1;
	}

	public boolean isFirst() {
		return this.pageNumber == 1;
	}

	public boolean isLast() {
		return this.pageNumber >= getMaxPages();
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber > this.maxPages)
			this.pageNumber = this.maxPages;
		else if (pageNumber < 1)
			this.pageNumber = 1;
		else
			this.pageNumber = pageNumber;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setMaxElements(int maxElements) {
		this.maxElements = maxElements;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

}
