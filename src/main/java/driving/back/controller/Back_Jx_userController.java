package driving.back.controller;

import driving.back.service.Back_Jx_userService;
import driving.entity.Jx_user;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("back_jx_user")
public class Back_Jx_userController {
    @Resource
    Back_Jx_userService back_jx_userService;

    // 查询全部驾校信息: 模糊查询,分页    uname:驾校名称
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<Jx_user> findAll(int page, int limit, String uname){
        System.out.println("page+limit+uname = " + page+limit+uname);
        return back_jx_userService.findAll(page,limit,uname);
    }

    // 修改状态
    @RequestMapping("upState")
    @ResponseBody
    public int upState(Jx_user jx_user){
        return back_jx_userService.upJxUser(jx_user);
    }

    // 根据驾校编号 获取驾校的基本信息
    @RequestMapping("findByJx_userId")
    public int findByJx_userId(Integer uid){
        return 1;/*back_jx_userService.upJxUser(jx_user);*/
    }
}
