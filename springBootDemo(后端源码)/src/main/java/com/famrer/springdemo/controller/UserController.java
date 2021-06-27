package com.famrer.springdemo.controller;

import com.famrer.springdemo.dao.TodoListDao;
import com.famrer.springdemo.dao.UserDao;
import com.famrer.springdemo.po.RestJson;
import com.famrer.springdemo.po.TodoList;
import com.famrer.springdemo.po.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedHashMap;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @RequestMapping("getInfo")
    public RestJson getUserInfo(HttpServletRequest request) {
        Object User =  request.getAttribute("user");
        return RestJson.make(User);
    }


}
