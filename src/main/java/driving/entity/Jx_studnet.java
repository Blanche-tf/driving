package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Integer outState;
    //    毕业描述:正常毕业,五次不过
    @Column
    private String outDesc;
    //    所属客户编号
    @Column
    private Integer uid;
}
