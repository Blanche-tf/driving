package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_CityDAO;
import driving.entity.City;
import driving.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Back_CityService {
    @Resource
    Back_CityDAO back_cityDAO;

    // 查询全部
    public PageData<City> findAll(Integer page,Integer limit,String param1){
        PageHelper.startPage(page,limit);
        PageInfo<City> pageInfo = new PageInfo<>(back_cityDAO.findAll(param1));
        // 分页
        PageData<City> pd = new PageData<>();
        pd.setData(pageInfo.getList());     //当前页的数据
        pd.setCount((int) pageInfo.getTotal()); // 总条数
        return pd;
    }
}