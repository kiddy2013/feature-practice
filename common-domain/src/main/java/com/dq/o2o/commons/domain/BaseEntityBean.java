//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain;

import java.util.Date;

import com.dq.o2o.commons.domain.criteria.Criteria;
import com.dq.o2o.commons.domain.enums.YNEnum;

public class BaseEntityBean extends Criteria {
    private static final long serialVersionUID = -7793739903799136331L;
    private Integer sysVersion;
    private Date createTime;
    private Date updateTime;
    private String createPin;
    private String updatePin;
    private Integer yn;
    private Date ts;

    public BaseEntityBean() {
    }

    public Integer getSysVersion() {
        return this.sysVersion;
    }

    public void setSysVersion(Integer sysVersion) {
        this.sysVersion = sysVersion;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreatePin() {
        return this.createPin;
    }

    public void setCreatePin(String createPin) {
        this.createPin = createPin;
    }

    public String getUpdatePin() {
        return this.updatePin;
    }

    public void setUpdatePin(String updatePin) {
        this.updatePin = updatePin;
    }

    public Integer getYn() {
        return this.yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Date getTs() {
        return this.ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public BaseEntityBean init() {
        this.createPin = "";
        this.updatePin = "";
        this.yn = YNEnum.Y.getCode();
        return this;
    }
}
