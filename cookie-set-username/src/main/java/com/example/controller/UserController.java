package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")  //lưu trữ thông tin của model attribute có tên là user
public class UserController {
    @ModelAttribute("user") //nhận user trả về từ view, sau đó đưa vào session
    public User setUpUserForm(){
        return new User();
    }
    @RequestMapping("/index")
    public String loginForm(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model){
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue",cookie);
        return "login";
    }
    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, @CookieValue(value = "setUser", defaultValue = "") String setUser, Model model,
                        HttpServletRequest request, HttpServletResponse response){
        if(user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")){
//            if(user.getEmail() != null)
                setUser = user.getEmail();

            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(12*60*60);
            response.addCookie(cookie); //response sẽ trả cookie về cho view

            Cookie[] cookies = request.getCookies();
            for (Cookie ck: cookies){   //lấy cookie có tên 'setUser' sau đó truyền vào model
                if(ck.getName().equals("setUser")){
                    model.addAttribute("cookieValue",ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue",ck);
                    break;
                }
            }
            model.addAttribute("message","Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser",setUser);
            model.addAttribute("cookieValue",cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }
}
