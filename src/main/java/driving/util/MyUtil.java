package driving.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyUtil {
     //判断日期
    public static String getWeek(Date date){
    	String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
    	if(week_index<0){
    	week_index = 0;
    	} 
    	return weeks[week_index];
    }
   
   
    //上传文件  ssm   
    public static List file(MultipartFile[] files) throws IOException {
        List list = new ArrayList();
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = "E:/upload/lesson";
        if (files != null && files.length > 0) {//判断file数组不能为空并且长度大于0
            for (int i = 0; i < files.length; i++) {//循环获取file数组中得文件
                MultipartFile file = files[i];
                File f = new File(path); // 判断，该路径是否存在
                System.out.println("f:"+f.exists());
                if (!f.exists()) {
                    f.mkdirs(); // 创建该文件夹
                }
                // 说明上传文件项
                // 获取上传文件的名称
                String filen = file.getOriginalFilename();
                if (filen == null || "".equals(filen)) {//如果没有上传文件
                    return null;
                }
                System.out.println(filen+"   aaa");
                //获取原文件名称后缀
                String suffix = filen.substring(filen.lastIndexOf("."));//.jpg
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filen = uuid  + suffix;
                System.out.println(filen);
                // 完成文件上传
                file.transferTo(new File(path, filen));
                list.add(filen);
            }
        }
        return list;
    }

    //上传文件  ssm
    public static List fileyin(MultipartFile[] files) throws IOException {
        List list = new ArrayList();
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = "F:/upload/lesson";
        if (files != null && files.length > 0) {//判断file数组不能为空并且长度大于0
            for (int i = 0; i < files.length; i++) {//循环获取file数组中得文件
                MultipartFile file = files[i];
                File f = new File(path); // 判断，该路径是否存在
                System.out.println("f:"+f.exists());
                if (!f.exists()) {
                    f.mkdirs(); // 创建该文件夹
                }
                // 说明上传文件项
                // 获取上传文件的名称
                String filen = file.getOriginalFilename();
                if (filen == null || "".equals(filen)) {//如果没有上传文件
                    return null;
                }
                //获取原文件名称后缀
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filen = uuid  + filen+".mp3";
                System.out.println(filen);
                // 完成文件上传
                file.transferTo(new File(path, filen));
                list.add(filen);
            }
        }
        return list;
    }






    //校验字符串是否为空
    public static boolean isNull(String content){
        return content==null || "".equals(content);
    }
    

    //日期转字符串
    public static String getDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getDate(Date date) {
        return getDate(date, "yyyy-MM-dd");
    }

    //将字符串转为日期类型
    public static Date getDate(String strDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(strDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //日期
    public static Date getDate(String strDate) {
        return getDate(strDate, "yyyy-MM-dd");
    }

    //分割参数
    public static List<Map<String, Object>> getData(String parameter) {
        String name = parameter;//参数
        int count = 0;//循环的次数
        List<Map<String, Object>> list = new ArrayList<>();
        //遍历参数的穿你的骨
        for (int i = 0; i < name.length(); i++) {
            if (name.length() == i + 1) break;//长度==1+1 跳出
            //传来的参数 id是几个 就是要要循环的次数
            if ("id".equals(name.substring(i, i + 2))) {
                count++;
            }
        }
        String[] newS = null;
        //分割
        String[] split = name.split("&");
        //System.out.println(count);
        Map<String, Object> map = null;
        //遍历分割之后的
        for (int i = 0; i < split.length; i++) {
            if (i % (split.length / count) == 0) {//没一组创建一个map
                map = new HashMap<>();
            }
            newS = split[i].split("=");//按照=分割
            map.put(newS[0], newS[1]);//键，值
//			System.out.println("第"+i+"次"+map);
            if (i % (split.length / count) == 0) {//把map放进list里面
                list.add(map);
            }
        }//返回list
        return list;
    }
}
