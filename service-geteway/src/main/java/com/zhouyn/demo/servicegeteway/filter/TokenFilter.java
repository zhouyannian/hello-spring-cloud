//package com.zhouyn.demo.servicegeteway.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Slf4j
//public class TokenFilter extends ZuulFilter {
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        log.info("--->>> TokenFilter {} {}", request.getMethod(), request.getRequestURI());
//
//        String token = request.getParameter("token");
//
//        if (StringUtils.isNotBlank(token)){
//            ctx.setSendZuulResponse(true);
//            ctx.setResponseStatusCode(200);
//            ctx.set("isSuccess",true);
//            return null;
//        }else {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(400);
//            ctx.setResponseBody("token is empty");
//            ctx.set("isSuccess",false);
//            return null;
//        }
//    }
//}
