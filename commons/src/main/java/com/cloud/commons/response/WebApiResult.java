package com.cloud.commons.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 请求返回类
 *
 * @param <T>
 * @author haoliuyang
 */
@Getter
@Setter
public class WebApiResult<T> {


    private T data;

    private String message;

    private Boolean success;

    /**
     * 返回成功带参数
     *
     * @param message 信息
     * @param <T>     泛型
     * @return 返回类型WebApiResult
     */
    public static <T> WebApiResult<T> successMsg(String message) {
        return getWebApiResult(message, null, true);
    }

    /**
     * 返回成功带数据
     *
     * @param message 信息
     * @param data    数据
     * @param <T>     泛型
     * @return 返回类型 WebApiResult<T>
     */
    public static <T> WebApiResult<T> successMsg(String message, T data) {
        return getWebApiResult(message, data, true);
    }

    /**
     * 异常处理
     *
     * @param message 返回信息
     * @param <T>     泛型
     * @return 返回类型WebApiResult
     */
    public static <T> WebApiResult<T> exception(String message) {
        return getWebApiResult(message, null, false);
    }

    /**
     * 封装返回信息
     *
     * @param message 返回信息
     * @param data    返回数据
     * @param success 返回状态
     * @param <T>     泛型
     * @return 返回类型WebApiResult<T>
     */
    private static <T> WebApiResult<T> getWebApiResult(String message, T data, Boolean success) {
        WebApiResult<T> webApiResult = new WebApiResult<>();
        webApiResult.setData(data);
        webApiResult.setMessage(message);
        webApiResult.setSuccess(success);
        return webApiResult;
    }

    /**
     * 返回错误
     *
     * @param message 返回信息
     * @param <T>     泛型
     * @return 返回类型
     */
    public static <T> WebApiResult<T> error(String message) {
        return getWebApiResult(message, null, false);
    }

}
