package driving.school.service;

import driving.back.dao.Back_Ex_modelDAO;
import driving.entity.Ex_model;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class School_Ex_modelService {
    // 驾考类型(C1,C2)
    @Resource
    Back_Ex_modelDAO back_ex_modelDAO;

    // 查询全部
    public List<Ex_model> findAll(){
        return back_ex_modelDAO.selectAll();
    }
}
