package driving.back.controller;

import driving.back.service.Back_ex_modelService;

import driving.entity.Ex_model;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("back_ex_model")
public class Back_ex_modelController {
    @Resource
    Back_ex_modelService
    back_ex_modelService;

    //    增
    @RequestMapping("add")
    @ResponseBody
    public int  add(Ex_model ex_model){
        return back_ex_modelService.add(ex_model);
    }

    @RequestMapping("delete")
    @ResponseBody
    public int  delete(int mid){
        return back_ex_modelService.del(mid);
    }

    @RequestMapping("updateShow")
    public String  updateShow(Ex_model ex_model, Model model){
        Ex_model e = back_ex_modelService.findById(ex_model.getMid());
        model.addAttribute("ex_model",e);
        model.addAttribute("opt","upd");
        return "back/topicManager/Ex_modelupdate";
    }

    @RequestMapping("update")
    @ResponseBody
    public int  update(Ex_model ex_model){
        System.out.println("ex_model = " + ex_model);
        return back_ex_modelService.update(ex_model);
    }
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<Ex_model> findAll(int page, int limit, String name){
        return  back_ex_modelService.findAll(page,limit,name);
    }
}
