package com.famrer.springdemo.dao;

import com.famrer.springdemo.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByUsername(@Param("username") String username);

    @Insert("INSERT INTO user (username, `password`, email) VALUES (#{username}, #{password}, #{email})")
    int addUser(
            @Param("username") String username,
            @Param("password") String password,
            @Param("email") String email);

}
