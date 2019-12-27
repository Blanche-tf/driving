package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_Ex_cfDAO;
import driving.entity.Ex_cf;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Back_Ex_cfService {
    @Resource
    Back_Ex_cfDAO
    back_ex_cfDAO;


    //    增
    public int add(Ex_cf ex_cf){
        return back_ex_cfDAO.insert(ex_cf);
    }

    //    删
    public int del(int cid){
        return back_ex_cfDAO.deleteByPrimaryKey(cid);
    }

    public PageData<Ex_cf> findAll(int page, int limit,String name){
        PageHelper.startPage(page,limit);
        List<Ex_cf> ex_cfs = back_ex_cfDAO.findAll(name);
        PageInfo<Ex_cf> pageInfo=new PageInfo<Ex_cf>(ex_cfs);
        PageData<Ex_cf> pd = new PageData<Ex_cf>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(ex_cfs);//当前页的数据
        return  pd;
    }

    public Ex_cf findById(Integer cid){
        return back_ex_cfDAO.selectByPrimaryKey(cid);
    }

    public int update(Ex_cf ex_cf){
        return  back_ex_cfDAO.updateByPrimaryKey(ex_cf);
    }

}
