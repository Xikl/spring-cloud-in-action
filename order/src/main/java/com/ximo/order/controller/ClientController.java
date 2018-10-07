package com.ximo.order.controller;

import com.ximo.order.client.ProductClient;
import com.ximo.order.domain.ProductInfo;
import com.ximo.order.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 17:39
 */
@Slf4j
@RestController
public class ClientController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 第三种方式
        // String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        // 通过feign调用
        String response = productClient.productMsg();
        log.info("rest请求， String={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        ResultVO<List<ProductInfo>> resultVO = productClient.listForOrder(Arrays.asList("123", "344"));
        log.info("rest请求，feignResponse={}", resultVO);
        return "ok";
    }


}
