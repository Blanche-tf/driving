package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_Kh_userDAO;
import driving.entity.Kh_user;
import driving.util.PageData;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Back_Kh_userService {
    @Resource
    Back_Kh_userDAO back_kh_userDAO;

    // 查询全部
    public PageData<Kh_user> findAll(int page, int limit, Kh_user kh_user) {
        PageHelper.startPage(page, limit);
        // 创建Example对象 允许指定sql后的where条件
        Example example = new Example(Kh_user.class);
        // new一个当前example的内部类Criteria
        Example.Criteria criteria = example.createCriteria();
        // 用户名不为空
        if (kh_user.getUname() != null && !"".equals(kh_user.getUname())) {
            criteria.andLike("uname", "%" + kh_user.getUname() + "%");
        }
        // 账户不能为空
        if (kh_user.getuAccout() != null && !"".equals(kh_user.getuAccout())) {
            criteria.andLike("uaccount", "%" + kh_user.getuAccout() + "%");
        }
        // 查询
        List<Kh_user> kh_users = back_kh_userDAO.selectByExample(example);
        // 分页
        PageInfo<Kh_user> pageInfo = new PageInfo<Kh_user>(kh_users);
        // 封装PageData
        PageData<Kh_user> pd = new PageData<>();
        pd.setData(pageInfo.getList());
        pd.setCount((int) pageInfo.getTotal());
        return pd;
    }

    // 修改，账号状态
    public int upKh_user(Kh_user kh_user){
        return back_kh_userDAO.updateByPrimaryKeySelective(kh_user);
    }
}