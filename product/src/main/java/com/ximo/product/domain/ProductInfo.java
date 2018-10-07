package com.ximo.product.domain;

import com.ximo.product.enums.ProductStatusEnums;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ximo
 * @date 2018/10/7 0:19
 */
@Data
@Entity
public class ProductInfo {

    /** 商品id，非自增String类型 */
    @Id
    private String productId;

    /** 商品名字 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 商品小图 */
    private String productIcon;

    /** 商品状态,0正常1下架 */
    private Integer productStatus = ProductStatusEnums.UP.getCode();

    /** 商品类目编号 */
    private Integer categoryType;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;


}
