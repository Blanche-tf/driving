package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_model {
    //    编号
    @Id
    private Integer mid;
    //    驾照类型
    @Column
    private String model;
    //    所属科目
    @Column
    private Integer sid;
}
