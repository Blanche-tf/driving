package driving.school.controller;

import driving.entity.Jx_user;
import driving.school.service.School_LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller("school_login")
@RequestMapping("school_login")
public class School_LoginController {
    private static final String PREFIX = "school/views/";

    @Resource
    School_LoginService schoolLoginService;

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object>  login(String phone, String password, HttpSession session){
        Map<String,Object>  login1 = schoolLoginService.SchoolLogin(phone,password);
        if (login1!=null){
            session.setAttribute("schoolLogin",login1);
            System.out.println("login1 = " + login1);
            return login1 ;
        }else{
            Map<String,Object> map = new HashMap<>();
            map.put("loginerror","error");
            return map ;
        }

    }

    @RequestMapping("index")
    public String index(){
        return PREFIX+"index";
    }


    @RequestMapping("loginForget")
    @ResponseBody
    public Map<String,Object> SchoolForget(String phone){
        Map<String,Object> login1 = schoolLoginService.SchoolForget(phone);
        if (login1!=null){
            return login1 ;
        }else{
            Map<String,Object> map = new HashMap<>();
            map.put("loginerror","error ");
            return map ;
        }
    }

    @RequestMapping("loginResetShow")
    public String loginForgetSubmit(int uid,String phone, Model model){
        model.addAttribute("uid",uid);
        model.addAttribute("phone",phone);
        return "/school/views/user/forgetSubmit";
    }



    @RequestMapping("loginResetSubmit")
    @ResponseBody
    public int SchoolResetSubmit(Jx_user jx_user,HttpSession session){
        session.removeAttribute("schoolLogin");
        int i =   schoolLoginService.SchoolResetSubmit(jx_user);
        return i;
    }



    @RequestMapping("register")
    @ResponseBody
    public int register(Jx_user jx_user){
        int i =  schoolLoginService.SchoolRegister(jx_user);
        return i;
    }

    @RequestMapping("lo")
    public String logout(HttpSession session){
        System.out.println(" 退出 ");
        session.removeAttribute("schoolLogin");
        return  PREFIX+"/user/login.html";
    }


    @RequestMapping("SchoolUpdate_pwd")
    public String SchoolUpdate_pwd(){
        return PREFIX+"/set/user/password";
    }
}