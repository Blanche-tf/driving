package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_model_type {
    //题库类型_考试类别编号
    @Id
    private Integer mtid;
    //外键(ex_model(mid)),所属考试类型(c1)
    @Column
    private Integer mid;
    //外键ex_type(tid),所属题库类型(顺序练习)
    @Column
    private Integer tid;
}
