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
@Data
@Table
public class Jx_modules {
    //    编号
    @Id
    private Integer moduleCode;
    //    模块文本
    @Column
    private String moduleText;
    //    模块路径
    @Column
    private String moduleUrl;
    //    模块图标
    @Column
    private String moduleIconCls;
    //    父级编号
    @Column
    private Integer parentCode;
    //    操作人编号
    @Column
    private Integer operationUid;
    //    操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date operationTime;
    //    模块显示排序
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date moduleNo;


}
