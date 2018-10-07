package com.ximo.order.domain;

import com.ximo.order.enums.OrderStatusEnums;
import com.ximo.order.enums.PayStatusEnums;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ximo
 * @date 2018/10/7 13:32
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {


    /** 订单id*/
    @Id
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
    private BigDecimal buyerAmount;

    /** 订单状态，默认为0，表示为新订单*/
    private Integer orderStatus = OrderStatusEnums.NEW.getCode();

    /** 支付状态，默认为0，表示为等待支付*/
    private Integer payStatus = PayStatusEnums.WAIT.getCode();

    /** 创建时间*/
    @Column(insertable = false, updatable = false)
    private Date createTime;

    /** 更新时间*/
    @Column(insertable = false, updatable = false)
    private Date updateTime;


}
