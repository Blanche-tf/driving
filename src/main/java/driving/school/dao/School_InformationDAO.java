package driving.school.dao;

import driving.entity.Jx_user;
import driving.entity.Jx_user_info;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface School_InformationDAO extends tk.mybatis.mapper.common.Mapper<Jx_user> {

    //查询驾校设施
    @Select("select * from jx_info")
    List<Map<String,Object>> jx_info();

    //查询个人驾校设施
    @Select("select iId from jx_user_info where uid = #{uid}")
    List<Map<String,Object>> jx_infoUser(Integer uid);

    //添加驾校设施
    @Select("insert into jx_user_info values(#{iId},#{uId})")
    Integer jxinfoAdd(Integer iId, Integer uId);


    //删除驾校设施
    @Delete("delete from jx_user_info where uid=#{uid}")
    Integer jxinfoDeleAll(Integer uid);


    //查询个人驾校信息
    @Select("select * from jx_user where uid=#{uid}")
    Jx_user jx_userFind(Integer uid);





//    @Select("select * from jx_user where uid=#{uid}")
//    @Results({
//            @Result(id = true,column = "uid",property = "uid"),
//            @Result(column = "uname",property = "uname"),
//            @Result(column = "uing",property = "uing"),
//            @Result(column = "phone",property = "phone"),
//            @Result(column = "password",property = "password"),
//            @Result(column = "intime",property = "intime"),
//            @Result(column = "balance",property = "balance"),
//            @Result(column = "aid",property = "aid"),
//            @Result(column = "state",property = "state"),
//            @Result(property = "jx_user_infos",column = "uid",javaType = Jx_user_info.class,
//                    many = @Many(select = "driving.school.dao.School_infouserDAO.userinfo"))
//    })
//    List<Jx_user> jx_userFind(Integer uid);


    //修改个人驾校信息
    @Update("update jx_user set uname=#{uname},phone=#{phone},uing=#{uing} where uid=#{uid} ")
    int jx_userUpdate(String uname, String phone, String uing, int uid);



}
