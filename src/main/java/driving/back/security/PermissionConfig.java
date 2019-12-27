package driving.back.security;

import driving.back.service.Back_ModulesService;
import driving.back.service.Back_PermissionService;
import driving.school.service.ModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Component
public class PermissionConfig {
    // 一帆驾校平台  增删改查权限
    @Autowired
    Back_PermissionService permissionService;
    @Autowired
    HttpSession session;
    // 一帆驾校平台模块
    @Autowired
    Back_ModulesService posModulesService;
    // 驾校后台 模块
    @Autowired
    ModulesService modulesService;

    /**
     * 判断是否拥有某一个权限
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){

        boolean flag=false;
        // 获取用户身份
        Object principal = authentication.getPrincipal();

        //判断是否认证成功
        if(principal instanceof UserDetails){
            // 认证已经通过
            // 获取用户对应的角色
            /*Collection<? extends GrantedAuthority> authorities = ((UserDetails) principal).getAuthorities();
            Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
            //循环获取下一个结果
            while(iterator.hasNext()){
                GrantedAuthority next = iterator.next();
                //角色名称  职务名称
                String roleName = next.getAuthority();
            }*/
            // 根据用户获取对应的权限
            Integer posId = (Integer) session.getAttribute("posId");
            List<String> permission = permissionService.findPermissionByPosId(posId);


            for (int i = 0; i <permission.size() ; i++) {
                String per = permission.get(i);
                if(request.getRequestURI().equals(per)){
                    //代表有当前的权限
                    System.out.println("增删改查代表有当前的权限:"+per);
                    flag=true;
                    break;
                }
            }
            List<String> urls = posModulesService.findUrlByPosId(posId);
            for (int i = 0; i <urls.size() ; i++) {
                String url = urls.get(i);
                System.out.println("urls:"+url);
                if(request.getRequestURI().equals(url)) {
                    //代表有当前的权限
                    System.out.println("菜单代表有当前的权限:"+url);
                    flag=true;
                    break;
                }
            }
            // 驾校后台菜单权限释放
            List<String> moduleUrls = modulesService.findByModuleUrl();
            for (int i = 0; i <moduleUrls.size() ; i++) {
                String moduleUrl = moduleUrls.get(i);
                if(request.getRequestURI().equals(moduleUrl)) {
                    //代表有当前的权限
                    System.out.println("驾校后台菜单代表有当前的权限:"+moduleUrl);
                    flag=true;
                    break;
                }
            }
            System.out.println("flag4 ========== " + flag);
            return flag;
        }else{
            return false;
        }


    }

}