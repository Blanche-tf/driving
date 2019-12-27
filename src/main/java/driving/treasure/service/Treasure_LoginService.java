package driving.treasure.service;

import driving.entity.Kh_user;
import driving.treasure.dao.Treasure_LoginDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class Treasure_LoginService {

    @Resource
    Treasure_LoginDAO treasure_loginDAO;

    public Integer treasureAdd(Kh_user kh_user){
        return  treasure_loginDAO.treasureAdd(kh_user);
    }


    public Map<String,Object> treasureLogin(String uAccout, String password){
        return treasure_loginDAO.treasureLogin(uAccout,password);
    }


}
