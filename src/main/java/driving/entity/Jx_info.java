package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Jx_info {
    //    编号
    @Id
    private Integer iId;
    //    驾校信息
    @Column
    private String iName;

}
