package driving.back.dao;

import driving.entity.Ex_subjects;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Back_Ex_subjectsDAO extends tk.mybatis.mapper.common.Mapper<Ex_subjects> {
    
    @Select("<script> select * from ex_subjects  s " +
            "<where>" +
            "<if test=\"name != null and name != '' \">\n" +
            "   and s.subject like concat(concat('%',#{name}),'%') \n" +
            " </if>" +
            "</where>" +
            "</script>")
    List<Ex_subjects> findAll(String name);


}
