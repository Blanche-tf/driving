package driving.back.security;

//认证生成器
import driving.back.service.Back_EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;




//认证生成器  用来生成认证信息
@Component
public class AuthenticationProviderConfig implements AuthenticationProvider {

    @Autowired
    UsersServiceConfig usersServiceConfig;

    @Autowired
    Back_EmpService usersService;

    /*@Autowired
    private BCryptPasswordEncoder encode;*/
    /**
     * 认证
     * authentication ：待认证的身份信息
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println("进入AuthenticationProviderConfig");
       //获取身份名称（表单提交的用户名）
        String username = authentication.getName();
        //获取凭证（密码）（表单提交的密码）
        String  credentials = authentication.getCredentials().toString();
        System.out.println("表单提交用户名和密码："+username+"  "+credentials);

        //进行解密认证  第一参数是表单提交的值 第二个参数是数据库查询的值 ☆☆☆☆☆☆
       /* boolean b = encode.matches(credentials, users.getPassword());
        System.out.println(b);*/

        //通过用户名去加载用户详细信息  真实的用户信息

        UserDetails userDetails = usersServiceConfig.loadUserByUsername(username);

        /*System.out.println("userdetaisl:"+userDetails);*/


        //判断是否存在
        if (userDetails == null){
            System.out.println("用户不存在");
            return null;
        }else {
            //if (userDetails.getPassword().equals(credentials) || b==true){
            if (userDetails.getPassword().equals(credentials)){
                //存入session
                System.out.println("认证成功，密码输入正确");
                //principal ：证书（用户的身份信息）  credentials：凭证（密码）   authorities：授权（权限）
                return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword() ,userDetails.getAuthorities());
            }else {
                System.out.println("认证失败");
                return null;
            }
        }
    }

    /**
     * 是否支持  true支持 false不支持
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}