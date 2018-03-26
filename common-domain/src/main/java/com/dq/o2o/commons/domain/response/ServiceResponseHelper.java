//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.response;

import com.jd.o2o.commons.domain.exception.O2OException;

public class ServiceResponseHelper {
    public ServiceResponseHelper() {
    }

    public static void validServiceResponse(ServiceResponse serviceResponse) throws O2OException {
        if (serviceResponse == null) {
            throw new RuntimeException("服务响应信息不能为空！");
        } else if (!BaseResponseCode.SUCCESS.getCode().equals(serviceResponse.getCode()) && !BaseResponseCode.WARNING.getCode().equals(serviceResponse.getCode())) {
            throw (new O2OException(serviceResponse.getCode(), serviceResponse.getMsg())).addDetail(new String[]{serviceResponse.getDetail()});
        }
    }

    public static ServiceResponse convertO2OException2ServiceResponse(O2OException e) {
        if (e == null) {
            throw new RuntimeException("异常信息不能为空！");
        } else {
            return (new ServiceResponse(e.getCode(), e.getMessage())).addDetail(e.getDetail());
        }
    }
}
