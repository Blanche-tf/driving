package driving.back.service;

import driving.back.dao.Back_Modules_roleDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Back_modules_roleService {
    @Resource
    Back_Modules_roleDAO modules_roleDAO;
}