package com.kaishengit.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardIsNull() {
            addCriterion("customer_id_card is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardIsNotNull() {
            addCriterion("customer_id_card is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardEqualTo(String value) {
            addCriterion("customer_id_card =", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotEqualTo(String value) {
            addCriterion("customer_id_card <>", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardGreaterThan(String value) {
            addCriterion("customer_id_card >", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id_card >=", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardLessThan(String value) {
            addCriterion("customer_id_card <", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardLessThanOrEqualTo(String value) {
            addCriterion("customer_id_card <=", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardLike(String value) {
            addCriterion("customer_id_card like", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotLike(String value) {
            addCriterion("customer_id_card not like", value, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardIn(List<String> values) {
            addCriterion("customer_id_card in", values, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotIn(List<String> values) {
            addCriterion("customer_id_card not in", values, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardBetween(String value1, String value2) {
            addCriterion("customer_id_card between", value1, value2, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardNotBetween(String value1, String value2) {
            addCriterion("customer_id_card not between", value1, value2, "customerIdCard");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoIsNull() {
            addCriterion("customer_id_card_photo is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoIsNotNull() {
            addCriterion("customer_id_card_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoEqualTo(String value) {
            addCriterion("customer_id_card_photo =", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoNotEqualTo(String value) {
            addCriterion("customer_id_card_photo <>", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoGreaterThan(String value) {
            addCriterion("customer_id_card_photo >", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id_card_photo >=", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoLessThan(String value) {
            addCriterion("customer_id_card_photo <", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoLessThanOrEqualTo(String value) {
            addCriterion("customer_id_card_photo <=", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoLike(String value) {
            addCriterion("customer_id_card_photo like", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoNotLike(String value) {
            addCriterion("customer_id_card_photo not like", value, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoIn(List<String> values) {
            addCriterion("customer_id_card_photo in", values, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoNotIn(List<String> values) {
            addCriterion("customer_id_card_photo not in", values, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBetween(String value1, String value2) {
            addCriterion("customer_id_card_photo between", value1, value2, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoNotBetween(String value1, String value2) {
            addCriterion("customer_id_card_photo not between", value1, value2, "customerIdCardPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackIsNull() {
            addCriterion("customer_id_card_photo_back is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackIsNotNull() {
            addCriterion("customer_id_card_photo_back is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackEqualTo(String value) {
            addCriterion("customer_id_card_photo_back =", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackNotEqualTo(String value) {
            addCriterion("customer_id_card_photo_back <>", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackGreaterThan(String value) {
            addCriterion("customer_id_card_photo_back >", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id_card_photo_back >=", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackLessThan(String value) {
            addCriterion("customer_id_card_photo_back <", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackLessThanOrEqualTo(String value) {
            addCriterion("customer_id_card_photo_back <=", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackLike(String value) {
            addCriterion("customer_id_card_photo_back like", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackNotLike(String value) {
            addCriterion("customer_id_card_photo_back not like", value, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackIn(List<String> values) {
            addCriterion("customer_id_card_photo_back in", values, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackNotIn(List<String> values) {
            addCriterion("customer_id_card_photo_back not in", values, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackBetween(String value1, String value2) {
            addCriterion("customer_id_card_photo_back between", value1, value2, "customerIdCardPhotoBack");
            return (Criteria) this;
        }

        public Criteria andCustomerIdCardPhotoBackNotBetween(String value1, String value2) {
            addCriterion("customer_id_card_photo_back not between", value1, value2, "customerIdCardPhotoBack");
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

        public Criteria andCustomerPhotoIsNull() {
            addCriterion("customer_photo is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoIsNotNull() {
            addCriterion("customer_photo is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoEqualTo(String value) {
            addCriterion("customer_photo =", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotEqualTo(String value) {
            addCriterion("customer_photo <>", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoGreaterThan(String value) {
            addCriterion("customer_photo >", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("customer_photo >=", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLessThan(String value) {
            addCriterion("customer_photo <", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLessThanOrEqualTo(String value) {
            addCriterion("customer_photo <=", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoLike(String value) {
            addCriterion("customer_photo like", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotLike(String value) {
            addCriterion("customer_photo not like", value, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoIn(List<String> values) {
            addCriterion("customer_photo in", values, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotIn(List<String> values) {
            addCriterion("customer_photo not in", values, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoBetween(String value1, String value2) {
            addCriterion("customer_photo between", value1, value2, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerPhotoNotBetween(String value1, String value2) {
            addCriterion("customer_photo not between", value1, value2, "customerPhoto");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIsNull() {
            addCriterion("customer_tel is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIsNotNull() {
            addCriterion("customer_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTelEqualTo(String value) {
            addCriterion("customer_tel =", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotEqualTo(String value) {
            addCriterion("customer_tel <>", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelGreaterThan(String value) {
            addCriterion("customer_tel >", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelGreaterThanOrEqualTo(String value) {
            addCriterion("customer_tel >=", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLessThan(String value) {
            addCriterion("customer_tel <", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLessThanOrEqualTo(String value) {
            addCriterion("customer_tel <=", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLike(String value) {
            addCriterion("customer_tel like", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotLike(String value) {
            addCriterion("customer_tel not like", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIn(List<String> values) {
            addCriterion("customer_tel in", values, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotIn(List<String> values) {
            addCriterion("customer_tel not in", values, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelBetween(String value1, String value2) {
            addCriterion("customer_tel between", value1, value2, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotBetween(String value1, String value2) {
            addCriterion("customer_tel not between", value1, value2, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNull() {
            addCriterion("customer_address is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIsNotNull() {
            addCriterion("customer_address is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressEqualTo(String value) {
            addCriterion("customer_address =", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotEqualTo(String value) {
            addCriterion("customer_address <>", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThan(String value) {
            addCriterion("customer_address >", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("customer_address >=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThan(String value) {
            addCriterion("customer_address <", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLessThanOrEqualTo(String value) {
            addCriterion("customer_address <=", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressLike(String value) {
            addCriterion("customer_address like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotLike(String value) {
            addCriterion("customer_address not like", value, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressIn(List<String> values) {
            addCriterion("customer_address in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotIn(List<String> values) {
            addCriterion("customer_address not in", values, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressBetween(String value1, String value2) {
            addCriterion("customer_address between", value1, value2, "customerAddress");
            return (Criteria) this;
        }

        public Criteria andCustomerAddressNotBetween(String value1, String value2) {
            addCriterion("customer_address not between", value1, value2, "customerAddress");
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

        public Criteria andCustomerAgeIsNull() {
            addCriterion("customer_age is null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIsNotNull() {
            addCriterion("customer_age is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeEqualTo(Integer value) {
            addCriterion("customer_age =", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotEqualTo(Integer value) {
            addCriterion("customer_age <>", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThan(Integer value) {
            addCriterion("customer_age >", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("customer_age >=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThan(Integer value) {
            addCriterion("customer_age <", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeLessThanOrEqualTo(Integer value) {
            addCriterion("customer_age <=", value, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeIn(List<Integer> values) {
            addCriterion("customer_age in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotIn(List<Integer> values) {
            addCriterion("customer_age not in", values, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeBetween(Integer value1, Integer value2) {
            addCriterion("customer_age between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("customer_age not between", value1, value2, "customerAge");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderIsNull() {
            addCriterion("customer_gender is null");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderIsNotNull() {
            addCriterion("customer_gender is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderEqualTo(String value) {
            addCriterion("customer_gender =", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderNotEqualTo(String value) {
            addCriterion("customer_gender <>", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderGreaterThan(String value) {
            addCriterion("customer_gender >", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderGreaterThanOrEqualTo(String value) {
            addCriterion("customer_gender >=", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderLessThan(String value) {
            addCriterion("customer_gender <", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderLessThanOrEqualTo(String value) {
            addCriterion("customer_gender <=", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderLike(String value) {
            addCriterion("customer_gender like", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderNotLike(String value) {
            addCriterion("customer_gender not like", value, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderIn(List<String> values) {
            addCriterion("customer_gender in", values, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderNotIn(List<String> values) {
            addCriterion("customer_gender not in", values, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderBetween(String value1, String value2) {
            addCriterion("customer_gender between", value1, value2, "customerGender");
            return (Criteria) this;
        }

        public Criteria andCustomerGenderNotBetween(String value1, String value2) {
            addCriterion("customer_gender not between", value1, value2, "customerGender");
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