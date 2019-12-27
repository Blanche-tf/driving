package driving.back.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import driving.back.dao.Back_Jx_userDAO;
import driving.entity.Jx_user;
import driving.util.PageData;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class Back_Jx_userService {
    @Resource
    Back_Jx_userDAO back_jx_userDAO;




    // 根据驾校编号查询



    // 查询全部驾校信息: 模糊查询,分页    uname:驾校名称
    public PageData<Jx_user> findAll(int page, int limit, String uname){
        // 分页
        PageHelper.startPage(page,limit);
        // Example对象允许在sql操作时手动指定where 条件：
        Example example = new Example(Jx_user.class);
        List<Jx_user> jx_users =  new ArrayList<Jx_user>();
        if (uname != null && !uname.equals("")){
            //new一个当前example的内部类Criteria
            Example.Criteria criteria = example.createCriteria();
            //  Example.Criteria对象加入自定义SQL
            criteria.andLike("uname","%"+uname+"%");
            // 根据对象添加where语句查询
            jx_users = back_jx_userDAO.selectByExample(example);
        }else {
            // 没有条件查询 -- 查询全部
            jx_users = back_jx_userDAO.selectAll();
        }
        PageInfo<Jx_user> pageInfo = new PageInfo<Jx_user>(jx_users);
        // 封装PageData对象
        PageData<Jx_user> pd = new PageData<Jx_user>();
        pd.setData(pageInfo.getList());
        pd.setCount((int) pageInfo.getTotal());
        return pd;
    }

    // 禁用账户
    public int upJxUser(Jx_user jx_user){
        return back_jx_userDAO.updateByPrimaryKeySelective(jx_user);
    }
}