//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dq.o2o.commons.domain;

import com.dq.o2o.commons.domain.search.SearchCriteria;

public class PageBeanHelper {
    public PageBeanHelper() {
    }

    public static <T> PageBean<T> buildPageBean(PageList<T> pageList, SearchCriteria criteria) {
        PageBean<T> pageBean = new PageBean((long)pageList.getTotalCount().intValue(), pageList);
        pageBean.setPage(criteria.getPageNo());
        pageBean.setPageSize(criteria.getPageSize());
        return pageBean;
    }
}
