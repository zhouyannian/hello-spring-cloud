package com.zhouyn.demo.redisserver.annotation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class PicResult<T> implements Result<T> {
    private static final long serialVersionUID = 874200365941306385L;
    private String code;
    private String msg;
    private T data;

    public PicResult() {
    }

    public PicResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public PicResult(PicCode saeCode) {
        this.code = saeCode.code();
        this.msg = saeCode.message();
    }

    public PicResult(PicCode saeCode, T data) {
        this.code = saeCode.code();
        this.msg = saeCode.message();
        this.data = data;
    }

    public PicResult(PicException saeException, String additionalMessage) {
        this.code = saeException.getCode();
        if (StringUtils.isNoneBlank(new CharSequence[]{additionalMessage}) && !Objects.equals(saeException.getMsg(), additionalMessage)) {
            this.msg = saeException.getMsg().concat(",").concat(additionalMessage);
        } else {
            this.msg = saeException.getMsg();
        }

    }

    @JsonIgnore
    public boolean isSuccess() {
        return PicResultCode.SUCCESS.code().equals(this.code);
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }
}

