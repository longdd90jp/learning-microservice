package com.mathtrainer.backend.gateway.config.security;

import javax.servlet.http.HttpServletResponse;

import com.mathtrainer.backed.common.constants.CommonConsant;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

public class ZuulModifyHeaderFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse servletResponse = context.getResponse();
        // add header for down service
        context.addZuulRequestHeader(
                CommonConsant.HEADER_USER_ID, servletResponse.getHeader(CommonConsant.HEADER_USER_ID));
        context.addZuulRequestHeader(
                CommonConsant.HEADER_USER_NAME, servletResponse.getHeader(CommonConsant.HEADER_USER_NAME));
        return null;
    }
}
