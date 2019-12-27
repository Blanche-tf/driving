package driving.back.service;

import driving.back.dao.Back_DeptDAO;
import driving.entity.Dept;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Back_DeptService {
    @Resource
    Back_DeptDAO deptDAO;

    //查询
    public PageData queryDept(){
        PageData PageData = new PageData();
        PageData.setData(deptDAO.selectAll());
        return PageData;
    }
    //添加
    public int addDept(Dept dept){
        return deptDAO.insert(dept);
    }

    //删除
    public int delDept(int deptId){
        return deptDAO.deleteByPrimaryKey(deptId);
    }

    //修改显示
    public Dept updateShowDept(int deptId){
        return deptDAO.selectByPrimaryKey(deptId);
    }

    //修改
    public int updateDept(Dept dept){
        return deptDAO.updateByPrimaryKey(dept);
    }
}
