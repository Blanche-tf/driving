package driving.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Jx_ambient {
    //    编号
    @Id
    private Integer aId;
    //    图片路径
    @Column
    private String aImg;
    //    所属驾校
    @Column
    private Integer uid;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }




    public String getaImg() {
        return aImg;
    }

    public void setaImg(String aImg) {
        this.aImg = aImg;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Jx_ambient{" +
                "aId=" + aId +
                ", aImg='" + aImg + '\'' +
                ", uid=" + uid +
                '}';
    }
}
