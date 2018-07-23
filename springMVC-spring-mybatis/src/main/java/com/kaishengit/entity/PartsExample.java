package com.kaishengit.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PartsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public PartsExample() {
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

        public Criteria andInPriceIsNull() {
            addCriterion("in_price is null");
            return (Criteria) this;
        }

        public Criteria andInPriceIsNotNull() {
            addCriterion("in_price is not null");
            return (Criteria) this;
        }

        public Criteria andInPriceEqualTo(BigDecimal value) {
            addCriterion("in_price =", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceNotEqualTo(BigDecimal value) {
            addCriterion("in_price <>", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceGreaterThan(BigDecimal value) {
            addCriterion("in_price >", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("in_price >=", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceLessThan(BigDecimal value) {
            addCriterion("in_price <", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("in_price <=", value, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceIn(List<BigDecimal> values) {
            addCriterion("in_price in", values, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceNotIn(List<BigDecimal> values) {
            addCriterion("in_price not in", values, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_price between", value1, value2, "inPrice");
            return (Criteria) this;
        }

        public Criteria andInPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("in_price not between", value1, value2, "inPrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(BigDecimal value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(BigDecimal value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(BigDecimal value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(BigDecimal value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<BigDecimal> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<BigDecimal> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNull() {
            addCriterion("inventory is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("inventory is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(Integer value) {
            addCriterion("inventory =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Integer value) {
            addCriterion("inventory <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Integer value) {
            addCriterion("inventory >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Integer value) {
            addCriterion("inventory <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Integer value) {
            addCriterion("inventory <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(List<Integer> values) {
            addCriterion("inventory in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(List<Integer> values) {
            addCriterion("inventory not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Integer value1, Integer value2) {
            addCriterion("inventory between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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