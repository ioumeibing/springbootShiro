package com.how2java.springboot.helper;

public class ResponseResult<T>{

    public int code;
    private String msg;
    private T data;

    public ResponseResult<T> setCode(ResultCode  retcode) {
        this.code = retcode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseResult<T> setCode(int code){
        this.code =code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
