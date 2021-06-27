package com.famrer.springdemo.controller;

import com.famrer.springdemo.dao.TodoListDao;
import com.famrer.springdemo.dao.UserDao;
import com.famrer.springdemo.po.RestJson;
import com.famrer.springdemo.po.TodoList;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todoList")
@Validated
public class TodoListController {
    @Resource
    private TodoListDao todoListDao;
    @Resource
    private UserDao userDao;

    @RequestMapping(value = "setTodoList", method = {RequestMethod.GET, RequestMethod.POST})
    public RestJson setTodoList(@Valid @RequestBody TodoList addTodoList, HttpServletRequest request){
        LinkedHashMap<String, Object> user = (LinkedHashMap<String, Object>) request.getAttribute("user");
        int state = todoListDao.addTodoList(addTodoList.getTask(), addTodoList.getState(), addTodoList.getCompleted(), (Integer) user.get("id"));
        if (state > 0) {
            TodoList todo = todoListDao.getUserLastTodo((Integer) user.get("id"));
            return RestJson.make(todo);
        }

        return RestJson.error("插入失败");
    }

    @RequestMapping(value = "getTodoList", method = {RequestMethod.POST, RequestMethod.GET})
    public RestJson getTodoList(HttpServletRequest request){
        LinkedHashMap<String, Object> user = (LinkedHashMap<String, Object>) request.getAttribute("user");
        List<TodoList> todoList = todoListDao.getTodoList( (Integer) user.get("id"));
        return RestJson.make(todoList);
    }

    @RequestMapping(value = "modifyTask", method = {RequestMethod.POST})
    public RestJson modifyTask(@Valid @RequestBody TodoList todoList, HttpServletRequest request){
        int state = todoListDao.modifyTask(todoList.getTask(), todoList.getState(), todoList.getCompleted(), todoList.getId());
        if (state > 0){
            return  RestJson.make("modify success.");
        }
        return RestJson.error("更新数据失败");
    }

    @RequestMapping(value = "del", method = {RequestMethod.POST, RequestMethod.DELETE})
    public RestJson delTask(@RequestBody HashMap<String, Integer> reqJson, HttpServletRequest request){
        int state = todoListDao.delTask(reqJson.get("taskId"));
        if (state > 0) {
            return RestJson.make(state);
        }
        return RestJson.error("删除失败");
    }

}
