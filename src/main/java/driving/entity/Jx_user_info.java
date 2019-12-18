package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Jx_user_info {
    //    基本信息
    @Id
    private Integer iId;
    //    所属驾校
    @Column
    private Integer uid;
}
