package driving.school.controller;

import driving.entity.Ex_model;
import driving.school.service.School_Ex_modelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("school_ex_model")
public class School_ex_modelController {
    @Resource
    School_Ex_modelService school_ex_modelService;

   // 查询全部
    @RequestMapping("findAll")
    @ResponseBody
    public List<Ex_model> findAll(){
        return school_ex_modelService.findAll();
    }
}