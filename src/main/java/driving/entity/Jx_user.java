package driving.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
public class Jx_user {
    //    编号
    @Id
    private Integer uid;
    //    驾校名称
    @Column
    private String uname;
    //    驾校图片
    @Column
    private String uimg;
    //    驾校账号
    @Column
    private String phone;
    //    驾校密码
    @Column
    private String password;
    //    注册日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date intime;
    //    余额
    @Column
    private Double balance;
    //    0:未认证 1:认证
    @Column
    private Integer aid;
    //    0:未认证 1:认证
    @Column
    private Integer state;

}
