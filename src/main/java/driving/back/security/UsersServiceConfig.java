package driving.back.security;
import driving.back.service.Back_EmpService;
import driving.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//用户详细信息配置类:获取用户真实详细信息
@Component
public class UsersServiceConfig implements UserDetailsService {

    @Autowired
    Back_EmpService usersService;

    @Autowired
    HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名回去用户信息
        Emp user=usersService.selectByUname(s);
        // 把登录人的信息存在session
        session.setAttribute("back_login",user);
        System.out.println("登录人的信息;"+session.getAttribute("back_login"));

        // 用户名查到 并且账号状态为0
        if(null!=user && user.getState() == 0)
        {
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

            //根据用户的名称去查询职位的编号
            Integer posId = usersService.findPosIdByUserName(s);
            //将posid存到session中 方便在controller中获取
            System.out.println("posId"+posId);
            // 把角色编号存在seesion
            session.setAttribute("posId",posId);
            String role=posId.toString();
            //获取对应的权限
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            return new User(user.getUserName(),user.getPassword(), list);
        }
        return null;
    }
}