package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
public class Traffictype {
    //    编号
    @Id
    private Integer tid;
    //    父级编号
    @Column
    private Integer pid;
    //    名称
    @Column
    private String name;

}
