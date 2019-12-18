package driving.back.controller;

import driving.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller("back_login")
@RequestMapping("back_login")
public class LoginController {

    private static final String PREFIX = "back/views/";

    //这个路径只是用来登录的，是否真的存在无所谓
    @RequestMapping("login-checkss")
    public String loginCheck(){
        System.out.println("login-check");
        return PREFIX+"index";
    }

    //登录成功
    @RequestMapping("login-success")
    public String loginSuccess(HttpSession session){
        System.out.println("login-success");
        return PREFIX+"index";
    }

    //登录失败
    @RequestMapping("login-error")
    public String loginError(HttpSession session){
        Emp emp = (Emp) session.getAttribute("back_login");
        if (emp == null){
            session.setAttribute("back_msg","账号或密码错误");
        }else if (emp.getState() == 1){
            session.setAttribute("back_msg","该账户已被禁用");
        }
        return PREFIX+"user/login";
    }

    //登录失败
    @RequestMapping("logoutUrl")
    public String logoutSuccessUrl(){
        System.out.println("logoutSuccessUrl");
        return PREFIX+"index";
    }
}