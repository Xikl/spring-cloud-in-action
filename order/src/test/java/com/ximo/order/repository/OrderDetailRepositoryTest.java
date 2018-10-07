package com.ximo.order.repository;

import com.ximo.order.OrderApplicationTests;
import com.ximo.order.domain.OrderDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/7 14:22
 */
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123wss");
        orderDetail.setOrderId("ssssss");
        orderDetail.setProductIcon("http://sss");
        orderDetail.setProductId("123");
        orderDetail.setProductName("test");
        orderDetail.setProductPrice(new BigDecimal(2.0));
        orderDetail.setProductQuantity(2);
        orderDetailRepository.save(orderDetail);
    }
}