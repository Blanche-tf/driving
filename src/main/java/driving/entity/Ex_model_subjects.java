package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_model_subjects {
    //外键ex_model(mid)
    @Id
    private Integer mid;
    //外键ex_subject(sid)
    @Column
    private Integer sid;
}
