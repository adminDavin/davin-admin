package com.t.zero.doc.words.dao.auto;

import com.t.zero.doc.words.model.auto.Varicode;
import com.t.zero.doc.words.model.auto.VaricodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VaricodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    long countByExample(VaricodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int deleteByExample(VaricodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int deleteByPrimaryKey(Integer varicodeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int insert(Varicode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int insertSelective(Varicode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    List<Varicode> selectByExample(VaricodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    Varicode selectByPrimaryKey(Integer varicodeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByExampleSelective(@Param("record") Varicode record, @Param("example") VaricodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByExample(@Param("record") Varicode record, @Param("example") VaricodeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByPrimaryKeySelective(Varicode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByPrimaryKey(Varicode record);
}