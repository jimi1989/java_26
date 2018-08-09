package com.kaishengit.erp.entity;

import java.util.ArrayList;
import java.util.List;

public class FixOrderPartsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public FixOrderPartsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andPartsIdIsNull() {
            addCriterion("parts_id is null");
            return (Criteria) this;
        }

        public Criteria andPartsIdIsNotNull() {
            addCriterion("parts_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartsIdEqualTo(Integer value) {
            addCriterion("parts_id =", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdNotEqualTo(Integer value) {
            addCriterion("parts_id <>", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdGreaterThan(Integer value) {
            addCriterion("parts_id >", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parts_id >=", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdLessThan(Integer value) {
            addCriterion("parts_id <", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdLessThanOrEqualTo(Integer value) {
            addCriterion("parts_id <=", value, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdIn(List<Integer> values) {
            addCriterion("parts_id in", values, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdNotIn(List<Integer> values) {
            addCriterion("parts_id not in", values, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdBetween(Integer value1, Integer value2) {
            addCriterion("parts_id between", value1, value2, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parts_id not between", value1, value2, "partsId");
            return (Criteria) this;
        }

        public Criteria andPartsNoIsNull() {
            addCriterion("parts_no is null");
            return (Criteria) this;
        }

        public Criteria andPartsNoIsNotNull() {
            addCriterion("parts_no is not null");
            return (Criteria) this;
        }

        public Criteria andPartsNoEqualTo(String value) {
            addCriterion("parts_no =", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoNotEqualTo(String value) {
            addCriterion("parts_no <>", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoGreaterThan(String value) {
            addCriterion("parts_no >", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoGreaterThanOrEqualTo(String value) {
            addCriterion("parts_no >=", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoLessThan(String value) {
            addCriterion("parts_no <", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoLessThanOrEqualTo(String value) {
            addCriterion("parts_no <=", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoLike(String value) {
            addCriterion("parts_no like", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoNotLike(String value) {
            addCriterion("parts_no not like", value, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoIn(List<String> values) {
            addCriterion("parts_no in", values, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoNotIn(List<String> values) {
            addCriterion("parts_no not in", values, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoBetween(String value1, String value2) {
            addCriterion("parts_no between", value1, value2, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNoNotBetween(String value1, String value2) {
            addCriterion("parts_no not between", value1, value2, "partsNo");
            return (Criteria) this;
        }

        public Criteria andPartsNameIsNull() {
            addCriterion("parts_name is null");
            return (Criteria) this;
        }

        public Criteria andPartsNameIsNotNull() {
            addCriterion("parts_name is not null");
            return (Criteria) this;
        }

        public Criteria andPartsNameEqualTo(String value) {
            addCriterion("parts_name =", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotEqualTo(String value) {
            addCriterion("parts_name <>", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameGreaterThan(String value) {
            addCriterion("parts_name >", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameGreaterThanOrEqualTo(String value) {
            addCriterion("parts_name >=", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameLessThan(String value) {
            addCriterion("parts_name <", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameLessThanOrEqualTo(String value) {
            addCriterion("parts_name <=", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameLike(String value) {
            addCriterion("parts_name like", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotLike(String value) {
            addCriterion("parts_name not like", value, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameIn(List<String> values) {
            addCriterion("parts_name in", values, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotIn(List<String> values) {
            addCriterion("parts_name not in", values, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameBetween(String value1, String value2) {
            addCriterion("parts_name between", value1, value2, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNameNotBetween(String value1, String value2) {
            addCriterion("parts_name not between", value1, value2, "partsName");
            return (Criteria) this;
        }

        public Criteria andPartsNumIsNull() {
            addCriterion("parts_num is null");
            return (Criteria) this;
        }

        public Criteria andPartsNumIsNotNull() {
            addCriterion("parts_num is not null");
            return (Criteria) this;
        }

        public Criteria andPartsNumEqualTo(Integer value) {
            addCriterion("parts_num =", value, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumNotEqualTo(Integer value) {
            addCriterion("parts_num <>", value, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumGreaterThan(Integer value) {
            addCriterion("parts_num >", value, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("parts_num >=", value, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumLessThan(Integer value) {
            addCriterion("parts_num <", value, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumLessThanOrEqualTo(Integer value) {
            addCriterion("parts_num <=", value, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumIn(List<Integer> values) {
            addCriterion("parts_num in", values, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumNotIn(List<Integer> values) {
            addCriterion("parts_num not in", values, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumBetween(Integer value1, Integer value2) {
            addCriterion("parts_num between", value1, value2, "partsNum");
            return (Criteria) this;
        }

        public Criteria andPartsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("parts_num not between", value1, value2, "partsNum");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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