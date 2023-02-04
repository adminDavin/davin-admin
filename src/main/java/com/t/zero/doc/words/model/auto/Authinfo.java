package com.t.zero.doc.words.model.auto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Authinfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authinfo.authId
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    private Integer authid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authinfo.authKey
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    private String authkey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authinfo.desc
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authinfo.state
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authinfo.createDate
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    private LocalDateTime createdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authinfo.expireDate
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    private LocalDateTime expiredate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table authinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authinfo.authId
     *
     * @return the value of authinfo.authId
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public Integer getAuthid() {
        return authid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authinfo.authId
     *
     * @param authid the value for authinfo.authId
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authinfo.authKey
     *
     * @return the value of authinfo.authKey
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public String getAuthkey() {
        return authkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authinfo.authKey
     *
     * @param authkey the value for authinfo.authKey
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public void setAuthkey(String authkey) {
        this.authkey = authkey == null ? null : authkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authinfo.desc
     *
     * @return the value of authinfo.desc
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authinfo.desc
     *
     * @param desc the value for authinfo.desc
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authinfo.state
     *
     * @return the value of authinfo.state
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authinfo.state
     *
     * @param state the value for authinfo.state
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authinfo.createDate
     *
     * @return the value of authinfo.createDate
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public LocalDateTime getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authinfo.createDate
     *
     * @param createdate the value for authinfo.createDate
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authinfo.expireDate
     *
     * @return the value of authinfo.expireDate
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public LocalDateTime getExpiredate() {
        return expiredate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authinfo.expireDate
     *
     * @param expiredate the value for authinfo.expireDate
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    public void setExpiredate(LocalDateTime expiredate) {
        this.expiredate = expiredate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table authinfo
     *
     * @mbg.generated Sun Jan 08 15:22:14 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authid=").append(authid);
        sb.append(", authkey=").append(authkey);
        sb.append(", desc=").append(desc);
        sb.append(", state=").append(state);
        sb.append(", createdate=").append(createdate);
        sb.append(", expiredate=").append(expiredate);
        sb.append("]");
        return sb.toString();
    }
}