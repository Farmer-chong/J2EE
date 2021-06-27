package com.famrer.springdemo.controller;


import com.famrer.springdemo.dao.UserDao;
import com.famrer.springdemo.po.RestJson;
import com.famrer.springdemo.po.User;
import com.famrer.springdemo.utils.JwtUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    @Resource
    private UserDao userDao;

    @RequestMapping(value = "login", method ={RequestMethod.GET, RequestMethod.POST})
    public RestJson login(@Valid @RequestBody User inputUser, HttpServletRequest request) {
        User user = userDao.getUserByUsername(inputUser.getUsername());
        if (user != null && user.getPassword().equals(inputUser.getPassword())) {
            user.setPassword(null);
            String jwt = JwtUtils.generateToken(user);
            HashMap<String, String> res = new HashMap<>();
            res.put("token", jwt);
            return RestJson.make(res);

        }

        return RestJson.make(401, "账号密码不匹配");
    }

    @PostMapping("reg")
    public RestJson regUser(@Valid @RequestBody User inputRegUser, HttpServletRequest request) {
        int state = userDao.addUser(inputRegUser.getUsername(), inputRegUser.getPassword(), inputRegUser.getEmail());
        if (state > 0){
            return RestJson.make();
        }
        return  RestJson.error(state, "注册失败");
    }
}
