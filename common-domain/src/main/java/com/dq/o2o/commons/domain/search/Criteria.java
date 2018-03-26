//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.search;

import java.util.HashMap;
import java.util.Map;

/** @deprecated */
@Deprecated
public class Criteria {
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
}
