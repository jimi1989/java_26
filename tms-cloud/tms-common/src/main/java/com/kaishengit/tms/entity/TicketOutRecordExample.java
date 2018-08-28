package com.kaishengit.tms.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketOutRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketOutRecordExample() {
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

        public Criteria andOutAccountNameIsNull() {
            addCriterion("out_account_name is null");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameIsNotNull() {
            addCriterion("out_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameEqualTo(String value) {
            addCriterion("out_account_name =", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameNotEqualTo(String value) {
            addCriterion("out_account_name <>", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameGreaterThan(String value) {
            addCriterion("out_account_name >", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("out_account_name >=", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameLessThan(String value) {
            addCriterion("out_account_name <", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameLessThanOrEqualTo(String value) {
            addCriterion("out_account_name <=", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameLike(String value) {
            addCriterion("out_account_name like", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameNotLike(String value) {
            addCriterion("out_account_name not like", value, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameIn(List<String> values) {
            addCriterion("out_account_name in", values, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameNotIn(List<String> values) {
            addCriterion("out_account_name not in", values, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameBetween(String value1, String value2) {
            addCriterion("out_account_name between", value1, value2, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andOutAccountNameNotBetween(String value1, String value2) {
            addCriterion("out_account_name not between", value1, value2, "outAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameIsNull() {
            addCriterion("finance_account_name is null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameIsNotNull() {
            addCriterion("finance_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameEqualTo(String value) {
            addCriterion("finance_account_name =", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotEqualTo(String value) {
            addCriterion("finance_account_name <>", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameGreaterThan(String value) {
            addCriterion("finance_account_name >", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("finance_account_name >=", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameLessThan(String value) {
            addCriterion("finance_account_name <", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameLessThanOrEqualTo(String value) {
            addCriterion("finance_account_name <=", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameLike(String value) {
            addCriterion("finance_account_name like", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotLike(String value) {
            addCriterion("finance_account_name not like", value, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameIn(List<String> values) {
            addCriterion("finance_account_name in", values, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotIn(List<String> values) {
            addCriterion("finance_account_name not in", values, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameBetween(String value1, String value2) {
            addCriterion("finance_account_name between", value1, value2, "financeAccountName");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountNameNotBetween(String value1, String value2) {
            addCriterion("finance_account_name not between", value1, value2, "financeAccountName");
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

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumIsNull() {
            addCriterion("begin_ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumIsNotNull() {
            addCriterion("begin_ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumEqualTo(String value) {
            addCriterion("begin_ticket_num =", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotEqualTo(String value) {
            addCriterion("begin_ticket_num <>", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumGreaterThan(String value) {
            addCriterion("begin_ticket_num >", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumGreaterThanOrEqualTo(String value) {
            addCriterion("begin_ticket_num >=", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumLessThan(String value) {
            addCriterion("begin_ticket_num <", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumLessThanOrEqualTo(String value) {
            addCriterion("begin_ticket_num <=", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumLike(String value) {
            addCriterion("begin_ticket_num like", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotLike(String value) {
            addCriterion("begin_ticket_num not like", value, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumIn(List<String> values) {
            addCriterion("begin_ticket_num in", values, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotIn(List<String> values) {
            addCriterion("begin_ticket_num not in", values, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumBetween(String value1, String value2) {
            addCriterion("begin_ticket_num between", value1, value2, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andBeginTicketNumNotBetween(String value1, String value2) {
            addCriterion("begin_ticket_num not between", value1, value2, "beginTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumIsNull() {
            addCriterion("end_ticket_num is null");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumIsNotNull() {
            addCriterion("end_ticket_num is not null");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumEqualTo(String value) {
            addCriterion("end_ticket_num =", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotEqualTo(String value) {
            addCriterion("end_ticket_num <>", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumGreaterThan(String value) {
            addCriterion("end_ticket_num >", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumGreaterThanOrEqualTo(String value) {
            addCriterion("end_ticket_num >=", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumLessThan(String value) {
            addCriterion("end_ticket_num <", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumLessThanOrEqualTo(String value) {
            addCriterion("end_ticket_num <=", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumLike(String value) {
            addCriterion("end_ticket_num like", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotLike(String value) {
            addCriterion("end_ticket_num not like", value, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumIn(List<String> values) {
            addCriterion("end_ticket_num in", values, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotIn(List<String> values) {
            addCriterion("end_ticket_num not in", values, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumBetween(String value1, String value2) {
            addCriterion("end_ticket_num between", value1, value2, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andEndTicketNumNotBetween(String value1, String value2) {
            addCriterion("end_ticket_num not between", value1, value2, "endTicketNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNull() {
            addCriterion("total_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalNumIsNotNull() {
            addCriterion("total_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNumEqualTo(Integer value) {
            addCriterion("total_num =", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotEqualTo(Integer value) {
            addCriterion("total_num <>", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThan(Integer value) {
            addCriterion("total_num >", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_num >=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThan(Integer value) {
            addCriterion("total_num <", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_num <=", value, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumIn(List<Integer> values) {
            addCriterion("total_num in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotIn(List<Integer> values) {
            addCriterion("total_num not in", values, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumBetween(Integer value1, Integer value2) {
            addCriterion("total_num between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_num not between", value1, value2, "totalNum");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameIsNull() {
            addCriterion("store_account_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameIsNotNull() {
            addCriterion("store_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameEqualTo(String value) {
            addCriterion("store_account_name =", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotEqualTo(String value) {
            addCriterion("store_account_name <>", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameGreaterThan(String value) {
            addCriterion("store_account_name >", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_account_name >=", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameLessThan(String value) {
            addCriterion("store_account_name <", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameLessThanOrEqualTo(String value) {
            addCriterion("store_account_name <=", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameLike(String value) {
            addCriterion("store_account_name like", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotLike(String value) {
            addCriterion("store_account_name not like", value, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameIn(List<String> values) {
            addCriterion("store_account_name in", values, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotIn(List<String> values) {
            addCriterion("store_account_name not in", values, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameBetween(String value1, String value2) {
            addCriterion("store_account_name between", value1, value2, "storeAccountName");
            return (Criteria) this;
        }

        public Criteria andStoreAccountNameNotBetween(String value1, String value2) {
            addCriterion("store_account_name not between", value1, value2, "storeAccountName");
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

        public Criteria andOutAccountIdIsNull() {
            addCriterion("out_account_id is null");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdIsNotNull() {
            addCriterion("out_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdEqualTo(Integer value) {
            addCriterion("out_account_id =", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdNotEqualTo(Integer value) {
            addCriterion("out_account_id <>", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdGreaterThan(Integer value) {
            addCriterion("out_account_id >", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_account_id >=", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdLessThan(Integer value) {
            addCriterion("out_account_id <", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("out_account_id <=", value, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdIn(List<Integer> values) {
            addCriterion("out_account_id in", values, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdNotIn(List<Integer> values) {
            addCriterion("out_account_id not in", values, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("out_account_id between", value1, value2, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andOutAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("out_account_id not between", value1, value2, "outAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdIsNull() {
            addCriterion("finance_account_id is null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdIsNotNull() {
            addCriterion("finance_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdEqualTo(Integer value) {
            addCriterion("finance_account_id =", value, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdNotEqualTo(Integer value) {
            addCriterion("finance_account_id <>", value, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdGreaterThan(Integer value) {
            addCriterion("finance_account_id >", value, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("finance_account_id >=", value, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdLessThan(Integer value) {
            addCriterion("finance_account_id <", value, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("finance_account_id <=", value, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdIn(List<Integer> values) {
            addCriterion("finance_account_id in", values, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdNotIn(List<Integer> values) {
            addCriterion("finance_account_id not in", values, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("finance_account_id between", value1, value2, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andFinanceAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("finance_account_id not between", value1, value2, "financeAccountId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
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