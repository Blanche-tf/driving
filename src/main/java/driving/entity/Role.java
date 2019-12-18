package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Role {
    //    编号
    @Id
    private Integer rid;
    //    角色名称
    @Column
    private String rname;
    //    角色描述
    @Column
    private String rDesc;
}
