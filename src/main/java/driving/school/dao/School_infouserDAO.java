package driving.school.dao;

import driving.entity.Jx_user_info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface School_infouserDAO {

    @Select("select * from jx_user_info where uId=#{uId}")
    List<Jx_user_info> userinfo();

}
