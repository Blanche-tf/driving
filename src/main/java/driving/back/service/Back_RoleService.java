package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_RoleDAO;
import driving.entity.Role;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Back_RoleService {
    @Resource
    Back_RoleDAO roleDAO;

    //查询所有角色
    public PageData<Role> findAll(int page,int limit,String param){
        PageHelper.startPage(page,limit);
        // 条件查询:编号,角色名称
        List<Role> roles = roleDAO.findAll(param);
        PageInfo<Role> pageInfo=new PageInfo<Role>(roles);
        PageData<Role> pd = new PageData<Role>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(roles);//当前页的数据
        return pd;
    }



    //显示职务部门信息
    public PageData queryRole(){
        PageData pageData = new PageData();
        pageData.setData(roleDAO.queryRole());
        return pageData;
    }

    //职务添加
    public int addRole(Role role){
        return roleDAO.insert(role);
    }

    //职务删除
    public int delRole(int roleId){
        return roleDAO.deleteByPrimaryKey(roleId);
    }

    //职务修改
    public int updateRole(Role role){
        return roleDAO.updateByPrimaryKey(role);
    }

    //职务修改显示
    public Role updateShowRole(int roleId){
        return roleDAO.selectByPrimaryKey(roleId);
    }

    //根据部门编号查询对应的职务信息
    public List<Role> findRoleByDeptId(int deptId){
        return roleDAO.findRoleByDeptId(deptId);
    }
}