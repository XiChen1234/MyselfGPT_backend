package com.example.myselfgpt_backend.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Description 通用响应类
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) // 空数据不包含
public class CommonResponse<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    public CommonResponse() {

    }

    private CommonResponse(int status) {
        this.status = status;
    }

    private CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private CommonResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private CommonResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    /**
     * 创建成功响应
     *
     * @return 成功响应
     */
    public static <T> CommonResponse<T> creatForSuccess() {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 创建成功响应 + 成功信息
     *
     * @param message 响应的信息内容
     * @return 成功响应
     */
    public static <T> CommonResponse<T> creatForSuccessMessage(String message) {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode(), message);
    }

    /**
     * 创建成功响应 + 数据
     *
     * @param data 响应的数据
     * @return 成功响应
     */
    public static <T> CommonResponse<T> creatForSuccessData(T data) {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    /**
     * 创建成功响应 + 信息 + 数据
     *
     * @param message 响应的信息内容
     * @param data    响应的数据
     * @return 成功响应
     */
    public static <T> CommonResponse<T> creatForSuccessMessageData(String message, T data) {
        return new CommonResponse<T>(ResponseCode.SUCCESS.getCode(), message, data);
    }


    /**
     * 创建警告响应
     *
     * @return 警告响应
     */
    public static <T> CommonResponse<T> creatForWarning() {
        return new CommonResponse<T>(ResponseCode.WARNING.getCode(), ResponseCode.WARNING.getMessage());
    }

    /**
     * 创建警告响应 + 信息
     *
     * @param message 警告的信息
     * @return 警告响应
     */
    public static <T> CommonResponse<T> creatForWarningMessage(String message) {
        return new CommonResponse<T>(ResponseCode.WARNING.getCode(), message);
    }

    /**
     * 创建错误响应
     *
     * @return 错误响应
     */
    public static <T> CommonResponse<T> creatForError() {
        return new CommonResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
    }

    /**
     * 创建错误响应 + 信息
     *
     * @param message 错误的信息
     * @return 错误响应
     */
    public static <T> CommonResponse<T> creatForErrorMessage(String message) {
        return new CommonResponse<T>(ResponseCode.ERROR.getCode(), message);
    }

    /**
     * 自定义响应码的错误 + 信息
     *
     * @param responseCode 响应码枚举类，包含错误码和信息
     * @return 错误响应
     */
    public static <T> CommonResponse<T> creatForCommonException(ResponseCode responseCode) {
        return new CommonResponse<T>(responseCode.getCode(), responseCode.getMessage());
    }
}
