package driving.back.service;

import driving.back.dao.Back_PermissionDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Back_PermissionService {
    @Resource
    Back_PermissionDAO permissionDAO;

    //根据职务编号查询对应的权限
    public List<String> findPermissionByPosId(Integer posId){
        return permissionDAO.findPermissionByPosId(posId);
    }
}
