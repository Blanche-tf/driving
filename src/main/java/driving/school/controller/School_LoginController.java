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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller("school_login")
@RequestMapping("school_login")
//@SessionAttributes(value = {"phone"})
public class School_LoginController {
    private static final String PREFIX = "school/views/";

    @Resource
    School_LoginService schoolLoginService;

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object>  login(String phone, String password, HttpSession session){
        Map<String,Object>  login1 = schoolLoginService.SchoolLogin(phone,password);
//        System.out.println("phone = " + phone);
//        System.out.println("password = " + password);
//        System.out.println("login:"+login1);
        if (login1!=null){
           // System.out.println("login1  = " + login1);
            session.setAttribute("schoolLogin",login1);
            return login1 ;
        }else{
            Map<String,Object> map = new HashMap<>();
            map.put("loginerror","error ");
            //System.out.println("login2 = " + map);
            return map ;
        }

    }


    @RequestMapping("loginForget")
    @ResponseBody
    public Map<String,Object> SchoolForget(String phone){
        //System.out.println("phone = " + phone);
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
    //@ResponseBody
    public String loginForgetSubmit(int uid,String phone, Model model){
       // System.out.println("phonehhhhh = " + phone);
        model.addAttribute("uid",uid);
        model.addAttribute("phone",phone);
        return "/school/views/user/forgetSubmit";
    }


    @RequestMapping("loginResetSubmit")
    @ResponseBody
    public int SchoolResetSubmit(Jx_user jx_user,HttpSession session){
        //System.out.println("jx_user = " + jx_user);
        session.removeAttribute("schoolLogin");
        int i =   schoolLoginService.SchoolResetSubmit(jx_user);
       // System.out.println("i = " + i);
        return i;
    }



    @RequestMapping("register")
    @ResponseBody
    public int register(Jx_user jx_user){
       // System.out.println("jx_user = " + jx_user);
       //System.out.println("login");
        int i =  schoolLoginService.SchoolRegister(jx_user);
        return i;
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("schoolLogin");
        //System.out.println("phone:"+session.getAttribute("phone"));
        return "/school/views/user/login";
    }

    @RequestMapping("SchoolUpdate_pwd")
    public String SchoolUpdate_pwd(){
        return "/school/views/set/user/test";
    }

}
