package com.t.zero.doc.words.model.auto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Varicode implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column varicode.variCodeId
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    private Integer varicodeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column varicode.loginName
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    private String loginname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column varicode.variCode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    private String varicode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column varicode.state
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column varicode.createData
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    private LocalDateTime createdata;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column varicode.updateDate
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    private LocalDateTime updatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column varicode.variCodeId
     *
     * @return the value of varicode.variCodeId
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public Integer getVaricodeid() {
        return varicodeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column varicode.variCodeId
     *
     * @param varicodeid the value for varicode.variCodeId
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setVaricodeid(Integer varicodeid) {
        this.varicodeid = varicodeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column varicode.loginName
     *
     * @return the value of varicode.loginName
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column varicode.loginName
     *
     * @param loginname the value for varicode.loginName
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column varicode.variCode
     *
     * @return the value of varicode.variCode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public String getVaricode() {
        return varicode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column varicode.variCode
     *
     * @param varicode the value for varicode.variCode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setVaricode(String varicode) {
        this.varicode = varicode == null ? null : varicode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column varicode.state
     *
     * @return the value of varicode.state
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column varicode.state
     *
     * @param state the value for varicode.state
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column varicode.createData
     *
     * @return the value of varicode.createData
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public LocalDateTime getCreatedata() {
        return createdata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column varicode.createData
     *
     * @param createdata the value for varicode.createData
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setCreatedata(LocalDateTime createdata) {
        this.createdata = createdata;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column varicode.updateDate
     *
     * @return the value of varicode.updateDate
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public LocalDateTime getUpdatedate() {
        return updatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column varicode.updateDate
     *
     * @param updatedate the value for varicode.updateDate
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setUpdatedate(LocalDateTime updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", varicodeid=").append(varicodeid);
        sb.append(", loginname=").append(loginname);
        sb.append(", varicode=").append(varicode);
        sb.append(", state=").append(state);
        sb.append(", createdata=").append(createdata);
        sb.append(", updatedate=").append(updatedate);
        sb.append("]");
        return sb.toString();
    }
}