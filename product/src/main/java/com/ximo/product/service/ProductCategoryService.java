package com.ximo.product.service;

import com.ximo.product.domain.ProductCategory;

import java.util.Collection;
import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 0:48
 */
public interface ProductCategoryService {

    /**
     * 通过类型查找
     *
     * @param productTypeList 类型列表
     * @return 上平类目信息
     */
    List<ProductCategory> findByCategoryTypeIn(Collection<Integer> productTypeList);


}
