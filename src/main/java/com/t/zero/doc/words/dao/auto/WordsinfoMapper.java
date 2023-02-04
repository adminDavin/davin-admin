package com.t.zero.doc.words.dao.auto;

import com.t.zero.doc.words.model.auto.Wordsinfo;
import com.t.zero.doc.words.model.auto.WordsinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WordsinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    long countByExample(WordsinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int deleteByExample(WordsinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int deleteByPrimaryKey(Integer wordsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int insert(Wordsinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int insertSelective(Wordsinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    List<Wordsinfo> selectByExample(WordsinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    Wordsinfo selectByPrimaryKey(Integer wordsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByExampleSelective(@Param("record") Wordsinfo record, @Param("example") WordsinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByExample(@Param("record") Wordsinfo record, @Param("example") WordsinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByPrimaryKeySelective(Wordsinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wordsinfo
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    int updateByPrimaryKey(Wordsinfo record);
}