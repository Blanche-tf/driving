package driving.school.controller;

import driving.entity.Jx_ambient;
import driving.school.service.School_imgService;
import driving.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("school_upload")
public class School_imgController {

    @Resource
    School_imgService schoolimgService;

    @RequestMapping(value="/uploadMany" , method = RequestMethod.POST)
    @ResponseBody
    public String uploadSource(@RequestParam("file") MultipartFile[] multipartFiles , HttpSession session) {
        //   System.out.println(file);
        Map<String,Object> jobInfo =(Map<String,Object>) session.getAttribute("schoolLogin");
        Integer uid = (Integer) jobInfo.get("uid");
        String pathString = null;
        for(MultipartFile m : multipartFiles){
            UUID uuid = UUID.randomUUID();
            pathString = "e:/driving/" + uuid + "_" +m.getOriginalFilename();
            try {
                File files=new File(pathString);
                String imgName = pathString.substring(11);
                Jx_ambient jx_ambient =new Jx_ambient();
                jx_ambient.setaImg(imgName);
                jx_ambient.setUid(uid);
                schoolimgService.schoolimgAdd(jx_ambient);

                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                m.transferTo(files);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //  System.out.println("getOriginalFilename:"+file.getOriginalFilename());
        return "{\"code\":0,\"msg\":\""+pathString+"\"}";
    }



    @RequestMapping("schoolimgAll")
    @ResponseBody
    public PageData<Jx_ambient> schoolimgAll(int page, int limit){
       // System.out.println("schoolimgService.schoolAll() = " + schoolimgService.schoolAll(page,limit));
        return  schoolimgService.schoolAll(page,limit);
    }


}
