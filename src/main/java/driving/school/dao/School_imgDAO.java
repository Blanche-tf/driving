package driving.school.dao;

import driving.entity.Jx_ambient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface School_imgDAO {

    //添加驾校图片
    @Insert("insert into  jx_ambient(aImg,uid) values(#{aImg},#{uid})")
    int schoolimgAdd(Jx_ambient jx_ambient);

     //查询驾校图片
    @Select("select * from jx_ambient ")
    List<Jx_ambient> schoolAll();


}
