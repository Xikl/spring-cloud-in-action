package com.ximo.product.enums;

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
    ;

    private Integer code;

    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
