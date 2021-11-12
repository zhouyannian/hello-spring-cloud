package com.zhouyn.demo.redisserver.annotation;

public enum PicResultCode implements PicCode {
    SUCCESS("0", "success"),
    BAD_REQUEST("505-00-00-40000", "bad request"),
    REQUEST_ID_IS_NULL("505-00-00-40001", "request id is null"),
    PARAM_IS_INVALID("505-00-00-40002", "param is invalid"),
    PARAM_IS_BLANK("505-00-00-40003", "param is blank"),
    PARAM_TYPE_BIND_ERROR("505-00-00-40004", "param type bind error"),
    UNSUPPORTED_RESPONSE_TYPE("505-00-00-40005", "unsupported response type"),
    GATEWAY_UNKNOWN_EXCEPTION("505-00-00-40006", "gateway unknown exception"),
    USER_ID_NOT_FOUND("505-00-00-40011", "user id not found"),
    USER_NAME_NOT_FOUND("505-00-00-40012", "username or password is error"),
    USER_NAME_IS_REGISTERED("505-00-00-40013", "user name is registered"),
    USER_NAME_CANNOT_CHANGE("505-00-00-40014", "user name cannot change"),
    PHONE_NUMBER_IS_REGISTERED("505-00-00-40015", "phone number is registered"),
    INVALID_GRANT("505-00-00-40022", "invalid grant"),
    UNSUPPORTED_GRANT_TYPE("505-00-00-40023", "unsupported grant type"),
    UNAUTHORIZED("505-00-00-40100", "unauthorized"),
    ACCESS_TOKEN_IS_NULL("505-00-00-40102", "access token is null"),
    ACCESS_TOKEN_EXPIRED("505-00-00-40103", "access token expired"),
    ACCESS_TOKEN_INVALID("505-00-00-40104", "access token invalid"),
    UNAUTHORIZED_USER("505-00-00-40110", "unauthorized user"),
    INVALID_USER("505-00-00-40111", "invalid user"),
    USER_LOGIN_FAILURE("505-00-00-40112", "user login failuer"),
    USER_NAME_ERROR("505-00-00-40113", "username or password is error"),
    USER_PASSWORD_ERROR("505-00-00-40114", "username or password is error"),
    USER_IS_NOT_LOGIN("505-00-00-40115", "user is not login"),
    UNAUTHORIZED_CLIENT("505-00-00-40120", "unauthorized client"),
    INVALID_CLIENT("505-00-00-40121", "invalid client"),
    CLIENT_ID_ERROR("505-00-00-40122", "client id error"),
    CLIENT_SECRET_ERROR("505-00-00-40123", "client secret error"),
    CLIENT_IS_NOT_LOGIN("505-00-00-40124", "client is not login"),
    CLIENT_LOGIN_FAILURE("505-00-00-40125", "client login failuer"),
    ACCESS_TOKEN_NO_AUTHORITY("505-00-00-40301", "access token no authority"),
    ACCESS_IP_NO_AUTHORITY("505-00-00-40302", "access ip no authority"),
    ACCESS_TIMES_EXCESSIVE("505-00-00-40303", "access times excessive"),
    INSUFFICIENT_SCOPE("505-00-00-40304", "insufficient scope"),
    ACCESS_DENIED("505-00-00-40305", "access denied"),
    INSUFFICIENT_AUTHENTICATION("505-00-00-40306", "insufficient authentication"),
    INTERFACE_ADDRESS_NOT_FOUND("505-00-00-40400", "interface address not found"),
    SERVICE_ADDRESS_NOT_FOUND("505-00-00-40401", "service address not found"),
    INTERFACE_REQUEST_TIMEOUT("505-00-00-40402", "interface request timeout"),
    METHOD_NOT_ALLOWED("505-00-00-40501", "method not allowed"),
    UNSUPPORTED_MEDIA_TYPE("505-00-00-41500", "unsupported media type"),
    SYSTEM_INNER_ERROR("505-00-00-50000", "system inner error"),
    SYSTEM_BUSY_NOW("505-00-00-50001", "system is busy now");

    private String code;
    private String message;

    private PicResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
