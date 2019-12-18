package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_enshrine {
    //    收藏编号
    @Id
    private Integer eid;
    //    题目编号
    @Column
    private Integer tid;
    //    用户编号
    @Column
    private Integer uid;
}
