package com.sherlockqwq.weibo.Filter;

import org.apache.coyote.Request;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;
import java.net.http.HttpRequest;

@javax.servlet.annotation.WebFilter("/*")
public class WebFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String url=request.getRequestURI();
        HttpSession session=request.getSession();
        if(session.getAttribute("account")!=null || url.indexOf("login")!=-1|| url.indexOf("register")!=-1){
            System.out.println("不拦截");
            filterChain.doFilter(request, servletResponse);
           //session里有数据或者访问的是login或者register页面不拦截
        }
        else {
            System.out.println("拦截");


        }
    }
}
