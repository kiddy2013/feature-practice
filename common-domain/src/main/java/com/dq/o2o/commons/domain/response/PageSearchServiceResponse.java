//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.response;

import com.jd.o2o.commons.domain.enums.ErrorCodeEnum;
import java.util.Collection;

public class PageSearchServiceResponse<T> extends ServiceResponse<Collection<T>> {
    private long page;
    private long count;

    public PageSearchServiceResponse() {
    }

    public PageSearchServiceResponse(String code, String msg) {
        super(code, msg);
    }

    public PageSearchServiceResponse(String code, String msg, String detail) {
        super(code, msg, detail);
    }

    public PageSearchServiceResponse(ResponseCode responseCode) {
        super(responseCode);
    }

    public PageSearchServiceResponse(long page, long count, Collection<T> result) {
        this.setResult(result);
        this.page = page;
        this.count = count;
    }

    public PageSearchServiceResponse(String code, String msg, Collection<T> result, long page, long count) {
        super(code, msg);
        this.setResult(result);
        this.page = page;
        this.count = count;
    }

    public PageSearchServiceResponse(ResponseCode responseCode, Collection<T> result, long page, long count) {
        super(responseCode);
        this.setResult(result);
        this.page = page;
        this.count = count;
    }

    /** @deprecated */
    @Deprecated
    public PageSearchServiceResponse(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }

    /** @deprecated */
    @Deprecated
    public PageSearchServiceResponse(ErrorCodeEnum errorCodeEnum, Collection<T> result, long page, long count) {
        super(errorCodeEnum);
        this.setResult(result);
        this.page = page;
        this.count = count;
    }

    public long getPage() {
        return this.page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
