package com.ximo.product.service.impl;

import com.ximo.product.domain.ProductCategory;
import com.ximo.product.repository.ProductCategoryRepository;
import com.ximo.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 0:50
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findByCategoryTypeIn(Collection<Integer> productTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(productTypeList);
    }
}
