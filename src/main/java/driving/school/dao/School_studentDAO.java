package driving.school.dao;

import driving.entity.Jx_studnet;
import driving.entity.Kh_user;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface School_studentDAO extends tk.mybatis.mapper.common.Mapper<Jx_studnet> {

    //添加客户信息
    @Insert("insert into kh_user(uname,uAccout,password,jxuid) values(#{uname},#{uAccout},#{password},#{jxuid})")
    @Options(useGeneratedKeys = true,keyProperty = "uid",keyColumn = "uid")//加入该注解可以保持对象后，查看对象插入id
    Integer khAdd(Kh_user kh_user);

   //查询驾校学员信息
    @Select("<script> select * from jx_studnet jx inner join kh_user kh on jx.uid = kh.uid where kh.jxuid=#{jxuid} " +
            "<if test=\"sName != null and sName != '' \">\n" +
            "   and jx.sName like concat(concat('%',#{sName}),'%') \n" +
            " </if>" +
            "</script>")
     List<Map<String,Object>> jxUserAll(Integer jxuid, String sName);

    //查询客户
    @Select("select * from kh_user where uid=#{uid}")
    Map<String,Object> kuUserFind(Integer uid);

    //退学
    @Update("update jx_studnet set state=3 where sId = #{sId}")
    Integer txStudent(Integer sId);

    //毕业
    @Update("update jx_studnet set state=1 where sId = #{sId}")
    Integer byStudent(Integer sId);

    //五次不过
    @Update("update jx_studnet set state=2 where sId = #{sId}")
    Integer outStudent(Integer sId);

    //查询驾校学员状态信息
     @Select("<script> select * from jx_studnet jx inner join kh_user kh on jx.uid = kh.uid where kh.jxuid=#{jxuid} and jx.state=#{state} " +
            "<if test=\"sName != null and sName != '' \">\n" +
            "   and jx.sName like concat(concat('%',#{sName}),'%') \n" +
            " </if>" +
            "</script>")
    List<Map<String,Object>> studentFind(Integer jxuid, Integer state, String sName);


}
