package com.t.zero.doc.words.dao.manu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.t.zero.doc.words.model.auto.Userinfo;

@Mapper
public interface ManuUserinfoMapper {

	public List<Userinfo> selectListWithPageByFilter(@Param("filters") UserinfoFilters filters,
			@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

	public Long selectCountWithPageByFilter(@Param("filters") UserinfoFilters filters);
}
