package com.sherlockqwq.weibo.Intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Configuration
public class SysInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        HttpSession session=request.getSession();
        if(session.getAttribute("account")!=null || url.indexOf("login")!=-1|| url.indexOf("register")!=-1){
            System.out.println("不拦截");
            return  true;//session里有数据或者访问的是login或者register页面不拦截
        }
        else {
            System.out.println("拦截");
            response.sendRedirect(request.getContextPath()+"/user/login");
        }


        return true;
    }
}
