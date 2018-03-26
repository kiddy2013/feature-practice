
package com.dq.o2o.commons.domain.criteria;

import com.dq.o2o.commons.domain.BaseBean;
import com.dq.o2o.commons.domain.enums.SortEnum;
import java.util.List;
import java.util.Vector;

public class SortCriteria extends BaseBean {
    private final Vector<SortCriteria.SortBean> sortBeanList = new Vector();

    public SortCriteria() {
    }

    public SortCriteria buildSortCriteria(SortCriteria.SortBean sortBean) {
        this.sortBeanList.add(sortBean);
        return this;
    }

    public SortCriteria buildSortCriteria(String name, SortEnum sortEnum) {
        this.sortBeanList.add(new SortCriteria.SortBean(name, sortEnum == null ? SortEnum.ASC : sortEnum));
        return this;
    }

    public SortCriteria clearSortCriteria() {
        this.sortBeanList.clear();
        return this;
    }

    public List<SortCriteria.SortBean> getSortBeanList() {
        return this.sortBeanList;
    }

    public static class SortBean extends BaseBean {
        private String name;
        private SortEnum sortEnum;

        public SortBean() {
        }

        public SortBean(String name, SortEnum sortEnum) {
            this.name = name;
            this.sortEnum = sortEnum;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public SortEnum getSortEnum() {
            return this.sortEnum;
        }

        public void setSortEnum(SortEnum sortEnum) {
            this.sortEnum = sortEnum;
        }
    }
}
