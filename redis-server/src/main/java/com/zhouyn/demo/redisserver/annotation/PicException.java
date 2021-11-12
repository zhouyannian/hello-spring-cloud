package com.zhouyn.demo.redisserver.annotation;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class PicException extends RuntimeException implements Result<String> {
    private static final long serialVersionUID = 194906846739586856L;
    private final String code;
    private final String msg;

    public PicException(PicCode saeCode) {
        super(saeCode.message());
        this.code = saeCode.code();
        this.msg = saeCode.message();
    }

    public PicException(PicCode saeCode, String addition) {
        super(saeCode.message());
        this.code = saeCode.code();
        if (StringUtils.isNoneBlank(new CharSequence[]{saeCode.message(), addition}) && !Objects.equals(saeCode.message(), addition)) {
            this.msg = saeCode.message().concat(",").concat(addition);
        } else {
            this.msg = saeCode.message();
        }

    }

    public PicException(Result<?> result) {
        super(result.getMsg());
        this.code = result.getCode();
        this.msg = result.getMsg();
    }

    public PicException(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public PicException(String code, String message, String addition) {
        super(message);
        this.code = code;
        if (StringUtils.isNoneBlank(new CharSequence[]{message, addition}) && !Objects.equals(message, addition)) {
            this.msg = message.concat(",").concat(addition);
        } else {
            this.msg = message;
        }

    }

    public PicException(PicCode saeCode, Throwable cause) {
        super(cause);
        this.code = saeCode.code();
        this.msg = saeCode.message();
    }

    public PicException(String code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = message;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getData() {
        return null;
    }

    @Override
    public void setCode(String code) {
    }

    @Override
    public void setMsg(String msg) {
    }

    @Override
    public void setData(String data) {
    }
}
