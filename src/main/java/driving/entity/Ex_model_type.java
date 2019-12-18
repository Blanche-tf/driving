package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_model_type {
    //    所属类型
    @Id
    private Integer mid;
    //    所属类别
    @Column
    private Integer tid;
}
