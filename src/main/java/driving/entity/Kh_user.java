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

    public String getuAccout() {
        return uAccout;
    }

    public void setuAccout(String uAccout) {
        this.uAccout = uAccout;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getJxuid() {
        return jxuid;
    }

    public void setJxuid(Integer jxuid) {
        this.jxuid = jxuid;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Kh_user{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uing='" + uing + '\'' +
                ", uAccout='" + uAccout + '\'' +
                ", password='" + password + '\'' +
                ", intime=" + intime +
                ", state=" + state +
                ", jxuid=" + jxuid +
                ", cId=" + cId +
                '}';
    }
}
