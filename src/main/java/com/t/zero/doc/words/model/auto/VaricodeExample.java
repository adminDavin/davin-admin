package com.t.zero.doc.words.model.auto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VaricodeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public VaricodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andVaricodeidIsNull() {
            addCriterion("variCodeId is null");
            return (Criteria) this;
        }

        public Criteria andVaricodeidIsNotNull() {
            addCriterion("variCodeId is not null");
            return (Criteria) this;
        }

        public Criteria andVaricodeidEqualTo(Integer value) {
            addCriterion("variCodeId =", value, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidNotEqualTo(Integer value) {
            addCriterion("variCodeId <>", value, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidGreaterThan(Integer value) {
            addCriterion("variCodeId >", value, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("variCodeId >=", value, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidLessThan(Integer value) {
            addCriterion("variCodeId <", value, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidLessThanOrEqualTo(Integer value) {
            addCriterion("variCodeId <=", value, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidIn(List<Integer> values) {
            addCriterion("variCodeId in", values, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidNotIn(List<Integer> values) {
            addCriterion("variCodeId not in", values, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidBetween(Integer value1, Integer value2) {
            addCriterion("variCodeId between", value1, value2, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andVaricodeidNotBetween(Integer value1, Integer value2) {
            addCriterion("variCodeId not between", value1, value2, "varicodeid");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNull() {
            addCriterion("loginName is null");
            return (Criteria) this;
        }

        public Criteria andLoginnameIsNotNull() {
            addCriterion("loginName is not null");
            return (Criteria) this;
        }

        public Criteria andLoginnameEqualTo(String value) {
            addCriterion("loginName =", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotEqualTo(String value) {
            addCriterion("loginName <>", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThan(String value) {
            addCriterion("loginName >", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
            addCriterion("loginName >=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThan(String value) {
            addCriterion("loginName <", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLessThanOrEqualTo(String value) {
            addCriterion("loginName <=", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameLike(String value) {
            addCriterion("loginName like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotLike(String value) {
            addCriterion("loginName not like", value, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameIn(List<String> values) {
            addCriterion("loginName in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotIn(List<String> values) {
            addCriterion("loginName not in", values, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameBetween(String value1, String value2) {
            addCriterion("loginName between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andLoginnameNotBetween(String value1, String value2) {
            addCriterion("loginName not between", value1, value2, "loginname");
            return (Criteria) this;
        }

        public Criteria andVaricodeIsNull() {
            addCriterion("variCode is null");
            return (Criteria) this;
        }

        public Criteria andVaricodeIsNotNull() {
            addCriterion("variCode is not null");
            return (Criteria) this;
        }

        public Criteria andVaricodeEqualTo(String value) {
            addCriterion("variCode =", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeNotEqualTo(String value) {
            addCriterion("variCode <>", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeGreaterThan(String value) {
            addCriterion("variCode >", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeGreaterThanOrEqualTo(String value) {
            addCriterion("variCode >=", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeLessThan(String value) {
            addCriterion("variCode <", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeLessThanOrEqualTo(String value) {
            addCriterion("variCode <=", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeLike(String value) {
            addCriterion("variCode like", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeNotLike(String value) {
            addCriterion("variCode not like", value, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeIn(List<String> values) {
            addCriterion("variCode in", values, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeNotIn(List<String> values) {
            addCriterion("variCode not in", values, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeBetween(String value1, String value2) {
            addCriterion("variCode between", value1, value2, "varicode");
            return (Criteria) this;
        }

        public Criteria andVaricodeNotBetween(String value1, String value2) {
            addCriterion("variCode not between", value1, value2, "varicode");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreatedataIsNull() {
            addCriterion("createData is null");
            return (Criteria) this;
        }

        public Criteria andCreatedataIsNotNull() {
            addCriterion("createData is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedataEqualTo(LocalDateTime value) {
            addCriterion("createData =", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataNotEqualTo(LocalDateTime value) {
            addCriterion("createData <>", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataGreaterThan(LocalDateTime value) {
            addCriterion("createData >", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("createData >=", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataLessThan(LocalDateTime value) {
            addCriterion("createData <", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("createData <=", value, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataIn(List<LocalDateTime> values) {
            addCriterion("createData in", values, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataNotIn(List<LocalDateTime> values) {
            addCriterion("createData not in", values, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("createData between", value1, value2, "createdata");
            return (Criteria) this;
        }

        public Criteria andCreatedataNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("createData not between", value1, value2, "createdata");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(LocalDateTime value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(LocalDateTime value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(LocalDateTime value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(LocalDateTime value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<LocalDateTime> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<LocalDateTime> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table varicode
     *
     * @mbg.generated do_not_delete_during_merge Sun Jan 08 15:22:15 CST 2023
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table varicode
     *
     * @mbg.generated Sun Jan 08 15:22:15 CST 2023
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}