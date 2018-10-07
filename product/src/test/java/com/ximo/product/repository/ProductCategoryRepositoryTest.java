package com.ximo.product.repository;

import com.ximo.product.domain.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/7 0:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1, 3));
    }
}