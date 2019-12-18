package driving.school.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.entity.Jx_ambient;
import driving.school.dao.School_imgDAO;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class School_imgService {
    @Resource
    School_imgDAO schoolimgDAO;

    //添加驾校图片
    public int schoolimgAdd(Jx_ambient jx_ambient){
        return schoolimgDAO.schoolimgAdd(jx_ambient);
    }
    //查询驾校图片
    public PageData<Jx_ambient> schoolAll(int page,int limit){
        PageHelper.startPage(page,limit);
        List<Jx_ambient> school = schoolimgDAO.schoolAll();
        PageInfo<Jx_ambient> pageInfo=new PageInfo<Jx_ambient>(school);
        PageData<Jx_ambient> pd = new PageData<Jx_ambient>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(school);//当前页的数据
        return pd;
    }

}
