package driving.back.service;

import driving.back.dao.Back_EmpDAO;
import driving.entity.Emp;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class Back_EmpService {
    @Resource
    Back_EmpDAO empDAO;

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
}