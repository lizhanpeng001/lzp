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
        response.setCharacterEncoding("UTF-8");// ����������ݵı����ʽ
        response.setContentType("text/html");// ����������ļ�����
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();//ʹ��request�����ȡsession
        String account=(String) session.getAttribute("account");//��session�л�ȡ��Ϣ
        String password=(String) session.getAttribute("password");
        int inactiveTime=session.getMaxInactiveInterval();//��ȡsession����Чʱ��
        out.println("��session�л�ȡ��<br/>" +
                "account="+account+"<br/>" +
                "password="+password+"<br/>" +
                "��Чʱ�䣨�룩��"+inactiveTime);
    }

}
