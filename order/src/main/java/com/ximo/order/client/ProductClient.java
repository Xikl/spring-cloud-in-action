package com.ximo.order.client;

import com.ximo.order.domain.ProductInfo;
import com.ximo.order.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Ximo
 * @date 2018/10/7 20:32
 */
@FeignClient(name = "product")
public interface ProductClient {

    /** 调用服务端的接口进行通信*/
    @GetMapping("/msg")
    String productMsg();


    /** 调用商品服务获得id列表对应的商品信息 */
    @PostMapping("/products/listForOrder")
    ResultVO<List<ProductInfo>> listForOrder(@RequestBody List<String> productIdList);


}
