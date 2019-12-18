package driving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


// 启动项必须在所有类的最外层
// 将当前类作为Sbpringoot的应用程序
@SpringBootApplication
@ServletComponentScan
public class DrivingStart {
    public static void main(String[] args){
        // 运行spring应用程序
        SpringApplication.run(DrivingStart.class);
    }
}