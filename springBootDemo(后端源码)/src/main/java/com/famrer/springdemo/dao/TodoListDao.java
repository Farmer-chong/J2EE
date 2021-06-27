package com.famrer.springdemo.dao;

import com.famrer.springdemo.po.TodoList;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TodoListDao {

    @Select("SELECT * FROM todo_list WHERE user_id = #{userId}")
    List<TodoList> getTodoList(@Param("userId") int userId);

    @Select("SELECT * FROM todo_list,`user`WHERE`user`.id = todo_list.user_id AND`user`.username = #{username}")
    List<TodoList> getTodoListByUsername(@Param("username") String username);

    @Select("SELECT * FROM todo_list ORDER BY id DESC LIMIT 1 ")
    TodoList getLastTodo();

    @Select("SELECT * FROM todo_list where user_id = #{user_id} ORDER BY id DESC LIMIT 1")
    TodoList getUserLastTodo(@Param("user_id") Integer userId);

    @Insert("INSERT INTO todo_list (task, state, completed, user_id) VALUES (#{task}, #{state}, #{completed}, #{user_id})")
    int addTodoList(
            @Param("task") String task,
            @Param("state") Integer state,
            @Param("completed") Boolean completed,
            @Param("user_id") Integer userId
    );

    @Update("UPDATE todo_list SET task=#{task}, state=#{state}, completed=#{completed} WHERE id=#{id}")
    int modifyTask(@Param("task") String task, @Param("state") Integer state, @Param("completed") Boolean completed, @Param("id") Integer id);

    @Delete("DELETE FROM todo_list WHERE id=#{id}")
    int delTask(@Param("id") Integer id);

}
