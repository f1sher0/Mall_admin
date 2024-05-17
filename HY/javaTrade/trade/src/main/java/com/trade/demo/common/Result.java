package com.trade.demo.common;


import lombok.Builder;
import lombok.Data;


@Data

@Builder/**
 * Controller统一返回的包装类
 */
public class Result {
    private static final String SUCCESS_CODE = "200";
    private static final String ERROR_CODE = "500";
    private static final String SC_UNAUTHORIZED="401";
    private String code;   // 返回的状态码。告诉前端这次请求成功还是失败
    private String msg;    // 错误信息
    private Object data;   // 包装的数据

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(Object data) {
        return new Result(SUCCESS_CODE, "", data);
    }

    public static Result success() {
        return new Result(SUCCESS_CODE, "");
    }

    public static Result error(String msg) {
        return new Result(ERROR_CODE, msg);
    }
}
