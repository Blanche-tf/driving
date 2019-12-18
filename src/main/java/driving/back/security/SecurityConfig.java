package driving.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

//1.当前类是一个配置类
@Configuration
//2.将当前类作为Security的web配置类
@EnableWebSecurity
//3.启用Security的全局方法配置，目的启用注解配置
@EnableGlobalMethodSecurity(prePostEnabled = true)
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Resource
        UsersServiceConfig usersServiceConfig;

    /**
     * 配置  请求是http协议请求
     * 拦截的请求配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 解决跨域
        http.headers().frameOptions().disable();




       //设置权限 只在这些路径下面进行权限的设置和访问
        http.authorizeRequests()//只设置后台请求才能触发认证
                .antMatchers("/back_login/**","/back_modules/**","/pos/**").access("@permissionConfig.hasPermission(request,authentication)").and().csrf().disable();
/*// 权限配置
        http.authorizeRequests()//http所有请求
                .antMatchers().
                //是否支持某一个权限  通过自定义的PermissionConfig类
                //返回true说明有 false 没有  通过方法的返回值判断有没有增删改查的权限
                        access("@permissionConfig.hasPermission(request,authentication)").and()
                // 禁用csrf跨域请求
                .csrf().disable();*/



        //先认证再授权
        // 认证请求  对于请求要进行身份认证
        http.authorizeRequests()
                // 所有请求  都需要进行身份认证
                .anyRequest()
                // 授权
                .authenticated()
                // 用于条件的拼接
                .and()
                // 使用自定义form表单进行登录
                .formLogin()
                // 登录页面的路径
                .loginPage("/back/views/user/login.html")
                // 登录提交的地址,表单的提交路径和配置的路径一致  而这个路径在controller中是否真的存在无所谓
                //如果真的存在这个路径的话，访问这个路径不代表登录成功，仅仅是需要提交路径而已
                .loginProcessingUrl("/back_login/login-check")
                // 登录成功默认跳转的地址,在没有访问资源时才会跳转  就是你没有访问的其他路径被拦截的时候（直接访问登录进行登录而登录成功的路径）
                //如果要是在访问其他路径被拦截到登录页面，则登录成功之后会直接跳转到登录之前访问的路径
                /*.defaultSuccessUrl("/back/views/index.html")*/
                .defaultSuccessUrl("/back_login/login-success")
                //.successHandler(new ForwardAuthenticationSuccessHandler("/back/views/index.html"))
                // 失败的地址
                .failureUrl("/back_login/login-error")
                // form表单对应的用户名属性名，默认必须使用username,password
                .usernameParameter("username")
                .passwordParameter("password")
                // 不进行认证
                .permitAll();
              /*  .and()
                //配置退出
                .logout()
                //退出的地址
                .logoutUrl("/back_login/loginOut")
                //退出成功的地址
                .logoutSuccessUrl("/back_login/login")
                .and()
                //禁用csrf跨域请求
                .csrf()
                .disable();*/

        // 权限配置
        /*     http.authorizeRequests()//http所有请求
                .anyRequest()
                //是否支持某一个权限  通过自定义的PermissionConfig类
                //返回true说明有 false 没有  通过方法的返回值判断有没有增删改查的权限
                .access("@permissionConfig.hasPermission(request,authentication)")
                .and()
                // 禁用csrf跨域请求
                .csrf().disable();*/

        // 配置退出
       /*http.logout()
                // 退出的地址
                .logoutUrl("/back_login/logout")
                // 退出成功的地址
                .logoutSuccessUrl("/back/views/user/login.html");*/



    }

    //自动注入 自定义的认证生成器
    @Autowired
    AuthenticationProviderConfig authenticationProviderConfig;

    /**
     * 认证管理构造器  配置
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //认证生成器  认证信息
        auth.authenticationProvider(authenticationProviderConfig);
    }

    // web配置，忽略静态资源
    @Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers(
                // 忽略静态资源
                "/back/image/**","/css/**","/font/**","/image/**","/js/**","/layuiadmin/**","/picture/**","/style/**","/layui/**","/driving/**"
                // 驾校后台模板,一帆驾校前台模板
                ,"/school/**","/treasure/**"
               // 后台模板
               ,"/back/views/index1.html"
                // 首页
                ,"/index.html"
                // 一帆驾校平台后台 注册,找回密码
                ,"/back/views/user/reg.html","/back/views/user/forget.html",

               // 驾校平台登录
               "/school_login/**",
               //短信验证
               "/sendSMS/**",
               //图片上传
               "/school_upload/**",
               //菜单
               "/school_modules/**"
                );
    }

    //加密
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限。
            //需要的权限分两部分，第一部分是拦截的路径，第二部分分访问该路径需要的权限
            //antMatchers表示拦截什么路径，permitAll任何权限都可以访问，直接放行所有。
            //permitAll（）任何的请求，authenticated认证后才能访问
            //and().csrf().disable();固定写法，表示使csrf拦截失效
            http
                    .authorizeRequests()
                    .antMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                    .and().csrf().disable();
        }
    }

}