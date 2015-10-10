package com.taskSystem.utils;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String path = req.getServletPath();
        //System.out.println("登陆过滤器取得ServletPath为："+path);

        // 不过滤的uri---静态资源
        String notFilter = "/resources";

        if (path.indexOf(notFilter) != -1){
            chain.doFilter(request, response);
        }else if(!"/login".equals(path)){
            if(session.getAttribute("admin") != null){
                chain.doFilter(request, response);
            }else {
                res.sendRedirect("login");
            }
        }else{
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
    public void destroy() {

    }

}
