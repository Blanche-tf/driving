package driving.back.controller;

import driving.back.service.Back_EmpService;
import driving.entity.Emp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller("back_login")
@RequestMapping("back_login")
public class LoginController {

    @Resource
    Back_EmpService back_empService;
    @Resource
    HttpSession session;
    private static final String PREFIX = "back/views/";

    // 修改密码
    @RequestMapping("rePwd")
    @ResponseBody
    public int rePwd(Emp emp){
        System.out.println("emp = " + emp);
        // 加密
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(emp.getPassword());
        emp.setPassword(hashPass);//密码 加密

        // 从session 中获取 当前登录的用户信息
        Emp back_login = (Emp) session.getAttribute("back_login");
        emp.setEid(back_login.getEid());

        System.out.println("emp = " + emp);
        return back_empService.updEmp(emp);
    }

    //这个路径只是用来登录的，是否真的存在无所谓
    @RequestMapping("login-check")
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

    // 退出
    @RequestMapping("loginOut")
    public String loginOut(){
        System.out.println("loginOut");
        return PREFIX+"user/login";
    }

    //登录成功
    @RequestMapping("login")
    public String login(){
        System.out.println("login");
        return PREFIX+"index";
    }
}