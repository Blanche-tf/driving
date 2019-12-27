package driving.back.dao;

import driving.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Back_CityDAO extends tk.mybatis.mapper.common.Mapper<City> {
    // 显示全部模糊搜索
    @Select("<script>" +
            "SELECT * FROM city  " +
            "<where>" +
            "   <if test=\"name != null and name != ''\">" +
            "  name=#{param1} OR pid in (SELECT id FROM city WHERE name like concat('%',#{param1},'%'))  " +
            "   </if>" +
            "</where>" +
            "</script>")
    List<City> findAll(String name);
}