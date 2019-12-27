package driving.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Jx_studnet {
    //    编号
    @Id
    private Integer sId;
    //   学员名称
    @Column
    private String sName;
    //    学员性别
    @Column
    private String sex;
    //    年龄
    @Column
    private Integer age;
    //    手机号
    @Column
    private String phone;
    //    身份证号
    @Column
    private String idCard;
    //    正面身份证图片
    @Column
    private String zImg;
    //    反面身份证图片
    @Column
    private String fImg;
    //    学员状态
    @Column
    private Integer state;
    //    0正常毕业 1 五次不过
    @Column
    private String outDesc;
    //    所属客户编号
    @Column
    private Integer uid;



    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getzImg() {
        return zImg;
    }

    public void setzImg(String zImg) {
        this.zImg = zImg;
    }

    public String getfImg() {
        return fImg;
    }

    public void setfImg(String fImg) {
        this.fImg = fImg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOutDesc() {
        return outDesc;
    }

    public void setOutDesc(String outDesc) {
        this.outDesc = outDesc;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "Jx_studnet{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", zImg='" + zImg + '\'' +
                ", fImg='" + fImg + '\'' +
                ", state=" + state +
                ", outDesc='" + outDesc + '\'' +
                ", uid=" + uid +
                '}';
    }
}
