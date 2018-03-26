//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.response;

import com.jd.o2o.commons.domain.enums.ErrorCodeEnum;

/** @deprecated */
@Deprecated
public class EntityServiceResponse<T> extends ServiceResponse<T> {
    public EntityServiceResponse() {
    }

    public EntityServiceResponse(T result) {
        this.setResult(result);
    }

    public EntityServiceResponse(String code, String msg) {
        super(code, msg);
    }

    public EntityServiceResponse(String code, String msg, String detail) {
        super(code, msg, detail);
    }

    public EntityServiceResponse(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }

    public EntityServiceResponse(ErrorCodeEnum errorCodeEnum, String detail) {
        super(errorCodeEnum, detail);
        this.setDetail(detail);
    }

    public EntityServiceResponse(String code, String msg, T result) {
        super(code, msg);
        this.setResult(result);
    }

    public EntityServiceResponse(ErrorCodeEnum errorCodeEnum, T result) {
        super(errorCodeEnum);
        this.setResult(result);
    }
}
