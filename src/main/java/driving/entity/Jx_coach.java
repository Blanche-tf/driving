package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Jx_coach {
    //    编号
    @Id
    private Integer cId;

    //    熟练名称
    @Column
    private String cName;

    //    教练照片
    @Column
    private String cImg;

    //    教龄
    @Column
    private String tage;

    //    0:在职 1:离职
    @Column
    private Integer state;

    //    教练简介
    @Column
    private String cDesc;
    //    所属驾校
    @Column
    private Integer uid;
}
