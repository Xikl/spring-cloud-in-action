package com.ximo.order.enums;

import lombok.Getter;

/**
 * @author Ximo
 * @date 2018/10/7 13:34
 */
@Getter
public enum PayStatusEnums {
    /** 等待支付 */
    WAIT(0, "等待支付"),
    /** 支付成功 */
    SUCCESS(1, "支付成功")
    ;

    private Integer code;

    private String msg;

    PayStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
