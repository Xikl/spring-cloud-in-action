package com.ximo.order.repository;

import com.ximo.order.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ximo
 * @date 2018/10/7 13:37
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>{


}
