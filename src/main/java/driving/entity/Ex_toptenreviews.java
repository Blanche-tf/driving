package driving.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data
public class Ex_toptenreviews {
    //    编号全真模拟
    @Id
    private Integer topid;
    //    外键客户编号
    @Column
    private Integer uid;
    //    用时
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date time;
    //    成绩
    @Column
    private Integer score;
    //    错题
    private Integer wrong;
    //    正确
    private Integer correct;
    //    漏题
    private Integer miss;

}
