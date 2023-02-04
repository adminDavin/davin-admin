package com.t.zero.doc.words.dao.auto;

import com.t.zero.doc.words.model.auto.Documentinfo;
import com.t.zero.doc.words.model.auto.DocumentinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    long countByExample(DocumentinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int deleteByExample(DocumentinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int deleteByPrimaryKey(Integer docid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int insert(Documentinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int insertSelective(Documentinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    List<Documentinfo> selectByExample(DocumentinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    Documentinfo selectByPrimaryKey(Integer docid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int updateByExampleSelective(@Param("record") Documentinfo record, @Param("example") DocumentinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int updateByExample(@Param("record") Documentinfo record, @Param("example") DocumentinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int updateByPrimaryKeySelective(Documentinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table documentinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    int updateByPrimaryKey(Documentinfo record);
}