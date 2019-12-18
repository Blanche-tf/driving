package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class City {
    //    编号
    @Id
    private Integer id;
    //    父级编号
    @Column
    private Integer pid;
    //    名称
    @Column
    private String name;
    //    类型
    @Column
    private Integer type;
}
