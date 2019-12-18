package driving.school.service;

import driving.entity.Modules;
import driving.school.dao.ModulesDAO;
import driving.util.ModulesNode;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("school_ModeuService")
public class ModulesService {
    @Autowired(required = false)
    ModulesDAO moduleDAO;


    //属性菜单
    public List<ModulesNode> getTree(){
        List<Modules> list = moduleDAO.findByParentCode("L01");
        List<ModulesNode> treelist = getEasyNode(list);
        return treelist;
    }


    public List<ModulesNode> getEasyNode(List<Modules> list){
        List<ModulesNode> rsList = new ArrayList<ModulesNode>();
        for(Modules modules:list){
            ModulesNode easyNode = new ModulesNode();
            easyNode.setId(modules.getModuleCode());
            easyNode.setText(modules.getModuleText());
            easyNode.setIconCls(modules.getModuleIconCls());
            easyNode.setChecked("false");

            Map<String,String> map = new HashMap<String,String>();
            // 子节点
            List<Modules> childlist = moduleDAO.findByParentCode(modules.getModuleCode());
            if(childlist.size()>0){
                // 有子节
                easyNode.setState("close");
                List<ModulesNode> childNode = getEasyNode(childlist);
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

    public List<Modules> selectByAdminId(String id) {
        //获取用户所有的全部权限(父,子权限)菜单
        List<Modules> treeMenuList = moduleDAO.findByParentCode(id);
        //保存所有的父(主)菜单
        List<Modules> root = new ArrayList<>();
        //遍历所有菜单集合,如果是主菜单的话直接放入root集合
        for(Modules treeMenu : treeMenuList){
            //pid为0,则为父(主)菜单
            if(treeMenu.getModuleCode() == null){
                root.add(treeMenu);
            }
        }
        //这个是遍历所有主菜单,分别获取所有主菜单的所有子菜单
        for(Modules treeMenu : root){
            //获取所有子菜单 递归
            List<Modules> childrenList = getchildrenMeun(treeMenu.getModuleCode(),treeMenuList);
            //这个是实体类中的子菜单集合
            treeMenu.setChildren(childrenList);
        }
        return root;
    }

    //递归获取子菜单
    public List<Modules> getchildrenMeun(String  id,List<Modules> allMeun){
        //用于保存子菜单
        List<Modules> childrenList=new ArrayList<>();
        for (Modules info: allMeun){
            //判断当前的菜单标识是否等于主菜单的id
            if(info.getModuleCode()==id){
                //如果是的话 就放入主菜单对象的子菜单集合
                childrenList.add(info);
            }
        }

        //这里就是递归了，遍历所有的子菜单
        for (Modules info:childrenList){
            info.setChildren(getchildrenMeun(info.getModuleCode(),allMeun));
        }

        //如果子菜单为空的话，那就说明某菜单下没有子菜单了，直接返回空,子菜单为空的话就不会继续
        //迭代了
        if(childrenList!=null && childrenList.size()==0){
            return null;
        }
        return  childrenList;
    }



    // springSecurity 权限 释放驾校后台菜单路径
    public List<String> findByModuleUrl(){
        return moduleDAO.findByModuleUrl();
    }
}
