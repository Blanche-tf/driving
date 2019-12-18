package driving.back.dao;

import driving.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Back_PermissionDAO extends tk.mybatis.mapper.common.Mapper<Permission> {
    //根据职务编号查询对应的权限
    @Select("select optname from permission where posId = #{param1}")
    List<String> findPermissionByPosId(Integer posId);
}
