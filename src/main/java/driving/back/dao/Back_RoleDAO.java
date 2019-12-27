package driving.back.dao;

import driving.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Back_RoleDAO extends tk.mybatis.mapper.common.Mapper<Role> {
    // 条件查询:编号,角色名称
    @Select("SELECT * FROM role where concat(rid,rname) like concat('%',CONCAT(#{param1}),'%')")
    List<Role> findAll(String parm);

    //查询职务部门信息
    @Select("select r.*,dname from dept d\n" +
            "join role r on d.did = r.did")
    List<Map<String,Object>> queryRole();

    //根据部门编号查询对应职务信息
    @Select(" select * from role where did = #{param1}")
    List<Role> findRoleByDeptId(int deptId);

}