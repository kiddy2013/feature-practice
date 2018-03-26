package com.dq.o2o.commons.domain.criteria;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Criteria implements Serializable {
    public static final String SORT_DIRECTION_ASC = "ASC";
    public static final String SORT_DIRECTION_DESC = "DESC";
    private LinkedHashMap<String, String> sortItemMap;
    private Map<String, Object> extFields;

    public Criteria() {
    }

    public Criteria addExtField(String fieldName, Object filedValue) {
        if (this.extFields == null) {
            this.extFields = new HashMap();
        }

        this.extFields.put(fieldName, filedValue);
        return this;
    }

    public Map<String, Object> getExtFields() {
        return this.extFields;
    }

    public void setExtFields(Map<String, Object> extFields) {
        this.extFields = extFields;
    }

    public LinkedHashMap<String, String> getSortItemMap() {
        return this.sortItemMap;
    }

    public void setSortItemMap(LinkedHashMap<String, String> sortItemMap) {
        this.sortItemMap = sortItemMap;
    }
}
