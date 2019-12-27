package driving.back.controller;

import driving.back.service.Back_CityService;
import driving.entity.City;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("back_city")
public class Back_CityController {
    @Resource
    Back_CityService back_cityService;

    // 查询全部
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<City> findAll(Integer page,Integer limit,String param){
        System.out.println("param = " + param);
        return back_cityService.findAll(page,limit,param);
    }

    // 更新全国城市信息
    @RequestMapping("upCity")
    @ResponseBody
    public Boolean upCity(){
        return true;
    }
}