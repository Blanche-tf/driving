package driving.school.controller;

import driving.entity.Jx_ambient;
import driving.entity.Jx_user;
import driving.entity.Jx_user_info;
import driving.school.service.School_InformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//修改个人信息 -- 个人设施
@Controller("school_information")
@RequestMapping("school_information")
public class School_InformationController {

    @Resource
    School_InformationService school_informationService;



    @RequestMapping("info")
    public String info(Model model, HttpSession session){
        Map<String,Object> jobInfo =(Map<String,Object>) session.getAttribute("schoolLogin");
        Integer uid = (Integer) jobInfo.get("uid");

        List<Map<String,Object>>  jx_info =  school_informationService.jx_info();
        model.addAttribute("jinfo",jx_info);


        Jx_user user = school_informationService.jx_userFind(uid);
        model.addAttribute("user",user);
        //System.out.println("user = " + user);

        List<Map<String,Object>> infoUser =  school_informationService.jx_infoUser(uid);
       // System.out.println("infoUser = " + infoUser);
        model.addAttribute("infoUser",infoUser);

        return  "/school/views/set/user/info";
    }
    //修改个人信息
    @RequestMapping("infoadd")
    @ResponseBody
    public int infoadd(String uname,String phone,String  uing,Integer uid,String like){
        //System.out.println("uname:"+uname+"phone:"+phone+"uid:"+uid+"like:"+like);
        String ids = like;        //ids和id都存在于实体类User
        String a[] = ids.split(",");
        if(like==""){
            school_informationService.jxinfoDeleAll(uid);
        }else {
            school_informationService.jxinfoDeleAll(uid);
            for (int i = 0; i < a.length; i++) {
                String id = a[i];
                Integer gd = Integer.valueOf(id).intValue();
                school_informationService.jxinfoAdd(gd,uid);
            }

        }
        int i =   school_informationService.jx_userUpdate(uname,phone,uing,uid);
        return  i;
    }
    //查询驾校设施
//    public List<Map<String,Object>> jx_info(){
//        return school_informationService.jx_info();
//    }

    @RequestMapping(value="/uploadSource" , method = RequestMethod.POST)
    @ResponseBody
    public String uploadSource(@RequestParam("file") MultipartFile file , HttpServletRequest request) {
        //   System.out.println(file);
        String pathString = null;
        String imgName = "";
        if(file!=null) {
            UUID uuid = UUID.randomUUID();
            pathString = "E:/driving/" + uuid + "_" +file.getOriginalFilename();
        }
      //  System.out.println("pathString = " + pathString);

        try {
            File files=new File(pathString);
            imgName = pathString.substring(11);

            if(!files.getParentFile().exists()){
                files.getParentFile().mkdirs();
            }
            file.transferTo(files);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "{\"code\":0,\"msg\":\""+imgName+"\"}";
}

}
