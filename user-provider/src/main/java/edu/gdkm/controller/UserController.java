package edu.gdkm.controller;

import edu.gdkm.dao.UserDao;
import edu.gdkm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public int register(@RequestParam(value = "upassword")String upassword,
                        @RequestParam(value = "uname")String uname,
                        @RequestParam(value = "usex")String usex){

        return userDao.register(upassword,uname,usex);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@RequestParam(value = "uname")String uname){
        return userDao.login(uname);
    }
}
