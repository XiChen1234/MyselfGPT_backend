package com.example.myselfgpt_backend.common;

import lombok.Getter;

/**
 * @Description 响应码枚举类
 */
@Getter
public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),    // 成功！
    WARNING(400, "WARNING"),    // 客户端错误，包含语法错误或无法完成请求
    ERROR(500, "ERROR"),        // 服务器错误，服务器在处理请求的过程中发生了错误

    // 在这里之后添加自定义的错误码
    // 邮件错误，邮件地址错误
    MAIL_ADDRESS_ERROR(50000, "【邮件发送失败】邮箱地址错误，请检查邮件地址。"),
    CAPTCHA_IMAGE_ERROR(40000, "【客户端验证失败】人机验证失败，请重试")
    ;

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ResponseCode(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
