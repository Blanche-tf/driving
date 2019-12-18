package driving.back.dao;

import driving.entity.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@org.apache.ibatis.annotations.Mapper
public interface Back_EmpDAO extends Mapper<Emp> {
    //根据用户名查询对应角色
    @Select("select  roleId from emp where username = #{param1}")
    Integer findPosIdByUserName(String userName);

    @Insert("insert into emp(userName,password,ename)\n" +
            "values (#{userName},#{password},#{ename})")
    int addUsers(Emp emp);

    //登录
    @Select("select * from emp where username = #{param1}")
    Emp loginOne(String username);

}
