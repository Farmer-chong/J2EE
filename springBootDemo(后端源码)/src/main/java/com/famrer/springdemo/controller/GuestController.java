package com.famrer.springdemo.controller;

import com.famrer.springdemo.dao.TodoListDao;
import com.famrer.springdemo.po.RestJson;
import com.famrer.springdemo.po.TodoList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestController {

    @Resource
    private TodoListDao todoListDao;

    @RequestMapping("getTodos")
    public RestJson getTodos(String username, HttpServletRequest request){
        List<TodoList> todos = todoListDao.getTodoListByUsername(username);
        return  RestJson.make(todos);
    }
}
