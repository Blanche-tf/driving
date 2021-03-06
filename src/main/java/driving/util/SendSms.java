package driving.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sendSMS")
public class SendSms extends HttpServlet {


    private static final long serialVersionUID = 1L;


    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String phone=req.getParameter("phone");
        System.out.println("phone:"+phone);
        //根据获取到的手机号发送验证码
        String code = GetMessageCode.getCode(phone);
        System.out.println(code);
        resp.getWriter().print(code);
    }
}
