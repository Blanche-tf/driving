package driving.back.controller;

import driving.back.service.Back_Ex_cfService;
import driving.entity.Ex_cf;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("back_ex_cf")
public class Back_Ex_cfController {
    @Resource
    Back_Ex_cfService
    back_ex_cfService;

    //    增
    @RequestMapping("add")
    @ResponseBody
    public int add(Ex_cf ex_cf){
        return back_ex_cfService.add(ex_cf);
    }

    @RequestMapping("delete")
    @ResponseBody
    public int  delete(int cid){
        return back_ex_cfService.del(cid);
    }

    @RequestMapping("updateShow")
    public String  updateShow(Ex_cf ex_cf, Model model){
        Ex_cf ex_cf1 = back_ex_cfService.findById(ex_cf.getCid());
        model.addAttribute("ex_cf1",ex_cf1);
        return "back/topicManager/Ex_cfupdate";
    }

    @RequestMapping("update")
    @ResponseBody
    public int  update(Ex_cf ex_cf){
        int i = back_ex_cfService.update(ex_cf);
        return i;
    }
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<Ex_cf> findAll(int page,int limit,String name){
        return  back_ex_cfService.findAll(page,limit,name);
    }
}
