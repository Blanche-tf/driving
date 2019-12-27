package driving.test;

import driving.back.dao.TopicDAO;
import driving.back.service.Back_EmpService;
import driving.back.service.Back_Jx_userService;
import driving.back.service.Back_ModulesService;
import driving.back.service.TopicService;
import driving.entity.Emp;
import driving.entity.Ex_topic;
import driving.entity.Jx_user;
import driving.school.service.ModulesService;
import driving.util.PageData;
import org.apache.catalina.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    // 树形菜单
    @Autowired
    Back_ModulesService modulesService;
    // 员工
    @Autowired
    Back_EmpService empService;
    // 题库
    @Autowired
    TopicService topicService;
    // 题库
    @Autowired
    TopicDAO topicDAO;
    // 驾校
    @Resource
    Back_Jx_userService back_jx_userService;

    // 测试题库: 驾校显示
    @org.junit.Test
    public void jx_userShow(){
        PageData<Jx_user> all = back_jx_userService.findAll(1, 10, "大");
        System.out.println("all = " + all);
    }

    // 测试题库: 显示
    @org.junit.Test
    public void topicShow(){
        PageData<Map<String,Object>> all = topicService.findAll(1, 10, "");
        System.out.println("all = " + all);
       /* List<Map<String,Object>> all = topicDAO.findAll("");
        System.out.println("all = " + all);*/
    }


    // 测试题库 : 更新题库
    @org.junit.Test
    public void topic(){
        topicService.upTopic();
    }



        // 测试树形菜单
    @org.junit.Test
    public void getTree(){
        System.out.println(modulesService.getTree(4));
    }

    // 测试加密
    @org.junit.Test
    public void bcrypt(){
        //加密
        String password = "123";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(password);

        Emp users = new Emp();
        users.setUserName("z");
        users.setPassword(hashPass);
        users.setEname("张经理");
        int i = empService.addUsers(users);
        System.out.println(i);
        System.out.println(hashPass);

        //解密
        boolean f = bcryptPasswordEncoder.matches("123",hashPass);
        System.out.println(f);
    }

}
