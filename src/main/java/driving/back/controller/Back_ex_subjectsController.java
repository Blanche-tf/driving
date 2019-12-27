package driving.back.controller;

import driving.back.service.Back_ex_subjectsService;
import driving.entity.Ex_subjects;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("back_ex_subjects")
public class Back_ex_subjectsController {
    @Resource
    Back_ex_subjectsService back_ex_subjectsService;
    //    增
    @RequestMapping("add")
    @ResponseBody
    public int add(Ex_subjects ex_subjects){
        System.out.println("ex_subjects = " + ex_subjects);
        return back_ex_subjectsService.add(ex_subjects);
    }


    @RequestMapping("delete")
    @ResponseBody
    public int  delete(int sid){
        return back_ex_subjectsService.del(sid);
    }

    @RequestMapping("updateShow")
    public String  updateShow(Ex_subjects ex_subjects, Model model){
        Ex_subjects ex_subjects1 = back_ex_subjectsService.findById(ex_subjects.getSid());
        model.addAttribute("ex_subjects",ex_subjects1);
        model.addAttribute("opt","upd");
        return "back/topicManager/Ex_subjectupdate";
    }

    @RequestMapping("update")
    @ResponseBody
    public int  update(Ex_subjects ex_subjects){
        int i = back_ex_subjectsService.update(ex_subjects);
        return i;
    }
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<Ex_subjects> findAll(int page, int limit, String name){
        return  back_ex_subjectsService.findAll(page,limit,name);
    }
}
