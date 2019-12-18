package driving.school.dao;


import driving.entity.Jx_user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface School_LoginDAO extends tk.mybatis.mapper.common.Mapper<Jx_user> {

    //添加驾校账号
    @Insert("insert into jx_user(uname,uing,phone,password,intime,balance,aid,state) " +
            " values(#{uname},#{uing},#{phone},#{password},#{intime},#{balance},#{aid},#{state})")
    int SchoolRegister(Jx_user jx_user);

    //查询驾校账号
    @Select("select * from jx_user where phone=#{param1} and password=#{param2} ")
    Map<String,Object> SchoolLogin(String phone, String password);

    //忘记查询驾校账号
    @Select("select * from jx_user where phone=#{param1}")
    Map<String,Object> SchoolForget(String phone);

    //修改忘记驾校账号
//    @Select("update jx_user set uname=#{uname},uing= #{uing},phone=#{phone},password=#{password}," +
//            " intime=#{intime},balance=#{balance},aid=#{aid},state=#{state} where uid=#{uid}" +
//            "")
//    //@Select("update jx_user set password = #{param1} where phone =#{param2}")
    //int SchoolResetSubmit(Jx_user jx_user);

}
