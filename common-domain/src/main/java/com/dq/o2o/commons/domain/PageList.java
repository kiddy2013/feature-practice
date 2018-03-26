//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain;

import java.util.ArrayList;
import java.util.List;

/** @deprecated */
@Deprecated
public class PageList<T> extends ArrayList implements List {
    private Integer totalCount;

    public PageList() {
    }

    public PageList(int totalCount, List<T> list) {
        this.totalCount = totalCount;
        this.addAll(list);
    }

    public Integer getTotalCount() {
        return this.totalCount == null ? this.size() : this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
