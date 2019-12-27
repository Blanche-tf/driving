package driving.back.dao;

import driving.entity.Ex_model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Back_Ex_modelDAO extends tk.mybatis.mapper.common.Mapper<Ex_model> {



    @Select("<script> select * from ex_model  m " +
            "<where>" +
            "<if test=\"name != null and name != '' \">\n" +
            "   and m.model like concat(concat('%',#{name}),'%') \n" +
            " </if>" +
            "</where>" +
            "</script>")

    List<Ex_model>findAll(String name);
    
}
