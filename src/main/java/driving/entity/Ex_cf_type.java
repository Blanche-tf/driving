package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table
public class Ex_cf_type {
    //编号
    @Id
    private Integer ctid;
    //题库分类类型名称(文字题，图片题正确题，判断题,图片题,聚，国片题顺序答题随机答题)
    @Column
    private String ctname;
   //条件搜索(REGEXP)
    @Column
    private String twhere;

}
