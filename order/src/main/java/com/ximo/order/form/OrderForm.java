package com.ximo.order.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Ximo
 * @date 2018/10/7 15:40
 */
@Data
public class OrderForm {

    /** 买家姓名 */
    @NotEmpty(message = "姓名必填")
    @JsonProperty("name")
    private String buyerName;

    /** 买家手机号 */
    @NotEmpty(message = "手机号必填")
    @JsonProperty("phone")
    private String buyerPhone;

    /** 买家地址 */
    @NotEmpty(message = "地址必填")
    @JsonProperty("address")
    private String buyerAddress;

    /** 买家微信id */
    @NotEmpty(message = "openid必填")
    @JsonProperty("openid")
    private String buyerOpenid;

    /** 购物车不能为空 */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
