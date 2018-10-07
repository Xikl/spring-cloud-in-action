package com.ximo.product.enums;

import lombok.Getter;

/**
 * @author Ximo
 * @date 2018/10/7 0:24
 */
@Getter
public enum ProductStatusEnums {

    /*在架商品*/
    UP(0, "在架"),
    /*下架商品*/
    DOWN(1, "下架")
    ;

    /** 状态 */
    private Integer code;

    /** 标注的信息 */
    private String msg;

    ProductStatusEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
