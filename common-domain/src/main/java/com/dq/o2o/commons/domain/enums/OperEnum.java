//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum OperEnum {
    ADD(1, "新增"),
    EDIT(2, "修改"),
    FIND(3, "查询"),
    DELETE(4, "删除");

    private int code;
    private String name;
    private static final Map<Integer, OperEnum> map = new HashMap();

    private OperEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static OperEnum idOf(int code) {
        return (OperEnum)map.get(code);
    }

    public String toString() {
        return this.getCode() + ":" + this.getName();
    }

    static {
        OperEnum[] arr$ = values();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            OperEnum t = arr$[i$];
            map.put(t.getCode(), t);
        }

    }
}
