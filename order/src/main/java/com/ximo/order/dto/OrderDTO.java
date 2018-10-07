package com.ximo.order.dto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ximo.order.domain.OrderDetail;
import com.ximo.order.enums.ResultEnums;
import com.ximo.order.exception.OrderException;
import com.ximo.order.form.OrderForm;
import com.ximo.order.util.ConvertUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 14:34
 */
@Data
public class OrderDTO {

    /** 订单id*/
    private String orderId;

    /** 买家名字*/
    private String buyerName;

    /** 买家手机号*/
    private String buyerPhone;

    /** 买家地址*/
    private String buyerAddress;

    /** 买家微信openid*/
    private String buyerOpenid;

    /** 买家订单总额*/
    private BigDecimal orderAmount;

    /** 订单状态，默认为0，表示为新订单*/
    private Integer orderStatus;

    /** 支付状态，默认为0，表示为等待支付*/
    private Integer payStatus;

    /** 订单详情 */
    private List<OrderDetail> orderDetailList;

    public static OrderDTO getOrderDTO(OrderForm orderForm) {
        try {
            OrderDTO orderDTO = ConvertUtil.convert(orderForm, OrderDTO.class);
            List<OrderDetail> orderDetailList =
                    new Gson().fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
            orderDTO.setOrderDetailList(orderDetailList);
            return orderDTO;
        } catch (Exception e) {
            throw new OrderException(ResultEnums.PARAM_ERROR);
        }
    }

}
