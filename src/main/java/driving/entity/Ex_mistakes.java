package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_mistakes {
    //    错误编号
    @Id
    private Integer kid;
    @Column
    //    题目错误
    private Integer tid;
    @Column
    //    用户编号
    private Integer uid;
}
