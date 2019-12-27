package driving.school.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.entity.Ex_model;
import driving.entity.Ex_subjects;
import driving.entity.Jx_classtype;
import driving.school.dao.School_jx_classTypeDAO;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class School_jx_classtypeService {
    @Resource
    School_jx_classTypeDAO
    school_jx_classTypeDAO;

    //    增
    public int add(Jx_classtype jx_classtype){
        return school_jx_classTypeDAO.insert(jx_classtype);
    }


    //    删
    public int del(int cId){
        return school_jx_classTypeDAO.deleteByPrimaryKey(cId);
    }

    public PageData<Jx_classtype> findAll(int page, int limit, String name){
        PageHelper.startPage(page,limit);
        List<Jx_classtype> jx_classtypes = school_jx_classTypeDAO.findAll(name);
        PageInfo<Jx_classtype> pageInfo=new PageInfo<Jx_classtype>(jx_classtypes);
        PageData<Jx_classtype> pd = new PageData<Jx_classtype>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(jx_classtypes);//当前页的数据

        System.out.println("pd = " + pd);
        return  pd;
    }

    public Jx_classtype findById(Integer cId){
        return school_jx_classTypeDAO.selectByPrimaryKey(cId);
    }

    public int update(Jx_classtype jx_classtype){
        return  school_jx_classTypeDAO.updateByPrimaryKeySelective(jx_classtype);
    }
}
