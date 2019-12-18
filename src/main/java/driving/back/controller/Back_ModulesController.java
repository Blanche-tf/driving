package driving.back.controller;



import driving.back.service.Back_ModulesService;
import driving.entity.Emp;
import driving.util.ModulesNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("back_modules")
public class Back_ModulesController {
    @Autowired
    Back_ModulesService modelsService;


    @RequestMapping("getModules")
    @ResponseBody
    public List<ModulesNode> getModules(HttpSession session){
        Integer posId = (Integer) session.getAttribute("posId");
        System.out.println("pososos:"+session.getAttribute("posId"));
        System.out.println(modelsService.getTree(posId));
        return modelsService.getTree(posId);
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