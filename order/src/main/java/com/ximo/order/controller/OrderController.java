package com.ximo.order.controller;

import com.ximo.order.dto.OrderDTO;
import com.ximo.order.enums.ResultEnums;
import com.ximo.order.exception.OrderException;
import com.ximo.order.form.OrderForm;
import com.ximo.order.service.OrderService;
import com.ximo.order.util.ConstraintUtil;
import com.ximo.order.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ximo
 * @date 2018/10/7 14:32
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     *
     * @param orderForm 订单表单信息
     * @param errors bean验证错误
     * @return ResultVO 返回订单ID
     */
    @PostMapping()
    public ResultVO create(@Valid OrderForm orderForm, BindingResult errors) {
        ConstraintUtil.orElseThrow(errors, log, logger -> logger.error("【创建订单】参数不正确， orderForm={}", orderForm));

        //转换为orderDTO对象
        OrderDTO orderDTO = OrderDTO.getOrderDTO(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new OrderException(ResultEnums.CART_EMPTY);
        }
        //创建订单
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", createResult.getOrderId());
        return ResultVO.success(map);
    }




}
