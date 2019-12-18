package driving.test;

import driving.back.service.Back_EmpService;
import driving.back.service.Back_ModulesService;
import driving.entity.Emp;
import driving.school.service.ModulesService;
import org.apache.catalina.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    Back_ModulesService modulesService;
    @Autowired
    Back_EmpService empService;

    @org.junit.Test
    public void test(){
        System.out.println(modulesService.getTree(4));
    }

    @org.junit.Test
    public void test1(){
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
