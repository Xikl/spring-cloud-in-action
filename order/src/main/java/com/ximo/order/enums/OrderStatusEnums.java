package com.ximo.order.enums;

import lombok.Getter;

/**
 * @author Ximo
 * @date 2018/10/7 13:33
 */
@Getter
public enum OrderStatusEnums {

    /** 新订单 */
    NEW(0, "新订单"),
    FINISHED(1, "已完结"),
    CANCEL(2, "已取消");

    private Integer code;

    private String msg;

    OrderStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
