package com.kaishengit.tms.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketOrderExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumIsNull() {
            addCriterion("ticket_order_num is null");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumIsNotNull() {
            addCriterion("ticket_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumEqualTo(String value) {
            addCriterion("ticket_order_num =", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumNotEqualTo(String value) {
            addCriterion("ticket_order_num <>", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumGreaterThan(String value) {
            addCriterion("ticket_order_num >", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_order_num >=", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumLessThan(String value) {
            addCriterion("ticket_order_num <", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumLessThanOrEqualTo(String value) {
            addCriterion("ticket_order_num <=", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumLike(String value) {
            addCriterion("ticket_order_num like", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumNotLike(String value) {
            addCriterion("ticket_order_num not like", value, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumIn(List<String> values) {
            addCriterion("ticket_order_num in", values, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumNotIn(List<String> values) {
            addCriterion("ticket_order_num not in", values, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumBetween(String value1, String value2) {
            addCriterion("ticket_order_num between", value1, value2, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderNumNotBetween(String value1, String value2) {
            addCriterion("ticket_order_num not between", value1, value2, "ticketOrderNum");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceIsNull() {
            addCriterion("ticket_order_price is null");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceIsNotNull() {
            addCriterion("ticket_order_price is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceEqualTo(BigDecimal value) {
            addCriterion("ticket_order_price =", value, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("ticket_order_price <>", value, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("ticket_order_price >", value, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ticket_order_price >=", value, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceLessThan(BigDecimal value) {
            addCriterion("ticket_order_price <", value, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ticket_order_price <=", value, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceIn(List<BigDecimal> values) {
            addCriterion("ticket_order_price in", values, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("ticket_order_price not in", values, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ticket_order_price between", value1, value2, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andTicketOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ticket_order_price not between", value1, value2, "ticketOrderPrice");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNull() {
            addCriterion("ticket_id is null");
            return (Criteria) this;
        }

        public Criteria andTicketIdIsNotNull() {
            addCriterion("ticket_id is not null");
            return (Criteria) this;
        }

        public Criteria andTicketIdEqualTo(Long value) {
            addCriterion("ticket_id =", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotEqualTo(Long value) {
            addCriterion("ticket_id <>", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThan(Long value) {
            addCriterion("ticket_id >", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ticket_id >=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThan(Long value) {
            addCriterion("ticket_id <", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdLessThanOrEqualTo(Long value) {
            addCriterion("ticket_id <=", value, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdIn(List<Long> values) {
            addCriterion("ticket_id in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotIn(List<Long> values) {
            addCriterion("ticket_id not in", values, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdBetween(Long value1, Long value2) {
            addCriterion("ticket_id between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andTicketIdNotBetween(Long value1, Long value2) {
            addCriterion("ticket_id not between", value1, value2, "ticketId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdIsNull() {
            addCriterion("store_account_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdIsNotNull() {
            addCriterion("store_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdEqualTo(Integer value) {
            addCriterion("store_account_id =", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdNotEqualTo(Integer value) {
            addCriterion("store_account_id <>", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdGreaterThan(Integer value) {
            addCriterion("store_account_id >", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_account_id >=", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdLessThan(Integer value) {
            addCriterion("store_account_id <", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_account_id <=", value, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdIn(List<Integer> values) {
            addCriterion("store_account_id in", values, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdNotIn(List<Integer> values) {
            addCriterion("store_account_id not in", values, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("store_account_id between", value1, value2, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andStoreAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_account_id not between", value1, value2, "storeAccountId");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeIsNull() {
            addCriterion("ticket_order_type is null");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeIsNotNull() {
            addCriterion("ticket_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeEqualTo(String value) {
            addCriterion("ticket_order_type =", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeNotEqualTo(String value) {
            addCriterion("ticket_order_type <>", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeGreaterThan(String value) {
            addCriterion("ticket_order_type >", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_order_type >=", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeLessThan(String value) {
            addCriterion("ticket_order_type <", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("ticket_order_type <=", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeLike(String value) {
            addCriterion("ticket_order_type like", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeNotLike(String value) {
            addCriterion("ticket_order_type not like", value, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeIn(List<String> values) {
            addCriterion("ticket_order_type in", values, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeNotIn(List<String> values) {
            addCriterion("ticket_order_type not in", values, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeBetween(String value1, String value2) {
            addCriterion("ticket_order_type between", value1, value2, "ticketOrderType");
            return (Criteria) this;
        }

        public Criteria andTicketOrderTypeNotBetween(String value1, String value2) {
            addCriterion("ticket_order_type not between", value1, value2, "ticketOrderType");
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