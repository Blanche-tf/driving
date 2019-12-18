package driving.entity;

import jdk.Exported;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Trafficpicture {
    //    编号
    @Id
    private Integer pId;
    //    图片名称
    @Column
    private String pName;
    //    图片路径
    @Column
    private String url;
    //    图片描述
    @Column
    private String pDesc;
    //    所属图片类型
    @Column
    private Integer tid;


}
