package com.ximo.product.vo;

import com.ximo.product.enums.ResultEnums;
import lombok.Data;

/**
 * 请求最外层对象
 *
 * @author Ximo
 * @date 2018/10/7 0:52
 */
@Data
public class ResultVO<T> {

    /** 是否成功*/
    private Boolean success;
    /** 返回码*/
    private Integer code;
    /** 返回信息*/
    private String msg;
    /** 返回数据*/
    private T data;

    /** 私有构造*/
    public ResultVO() {
    }

    /** 私有构造*/
    private ResultVO(Boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /** 成功方法 无返回数据*/
    public static <T> ResultVO<T> success() {
        return success(null);
    }

    /** 成功方法 默认返回信息-成功 指定返回数据*/
    public static <T> ResultVO<T> success(T data) {
        return success(ResultEnums.SUCCESS.getMsg(), data);
    }

    /** 成功方法 指定返回信息 和 返回数据*/
    public static <T> ResultVO<T> success(String msg, T data) {
        return new ResultVO<>(true, ResultEnums.SUCCESS.getCode(), msg, data);
    }

    /** 错误方法*/
    public static <T> ResultVO<T> error(ResultEnums enums) {
        return error(enums.getCode(), enums.getMsg());
    }

    /** 错误方法*/
    public static <T> ResultVO<T> error(Integer code, String msg) {
        return new ResultVO<>(false, code, msg, null);
    }


}
