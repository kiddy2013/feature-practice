
package com.dq.o2o.road.common.utils;

import com.dq.o2o.commons.domain.BaseBean;
import com.dq.o2o.commons.domain.criteria.SortCriteria;
import com.dq.o2o.commons.domain.criteria.SortCriteria.SortBean;
import com.dq.o2o.commons.domain.enums.SortEnum;
import com.dq.o2o.road.common.domain.BaseMsgException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

public class BeanHelper extends BeanUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanHelper.class);

    public BeanHelper() {
    }

    public static <T> Collection<T> copyTo(Collection<?> sourceList, Class<T> target) {
        List<T> list = new ArrayList();
        if (CollectionUtils.isEmpty(sourceList)) {
            return list;
        } else {
            try {
                Iterator var3 = sourceList.iterator();

                while (var3.hasNext()) {
                    Object o = var3.next();
                    list.add(copyTo(o, target));
                }

                return list;
            } catch (Exception var5) {
                LOGGER.error("数组复制出现错误source=[{}],targetType=[{}],errMsg=[{}]",
                    new Object[] {sourceList, target, var5.getMessage()});
                throw new BaseMsgException(var5.getMessage());
            }
        }
    }

    public static <T> T copyTo(Object sourceObj, Class<T> target) {
        if (sourceObj == null) {
            return null;
        } else {
            try {
                T e = target.newInstance();
                BeanUtils.copyProperties(sourceObj, e);
                return e;
            } catch (Exception var3) {
                LOGGER.error("对象复制出现错误source=[{}],targetType=[{}],errMsg=[{}]",
                    new Object[] {sourceObj, target, var3.getMessage()});
                throw new BaseMsgException(var3.getMessage());
            }
        }
    }

    public static Map<String, Object> modelToMap(Object obj, String prefix, String suffix) {
        Map<String, Object> result = new HashMap();
        if (obj == null) {
            return result;
        } else if (obj instanceof Map) {
            return (Map)obj;
        } else {
            for (Class clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
                Field[] fs = clazz.getDeclaredFields();

                for (int i = 0; i < fs.length; ++i) {
                    if (!Modifier.isStatic(fs[i].getModifiers())) {
                        boolean isAccessible = fs[i].isAccessible();
                        if (!isAccessible) {
                            fs[i].setAccessible(true);
                        }

                        try {
                            Object value = fs[i].get(obj);
                            String key = (StringUtils.isBlank(prefix) ? "" : prefix) + fs[i].getName() + (
                                StringUtils.isBlank(suffix) ? "" : suffix);
                            if (value != null && !result.containsKey(key)) {
                                result.put(key, value);
                            }
                        } catch (Exception var10) {
                            LOGGER.error("对象转map出现错误source=[{}],prefix=[{}],suffix=[{}],errMsg=[{}]",
                                new Object[] {obj, prefix, suffix, var10.getMessage()});
                            throw new BaseMsgException(var10.getMessage());
                        }

                        if (!isAccessible) {
                            fs[i].setAccessible(isAccessible);
                        }
                    }
                }
            }

            return result;
        }
    }

    public static Map<String, String> modelToMap(Object obj) {
        Map<String, String> result = new HashMap();
        if (obj == null) {
            return result;
        } else if (obj instanceof Map) {
            return (Map)obj;
        } else {
            for (Class clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
                Field[] fs = clazz.getDeclaredFields();

                for (int i = 0; i < fs.length; ++i) {
                    if (!Modifier.isStatic(fs[i].getModifiers())) {
                        boolean isAccessible = fs[i].isAccessible();
                        if (!isAccessible) {
                            fs[i].setAccessible(true);
                        }

                        try {
                            Object value = fs[i].get(obj);
                            if (value != null) {
                                if (value instanceof Date) {
                                    value = DateFormatUtils.format((Date)value, "yyyy-MM-dd HH:mm:ss");
                                }

                                result.put(fs[i].getName(), String.valueOf(value));
                            }
                        } catch (Exception var7) {
                            LOGGER.error("对象转map出现错误source=[{}],errMsg=[{}]", new Object[] {obj, var7.getMessage()});
                            throw new BaseMsgException(var7.getMessage());
                        }

                        if (!isAccessible) {
                            fs[i].setAccessible(isAccessible);
                        }
                    }
                }
            }

            return result;
        }
    }

    public static <T> T mapToModel(Map<String, String> map, Class<T> clazz) {
        return mapToModel(map, clazz, (String[])null);
    }

    public static <T> T mapToModel(Map<String, String> map, Class<T> clazz, String[] excludes) {
        try {
            Set<String> keySet = map.keySet();
            if (excludes != null && excludes.length > 0) {
                keySet.removeAll(Arrays.asList(excludes));
            }

            T result = clazz.newInstance();
            Iterator var5 = keySet.iterator();

            while (var5.hasNext()) {
                String attr = (String)var5.next();
                Field field = null;

                try {
                    field = clazz.getDeclaredField(attr);
                } catch (NoSuchFieldException var14) {
                    continue;
                }

                boolean isAccessible = field.isAccessible();
                if (!isAccessible) {
                    field.setAccessible(true);
                }

                Class<?> typeClazz = field.getType();
                Object o = map.get(attr);
                if (o != null) {
                    String dateType;
                    if (typeClazz.equals(String.class)) {
                        dateType = o.toString();
                        field.set(result, dateType);
                    } else if (typeClazz.equals(Integer.class)) {
                        field.set(result, Integer.parseInt(o.toString()));
                    } else if (typeClazz.equals(Long.class)) {
                        field.set(result, Long.parseLong(o.toString()));
                    } else if (typeClazz.equals(Date.class)) {
                        dateType = DateFormatUtils.getFormat(o.toString());
                        if (dateType != null) {
                            SimpleDateFormat sdf = new SimpleDateFormat(dateType);
                            Date date = sdf.parse(o.toString());
                            field.set(result, date);
                        }
                    } else if (typeClazz.equals(Float.class)) {
                        field.set(result, Float.parseFloat(o.toString()));
                    } else if (typeClazz.equals(Double.class)) {
                        field.set(result, Double.parseDouble(o.toString()));
                    }

                    if (!isAccessible) {
                        field.setAccessible(isAccessible);
                    }
                }
            }

            return result;
        } catch (Exception var15) {
            LOGGER.error("map转对象出现错误source=[{}],targetType=[{}],errMsg=[{}]",
                new Object[] {map, clazz, var15.getMessage()});
            throw new BaseMsgException(var15.getMessage());
        }
    }

    public static <T> Class<T> findParameterizedType(Class<?> clazz, int index) {
        while (true) {
            if (clazz != Object.class) {
                Type parameterizedType = clazz.getGenericSuperclass();
                if (parameterizedType == null) {
                    return null;
                }

                if (!(parameterizedType instanceof ParameterizedType)) {
                    clazz = clazz.getSuperclass();
                    continue;
                }

                Type[] actualTypeArguments = ((ParameterizedType)parameterizedType).getActualTypeArguments();
                if (actualTypeArguments != null && actualTypeArguments.length != 0
                    && index <= actualTypeArguments.length) {
                    return (Class)actualTypeArguments[index];
                }

                return null;
            }

            return null;
        }
    }

    public static <T> void sort(final List<T> list, final SortCriteria sortCriteria) {
        if (!CollectionUtils.isEmpty(list) && sortCriteria != null && !CollectionUtils.isEmpty(
            sortCriteria.getSortBeanList())) {
            final Class clazz = list.get(0).getClass();
            Collections.sort(list, new Comparator<T>() {
                public int compare(T a, T b) {
                    int r = 0;

                    try {
                        Iterator var4 = sortCriteria.getSortBeanList().iterator();

                        do {
                            if (!var4.hasNext()) {
                                return r;
                            }

                            SortBean sortBean = (SortBean)var4.next();
                            Field field = clazz.getDeclaredField(sortBean.getName());
                            boolean isAccessible = field.isAccessible();
                            if (!isAccessible) {
                                field.setAccessible(true);
                            }

                            Object av = field.get(a);
                            Object bv = field.get(b);
                            if (!isAccessible) {
                                field.setAccessible(isAccessible);
                            }

                            if (av == null) {
                                return 1;
                            }

                            if (bv == null) {
                                return -1;
                            }

                            if (!(av instanceof Comparable)) {
                                throw new BaseMsgException(String
                                    .format("属性[%s]的类型[%s]没有实现Comparable接口", sortBean.getName(),
                                        field.getType().getName()));
                            }

                            Comparable ca = (Comparable)av;
                            Comparable cb = (Comparable)bv;
                            if (sortBean.getSortEnum() == SortEnum.DESC) {
                                r = cb.compareTo(ca);
                            } else {
                                r = ca.compareTo(cb);
                            }
                        } while (r == 0);

                        return r;
                    } catch (Exception var12) {
                        BeanHelper.LOGGER.error("数组排序错误source=[{}],sort=[{}],errMsg=[{}]",
                            new Object[] {list, sortCriteria, var12.getMessage()});
                        throw new BaseMsgException(var12.getMessage());
                    }
                }
            });
        }
    }

    public static <T extends Serializable> T clone(T obj) {
        Serializable clonedObj = null;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (Serializable)ois.readObject();
            ois.close();
            return clonedObj;
        } catch (Exception var6) {
            LOGGER.error("数据复制出现错误source=[{}],errMsg=[{}]", new Object[] {obj, var6.getMessage()});
            throw new BaseMsgException(var6.getMessage());
        }
    }

    public static Object getTarget(Object proxyObject) throws Exception {
        if (!AopUtils.isAopProxy(proxyObject)) {
            return proxyObject;
        } else {
            return AopUtils.isJdkDynamicProxy(proxyObject) ? getJdkDynamicProxyTargetObject(proxyObject)
                : getCglibProxyTargetObject(proxyObject);
        }
    }

    public static <T> T getFieldValue(Object obj, String fieldName) throws IllegalAccessException {
        if (obj == null) {
            return null;
        } else {
            Field field = ReflectionUtils.findField(obj.getClass(), fieldName);
            if (field == null) {
                return null;
            } else {
                field.setAccessible(true);
                return field.get(obj);
            }
        }
    }

    public static <T> T primitiveToObject(String value, Class<T> target) {
        if (target.isPrimitive()) {
            if (target.isAssignableFrom(Integer.TYPE)) {
                return Integer.valueOf(value);
            }

            if (target.isAssignableFrom(Long.TYPE)) {
                return Long.valueOf(value);
            }

            if (target.isAssignableFrom(Double.TYPE)) {
                return Double.valueOf(value);
            }

            if (target.isAssignableFrom(Float.TYPE)) {
                return Float.valueOf(value);
            }

            if (target.isAssignableFrom(Boolean.TYPE)) {
                return Boolean.valueOf(value);
            }

            if (target.isAssignableFrom(Byte.TYPE)) {
                return Byte.valueOf(value);
            }

            if (target.isAssignableFrom(Short.TYPE)) {
                return Short.valueOf(value);
            }
        }

        if (target.isAssignableFrom(Integer.class)) {
            return Integer.valueOf(value);
        } else if (target.isAssignableFrom(Long.class)) {
            return Long.valueOf(value);
        } else if (target.isAssignableFrom(Double.class)) {
            return Double.valueOf(value);
        } else if (target.isAssignableFrom(Float.class)) {
            return Float.valueOf(value);
        } else if (target.isAssignableFrom(String.class)) {
            return value;
        } else if (target.isAssignableFrom(Boolean.class)) {
            return Boolean.valueOf(value);
        } else if (target.isAssignableFrom(Byte.class)) {
            return Byte.valueOf(value);
        } else if (target.isAssignableFrom(Short.class)) {
            return Short.valueOf(value);
        } else if (target.isAssignableFrom(Date.class)) {
            try {
                return DateFormatUtils.parse(value);
            } catch (ParseException var3) {
                throw new BaseMsgException(var3.getMessage());
            }
        } else {
            throw new BaseMsgException("不支持的对象类型转换");
        }
    }

    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object dynamicAdvisedInterceptor = h.get(proxy);
        Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport)advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();
        return target;
    }

    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy)h.get(proxy);
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport)advised.get(aopProxy)).getTargetSource().getTarget();
        return target;
    }

    public static <T extends Annotation> Collection<T> getAnnotations(AnnotatedElement ae, Class<T> annotationType) {
        Collection<T> anns = new ArrayList(2);
        T ann = ae.getAnnotation(annotationType);
        if (ann != null) {
            anns.add(ann);
        }

        Annotation[] var4 = ae.getAnnotations();
        int var5 = var4.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            Annotation metaAnn = var4[var6];
            ann = metaAnn.annotationType().getAnnotation(annotationType);
            if (ann != null) {
                anns.add(ann);
            }
        }

        return anns.isEmpty() ? null : anns;
    }

    public static void main(String[] args) {
        BeanHelper.A a = new BeanHelper.A(Integer.valueOf(1), "c", 333L);
        BeanHelper.A b = new BeanHelper.A(Integer.valueOf(2), "b", 331L);
        BeanHelper.A c = new BeanHelper.A(Integer.valueOf(3), "a", 332L);
        BeanHelper.A d = new BeanHelper.A(Integer.valueOf(1), "b", 331L);
        BeanHelper.A e = new BeanHelper.A(Integer.valueOf(1), "b", 332L);
        List<BeanHelper.A> list = new ArrayList();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        sort(list, (new SortCriteria()).buildSortCriteria("a", SortEnum.DESC).buildSortCriteria("b", SortEnum.ASC)
            .buildSortCriteria("c", SortEnum.DESC));
        Iterator var7 = list.iterator();

        while (var7.hasNext()) {
            BeanHelper.A t = (BeanHelper.A)var7.next();
            System.out.println(t);
        }

    }

    public static class A extends BaseBean {
        private Integer a;
        private String b;
        private Long c;

        public A(Integer a, String b, Long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
