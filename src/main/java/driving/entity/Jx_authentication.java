package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Jx_authentication {
    //    编号
    @Id
    private Integer aid;
    //    驾校名称
    @Column
    private String uname;
    //    社会信用代码
    @Column
    private String creditCode;
    //    单位名称
    @Column
    private String unit;
    //    法人
    @Column
    private String legalPerson;
    //    地址
    @Column
    private String address;
    //    0:认证通过 1:认证失败 2:认证中
    @Column
    private Integer aState;
    //    所属驾校 外键jx_user(uid)
    @Column
    private Integer uid;

}
