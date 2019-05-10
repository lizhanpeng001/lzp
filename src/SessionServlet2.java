import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionServlet2 extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");// 设置输出内容的编码格式
        response.setContentType("text/html");// 设置输出的文件类型
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();//使用request对象获取session
        String account=(String) session.getAttribute("account");//从session中获取信息
        String password=(String) session.getAttribute("password");
        int inactiveTime=session.getMaxInactiveInterval();//获取session的有效时间
        out.println("从session中获取：<br/>" +
                "account="+account+"<br/>" +
                "password="+password+"<br/>" +
                "有效时间（秒）："+inactiveTime);
    }

}
