package driving.back.dao;


import driving.entity.Modules;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 模块接口
 */
@org.apache.ibatis.annotations.Mapper
public interface Back_ModulesDAO extends Mapper<Modules> {
   // 权限分配
   List<Modules> findByParentCode(String parentCode, Integer posId);

   //根据角色编号查询对应的菜单执行路径
   @Select("select moduleUrl from modules_role  mr join modules m on mr.moduleCode = m.moduleCode \n" +
           "join role r on mr.rid=r.rid where r.rid=#{param1} and moduleUrl  is not null and moduleUrl != ''")
   List<String> findUrlByPosId(Integer posId);
}
