package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
public class Ex_topic {
    //    编号
    @Id
    private Integer tid;
    //    题目标题
    @Column
    private String question;
    //    题目答案(1:A正确 2:B错误)
    private String answer;
    //    题目选项1
    @Column
    private String item1;
    //    题目选项2
    @Column
    private String item2;
    //    题目选项3
    @Column
    private String item3;
    //    题目选项4
    @Column
    private String item4;
    //    帮助描述
    @Column
    private String explains;
    //    题目图片
    @Column
    private String url;
    //    所属科目 外键ex_subjects(sid)
    @Column
    private Integer sid;
    //    所属考试类型
    @Column
    private Integer mid;
}
