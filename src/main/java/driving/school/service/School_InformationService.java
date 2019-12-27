package driving.school.service;

import driving.entity.Jx_user;
import driving.entity.Jx_user_info;
import driving.school.dao.School_InformationDAO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class School_InformationService {
    @Resource
    School_InformationDAO school_informationDAO;

    //查询驾校设施
    public List<Map<String,Object>> jx_info(){
        return  school_informationDAO.jx_info();
    }

    //查询个人驾校设施
    public List<Map<String,Object>> jx_infoUser(Integer uid){
        return  school_informationDAO.jx_infoUser(uid);
    }



    ////删除驾校设施
    public Integer jxinfoDeleAll(Integer uid){
        return school_informationDAO.jxinfoDeleAll(uid);
    }



    //添加驾校设施
    public Integer jxinfoAdd(Integer iId,Integer uId){
        return school_informationDAO.jxinfoAdd(iId,uId);
    }
    //查询驾校信息
    public  Jx_user jx_userFind(Integer uid){
        return school_informationDAO.jx_userFind(uid);
    }

    //修改个人驾校信息
    public  int jx_userUpdate(String uname,String phone,String uing,int uid){
        return school_informationDAO.jx_userUpdate(uname,phone,uing,uid);
    }

}
