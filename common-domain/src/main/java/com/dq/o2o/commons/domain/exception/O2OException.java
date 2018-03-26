//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.exception;

import com.dq.o2o.commons.domain.enums.ErrorCodeEnum;
import com.dq.o2o.commons.domain.response.ResponseCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class O2OException extends RuntimeException {
    private String code;
    private List<String> detail;

    public O2OException() {
    }

    public O2OException(String message) {
        super(message);
    }

    public O2OException(String code, String message) {
        super(message);
        this.code = code;
    }

    public O2OException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public O2OException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public O2OException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
    }

    /**
     * @deprecated
     */
    @Deprecated
    public O2OException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getMsg(), cause);
        this.code = errorCodeEnum.getCode();
    }

    public O2OException(ResponseCode responseCode) {
        super(responseCode.getMsg());
        this.code = responseCode.getCode();
    }

    public O2OException(ResponseCode responseCode, Throwable cause) {
        super(responseCode.getMsg(), cause);
        this.code = responseCode.getCode();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return this.joinDetail();
    }

    public List<String> getDetailList() {
        return this.detail;
    }

    private void preAddDetail() {
        if (this.detail == null) {
            this.detail = new ArrayList();
        }

    }

    public void setDetail(String... detail) {
        if (detail == null) {
            this.detail = new ArrayList();
        } else {
            this.detail = Arrays.asList(detail);
        }
    }

    public void setDetail(List<String> detail) {
        this.detail = detail;
    }

    public O2OException addDetail(List<String> detail) {
        if (detail == null) {
            return this;
        } else {
            this.preAddDetail();
            this.detail.addAll(detail);
            return this;
        }
    }

    public O2OException addDetail(String... detail) {
        if (detail == null) {
            return this;
        } else {
            this.preAddDetail();
            this.detail.addAll(Arrays.asList(detail));
            return this;
        }
    }

    private String joinDetail() {
        if (this.detail != null && this.detail.size() != 0) {
            if (this.detail.size() == 1) {
                return (String)this.detail.get(0);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                Iterator i$ = this.detail.iterator();

                while (i$.hasNext()) {
                    String item = (String)i$.next();
                    stringBuilder.append("，").append(item);
                }

                return stringBuilder.substring(1);
            }
        } else {
            return null;
        }
    }

    public String toString() {
        return "code:" + this.code + ", msg:" + this.getMessage() + ",detail:[" + this.joinDetail() + "]";
    }
}
