import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionServlet1 extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");// 设置输出内容的编码格式
        response.setContentType("text/html");// 设置输出的文件类型
        PrintWriter out = response.getWriter();
        //使用request对象的getSession()获取session
        HttpSession session = request.getSession();
        session.setAttribute("account", "wangwu");//session存放数据
        session.setAttribute("password", "123456");
        session.setMaxInactiveInterval(60);//设置session的有效时间，60秒
        out.println("登录信息成功保存到session中！<br/>" +
                "点击链接进行访问:<a href='session2'>请点击</a><br/>");
    }

}
