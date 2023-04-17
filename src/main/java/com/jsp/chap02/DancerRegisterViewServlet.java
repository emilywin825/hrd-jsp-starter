package com.jsp.chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//등록 화면 띄워주세요!
@WebServlet("/chap02/dancer/register") //이 요청이 오면 밑에 서비스가 작동하겠다.
public class DancerRegisterViewServlet extends HttpServlet { //이 페이지가 서블릿으로 사용되려면 HttpServlet 필요

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("<style>\n");
        w.write("label { display: block; }\n");
        w.write("</style>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("<form action=\"/chap02/dancer/reg-process\" method=\"post\" id=\"reg-form\">");
        w.write("<label># 이름 : <input type=\"text\" name=\"name\"></label>");
        w.write("<label># 크루이름 : <input type=\"text\" name=\"crewName\"></label>");
        w.write("<label># 레벨 :<input type=\"radio\" name=\"danceLevel\" value=\"PROFESSIONAL\"> 프로 <input type=\"radio\" name=\"danceLevel\" value=\"AMATEUR\"> 아마추어 <input type=\"radio\" name=\"danceLevel\" value=\"BEGINNER\"> 초보자 </label>");
        w.write("<label># 장르 :<input type=\"checkbox\" name=\"genres\" value=\"HIPHOP\"> 힙합 <input type=\"checkbox\" name=\"genres\" value=\"STREET\"> 스트릿 <input type=\"checkbox\" name=\"genres\" value=\"KPOP\"> 케이팝 </label>");
        w.write("<label><button id=\"reg-btn\" type=\"submit\">등록</button></label>");
        w.write("</form>");
        w.write("</body>\n");
        w.write("</html>");

        w.flush();
        w.close();

    }
}