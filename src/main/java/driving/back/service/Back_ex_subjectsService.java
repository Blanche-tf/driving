package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_Ex_subjectsDAO;
import driving.entity.Ex_subjects;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Back_ex_subjectsService {
    @Resource
    Back_Ex_subjectsDAO back_ex_subjectsDAO;

    //    增
    public int add(Ex_subjects ex_subjects){
        return back_ex_subjectsDAO.insert(ex_subjects);
    }

    //    删
    public int del(int sid){
        return back_ex_subjectsDAO.deleteByPrimaryKey(sid);
    }

    public PageData<Ex_subjects> findAll(int page, int limit, String name){
        PageHelper.startPage(page,limit);
        List<Ex_subjects> ex_subjects1 = back_ex_subjectsDAO.findAll(name);
        PageInfo<Ex_subjects> pageInfo=new PageInfo<Ex_subjects>(ex_subjects1);
        PageData<Ex_subjects> pd = new PageData<Ex_subjects>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(ex_subjects1);//当前页的数据
        return  pd;
    }
    
    public Ex_subjects findById(Integer sid){
        return back_ex_subjectsDAO.selectByPrimaryKey(sid);
    }

    public int update(Ex_subjects ex_subjects){
        return  back_ex_subjectsDAO.updateByPrimaryKey(ex_subjects);
    }
    
    

}
