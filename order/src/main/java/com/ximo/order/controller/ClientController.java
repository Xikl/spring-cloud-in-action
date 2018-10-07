package com.ximo.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ximo
 * @date 2018/10/7 17:39
 */
@Slf4j
@RestController
public class ClientController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 第三种方式
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        log.info("rest请求， String={}", response);
        return response;
    }


}
