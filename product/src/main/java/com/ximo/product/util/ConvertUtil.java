package com.ximo.product.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;

import static com.ximo.product.constants.CommonConstants.SERIAL_VERSION_UID;
import static java.util.stream.Collectors.toList;

/**
 * 转化工具类
 *
 * @author Ximo
 * @date 2018/10/7 1:29
 */
public class ConvertUtil {

    private ConvertUtil() {
        throw new UnsupportedOperationException();
    }


    /**
     * 结合律
     * 将target中的值赋值给source中，返回source
     *
     * @param source 源信息
     * @param target 目标信息
     * @param <T> 二者共同的类型
     * @return source
     */
    public static <T> T combine(T source, T target) {
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();
        if (!sourceClass.equals(targetClass)) {
            throw new IllegalArgumentException("target's class must be equal to source's");
        }
        Field[] fields = sourceClass.getDeclaredFields();
        for (Field field : fields) {
            handleCombine(source, target, field);
        }
        return target;
    }

    private static <T> void handleCombine(T source, T target, Field field) {
        field.setAccessible(true);
        try {
            if (field.get(source) != null && !SERIAL_VERSION_UID.equals(field.getName())) {
                field.set(target, field.get(source));
            }
        } catch (IllegalAccessException e) {
            throw new UnsupportedOperationException("两个对象结合出现错误", e);
        }
    }

    /**
     * 转化
     *
     * @param source 源头类信息
     * @param targetClazz 目标类class
     * @param <T> 源头类泛型
     * @param <R> 目标类泛型
     * @return 转化后的target
     */
    public static <T, R> R convert(T source, Class<R> targetClazz) {
        try {
            R target = targetClazz.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnsupportedOperationException("合并对象出现错误", e);
        }
    }

    /**
     * 转化
     *
     * @param sourceList 源头类list信息
     * @param targetClazz 目标类class
     * @param <T> 源头类泛型
     * @param <R> 目标类泛型
     * @return 转化后的target list
     */
    public static <T, R> List<R> convert(List<T> sourceList, Class<R> targetClazz) {
        return sourceList.stream().map(source -> convert(source, targetClazz)).collect(toList());
    }
}
