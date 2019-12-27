package driving.back.controller;

import driving.back.service.Back_DeptService;
import driving.entity.Dept;
import driving.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("back_dept")
public class Back_DeptController {


    @Resource
    Back_DeptService deptService;

    //显示所有职务信息
    @RequestMapping("queryDept")
    @ResponseBody
    public PageData queryDept(){
        return deptService.queryDept();
    }

    //部门添加显示
    @RequestMapping("addShowDept")
    public String addShowDept(){
        return "/back/personnel_management/deptAdd";
    }

    //添加部门
    @RequestMapping("addDept")
    @ResponseBody
    public int addDept(Dept dept){
       return deptService.addDept(dept);
    }

    //职务修改显示
    @RequestMapping("updateShowDept")
    public String  updateShowDept(Model model, int deptId){
        Dept deptList = deptService.updateShowDept(deptId);
        model.addAttribute("deptList", deptList);
        return "/back/personnel_management/deptUpdate";
    }

    //职务修改
    @RequestMapping("updateDept")
    @ResponseBody
    public int updateDept(Dept dept){
        return  deptService.updateDept(dept);
    }

    //职务删除
    @RequestMapping("delDept")
    @ResponseBody
    public int del(int deptId){
        return deptService.delDept(deptId);
    }
}
