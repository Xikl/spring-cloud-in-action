package com.ximo.order.enums;

import lombok.Getter;

/**
 * @author Ximo
 * @date 2018/10/7 0:55
 */
@Getter
public enum ResultEnums {

    /* 内部错误*/
    INNER_ERROR(-1, "内部错误，看来有人要扣工资了"),
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    CART_EMPTY(2, "购物车不能为空"),
    ;

    private Integer code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
