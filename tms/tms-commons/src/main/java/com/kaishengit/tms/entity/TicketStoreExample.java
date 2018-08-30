package com.kaishengit.tms.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketStoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TicketStoreExample() {
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

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIsNull() {
            addCriterion("store_manager is null");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIsNotNull() {
            addCriterion("store_manager is not null");
            return (Criteria) this;
        }

        public Criteria andStoreManagerEqualTo(String value) {
            addCriterion("store_manager =", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerNotEqualTo(String value) {
            addCriterion("store_manager <>", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerGreaterThan(String value) {
            addCriterion("store_manager >", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerGreaterThanOrEqualTo(String value) {
            addCriterion("store_manager >=", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerLessThan(String value) {
            addCriterion("store_manager <", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerLessThanOrEqualTo(String value) {
            addCriterion("store_manager <=", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerLike(String value) {
            addCriterion("store_manager like", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerNotLike(String value) {
            addCriterion("store_manager not like", value, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerIn(List<String> values) {
            addCriterion("store_manager in", values, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerNotIn(List<String> values) {
            addCriterion("store_manager not in", values, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerBetween(String value1, String value2) {
            addCriterion("store_manager between", value1, value2, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreManagerNotBetween(String value1, String value2) {
            addCriterion("store_manager not between", value1, value2, "storeManager");
            return (Criteria) this;
        }

        public Criteria andStoreTelIsNull() {
            addCriterion("store_tel is null");
            return (Criteria) this;
        }

        public Criteria andStoreTelIsNotNull() {
            addCriterion("store_tel is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTelEqualTo(String value) {
            addCriterion("store_tel =", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotEqualTo(String value) {
            addCriterion("store_tel <>", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelGreaterThan(String value) {
            addCriterion("store_tel >", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelGreaterThanOrEqualTo(String value) {
            addCriterion("store_tel >=", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLessThan(String value) {
            addCriterion("store_tel <", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLessThanOrEqualTo(String value) {
            addCriterion("store_tel <=", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelLike(String value) {
            addCriterion("store_tel like", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotLike(String value) {
            addCriterion("store_tel not like", value, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelIn(List<String> values) {
            addCriterion("store_tel in", values, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotIn(List<String> values) {
            addCriterion("store_tel not in", values, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelBetween(String value1, String value2) {
            addCriterion("store_tel between", value1, value2, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreTelNotBetween(String value1, String value2) {
            addCriterion("store_tel not between", value1, value2, "storeTel");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeIsNull() {
            addCriterion("store_geo_longitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeIsNotNull() {
            addCriterion("store_geo_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeEqualTo(String value) {
            addCriterion("store_geo_longitude =", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeNotEqualTo(String value) {
            addCriterion("store_geo_longitude <>", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeGreaterThan(String value) {
            addCriterion("store_geo_longitude >", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("store_geo_longitude >=", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeLessThan(String value) {
            addCriterion("store_geo_longitude <", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeLessThanOrEqualTo(String value) {
            addCriterion("store_geo_longitude <=", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeLike(String value) {
            addCriterion("store_geo_longitude like", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeNotLike(String value) {
            addCriterion("store_geo_longitude not like", value, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeIn(List<String> values) {
            addCriterion("store_geo_longitude in", values, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeNotIn(List<String> values) {
            addCriterion("store_geo_longitude not in", values, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeBetween(String value1, String value2) {
            addCriterion("store_geo_longitude between", value1, value2, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLongitudeNotBetween(String value1, String value2) {
            addCriterion("store_geo_longitude not between", value1, value2, "storeGeoLongitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeIsNull() {
            addCriterion("store_geo_latitude is null");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeIsNotNull() {
            addCriterion("store_geo_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeEqualTo(String value) {
            addCriterion("store_geo_latitude =", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeNotEqualTo(String value) {
            addCriterion("store_geo_latitude <>", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeGreaterThan(String value) {
            addCriterion("store_geo_latitude >", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("store_geo_latitude >=", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeLessThan(String value) {
            addCriterion("store_geo_latitude <", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeLessThanOrEqualTo(String value) {
            addCriterion("store_geo_latitude <=", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeLike(String value) {
            addCriterion("store_geo_latitude like", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeNotLike(String value) {
            addCriterion("store_geo_latitude not like", value, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeIn(List<String> values) {
            addCriterion("store_geo_latitude in", values, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeNotIn(List<String> values) {
            addCriterion("store_geo_latitude not in", values, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeBetween(String value1, String value2) {
            addCriterion("store_geo_latitude between", value1, value2, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreGeoLatitudeNotBetween(String value1, String value2) {
            addCriterion("store_geo_latitude not between", value1, value2, "storeGeoLatitude");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentIsNull() {
            addCriterion("store_attachment is null");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentIsNotNull() {
            addCriterion("store_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentEqualTo(String value) {
            addCriterion("store_attachment =", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentNotEqualTo(String value) {
            addCriterion("store_attachment <>", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentGreaterThan(String value) {
            addCriterion("store_attachment >", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("store_attachment >=", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentLessThan(String value) {
            addCriterion("store_attachment <", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentLessThanOrEqualTo(String value) {
            addCriterion("store_attachment <=", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentLike(String value) {
            addCriterion("store_attachment like", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentNotLike(String value) {
            addCriterion("store_attachment not like", value, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentIn(List<String> values) {
            addCriterion("store_attachment in", values, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentNotIn(List<String> values) {
            addCriterion("store_attachment not in", values, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentBetween(String value1, String value2) {
            addCriterion("store_attachment between", value1, value2, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreAttachmentNotBetween(String value1, String value2) {
            addCriterion("store_attachment not between", value1, value2, "storeAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentIsNull() {
            addCriterion("store_manager_attachment is null");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentIsNotNull() {
            addCriterion("store_manager_attachment is not null");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentEqualTo(String value) {
            addCriterion("store_manager_attachment =", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentNotEqualTo(String value) {
            addCriterion("store_manager_attachment <>", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentGreaterThan(String value) {
            addCriterion("store_manager_attachment >", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("store_manager_attachment >=", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentLessThan(String value) {
            addCriterion("store_manager_attachment <", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentLessThanOrEqualTo(String value) {
            addCriterion("store_manager_attachment <=", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentLike(String value) {
            addCriterion("store_manager_attachment like", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentNotLike(String value) {
            addCriterion("store_manager_attachment not like", value, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentIn(List<String> values) {
            addCriterion("store_manager_attachment in", values, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentNotIn(List<String> values) {
            addCriterion("store_manager_attachment not in", values, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentBetween(String value1, String value2) {
            addCriterion("store_manager_attachment between", value1, value2, "storeManagerAttachment");
            return (Criteria) this;
        }

        public Criteria andStoreManagerAttachmentNotBetween(String value1, String value2) {
            addCriterion("store_manager_attachment not between", value1, value2, "storeManagerAttachment");
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