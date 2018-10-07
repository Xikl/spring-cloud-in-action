package com.ximo.product.service;

import com.ximo.product.ProductApplicationTests;
import com.ximo.product.domain.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 0:46
 */
@Component
public class ProductInfoServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoService productService;


    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
    }
}