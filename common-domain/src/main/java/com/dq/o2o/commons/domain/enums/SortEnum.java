//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.enums;

public enum SortEnum {
    DESC(Integer.valueOf(1), "desc", "降序"),
    ASC(Integer.valueOf(2), "asc", "升序");

    private Integer code;
    private String name;
    private String desc;

    private SortEnum(Integer code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }
}
