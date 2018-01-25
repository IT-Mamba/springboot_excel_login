package com.yht.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yht.WebSecurityConfig;
import com.yht.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account,Model model){
        return "index";
    }
    
    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException {
        return "login";
    }
    
    @PostMapping("/loginVerify")
    public String loginVerify(String username,String password,String checkcode,HttpSession session,Map<String,Object> map){
        String code =(String) session.getAttribute("number");
        if(checkcode==null||checkcode.length()==0||!code.equalsIgnoreCase(checkcode)){
        	map.put("result", "验证码错误！");
            return "login";
        } else {
        	boolean verify = loginService.verifyLogin(username,password);
            if (verify) {
                session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
                return "index";
            } else {
            	map.put("result", "用户名或密码错误！");
                return "login";
            }
        }
    }

    @GetMapping("/createImage")
    public void createImage(HttpServletResponse response, HttpSession session) throws IOException {
        BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.fillRect(0, 0, 80, 20);
        //获取生成的验证码
        String code = getNumber();
        //绑定验证码
        session.setAttribute("number", code);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.drawString(code, 5, 25);
        //设置消息头
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "jpeg", os);
    }
    public String getNumber(){
        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklnmopqrstuvwxyz";
        String code = "";
        for(int i= 0;i<4;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }
        return code;
    }
	
    
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "login";
    }
}
