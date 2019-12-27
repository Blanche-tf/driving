package driving.treasure.controller;


import driving.entity.Kh_user;
import driving.treasure.service.Treasure_LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller("treasure_login")
@RequestMapping("treasure_login")
public class Treasure_LoginController {

    @Resource
    Treasure_LoginService treasure_loginService;


    @RequestMapping("register")
    @ResponseBody
    public int registerAdd(Kh_user kh_user){
          return treasure_loginService.treasureAdd(kh_user);
    }

    @RequestMapping("treasureLogin")
    @ResponseBody
    public Map<String,Object> login(String uAccout, String password, HttpSession session){
        Map<String,Object>  login1 = treasure_loginService.treasureLogin(uAccout,password);
        if (login1!=null){
            session.setAttribute("treasureLogin",login1);
           //System.out.println("login1 = " + login1);
            return login1 ;
        }else{
            Map<String,Object> map = new HashMap<>();
            map.put("treasureLoginError","error");
            return map ;
        }
    }

    @RequestMapping("index")
    public String index(){
       // System.out.println("treasure:"+session.getAttribute("treasureLogin"));
        return "/treasure/index";
    }



}
