import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SessionServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");// 设置输出内容的编码格式
        response.setContentType("text/plain");// 设置输出的文件类型
        PrintWriter out = response.getWriter();
        // 使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        String sessionId = session.getId();// 获取session的Id
        if (session.isNew()) {// 判断session是不是新创建的
            out.println("session创建成功，session的id是：" + sessionId);
        } else {
            out.println("服务器已经存在该session了，session的id是：" + sessionId);
        }
        Cookie[] cookies=request.getCookies();//获取请求中所有的Cookie
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                out.println("Cookie Name:"+cookies[i].getName());//输出Cookie的名字
                out.println("Cookie Value:"+cookies[i].getValue());//输出Cookie的值
            }
        }else{
            out.println("No Cookies");
        }
    }
	
}
