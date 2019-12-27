package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Ex_type {
    //    类型编号
    @Id
    private Integer tid;
    //    类型名称
    @Column
    private String tName;
    //    类型描述
    @Column
    private String tDesc;
}