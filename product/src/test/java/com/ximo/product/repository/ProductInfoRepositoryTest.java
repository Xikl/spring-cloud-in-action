package com.ximo.product.repository;

import com.ximo.product.domain.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 0:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = productInfoRepository.findByProductStatus(1);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> result = productInfoRepository.findByProductIdIn(Arrays.asList("133", "244"));
    }
}