package com.kpwang.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

/**
 * @author kpwang
 * @create 2020-08-25 21:03
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器类型，前置过滤器
     * pre:  请求在被路由之前执行
     * route:  在路由请求是调用
     * post:  在route和error过滤器之后调用
     * error:  处理请求是发生错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 该过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取zuul公告的上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        //从上下文对象中获取请求对象
        HttpServletRequest request = context.getRequest();
        //获取token信息
        String token = request.getParameter("access-token");
        //判断
        if (StringUtils.isBlank(token)){
            //过滤该请求，不对其进行路由
            context.setSendZuulResponse(false);
            //设置响应码，401
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置响应信息
            context.setResponseBody("{\"status\":\"401\",\"text\":\"request error!\"}");
        }
        //校验通过，把登录信息放入上下文信息，继续向后执行
        context.set("token",token);
        return null;
    }
}
