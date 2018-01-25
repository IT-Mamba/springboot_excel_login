package com.yht;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by huangds on 2017/10/24.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yht.controller.LoginController;

/**
 * 登录配置
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter{
    public final static String SESSION_KEY="username";

    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }

    public void  addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");

        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter{
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws IOException {
            HttpSession session = request.getSession();

            //判断是否已有该用户登录的session
            if(session.getAttribute(SESSION_KEY) != null){
                return true;
            }
            String name = request.getRequestURI();
            if (name.equals("/logout")){
            	String url = "/login";
            	response.sendRedirect(url);
            	return false;
            }else if (name.equals("/index")){
            	String url = "/login";
            	response.sendRedirect(url);
            	return false;
            }else {
                LoginController loginController = new LoginController();
                loginController.createImage(response,session);
                return false;
            }
            
        }
    }
}
