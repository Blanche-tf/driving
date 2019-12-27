package driving.back.controller;

import com.alibaba.fastjson.JSONArray;
import driving.back.service.Back_DeptService;
import driving.back.service.Back_EmpService;
import driving.back.service.Back_RoleService;
import driving.entity.Emp;
import driving.entity.Role;
import driving.util.PageData;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("back_emp")
public class Back_EmpController {
    @Resource
    Back_DeptService back_deptService;
    @Resource
    Back_RoleService back_roleService;
    @Resource
    Back_EmpService back_empService;
    @Resource
    HttpSession session;


    // 定义员工增删改查路径页面
    private final String PREFIX = "back/personnel_management/";

    //员工分页显示
    @RequestMapping("pageQuery")
    @ResponseBody
    //当前是第page页  每一页limit数据
    public String pageQuery(int page, int limit, String param, Integer posId, String startTime, String endTime) {
        PageData pageData = back_empService.pageQuery(page, limit, param, posId, startTime, endTime);
        //转换成json类型
        String jsonStr = JSONArray.toJSONStringWithDateFormat(pageData, "yyyy-MM-dd HH:mm:ss");
        System.out.println("jsonStr = " + jsonStr);
        return jsonStr;
    }

    //添加员工显示
    @RequestMapping("addShowEmp")
    public String addShowEmp(Model model) {
        model.addAttribute("deptInfo", back_deptService.queryDept().getData());
        return PREFIX+"empAdd";
    }

    //根据部门获取对应的职务
    @RequestMapping("findPosByDeptId")
    @ResponseBody
    public List<Role> findPosByDeptId(int deptId) {
        return back_roleService.findRoleByDeptId(deptId);
    }

    // 添加员工  的同时应该给一个默认的账号
     @RequestMapping("addEmp")
    @ResponseBody
    public int addEmp(Emp e) {
         System.out.println("e = " + e);
        Emp emp = (Emp) session.getAttribute("back_login");
        // 操作人员
        Integer empId = (Integer) emp.getEid();
         e.setOperationUid(empId);

        //给新添加的员工添加账号
        //给默认密码并加密
         //加密
         String password = "123456";
         BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
         String hashPass = bcryptPasswordEncoder.encode(password);
         e.setPassword(hashPass);//默认的密码 加密

        return back_empService.addEmp(emp);
    }

    //修改显示
    @RequestMapping("updateShowEmp")
    public String updateShowEmp(String empId, Model model) {
        model.addAttribute("empInfo", back_empService.updateShowEmp(empId));
        model.addAttribute("deptInfo", back_deptService.queryDept().getData());
        model.addAttribute("posInfo", back_roleService.queryRole().getData());
        return PREFIX+"empUpdate";
    }

    //修改提交信息
    @RequestMapping("updateEmp")
    @ResponseBody
    public int updateEmp(Emp emp) {
        Emp e = (Emp) session.getAttribute("back_login");
        // 操作人员
        Integer empId = (Integer) e.getEid();
        emp.setOperationUid(empId);
        return back_empService.updateEmp(emp);

    }

    //离职员工 把员工状态改为1 并且把账号的状态改为1 禁用
    @RequestMapping("leaveEmp")
    @ResponseBody
    public int leaveEmp(Integer empId) {
        return back_empService.empLeave(empId);
    }
}