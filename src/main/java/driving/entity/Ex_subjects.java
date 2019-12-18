package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_subjects {
    //    编号
    @Id
    private Integer sid;
    //    科目名称
    @Column
    private String subject;

}
