package com.zhouyn.demo.redisserver.handle;

import com.zhouyn.demo.redisserver.annotation.PicResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
@ConditionalOnProperty(
        name = {"pic-response.enabled"},
        havingValue = "true",
        matchIfMissing = true
)
public class ResponseResultInterceptor implements HandlerInterceptor {
    public static final String RESPONSE_RESULT = "RESPONSE-RESULT";
    private static final String REQUEST_TIME = "REQUEST-TIME";
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultInterceptor.class);

    public ResponseResultInterceptor() {
        LOGGER.info("sae.sdk.sae-response.enabled use default value: true");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(PicResponse.class)) {
                request.setAttribute("RESPONSE-RESULT", method.getAnnotation(PicResponse.class));
                request.setAttribute("REQUEST-TIME", System.currentTimeMillis());
            } else if (clazz.isAnnotationPresent(PicResponse.class)) {
                request.setAttribute("RESPONSE-RESULT", clazz.getAnnotation(PicResponse.class));
                request.setAttribute("REQUEST-TIME", System.currentTimeMillis());
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(PicResponse.class) || clazz.isAnnotationPresent(PicResponse.class)) {
                String requestID = request.getHeader("requestId");
                int statusCode = response.getStatus();
                long requestTime = (Long) request.getAttribute("REQUEST-TIME");
                if (statusCode != HttpStatus.OK.value()) {
                    LoggerFactory.getLogger(clazz).error("RequestID: {}, Method: {}, Response Time: {}ms, HttpStatus: {}", new Object[]{requestID, method.getName(), System.currentTimeMillis() - requestTime, statusCode, ex});
                } else {
                    LoggerFactory.getLogger(clazz).info("RequestID: {}, Method: {}, Response Time: {}ms", new Object[]{requestID, method.getName(), System.currentTimeMillis() - requestTime});
                }
            }
        }

    }
}
