package driving.school.service;

import driving.entity.Jx_user;
import driving.school.dao.School_LoginDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class School_LoginService {

    @Resource
    School_LoginDAO schoolLoginDAO;

    public int SchoolRegister(Jx_user jx_user){
        return  schoolLoginDAO.SchoolRegister(jx_user);
    }

    public Map<String,Object> SchoolLogin(String phone, String password){
        return schoolLoginDAO.SchoolLogin(phone,password);
    }

    public Map<String,Object> SchoolForget(String phone){
        return schoolLoginDAO.SchoolForget(phone);
    }


    public int SchoolResetSubmit(Jx_user jx_user){
        return  schoolLoginDAO.updateByPrimaryKey(jx_user);
    }


}
