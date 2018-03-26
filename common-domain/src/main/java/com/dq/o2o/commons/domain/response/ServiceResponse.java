//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.response;

import com.jd.o2o.commons.domain.enums.ErrorCodeEnum;
import java.io.Serializable;

public class ServiceResponse<T> implements Serializable {
    private static final long serialVersionUID = 2488663702267110932L;
    private String code;
    private String msg;
    private String detail;
    private T result;

    public static ServiceResponse successResponse() {
        return new ServiceResponse(BaseResponseCode.SUCCESS);
    }

    public static ServiceResponse failureResponse() {
        return new ServiceResponse(BaseResponseCode.FAILURE);
    }

    public ServiceResponse() {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
    }

    public ServiceResponse(T result) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.result = result;
    }

    public ServiceResponse(String code, String msg) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = code;
        this.msg = msg;
    }

    public ServiceResponse(String code, String msg, String detail) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = code;
        this.msg = msg;
        this.detail = detail;
    }

    public ServiceResponse(ResponseCode ResponseCode) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = ResponseCode.getCode();
        this.msg = ResponseCode.getMsg();
    }

    public ServiceResponse(ResponseCode ResponseCode, String detail) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = ResponseCode.getCode();
        this.msg = ResponseCode.getMsg();
        this.detail = detail;
    }

    public void setResponseCode(ResponseCode ResponseCode) {
        this.code = ResponseCode.getCode();
        this.msg = ResponseCode.getMsg();
    }

    /** @deprecated */
    @Deprecated
    public ServiceResponse(ErrorCodeEnum errorCodeEnum) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
    }

    /** @deprecated */
    @Deprecated
    public ServiceResponse(ErrorCodeEnum errorCodeEnum, String detail) {
        this.code = BaseResponseCode.SUCCESS.getCode();
        this.msg = BaseResponseCode.SUCCESS.getMsg();
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
        this.detail = detail;
    }

    /** @deprecated */
    @Deprecated
    public void setErrorCodeEnum(ErrorCodeEnum errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.msg = errorCodeEnum.getMsg();
    }

    public boolean isSuccess() {
        return BaseResponseCode.SUCCESS.getCode().equals(this.code);
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

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return this.detail;
    }

    public <T extends ServiceResponse> T addDetail(String detail) {
        this.setDetail(detail);
        return this;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
