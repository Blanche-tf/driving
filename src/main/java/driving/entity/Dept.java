package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Dept {
    //    编号
    @Id
    private Integer did;
    @Column
    //    部门名称
    private String dname;


}
