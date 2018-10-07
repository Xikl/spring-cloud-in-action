package com.ximo.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ximo.product.domain.ProductCategory;
import com.ximo.product.domain.ProductInfo;
import com.ximo.product.util.ConvertUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    /**
     * 获得商品列表信息
     *
     * @param productCategory 商品类目
     * @param productInfoList 商品信息列表
     * @return 商品VO对象
     */
    public static ProductVO getProductVO(ProductCategory productCategory, List<ProductInfo> productInfoList) {
        ProductVO productVO = ConvertUtil.convert(productCategory, ProductVO.class);
        List<ProductInfoVO> productInfoVOList = productInfoList.stream()
                .filter(productInfo -> productCategory.getCategoryType().equals(productInfo.getCategoryType()))
                .map(productInfo -> ConvertUtil.convert(productInfo, ProductInfoVO.class))
                .collect(toList());
        productVO.setProductInfoVOList(productInfoVOList);
        return productVO;
    }

}
