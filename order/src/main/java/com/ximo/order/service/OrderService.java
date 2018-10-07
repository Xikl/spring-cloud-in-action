package com.ximo.order.service;

import com.ximo.order.dto.OrderDTO;

/**
 * @author Ximo
 * @date 2018/10/7 14:33
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO 订单DTO
     * @return 订单DTO
     */
    OrderDTO create(OrderDTO orderDTO);

}
