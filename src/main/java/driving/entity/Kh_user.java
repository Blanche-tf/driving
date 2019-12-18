package driving.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Kh_user {
    //    编号
    @Id
    private Integer uid;
    //    客户名称
    @Column
    private String uname;
    //    客户图片
    @Column
    private String uing;
    //    客户账号
    @Column
    private String uAccout;
    //    客户密码
    @Column
    private String password;
    //    注册日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date intime;
    //    账户状态
    @Column
    private Integer state;
    //    所属驾校
    @Column
    private Integer jxuid;
    //    所属教练
    @Column
    private Integer cId;


}
