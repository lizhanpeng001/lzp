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
        response.setCharacterEncoding("UTF-8");// ����������ݵı����ʽ
        response.setContentType("text/html");// ����������ļ�����
        PrintWriter out = response.getWriter();
        //ʹ��request�����getSession()��ȡsession
        HttpSession session = request.getSession();
        session.setAttribute("account", "wangwu");//session�������
        session.setAttribute("password", "123456");
        session.setMaxInactiveInterval(60);//����session����Чʱ�䣬60��
        out.println("��¼��Ϣ�ɹ����浽session�У�<br/>" +
                "������ӽ��з���:<a href='session2'>����</a><br/>");
    }

}
