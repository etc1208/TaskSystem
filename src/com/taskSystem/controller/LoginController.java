package com.taskSystem.controller;

import com.taskSystem.service.LoginService;
import com.taskSystem.utils.LoginException;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yh on 2015/10/9.
 */
@Controller
public class LoginController {

    private LoginService loginService;
    private JSONObject jsonObject = null;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session){
        jsonObject = new JSONObject();
        jsonObject = loginService.login(username,password);

        if(jsonObject.get("success").toString().equals("true")){
            session.setAttribute("admin",username);
            return "redirect:/staff";
        }else {
            System.out.println("登陆错误信息：" + jsonObject.get("message"));
            throw new LoginException(jsonObject.get("message").toString());
        }
    }

    @ExceptionHandler(value={LoginException.class})
    public String handlerException(Exception ex,HttpServletRequest req) {
        req.setAttribute("exception",ex);
        return "login";
    }

    public LoginService getLoginService() {
        return loginService;
    }
    @Resource(name = "loginService")
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
