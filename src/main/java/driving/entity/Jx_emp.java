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
public class Jx_emp {
    //    员工编号
    @Id
    private Integer eid;
    //    员工图片
    @Column
    private String ename;
    //    员工手机号
    @Column
    private String emping;
    //    员工手机号
    @Column
    private String phone;
    //    员工账号
    @Column
    private String empAccout;
    //    员工密码
    @Column
    private String password;
    //    入职日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date intime;
    //    离职日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date outtime;
    //   所属部门
    @Column
    private Integer deptId;
    //    账号状态
    @Column
    private Integer state;
}
