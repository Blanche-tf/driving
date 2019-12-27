package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_Ex_modelDAO;
import driving.entity.Ex_model;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Back_ex_modelService {
    @Resource
    Back_Ex_modelDAO
    back_ex_modelDAO;
    
    //    增
    public int add(Ex_model ex_model){
        return back_ex_modelDAO.insert(ex_model);
    }


    //    删
    public int del(int mid){
        return back_ex_modelDAO.deleteByPrimaryKey(mid);
    }

    public PageData<Ex_model> findAll(int page, int limit,String name){
        PageHelper.startPage(page,limit);

        List<Ex_model> ex_models = back_ex_modelDAO.findAll(name);
        PageInfo<Ex_model> pageInfo=new PageInfo<Ex_model>(ex_models);
        PageData<Ex_model> pd = new PageData<Ex_model>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(ex_models);//当前页的数据
        return  pd;
    }

    public Ex_model findById(Integer mid){
        return back_ex_modelDAO.selectByPrimaryKey(mid);
    }

    public int update(Ex_model ex_model){
        return  back_ex_modelDAO.updateByPrimaryKey(ex_model);
    }
}
