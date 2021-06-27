package com.famrer.springdemo.Interceptor;

import com.famrer.springdemo.po.RestJson;
import com.famrer.springdemo.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@CrossOrigin(origins = "*")
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         *  控制器处理前拦截
         *  处理token验证
         */

        response.setContentType("application/json;charset=utf-8");
        try {

            String jwt = request.getHeader("authorization");
            jwt = jwt.split("Bearer ")[1];
//            System.out.println(jwt);
            Object payLoadData = JwtUtils.parse(jwt);
//            System.out.println(payLoadData);
            request.setAttribute("user", payLoadData);
            return true;
        } catch (ExpiredJwtException e) {
            response.setStatus(401);
            response.getWriter().println(RestJson.make(401, "token已过期").toString());
        }catch (NullPointerException e){
            response.setStatus(401);
            response.getWriter().println(RestJson.make(401, "找不到token").toString());
        } catch (Exception e) {
            response.setStatus(401);
            response.getWriter().println(RestJson.make(401, "token无效").toString());
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /**
         * 控制器处理后拦截
         */
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /**
         * 响应体发送后 处理的任务
         */
    }
}
