package driving.back.dao;

import driving.entity.Ex_topic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicDAO extends tk.mybatis.mapper.common.Mapper<Ex_topic> {
    // 清空表格数据
    @Delete("TRUNCATE table ex_topic")
    int truncateTab();
}