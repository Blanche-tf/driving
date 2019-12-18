package driving.back.service;

import driving.util.TopicUtil;
import org.springframework.stereotype.Service;

@Service("back_topicService")
public class TopicService {
    // 更新题库
    //选择考试科目类型，1：科目1；4：科目4
    //驾照类型，可选择参数为：c1,c2,a1,a2,b1,b2；当subject=4时可省略
    //测试类型，rand：随机测试（随机100个题目），order：顺序测试（所选科目全部题目）
    //getRequest1("4","a1","order");
    public Boolean upTopic(){
        TopicUtil.getRequest1("","","");
        return true;
    }
}