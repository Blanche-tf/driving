package driving.back.dao;

import driving.entity.Ex_topic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TopicDAO extends tk.mybatis.mapper.common.Mapper<Ex_topic> {
    // 显示全部模糊搜索
    @Select("SELECT t.*,s.subject,m.model FROM ex_topic t LEFT JOIN ex_subjects s on t.sid = s.sid\n" +
            "LEFT JOIN ex_model m ON t.mid = m.mid \n" +
            "where CONCAT(t.question,t.explains,s.subject) \n" +
            "like concat('%',concat(#{param1},'%'))")
    List<Map<String,Object>> findAll(String param);


    // 清空表格数据
    @Delete("TRUNCATE table ex_topic")
    int truncateTab();

    // 更新题库(添加)
}