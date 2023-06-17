package edu.gdkm.controller;

import edu.gdkm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;
    //跳转注册页面
    @GetMapping(value = "/toregister")
    public String toregister(){
        return "register";
    }

    //用户注册
    @GetMapping(value = "/register")
    public String register(HttpServletRequest request,String upassword,String uname,String usex){
        if(userService.register(upassword,uname,usex)>0){
            System.out.print("注册成功");
            return "login";
        }
        System.out.print("注册失败");
        return "register";
    }
    //跳转到登录页面
    @GetMapping(value = "/tologin")
    public String login(){
        return "login";
    }

    //用户登录
    @GetMapping(value = "/login")
    public String login(String uname,String upassword,HttpServletRequest request){
        if(userService.login(uname)!=null){
            if(userService.login(uname).getUpassword().equals(upassword)){
                HttpSession session=request.getSession(true);
                //将登录者信息存入session
                session.setAttribute("user",userService.login(uname));
                System.out.print("登录成功");
                return "redirect:http://localhost:8896/goods/getAll?uaccount="+userService.login(uname).
                        getUaccount()+ "&upassword="+userService.login(uname).getUpassword();
            }
        }
        System.out.print("登录失败！");
        return "login";
    }
}
