package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Modules_role {
    //    所属模块
    @Id
    private Integer moduleCode;
    //    所属角色
    @Column
    private String rid;
}
