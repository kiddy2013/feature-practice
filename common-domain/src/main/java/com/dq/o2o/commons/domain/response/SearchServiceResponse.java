//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.response;

import com.jd.o2o.commons.domain.enums.ErrorCodeEnum;
import java.util.List;

/** @deprecated */
public class SearchServiceResponse<T> extends ServiceResponse<List<T>> {
    public SearchServiceResponse() {
    }

    public SearchServiceResponse(String code, String msg) {
        super(code, msg);
    }

    public SearchServiceResponse(String code, String msg, String detail) {
        super(code, msg, detail);
    }

    public SearchServiceResponse(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }

    public SearchServiceResponse(ErrorCodeEnum errorCodeEnum, String detail) {
        super(errorCodeEnum, detail);
    }

    public SearchServiceResponse(List<T> result) {
        this.setResult(result);
    }

    public SearchServiceResponse(String code, String msg, List<T> result) {
        super(code, msg);
        this.setResult(result);
    }

    public SearchServiceResponse(ErrorCodeEnum errorCodeEnum, List<T> result) {
        super(errorCodeEnum);
        this.setResult(result);
    }
}
