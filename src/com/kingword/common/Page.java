package com.kingword.common;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Page<T> {
	private int pageSize;  

    private int resultTotalSize;  

    private List<T> resultList = new ArrayList<T>();

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getResultTotalSize() {
		return resultTotalSize;
	}

	public void setResultTotalSize(int resultTotalSize) {
		this.resultTotalSize = resultTotalSize;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<T> list) {
		this.resultList = (List<T>) list;
	}  
	
	public static int getCurrentPageNoForPopWindow(HttpServletRequest request){
		String pageNo = request.getParameter("p");
		int page= 1;
		if( pageNo!=null ){
			page = Integer.parseInt(pageNo);;
		}
		return page >0 ? page : 1;
	}
	
	public static int getCurrentPage(HttpServletRequest request){
      int page=0;
        Enumeration<?> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = (String)paramNames.nextElement();
            if (name != null && name.startsWith("d-") && name.endsWith("-p")) {
                String pageValue = request.getParameter(name);
                if (pageValue != null) {
                    page = Integer.parseInt(pageValue)-1;
                }else{
                	page = 1;
                }
            }
        }
        return page;
	}
}
