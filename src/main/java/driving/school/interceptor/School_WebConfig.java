package driving.school.interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class School_WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        School_LoginHandlerInterceptor loginInterceptor = new School_LoginHandlerInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        // 拦截路径
        loginRegistry.addPathPatterns("/school/**");



        // 排除路径
        loginRegistry.excludePathPatterns("/school/views/user/login.html");
        loginRegistry.excludePathPatterns("/school/views/user/forget.html");
        loginRegistry.excludePathPatterns("/school/views/user/forgetSubmit.html");
        loginRegistry.excludePathPatterns("/school/views/user/reg.html");
        loginRegistry.excludePathPatterns("/school_login/**");
        loginRegistry.excludePathPatterns("/loginout/**");
        loginRegistry.excludePathPatterns("/sendSMS/**");
        // 排除资源请求
        loginRegistry.excludePathPatterns("/layuiadmin/**");
        loginRegistry.excludePathPatterns("/school/image/**");
        loginRegistry.excludePathPatterns("/school/views/backstage/**");
        loginRegistry.excludePathPatterns("/school/jx_imgManager/**");
        loginRegistry.excludePathPatterns("/school/views/index1.html");
    }
}