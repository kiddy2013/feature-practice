//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.constants;

import com.dq.o2o.commons.domain.enums.ErrorCodeEnum;

/** @deprecated */
@Deprecated
public enum ServiceResponseCode implements ErrorCodeEnum {
    SYSTEM_ERROR("-3", "系统错误"),
    WARNING("-2", "警告"),
    FAILURE("-1", "失败"),
    SUCCESS("0", "成功"),
    PARAM_ERROR("1", "参数错误"),
    NO_SUCH_METHOD("2", "方法不存在"),
    USER_NOT_LOGIN("3", "用户未登录"),
    RECORD_NOT_EXISTS("4", "%s不存在"),
    RECORD_UNAVAILABLE("5", "%s不可用"),
    DUPLICATE_RECORD("6", "重复记录"),
    REFERENCED_RECORD("7", "记录被引用"),
    BUSINESS_ILLEGAL_OP("9", "非法的操作"),
    REPEAT_SUBMIT("10", "重复提交"),
    NO_PERMISSION("11", "无此操作权限"),
    IP_CHANGED("12", "IP已变更"),
    SESSION_EXPIRED("13", "session失效");

    private String code;
    private String msg;

    private ServiceResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
