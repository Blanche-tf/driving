package driving.back.dao;

import driving.entity.Ex_cf;
import driving.entity.Ex_model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Back_Ex_cfDAO extends tk.mybatis.mapper.common.Mapper<Ex_cf> {

    @Select("<script> select * from ex_cf  e " +
            "<where>" +
            "<if test=\"name != null and name != '' \">\n" +
            "   and e.cname like concat(concat('%',#{name}),'%') \n" +
            " </if>" +
            "</where>" +
            "</script>")
    List<Ex_cf> findAll(String name);
}
