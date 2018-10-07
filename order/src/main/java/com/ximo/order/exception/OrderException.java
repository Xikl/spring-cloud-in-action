package com.ximo.order.exception;

import com.ximo.order.enums.ResultEnums;
import lombok.Getter;

/**
 * @author Ximo
 * @date 2018/10/7 15:34
 */
@Getter
public class OrderException extends RuntimeException {

    private Integer code;

    /**
     * 获得异常枚举对象的msg和code
     *
     * @param resultEnums 异常枚举对象
     */
    public OrderException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.code = resultEnums.getCode();
    }

    /**
     * 异常构造函数
     *
     * @param code
     * @param msg
     */
    public OrderException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
