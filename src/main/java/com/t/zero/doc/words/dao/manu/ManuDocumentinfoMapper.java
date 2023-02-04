package com.t.zero.doc.words.dao.manu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.t.zero.doc.words.model.auto.Documentinfo;

@Mapper
public interface ManuDocumentinfoMapper {

	public List<Documentinfo> selectListWithPageByFilter(@Param("filters") DocumentinfoFilters filters,
			@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

	public Long selectCountWithPageByFilter(@Param("filters") DocumentinfoFilters filters);
}
