package com.ximo.order.repository;

import com.ximo.order.OrderApplicationTests;
import com.ximo.order.domain.OrderMaster;
import com.ximo.order.enums.OrderStatusEnums;
import com.ximo.order.enums.PayStatusEnums;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Ximo
 * @date 2018/10/7 13:39
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSaveOrderMaster() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234");
        orderMaster.setBuyerAddress("testAddr2");
        orderMaster.setOrderAmount(new BigDecimal(3.0));
        orderMaster.setBuyerName("ximo");
        orderMaster.setBuyerOpenid("asdnjfoijopiajpsdfasdf");
        orderMaster.setBuyerPhone("123456677");
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
    }
}