package com.ximo.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ximo
 * @date 2018/10/7 20:32
 */
@FeignClient(name = "product")
public interface ProductClient {

    /** 调用服务端的接口进行通信*/
    @GetMapping("/msg")
    String productMsg();




}
