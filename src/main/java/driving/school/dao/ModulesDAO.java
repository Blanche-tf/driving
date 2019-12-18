package driving.school.dao;

import driving.entity.Modules;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 模块接口
 */
@org.apache.ibatis.annotations.Mapper
public interface ModulesDAO extends Mapper<Modules> {
   List<Modules> findByParentCode(String parentCode);

   // springSecurity 权限 释放驾校后台菜单路径
   @Select("SELECT moduleUrl FROM jx_modules where moduleUrl is not null or moduleUrl != ''")
   List<String> findByModuleUrl();
}
