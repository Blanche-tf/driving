package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Jx_classtype {
    //    编号
    @Id
    private Integer cId;
    //    课程名称
    @Column
    private String cName;
    //    驾照类型(C1)
    @Column
    private Integer mId;
    //    班型费用
    @Column
    private Double money;
    //    学车时间
    @Column
    private String cTime;
    //    几人一车
    @Column
    private Integer people;
    //    班型描述
    @Column
    private String cDesc;
    //    所属驾校
    @Column
    private Integer uId;
}
