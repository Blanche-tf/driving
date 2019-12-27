package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_EmpDAO;
import driving.entity.Emp;
import driving.util.PageData;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Back_EmpService {
    @Resource
    Back_EmpDAO empDAO;

    // 修改:mybatis
    public int updEmp(Emp emp){
        return empDAO.updateByPrimaryKeySelective(emp);
    }


    //登录 根据用户查询对应信息
    public Emp selectByUname(String username){
        System.out.println("username："+username);
        Example example = new Example(Emp.class);
        Example.Criteria criteria = example.createCriteria();
        //property必须和实体类保持一致
        criteria.andEqualTo("userName",username);

        Emp emp = empDAO.selectOneByExample(example);

        return emp;
    }


    //登录
    public Emp loginOne(String username){
        System.out.println(username);
        return empDAO.loginOne(username);
    }

    //根据用户名查询对应职务
    public Integer findPosIdByUserName(String username){
        return empDAO.findPosIdByUserName(username);
    }


    //添加用户
    public int addUsers(Emp emp){
        return empDAO.addUsers(emp);
    }


    //分页显示
    public PageData pageQuery(int page, int limit, String param, Integer posId, String startTime, String  endTime){
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> emps = empDAO.query(param,posId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(emps) ;
        PageData pageData = new PageData();
        //pageInfo.getPageNum(),pageInfo.getSize(), (int) pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList()
        pageData.setData(pageInfo.getList());
        pageData.setCount((int) pageInfo.getTotal());
        return pageData;
    }

    //添加员工
    public int addEmp(Emp emp){
        return empDAO.addEmp(emp);
    }


    //修改员工信息
    public int updateEmp(Emp emp){
        return empDAO.updateEmp(emp);
    }



    //修改员工信息并显示
    public Map<String,Object> updateShowEmp(String empId){
        System.out.println("empId = " + empId);

        System.out.println(empDAO.updateShowEmp(empId));
        return empDAO.updateShowEmp(empId);
    }
    //离职员工信息  修改员工状态为 1 并且对应的账号进行禁用 状态也修改为1
    public int empLeave(Integer empId){
        int i = empDAO.empLeave(empId);
        return  i;
    }

}