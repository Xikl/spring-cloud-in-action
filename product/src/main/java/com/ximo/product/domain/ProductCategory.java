package com.ximo.product.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Ximo
 * @date 2018/10/7 0:32
 */
@Entity
@Data
public class ProductCategory {

    /** 类目id */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目类型 */
    private Integer categoryType;

    /** 类目创建时间 */
    private Date createTime;

    /** 类目更新时间 */
    private Date updateTime;


}
