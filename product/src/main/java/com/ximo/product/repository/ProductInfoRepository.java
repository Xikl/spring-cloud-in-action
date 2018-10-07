package com.ximo.product.repository;

import com.ximo.product.domain.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 0:26
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查找所有的商品根据商品状态
     *
     * @param productStatus 商品状态
     * @return 列表
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);



}
