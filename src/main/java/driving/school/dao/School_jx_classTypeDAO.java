package driving.school.dao;


import driving.entity.Ex_subjects;
import driving.entity.Jx_classtype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface School_jx_classTypeDAO extends tk.mybatis.mapper.common.Mapper<Jx_classtype> {

    @Select("<script> select * from jx_classtype  c " +
            "<where>" +
            "<if test=\"name != null and name != '' \">\n" +
            "   and c.cName like concat(concat('%',#{name}),'%') \n" +
            " </if>" +
            "</where>" +
            "</script>")
    List<Jx_classtype> findAll(String name);
}
