package driving.back.controller;

import driving.back.service.Back_DeptService;
import driving.back.service.Back_RoleService;
import driving.entity.Role;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("back_role")
public class Back_RoleController {
    private static final String PREFIX = "back/personnel_management/";
    // 角色
    @Resource
    Back_RoleService roleService;
    // 部门
    @Resource
    Back_DeptService deptService;

    //查询所有角色
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<Role> findAll(int page, int limit,@RequestParam(defaultValue = "") String param) {
        return roleService.findAll(page, limit, param);
    }


    //显示所有职务信息
    @RequestMapping("queryRole")
    @ResponseBody
    public PageData queryRole(){
        return roleService.queryRole();
    }

    //职务添加显示
    @RequestMapping("addShowRole")
    public String addShowRole(Model model){
        List deptInfo = deptService.queryDept().getData();
        model.addAttribute("deptInfo", deptInfo);
        return PREFIX+"posAdd";
    }

    //添加职务
    @RequestMapping("addRole")
    @ResponseBody
    public int addRole(Role role){
        System.out.println("role = " + role);
        return roleService.addRole(role);
    }

    //职务修改显示
    @RequestMapping("updateShowRole")
    public String  updateShowRole(Model model, int roleId){
        Role roleInfo = roleService.updateShowRole(roleId);
        model.addAttribute("roleInfo", roleInfo);

        PageData pageData = deptService.queryDept();
        List deptInfo = pageData.getData();
        model.addAttribute("deptInfo", deptInfo);
        return PREFIX+"posUpdate";
    }

    //职务修改
    @RequestMapping("updateRole")
    @ResponseBody
    public int updateRole(Role role){
        return  roleService.updateRole(role);
    }

    //职务删除
    @RequestMapping("delRole")
    @ResponseBody
    public int delRole(int roleId){
        return roleService.delRole(roleId);
    }
}