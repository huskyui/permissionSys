package com.husky.persys.common.exception;

public class ErrorInfo<T> {
    public static final Integer ACCESS_DENIED = 100;

    private Integer code;//错误代码
    private String message;//错误信息
    private String url;//错误的请求地址
    private T data;//附加信息


    public static Integer getAccessDenied() {
        return ACCESS_DENIED;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }
}
