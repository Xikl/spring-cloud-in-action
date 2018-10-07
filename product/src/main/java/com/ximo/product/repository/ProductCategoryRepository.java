package com.ximo.product.repository;

import com.ximo.product.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 0:34
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据类目类型进行查询
     *
     * @param categoryTypeList 类型列表
     * @return 类目列表
     */
    List<ProductCategory> findByCategoryTypeIn(Collection<Integer> categoryTypeList);



}
