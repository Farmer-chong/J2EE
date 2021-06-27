package com.famrer.springdemo.controller;

import com.famrer.springdemo.dao.UserDao;
import com.famrer.springdemo.po.RestJson;
import com.famrer.springdemo.po.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Resource
    private UserDao userDao;

    @GetMapping("hello")
    public String hello(String username, String password, HttpServletRequest request) {
        return username + " " + password;
    }

    @RequestMapping(value = "getUserInToken", method = {RequestMethod.GET, RequestMethod.POST})
    public RestJson login(String username, String password, HttpServletRequest request) {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            request.getSession().setAttribute("user", user);
            return RestJson.make();
        }

        return RestJson.make(401);
    }

    @RequestMapping("getUserInfo")
    public RestJson getUser(HttpServletRequest request){
        Object user = request.getAttribute("user");
        return RestJson.make(user);
    }
}
