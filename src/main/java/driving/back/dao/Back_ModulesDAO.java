package driving.back.dao;


import driving.entity.Modules;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

   // 权限分配
   @Select("select * from modules   where parentCode = #{param1}")
   List<Modules> findByParentCodeAll(String parentCode);

   // 根据角色查询已有的权限   让复选框选中状态
   @Select("SELECT moduleCode FROM modules_role where rid =  #{param1}" )
   List<String> findByRid(Integer rId);
   // 根据角色查询已有的权限   让复选框选中状态

   // 根据角色清空所属的权限
   @Delete(" DELETE from  modules_role  where rid = #{param1}" )
   int doDelByRidModules(Integer rId);

   // 根据角色添加所属的权限
   @Insert("insert into modules_role(rid,moduleCode) \n" +
           " values(#{param1},#{param2}) " )
   int doAddByRidModules(Integer rId, Integer modules);
}
