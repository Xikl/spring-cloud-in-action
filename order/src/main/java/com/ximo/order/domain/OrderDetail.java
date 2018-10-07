package com.ximo.order.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ximo
 * @date 2018/10/7 13:35
 */
@Data
@Entity
@DynamicUpdate
public class OrderDetail {

    /** 详情id */
    @Id
    private String detailId;

    /** 订单id */
    private String orderId;

    /** 商品id */
    private String productId;

    /** 商品名字 */
    private String productName;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品价格*/
    private BigDecimal productPrice;

    /** 商品图片*/
    private String productIcon;

    /** 创建时间*/
    @Column(insertable = false, updatable = false)
    private Date createTime;

    /** 更新时间*/
    @Column(insertable = false, updatable = false)
    private Date updateTime;


}
