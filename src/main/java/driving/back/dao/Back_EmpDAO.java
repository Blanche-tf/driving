package driving.back.dao;

import driving.entity.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Back_EmpDAO extends Mapper<Emp> {
    //根据用户名查询对应角色
    @Select("select  roleId from emp where username = #{param1}")
    Integer findPosIdByUserName(String userName);

    @Insert("insert into emp(userName,password,ename)\n" +
            "values (#{userName},#{password},#{ename})")
    int addUsers(Emp emp);

    //登录
    @Select("select * from emp where binary username = #{param1}")
    Emp loginOne(String username);


    //查询  员工分页模糊查询
    @Select("<script>" +
            "select d.did,d.dname,e.eId,e.state,e.eName,e.sex,e.inTime,e.operationUid,e.operationTime,e.empimg,\n" +
            " e.idcard,e.phone,r.rid,rname,r.rId,rName\n" +
            "from  emp e\n" +
            "join role r  on r.rid = e.roleId\n" +
            "join dept d on d.did = r.did" +
            "<where>\n" +
            "            <if test=\"param1!=null and param1 != ''\">\n" +
            "                and concat(e.ename,e.sex,e.idcard,e.phone) like '%${param1}%'\n" +
            "            </if>\n" +
            "            <if test=\"param2!=null and param2 != ''\">\n" +
            "                and r.rid = #{param2}\n" +
            "            </if>\n" +
            "            <if test=\"param3!=null and param4!=null and param3 != '' and param4 != ''\">\n" +
            "                and e.inTime between  #{param3} and #{param4}\n" +
            "            </if>\n" +
            "        </where>" +
            "</script>")
    List<Map<String,Object>> query(String param, Integer posId, String startTime, String endTime);

    //添加员工信息
    @Insert("insert into emp (eName,sex,inTime,idcard,phone,roleid,operationUid,operationTime)\n" +
            "values(#{eName},#{sex},NOW(),#{idcard},#{phone},#{roleid},#{operationUid},NOW())")
    int addEmp(Emp emp);

    //修改显示
    @Select("select e.*,d.did  from  emp e\n" +
            "INNER JOIN role r on e.roleid=r.rid\n" +
            "INNER JOIN dept d on r.did = d.did\n" +
            "where e.eId =  #{param1}")
    Map<String,Object> updateShowEmp(String empId);


    //修改员工信息
    @Update("update emp\n" +
            "  set eName = #{eName} ,sex = #{sex},idcard=#{idcard},\n" +
            "phone=#{phone},roleid = #{roleid},\n" +
            "operationUid = #{operationUid},operationTime = NOW()\n" +
            "where eId = #{eId}")
    int updateEmp(Emp emp);

    //修改员工状态为离职
    @Update("update emp set state = 1 ,outTime=NOW() where eId = #{param1}")
    int empLeave(Integer empId);
}