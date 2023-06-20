package edu.gdkm.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName: SysInterceptor
 * Package: edu.gdkm.filter
 * Description:
 *
 * @Author 林
 * @Create 2023/6/20 14:09
 * @Version 1.0
 */
public class SysInterceptor extends HandlerInterceptorAdapter {
    /**
     * 进入拦截器后首先进入的方法
     * 返回false则不再执行
     * 返回true则继续执行
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        System.out.println("我是拦截器，证明我进来了");
        HttpSession session=request.getSession();
        String userInfo=(String) session.getAttribute("uaccount");
        if(userInfo==null){
            System.out.println("我证明用户没有登录");
            response.sendRedirect(request.getContextPath()+"http://localhost:8893/admin/tologin");
            return false;
        }
        System.out.println("我证明用户已登录");
        return true;
    }
}
