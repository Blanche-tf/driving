package driving.back.service;


import driving.back.dao.Back_ModulesDAO;
import driving.entity.Modules;
import driving.util.ModulesNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Back_ModulesService {
    @Autowired(required = false)
    Back_ModulesDAO modulesDAO;

    //根据职务编号查询对应的菜单执行路径
    public List<String> findUrlByPosId(Integer posId){
        return modulesDAO.findUrlByPosId(posId);
    }

    //属性菜单
    public List<ModulesNode> getTree(Integer posId){
        System.out.println("possUd"+posId);
        List<Modules> list = modulesDAO.findByParentCode("L01",posId);
        List<ModulesNode> treelist = getEasyNode(list,posId);
        return treelist;
    }


    public List<ModulesNode> getEasyNode(List<Modules> list,Integer posId){
        System.out.println("pos:"+posId);
        List<ModulesNode> rsList = new ArrayList<ModulesNode>();
        for(Modules modules:list){
            ModulesNode easyNode = new ModulesNode();
            easyNode.setId(modules.getModuleCode());
            easyNode.setText(modules.getModuleText());
            easyNode.setIconCls(modules.getModuleIconCls());
            easyNode.setChecked("false");
            System.out.println("easyNode:"+easyNode);
            Map<String,String> map = new HashMap<String,String>();
            // 子节点
            List<Modules> childlist = modulesDAO.findByParentCode(modules.getModuleCode(),posId);
            if(childlist.size()>0){
                // 有子节
                easyNode.setState("close");
                List<ModulesNode> childNode = getEasyNode(childlist,posId);
                easyNode.setChildren(childNode);
            }else{
                // 没有
                easyNode.setState("open");
                // 没有子节点，点击时要打开新窗口，需要url地址信息
                map.put("url",modules.getModuleUrl());
                easyNode.setChildren(null);
            }
            easyNode.setAttributes(map);
            rsList.add(easyNode);
        }
        return rsList;
    }


}
