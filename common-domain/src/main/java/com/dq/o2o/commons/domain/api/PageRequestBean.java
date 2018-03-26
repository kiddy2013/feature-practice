package com.dq.o2o.commons.domain.api;

public class PageRequestBean extends RequestBean {
    private static final long serialVersionUID = -1231524027443366825L;
    private long pageNo = 1L;
    private int pageSize = 20;

    public PageRequestBean() {
    }

    public long getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
