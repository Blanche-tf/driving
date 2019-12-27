package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_cf {
    //    编号
    @Id
    private Integer cid;
    //题库分类名称(安全行车常识/章节/按内容)
    @Column
    private String cname;



}
