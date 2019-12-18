package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Data
public class Busvideotype {
    //    编号
    @Id
    private Integer tid;
    //    类型名称
    @Column
    private String tName;
}
