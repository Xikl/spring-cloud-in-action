package com.ximo.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 1:02
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -1452967461823840049L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
