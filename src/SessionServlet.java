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
        response.setCharacterEncoding("UTF-8");// ����������ݵı����ʽ
        response.setContentType("text/plain");// ����������ļ�����
        PrintWriter out = response.getWriter();
        // ʹ��request�����getSession()��ȡsession�����session�������򴴽�һ��
        HttpSession session = request.getSession();
        String sessionId = session.getId();// ��ȡsession��Id
        if (session.isNew()) {// �ж�session�ǲ����´�����
            out.println("session�����ɹ���session��id�ǣ�" + sessionId);
        } else {
            out.println("�������Ѿ����ڸ�session�ˣ�session��id�ǣ�" + sessionId);
        }
        Cookie[] cookies=request.getCookies();//��ȡ���������е�Cookie
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                out.println("Cookie Name:"+cookies[i].getName());//���Cookie������
                out.println("Cookie Value:"+cookies[i].getValue());//���Cookie��ֵ
            }
        }else{
            out.println("No Cookies");
        }
    }
	
}
