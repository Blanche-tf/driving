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
@Data
@Table
public class Emp {
    //    编号
    @Id
    private Integer eid;
    //    员工名称
    @Column
    private String ename;
    //    员工图片
    @Column
    private String empimg;
    //    员工账号
    @Column
    private String userName;
    //    员工密码
    @Column
    private String password;
    //    员工入职日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date intime;
    //    员工离职日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date outtime;
    // 员工手机号
    @Column
    private String phone;
    //    员工角色
    @Column
    private Integer roleid;
    //    账户状态
    @Column
    private Integer state;
    //    操作人编号
    @Column
    private Integer operationUid;
    //    操作时间
    @Column
    private Integer operationTime;


}
