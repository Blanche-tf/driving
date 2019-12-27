package driving.school.controller;

import driving.entity.Ex_model;
import driving.entity.Jx_classtype;
import driving.school.service.School_Ex_modelService;
import driving.school.service.School_jx_classtypeService;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("school_jx_classtype")
public class School_jx_classtypeController {
    @Resource
    School_jx_classtypeService school_jx_classtypeService;
    @Resource
    School_Ex_modelService school_ex_modelService;

    //    增
    @RequestMapping("add")
    @ResponseBody
    public int add(Jx_classtype jx_classtype, HttpSession session){
        Map<String,Object> schoolLogin =(Map<String,Object>) session.getAttribute("schoolLogin");
         jx_classtype.setUId((Integer) schoolLogin.get("uid"));
        return school_jx_classtypeService.add(jx_classtype);
    }


    @RequestMapping("delete")
    @ResponseBody
    public int  delete(int cId){
        return school_jx_classtypeService.del(cId);
    }

    @RequestMapping("updateShow")
    public String updateShow(Integer cId, Model model){
        Jx_classtype e = school_jx_classtypeService.findById(cId);
        List<Ex_model> ex_models = school_ex_modelService.findAll();
        model.addAttribute("school_jx_classtype",e);
        model.addAttribute("ex_models",ex_models);
        return "/school/jx_imgManager/jx_classtypeupdate";
    }

    @RequestMapping("update")
    @ResponseBody
    public int  update(Jx_classtype jx_classtype){
        System.out.println("jx_classtype = " + jx_classtype);
        int i = school_jx_classtypeService.update(jx_classtype);
        
        return i;
    }
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<Jx_classtype> findAll(int page,int limit,String name){
        return  school_jx_classtypeService.findAll(page,limit,name);
    }

    
}
