package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_cf_cf_type {
    //外键ex_cf(cid)，所属题库分类
    @Column
    private Integer cid;
    //外键ex_cf_type(ctid)，所属题库分类类型
    @Column
    private Integer ctid;

}
