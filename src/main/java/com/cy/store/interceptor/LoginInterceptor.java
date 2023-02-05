package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 定义一个拦截器 */
public class LoginInterceptor implements HandlerInterceptor {
    // 在调用所有处理请求的方法之前

    /**
     *
     * @param request
     * @param response
     * @param handler （url + controller： 映射）
     * @return 返回值为true表示放行当前的请求，为false表示拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute("uid");
        if (object == null) {
            response.sendRedirect("/web/login.html");
            return false;
        }

        return true;
    }

//    // 在ModelAndView对象返回之后
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }

//    // 在整个请求所有关联的资源被执行完毕后
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
