package com.ximo.product.controller;

import com.ximo.product.domain.ProductCategory;
import com.ximo.product.domain.ProductInfo;
import com.ximo.product.service.ProductCategoryService;
import com.ximo.product.service.ProductInfoService;
import com.ximo.product.util.ConvertUtil;
import com.ximo.product.vo.ProductInfoVO;
import com.ximo.product.vo.ProductVO;
import com.ximo.product.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .map(productCategory -> getProductVO(productCategory, productInfoList)).collect(toList());
        return ResultVO.success(productVOList);
    }

    /**
     * 获得商品列表信息
     *
     * @param productCategory 商品类目
     * @param productInfoList 商品信息列表
     * @return 商品VO对象
     */
    private ProductVO getProductVO(ProductCategory productCategory, List<ProductInfo> productInfoList) {
        ProductVO productVO = ConvertUtil.convert(productCategory, ProductVO.class);
        List<ProductInfoVO> productInfoVOList = productInfoList.stream()
                .filter(productInfo -> productCategory.getCategoryType().equals(productInfo.getCategoryType()))
                .map(productInfo -> ConvertUtil.convert(productInfo, ProductInfoVO.class))
                .collect(toList());
        productVO.setProductInfoVOList(productInfoVOList);
        return productVO;
    }


    



}
