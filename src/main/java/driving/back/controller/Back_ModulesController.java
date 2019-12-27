package driving.back.controller;



import driving.back.service.Back_ModulesService;
import driving.entity.Emp;
import driving.util.ModulesNode;
import driving.util.ModulesNodeTree;
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

    // 分配权限
    @RequestMapping("modules_role")
    @ResponseBody
    public boolean modules_role(String[] modules,Integer rid){
        return  modelsService.modules_role(rid, modules);
    }

    // 分配权限的树形菜单
    @RequestMapping("getTreeModule")
    @ResponseBody
    public List<ModulesNodeTree> getTreeModule(Integer rid){
        System.out.println("分配权限:"+rid);
        return modelsService.getTreeModule(rid);
    }


    //左边垂直树形菜单
    @RequestMapping("getModules")
    @ResponseBody
    public List<ModulesNode> getModules(HttpSession session){
        Integer posId = (Integer) session.getAttribute("posId");
        System.out.println("pososos:"+session.getAttribute("posId"));
        System.out.println("一帆驾校菜单:"+modelsService.getTree(posId));
        return modelsService.getTree(posId);
    }

}