package com.ximo.product.controller;

import com.ximo.product.domain.ProductCategory;
import com.ximo.product.domain.ProductInfo;
import com.ximo.product.service.ProductCategoryService;
import com.ximo.product.service.ProductInfoService;
import com.ximo.product.vo.ProductVO;
import com.ximo.product.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Ximo
 * @date 2018/10/7 0:07
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /** 查询所有的上架商品*/
    @GetMapping()
    public ResultVO<List<ProductVO>> list() {
        //1查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2获得类目
        List<Integer> productTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(toList());
        //3查询类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(productTypeList);
        //4构造数据
        List<ProductVO> productVOList = productCategoryList.stream()
                .map(productCategory -> ProductVO.getProductVO(productCategory, productInfoList)).collect(toList());
        return ResultVO.success(productVOList);
    }

    /**
     * 获取商品列表
     * 给Order服务进行调用的
     *
     * @param productIdList 商品ID列表
     * @return 商品对应的信息
     */
    @PostMapping("/listForOrder")
    public ResultVO<List<ProductInfo>> listForOrder(@RequestBody List<String> productIdList) {
        return ResultVO.success(productInfoService.findList(productIdList));
    }


    



}
