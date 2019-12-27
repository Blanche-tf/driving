package driving.treasure.dao;

import driving.entity.Kh_user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface Treasure_LoginDAO{

    //添加客户
    @Insert("insert into kh_user(uAccout,password) values(#{uAccout},#{password})")
    Integer treasureAdd(Kh_user kh_user);
    //查询客户
    @Select("select * from kh_user where uAccout=#{param1} and password=#{param2} ")
    Map<String,Object> treasureLogin(String uAccout, String password);


}
