package driving.school.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.entity.Jx_studnet;
import driving.entity.Kh_user;
import driving.school.dao.School_studentDAO;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class School_studentService {

    @Resource
    School_studentDAO school_studentDAO;

    //添加学员信息
    public Integer school_studentAdd(Jx_studnet jx_studnet){
        return  school_studentDAO.insert(jx_studnet);
    }

    //添加客户信息
    public Integer khAdd(Kh_user kh_user){
        return  school_studentDAO.khAdd(kh_user);
    }

    //查询驾校学员信息
    public PageData<Map<String,Object>> JxStudentAll(int page, int limit,Integer jxuid,String  sName){
        PageHelper.startPage(page,limit);
        List<Map<String,Object>> jx_studnets = school_studentDAO.jxUserAll(jxuid,sName);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(jx_studnets);
        PageData<Map<String,Object>> pd = new PageData<Map<String,Object>>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(jx_studnets);//当前页的数据
        return pd;
    }


    public Map<String,Object> kuUserFind(Integer uid){
        return school_studentDAO.kuUserFind(uid);
    }

    public Integer txStudent(Integer sId){
        return  school_studentDAO.txStudent(sId);
    }

    public Integer byStudent(Integer sId){
        return  school_studentDAO.byStudent(sId);
    }

    public Integer outStudent(Integer sId){
        return  school_studentDAO.outStudent(sId);
    }


    public PageData<Map<String,Object>> studentFind(int page, int limit,Integer jxuid,Integer state,String sName){
        PageHelper.startPage(page,limit);
        List<Map<String,Object>> studentFind =  school_studentDAO.studentFind(jxuid,state,sName);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(studentFind);
        PageData<Map<String,Object>> pd = new PageData<Map<String,Object>>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(studentFind);//当前页的数据
        return pd;
    }

}
