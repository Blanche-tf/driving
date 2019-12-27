package driving.back.service;


import driving.back.dao.Back_ModulesDAO;
import driving.entity.Modules;
import driving.util.ModulesNode;
import driving.util.ModulesNodeTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
// 事务管理报错回滚
@Transactional(rollbackFor = Exception.class)
public class Back_ModulesService {
    @Autowired(required = false)
    Back_ModulesDAO modulesDAO;

    // 查询所有菜单  判断有权限选中
    public List<Modules> findAll(){
        return modulesDAO.selectAll();
    }



    //根据职务编号查询对应的菜单执行路径
    public List<String> findUrlByPosId(Integer posId){
        return modulesDAO.findUrlByPosId(posId);
    }

    // 分配权限
    public boolean modules_role(Integer rId,String[] modules){
        // 根据角色清空所属的权限
        int del = modulesDAO.doDelByRidModules(rId);

        // 根据角色添加所属的权限
        int add = 0;
        for (int i = 0; i < modules.length; i++) {
            Integer m = Integer.parseInt(modules[i]);
            modulesDAO.doAddByRidModules(rId, m);
        }
        return del >= 0 && add >=0?true:false;
    }


    // 分配权限的树形菜单
    public List<ModulesNodeTree> getTreeModule(Integer rid){
        List<Modules> list = modulesDAO.findByParentCodeAll("0");
        List<ModulesNodeTree> treelist = getLayuiNode(list,rid);
        return treelist;
    }


    public List<ModulesNodeTree> getLayuiNode(List<Modules> list,Integer rid){
        List<ModulesNodeTree> rsList = new ArrayList<ModulesNodeTree>();
        for(Modules modules:list){
            ModulesNodeTree easyNode = new ModulesNodeTree();
            easyNode.setValue(modules.getModuleCode());
            easyNode.setTitle(modules.getModuleText());
            System.out.println("easyNode:"+easyNode);

            // 查询该角色已有的权限是否存在  存在选择状态
            List<String> moduleCodes = modulesDAO.findByRid(rid);
            easyNode.setChecked(moduleCodes.contains(modules.getModuleCode()));

            Map<String,String> map = new HashMap<String,String>();
            // 子节点
            List<Modules> childlist = modulesDAO.findByParentCodeAll(modules.getModuleCode());
            if(childlist.size()>0){
                // 有子节
                List<ModulesNodeTree> childNode = getLayuiNode(childlist,rid);
                easyNode.setData(childNode);
            }else{
                // 没有
                // 没有子节点，点击时要打开新窗口，需要url地址信息
                map.put("url",modules.getModuleUrl());
                easyNode.setData(null);
            }
            rsList.add(easyNode);
        }
        return rsList;
    }




    //左边垂直树形菜单
    public List<ModulesNode> getTree(Integer posId){
        System.out.println("possUd"+posId);
        List<Modules> list = modulesDAO.findByParentCode("0",posId);
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