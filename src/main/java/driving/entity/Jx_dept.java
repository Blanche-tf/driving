package driving.entity;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Jx_dept {
    //    编号
    @Id
    private Integer did;
    //    名称
    @Column
    private String dname;
}
