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
    private String uing;
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUing() {
        return uing;
    }

    public void setUing(String uing) {
        this.uing = uing;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Jx_user{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uing='" + uing + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", intime=" + intime +
                ", balance=" + balance +
                ", aid=" + aid +
                ", state=" + state +
                '}';
    }
}
