package com.ximo.product.service;

import com.ximo.product.domain.ProductInfo;

import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 0:40
 */
public interface ProductInfoService {

    /**
     * 查询所有的在架商品
     *
     * @return 列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 通过商品ID进行查询商品信息
     *
     * @param productIdList 商品列表信息
     * @return 商品信息列表
     */
    List<ProductInfo> findList(List<String> productIdList);

}
