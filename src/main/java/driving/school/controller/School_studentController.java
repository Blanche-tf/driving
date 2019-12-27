package driving.school.controller;

import com.github.pagehelper.PageHelper;
import driving.entity.Jx_studnet;
import driving.entity.Kh_user;
import driving.school.service.School_studentService;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("school_student")
@RequestMapping("school_student")
public class School_studentController {

    @Resource
    School_studentService school_studentService;

    //添加客户信息
    @RequestMapping("studentAdd")
    @ResponseBody
    public int studentAdd(Jx_studnet jx_studnet, HttpSession session){
        Map<String,Object> jobInfo =(Map<String,Object>) session.getAttribute("schoolLogin");
        Integer jxuid = (Integer) jobInfo.get("uid");
        //System.out.println("jxuid = " + jxuid);
        Kh_user kh_user = new Kh_user();
        kh_user.setUname(jx_studnet.getsName());
        kh_user.setuAccout(jx_studnet.getPhone());
        kh_user.setPassword("123456");
        kh_user.setJxuid(jxuid);
        school_studentService.khAdd(kh_user);
        Integer uid = kh_user.getUid();
        //System.out.println("uid:"+kh_user.getUid());
        jx_studnet.setUid(uid);
        jx_studnet.setState(0);
        Integer i =  school_studentService.school_studentAdd(jx_studnet);
       // System.out.println("i = " + i);
        return i;
    }

//    //查询客户信息
    @RequestMapping("query")
    @ResponseBody
    public PageData<Map<String,Object>> JxStudentAll(int page, int limit,HttpSession session,String sName){
        Map<String,Object> jobInfo =(Map<String,Object>) session.getAttribute("schoolLogin");
        Integer jxuid = (Integer) jobInfo.get("uid");
        PageHelper.startPage(page,limit);
        PageData<Map<String,Object>> list = school_studentService.JxStudentAll(page,limit,jxuid,sName);
        return list;
    }
    @RequestMapping("khfind")
    public String khfind(Integer uid, Model model) {
        Map<String, Object> kuser = school_studentService.kuUserFind(uid);
        model.addAttribute("kuser",kuser);
        //System.out.println("kuser = " + kuser);
        return "/school/views/backstage/khUser";
    }


    @RequestMapping("txStudent")
    @ResponseBody
    public int txStudent(Integer sId) {
        //System.out.println("sId:"+sId);
        Integer i =    school_studentService.txStudent(sId);
        //System.out.println("i = " + i);
        return i;
    }

    @RequestMapping("byStudent")
    @ResponseBody
    public int byStudent(Integer sId) {
        //System.out.println("sId:"+sId);
        Integer i =    school_studentService.byStudent(sId);
        //System.out.println("i = " + i);
        return i;
    }

    @RequestMapping("outStudent")
    @ResponseBody
    public int outStudent(Integer sId) {
        //System.out.println("sId:"+sId);
        Integer i =    school_studentService.outStudent(sId);
       // System.out.println("i = " + i);
        return i;
    }


    @RequestMapping("studentFind")
    @ResponseBody
    public PageData<Map<String,Object>>  studentFind(int page, int limit,HttpSession session,Integer state,String sName){
        //System.out.println("state = " + state);
        Map<String,Object> jobInfo =(Map<String,Object>) session.getAttribute("schoolLogin");
        Integer jxuid = (Integer) jobInfo.get("uid");
        PageHelper.startPage(page,limit);
        PageData<Map<String,Object>> list = school_studentService.studentFind(page,limit,jxuid,state,sName);
        return list;
    }
    
}


