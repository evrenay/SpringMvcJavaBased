package com.example.testspring.config;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
@Component
public class ControllerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();
        System.out.println(method.getName() + " metodu yurutulmeden once");
        request.setAttribute("startTime", System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {        HandlerMethod hm = (HandlerMethod) handler;        Method method = hm.getMethod();
        System.out.println(method.getName() + " metodu yurutuldukten sonra");
        request.setAttribute("endTime", System.currentTimeMillis());
        super.postHandle(request, response, handler, modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerMethod hm = (HandlerMethod) handler;        Method method = hm.getMethod();
        long startTime = Long.parseLong(request.getAttribute("startTime").toString());
        long endTime = Long.parseLong(request.getAttribute("endTime").toString());
        System.out.println("Method " + method.getName() + " yürütüldü. Süre: " + (endTime-startTime) + " ms.");
        super.afterCompletion(request, response, handler, ex);    }
}
