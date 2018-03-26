//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.response;

import com.jd.o2o.commons.domain.enums.ErrorCodeEnum;
import java.util.Map;

public class BaseMapResponse<K, V> extends ServiceResponse<Map<K, V>> {
    public BaseMapResponse() {
    }

    public BaseMapResponse(String code, String msg) {
        super(code, msg);
    }

    public BaseMapResponse(String code, String msg, String detail) {
        super(code, msg, detail);
    }

    public BaseMapResponse(ResponseCode responseCode) {
        super(responseCode);
    }

    public BaseMapResponse(ResponseCode responseCode, String detail) {
        super(responseCode);
        super.setDetail(detail);
    }

    public BaseMapResponse(ResponseCode responseCode, Map<K, V> result) {
        super(responseCode);
        this.setResult(result);
    }

    /** @deprecated */
    @Deprecated
    public BaseMapResponse(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum);
    }

    /** @deprecated */
    @Deprecated
    public BaseMapResponse(ErrorCodeEnum errorCodeEnum, String detail) {
        super(errorCodeEnum);
        super.setDetail(detail);
    }

    /** @deprecated */
    @Deprecated
    public BaseMapResponse(ErrorCodeEnum errorCodeEnum, Map<K, V> data) {
        super(errorCodeEnum);
        this.setResult(data);
    }

    /** @deprecated */
    @Deprecated
    public void setData(Map<K, V> data) {
        this.setResult(data);
    }

    /** @deprecated */
    @Deprecated
    public Map<K, V> getData() {
        return (Map)this.getResult();
    }
}
