//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** @deprecated */
@Deprecated
public class BaseEntity implements Serializable {
    private Date createTime;
    private String createPin;
    private Date updateTime;
    private String updatePin;
    private Integer sysVersion;
    private HashMap<String, Object> extFields;

    public BaseEntity() {
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePin() {
        return this.createPin;
    }

    public void setCreatePin(String createPin) {
        this.createPin = createPin == null ? null : createPin.trim();
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatePin() {
        return this.updatePin;
    }

    public void setUpdatePin(String updatePin) {
        this.updatePin = updatePin == null ? null : updatePin.trim();
    }

    public Integer getSysVersion() {
        return this.sysVersion;
    }

    public void setSysVersion(Integer sysVersion) {
        this.sysVersion = sysVersion;
    }

    public void addExtField(String fieldName, Object fieldValue) {
        if (this.extFields == null) {
            this.extFields = new HashMap();
        }

        this.extFields.put(fieldName, fieldValue);
    }

    public Map<String, Object> getExtFields() {
        return this.extFields;
    }

    public void setExtFields(HashMap<String, Object> extFields) {
        this.extFields = extFields;
    }

    public Object getExtFieldValue(String fieldName) {
        return this.extFields != null && this.extFields.size() != 0 ? this.extFields.get(fieldName) : null;
    }
}
