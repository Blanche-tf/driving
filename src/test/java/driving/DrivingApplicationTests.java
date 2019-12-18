package driving;

import driving.back.service.Back_EmpService;
import driving.back.service.Back_ModulesService;
import driving.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DrivingApplicationTests {

    @Autowired
    Back_ModulesService modulesService;
    @Autowired
    Back_EmpService empService;

    @Test
    void contextLoads() {
        System.out.println(modulesService.getTree(4));
    }

    @Test
    void test1() {
        //加密
        String password = "123";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(password);

        Emp users = new Emp();
        users.setUserName("z");
        users.setPassword(hashPass);
        users.setEname("E002");
        int i = empService.addUsers(users);
        System.out.println(i);
        System.out.println(hashPass);

        //解密
        boolean f = bcryptPasswordEncoder.matches("123",hashPass);
        System.out.println(f);
    }

}
