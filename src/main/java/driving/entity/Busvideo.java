package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Data
@Entity
public class Busvideo {
    //    编号
    @Id
    private Integer busId;
    //    视频
    @Column
    private String busName;
    //    视频路径
    @Column
    private String url;
    //    所属视频类型
    @Column
    private Integer Tid;

}
