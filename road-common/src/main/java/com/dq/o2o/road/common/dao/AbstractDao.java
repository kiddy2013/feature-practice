
package com.dq.o2o.road.common.dao;

import com.dq.o2o.commons.domain.PageBean;
import com.dq.o2o.commons.domain.criteria.Criteria;
import com.dq.o2o.road.common.utils.BeanHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.Assert;

public abstract class AbstractDao<M extends Criteria, PK> extends SqlSessionDaoSupport implements BaseDao<M, PK> {
    public static final String UNSUPPORT_TIPS = "The method does not support this operation";
    private final String nameSpace;

    public AbstractDao() {
        TableDes myTable = (TableDes)this.getClass().getAnnotation(TableDes.class);
        Assert.notNull(myTable);
        String nameSpaceTmp = myTable.nameSpace();
        this.nameSpace = StringUtils.isEmpty(nameSpaceTmp) ? "" : nameSpaceTmp + ".";
    }

    public int save(M modelEntity) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int saveAll(List<M> entityList) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int update(M modelEntry, M modelQuery) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int updateAll(List<M> entityList) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int update(M modelEntry) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int saveOrUpdate(M modelEntry) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int saveOrUpdate(List<M> entryList) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int delete(PK id) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int delete(M modelQuery) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public M get(PK id) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public int count(M modelQuery) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public List<M> findList(M modelQuery) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public List<M> findList(M modelQuery, int pn, int pageSize) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public PageBean<M> pageQuery(M modelQuery, PageBean<M> pageBean) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public M findOne(M modelQuery) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    public boolean exists(PK id) {
        throw new UnsupportedOperationException("The method does not support this operation");
    }

    protected int save(String statement, M modelEntity) {
        return this.getSqlSession().insert(this.addNameSpace(statement), modelEntity);
    }

    protected int saveOrUpdate(String insertStatement, String updateStatement, M modelEntry) {
        return this.getPrimaryFieldValue(modelEntry) == null ? this.save(insertStatement, modelEntry) : this.update(
            updateStatement, modelEntry);
    }

    protected int saveOrUpdate(String insertStatement, String updateStatement, List<M> entityList) {
        int effectCount = 0;
        if (CollectionUtils.isEmpty(entityList)) {
            return effectCount;
        } else {
            List<M> addList = new ArrayList();
            List<M> updateList = new ArrayList();
            Iterator var7 = entityList.iterator();

            while (var7.hasNext()) {
                M modelEntry = (Criteria)var7.next();
                if (this.getPrimaryFieldValue(modelEntry) == null) {
                    addList.add(modelEntry);
                } else {
                    updateList.add(modelEntry);
                }
            }

            if (CollectionUtils.isNotEmpty(addList)) {
                effectCount += this.saveAll(insertStatement, addList);
            }

            if (CollectionUtils.isNotEmpty(updateList)) {
                effectCount += this.updateAll(updateStatement, updateList);
            }

            return effectCount;
        }
    }

    protected int count(String statement, Criteria criteria) {
        Integer result = (Integer)this.getSqlSession().selectOne(this.addNameSpace(statement), criteria);
        return result == null ? 0 : result.intValue();
    }

    protected int update(String statement, M modelEntry, M modelQuery) {
        Map<String, Object> map = BeanHelper.modelToMap(modelEntry, "", "");
        map.putAll(BeanHelper.modelToMap(modelQuery, "_", ""));
        return this.getSqlSession().update(this.addNameSpace(statement), map);
    }

    protected int updateAll(String statement, List<M> entityList) {
        return this.getSqlSession().update(this.addNameSpace(statement), entityList);
    }

    protected int update(String statement, M modelEntry) {
        Map<String, Object> map = BeanHelper.modelToMap(modelEntry, "", "");
        return this.getSqlSession().update(this.addNameSpace(statement), map);
    }

    protected M get(String statement, PK id) {
        return (Criteria)this.getSqlSession().selectOne(this.addNameSpace(statement), id);
    }

    protected List<M> findList(String statement, Criteria criteria) {
        return this.getSqlSession().selectList(this.addNameSpace(statement), criteria);
    }

    protected <T> List<T> findList(String statement, Map<String, Object> modelQuery) {
        return this.getSqlSession().selectList(this.addNameSpace(statement), modelQuery);
    }

    protected List<M> findList(String statement, Criteria criteria, int pn, int pageSize) {
        return this.findList(statement, this.buildCriteria(criteria, pn, pageSize));
    }

    protected <T> List<T> findList(String statement, Object entity) {
        return this.getSqlSession().selectList(this.addNameSpace(statement), entity);
    }

    protected boolean exists(String statement, PK id) {
        return (this.get(statement, id) == null ? Boolean.FALSE : Boolean.TRUE).booleanValue();
    }

    protected int saveAll(String statement, List<M> list) {
        return this.getSqlSession().insert(this.addNameSpace(statement), list);
    }

    protected int delete(String statement, Object modelQuery) {
        return this.getSqlSession().delete(this.addNameSpace(statement), modelQuery);
    }

    protected <T> T findOne(String statement, T modelQuery) {
        return this.getSqlSession().selectOne(this.addNameSpace(statement), modelQuery);
    }

    protected <T> PageBean<T> pageQuery(String queryCountSql, String queryListSql, Criteria modelQuery,
                                        PageBean<T> pageBean) {
        Assert.notNull(pageBean, "分页条件不能为空.");
        pageBean.setTotalCount((long)this.count(queryCountSql, modelQuery));
        pageBean.setResultList(this.findList(queryListSql,
            this.buildCriteria(modelQuery, (int)pageBean.getPageNo(), pageBean.getPageSize())));
        return pageBean;
    }

    private String addNameSpace(String statement) {
        return this.nameSpace + statement;
    }

    private Criteria buildCriteria(Criteria criteria, int pn, int pageSize) {
        Assert.notNull(criteria, "查询条件不能为空.");
        int skipResults = pn > 1 ? (pn - 1) * pageSize : 0;
        int maxResults = pageSize > 0 ? pageSize : 10;
        criteria.addExtField("start", skipResults);
        criteria.addExtField("limit", maxResults);
        return criteria;
    }

    private Object getPrimaryFieldValue(M modelEntry) {
        Class clazz = modelEntry.getClass();
        Field field = this.findPrimaryField(clazz);
        if (field == null) {
            throw new RuntimeException("方法不支持该实体对象的[保存或更新]操作");
        } else {
            field.setAccessible(true);

            try {
                Object id = field.get(modelEntry);
                return id;
            } catch (IllegalAccessException var6) {
                throw new RuntimeException(var6);
            }
        }
    }

    private Field findPrimaryField(Class clazz) {
        while (clazz != Object.class) {
            Field[] fs = clazz.getDeclaredFields();
            Field[] var3 = fs;
            int var4 = fs.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                Field field = var3[var5];
                if ("ID".equals(field.getName().toUpperCase())) {
                    return field;
                }
            }

            clazz = clazz.getSuperclass();
        }

        return null;
    }
}
