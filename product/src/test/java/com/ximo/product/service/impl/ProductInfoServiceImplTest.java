package com.ximo.product.service.impl;

import com.ximo.product.ProductApplicationTests;
import com.ximo.product.domain.ProductInfo;
import com.ximo.product.service.ProductInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/7 21:01
 */
@Component
public class ProductInfoServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findUpAll() {
    }

    @Test
    public void findList() {
        List<ProductInfo> result = productInfoService.findList(Arrays.asList("123", "244"));
    }
}