//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchServiceResponse<T extends ServiceResponse> extends ServiceResponse<List<T>> {
    public BatchServiceResponse() {
        super(BaseResponseCode.SUCCESS);
    }

    public BatchServiceResponse(ResponseCode responseCode) {
        super(responseCode);
    }

    public BatchServiceResponse(ResponseCode responseCode, String detail) {
        super(responseCode, detail);
    }

    public BatchServiceResponse(String code, String msg, String detail) {
        super(code, msg, detail);
    }

    public List<T> getResponses() {
        return (List)this.getResult();
    }

    public void setResponses(List<T> responses) {
        this.setResult(responses);
    }

    public int getSuccess() {
        return this.calculateCount(true);
    }

    public int getFailure() {
        return this.calculateCount(false);
    }

    private int calculateCount(boolean success) {
        if (this.getResponses() != null && this.getResponses().size() != 0) {
            int count = 0;
            Iterator i$ = this.getResponses().iterator();

            while(true) {
                ServiceResponse response;
                do {
                    if (!i$.hasNext()) {
                        return count;
                    }

                    response = (ServiceResponse)i$.next();
                } while((!success || !response.getCode().equals(BaseResponseCode.SUCCESS.getCode())) && (success || response.getCode().equals(BaseResponseCode.SUCCESS.getCode())));

                ++count;
            }
        } else {
            return 0;
        }
    }

    private int getCount() {
        return this.getResponses() == null ? 0 : this.getResponses().size();
    }

    public String getCode() {
        if (this.getResponses() != null && this.getResponses().size() != 0) {
            if (this.getSuccess() == this.getResponses().size()) {
                return BaseResponseCode.SUCCESS.getCode();
            } else {
                return this.getFailure() == this.getResponses().size() ? BaseResponseCode.FAILURE.getCode() : BaseResponseCode.WARNING.getCode();
            }
        } else {
            return super.getCode();
        }
    }

    public String getMsg() {
        if (super.getMsg() == null) {
            return String.format("本次共处理%s条数据，其中成功数为%s，失败数为%s。", this.getCount(), this.getSuccess(), this.getFailure());
        } else if (BaseResponseCode.SUCCESS.getMsg().equals(super.getMsg()) && !BaseResponseCode.SUCCESS.getCode().equals(this.getCode())) {
            return BaseResponseCode.FAILURE.getCode().equals(this.getCode()) ? BaseResponseCode.FAILURE.getMsg() : BaseResponseCode.WARNING.getMsg();
        } else {
            return super.getMsg();
        }
    }

    public BatchServiceResponse<T> addResponse(T response) {
        if (this.getResult() == null) {
            this.setResult(new ArrayList());
        }

        this.getResponses().add(response);
        return this;
    }
}
