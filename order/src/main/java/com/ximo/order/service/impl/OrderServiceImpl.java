package com.ximo.order.service.impl;

import com.ximo.order.domain.OrderMaster;
import com.ximo.order.dto.OrderDTO;
import com.ximo.order.enums.OrderStatusEnums;
import com.ximo.order.enums.PayStatusEnums;
import com.ximo.order.repository.OrderDetailRepository;
import com.ximo.order.repository.OrderMasterRepository;
import com.ximo.order.service.OrderService;
import com.ximo.order.util.ConvertUtil;
import com.ximo.order.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Ximo
 * @date 2018/10/7 14:33
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // 查询订单中的商品信息
        // 计算总价
        // 扣库存
        // 订单入库
        orderDTO.setOrderId(KeyUtil.getUniqueKey());
        OrderMaster orderMaster = ConvertUtil.convert(orderDTO, OrderMaster.class);
        orderMaster.setOrderAmount(new BigDecimal(2));
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());

        orderMasterRepository.save(orderMaster);


        return orderDTO;
    }
}
