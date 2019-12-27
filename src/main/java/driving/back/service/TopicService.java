package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.TopicDAO;
import driving.entity.Ex_topic;
import driving.entity.Jx_ambient;
import driving.util.PageData;
import driving.util.TopicUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

// 事务管理报错回滚
@Transactional(rollbackFor = Exception.class)
@Service("back_topicService")
public class TopicService {
    @Resource
    TopicDAO topicDAO;

    // 显示题库分页,模糊搜索
    public PageData<Map<String,Object>> findAll(int page,int limit,String param){
        PageHelper.startPage(page,limit);
        List<Map<String,Object>> exTopics = topicDAO.findAll(param);
        // 分页
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(exTopics);
        PageData<Map<String,Object>> pd = new PageData<Map<String,Object>>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(exTopics);//当前页的数据
        return pd;
    }


    // 更新题库
    //测试类型，rand：随机测试（随机100个题目），order：顺序测试（所选科目全部题目）
    public Boolean upTopic() {
        // 清空表格数据
        int delCount = topicDAO.truncateTab();

        Ex_topic ex_topic = new Ex_topic();
        // 计算执行次数
        int count = 0;

        // 驾考类型:c1,c2,a1,a2,b1,b2
        String[] model = {"c1", "c2", "a1", "a2", "b1", "b2"};

        // 考试类型类型: 科一,科四(科四可省略题一样)

        // 添加科一
        ex_topic.setSid(1);
        for (int i = 0; i < model.length; i++) {
            System.out.println("i = " + i);
            // 驾考类型:c1,c2,a1,a2,b1,b2
            ex_topic.setMid(i+1);

            List<Map<String, String>> topics = (List<Map<String, String>>) TopicUtil.getRequest1("1", model[i], "order");

            for (int j = 0; j < topics.size(); j++) {
                Map<String, String> topic = topics.get(j);
                // 问题
                ex_topic.setQuestion(topic.get("question"));
                // 答案
                ex_topic.setAnswer(topic.get("answer"));
                // A B C D
                ex_topic.setItem1(topic.get("item1"));
                ex_topic.setItem2(topic.get("item2"));
                ex_topic.setItem3(topic.get("item3"));
                ex_topic.setItem4(topic.get("item4"));
                // 帮助描述
                ex_topic.setExplains(topic.get("explains"));
                // 图片路径
                ex_topic.setUrl(topic.get("url"));

                // 添加
                count += topicDAO.insert(ex_topic);
            }
        }



        List<Map<String, String>> topics = (List<Map<String, String>>) TopicUtil.getRequest1("4", "", "order");
        System.out.println("topics = " + topics);
        // 添加科四
        ex_topic.setSid(4);
        // 驾考类型:c1,c2,a1,a2,b1,b2 可省略
        ex_topic.setMid(0);
        for (int i = 0; i < topics.size(); i++) {
            Map<String, String> topic = topics.get(i);
            // 问题
            ex_topic.setQuestion(topic.get("question"));
            // 答案
            ex_topic.setAnswer(topic.get("answer"));
            // A B C D
            ex_topic.setItem1(topic.get("item1"));
            ex_topic.setItem2(topic.get("item2"));
            ex_topic.setItem3(topic.get("item3"));
            ex_topic.setItem4(topic.get("item4"));
            // 帮助描述
            ex_topic.setExplains(topic.get("explains"));
            // 图片路径
            ex_topic.setUrl(topic.get("url"));
            // 添加
            count += topicDAO.insert(ex_topic);
        }

        System.out.println("count = " + count);
        return delCount>=0 && count > 0?true:false;
    }
}