package driving.back.controller;

import driving.back.service.TopicService;
import driving.entity.Ex_topic;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller("back_topic")
@RequestMapping("back_topic")
public class TopicController {
    @Resource
    TopicService topicService;

    // 查询全部
    @RequestMapping("findAll")
    @ResponseBody
    public PageData<Map<String,Object>> findAll(int page, int limit, @RequestParam(defaultValue = "") String param){
        PageData<Map<String,Object>> ex_topics = topicService.findAll(page, limit, param);
        return ex_topics;
    }

    // 更新题库
    @RequestMapping("upTopic")
    @ResponseBody
    public Boolean upTopic(){
        return topicService.upTopic();
    }
}
