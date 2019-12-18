package driving.school.controller;

import driving.school.service.ModulesService;
import driving.util.ModulesNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("school_modules")
public class ModulesController {
    @Autowired
    ModulesService modelService;


    @RequestMapping("getModules")
    @ResponseBody
    public List<ModulesNode> getModules(){
       // System.out.println("进入");
        // System.out.println(modelsService.getTree());
        return modelService.getTree();
    }

    /*//树形菜单
    @RequestMapping("getTree")
    @ResponseBody
    public List<ModulesNode> getTree(HttpSession session){
        Integer posId =  Integer.parseInt(session.getAttribute("posId").toString());
        System.out.println("===========posId:"+posId);
        return modelsService.getTree(posId);
    }*/
}
