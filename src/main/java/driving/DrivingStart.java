package driving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


// 启动项必须在所有类的最外层
// 将当前类作为Sbpringoot的应用程序
@SpringBootApplication
// 访问webServlet
@ServletComponentScan
// 声明式事务
@EnableTransactionManagement
public class DrivingStart {
    public static void main(String[] args){
        // 运行spring应用程序
        SpringApplication.run(DrivingStart.class);
    }
}