package com.zhouyn.demo.redisserver.handle;

import com.zhouyn.demo.redisserver.annotation.PicResponse;
import com.zhouyn.demo.redisserver.annotation.PicResult;
import com.zhouyn.demo.redisserver.annotation.PicResultCode;
import com.zhouyn.demo.redisserver.annotation.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@ControllerAdvice
@ConditionalOnBean({ResponseResultInterceptor.class})
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultHandler.class);

    public ResponseResultHandler() {
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        PicResponse responseResultAnn = (PicResponse) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getAttribute("RESPONSE-RESULT");
//        return responseResultAnn != null;
        return Optional.ofNullable((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .map(servletRequestAttributes -> servletRequestAttributes.getRequest())
                .map(httpServletRequest -> (PicResponse) httpServletRequest.getAttribute("RESPONSE-RESULT"))
                .map(picResponse -> picResponse != null)
                .orElse(false);
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        PicResponse picResponse = httpRequest != null ? (PicResponse) httpRequest.getAttribute("RESPONSE-RESULT") : null;
        Object objBuffer = null;

        try {
            HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.
                    getRequestAttributes()).getResponse();
            if (httpServletResponse != null) {
                httpServletResponse.setHeader("requestId", httpRequest.getHeader("requestId"));
            }

            Result result = (Result) picResponse.value().newInstance();

            if (obj instanceof Map) {
                Map resultMap = (Map) obj;
                String code = resultMap.get("status").toString();
                result.setCode(code);
                result.setMsg(resultMap.get("message").toString());
                result.setData(StringUtils.EMPTY);
            } else {
                result.setCode(PicResultCode.SUCCESS.code());
                result.setMsg(PicResultCode.SUCCESS.message());
                result.setData(obj);
            }

            if (!(obj instanceof String) && !selectedConverterType.isAssignableFrom(StringHttpMessageConverter.class)) {
                if (obj instanceof Result) {
                    objBuffer = obj;
                } else {
                    objBuffer = result;
                }
            } else {
                objBuffer = result.toJson();
            }
        } catch (IllegalAccessException | InstantiationException var11) {
            objBuffer = new PicResult(PicResultCode.SYSTEM_INNER_ERROR);
            LOGGER.error("BeforeBodyWrite got failed!", var11);
        }

        return objBuffer;
    }
}

