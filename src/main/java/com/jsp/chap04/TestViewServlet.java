package com.jsp.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// url요청으로 /hahahoho 라고 요청하면 test.jsp를 열어줄 것이다.
@WebServlet("/hahahoho")
public class TestViewServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // jsp 파일 열기 : 포워딩
        RequestDispatcher dp
                = req.getRequestDispatcher("/WEB-INF/test.jsp");
        dp.forward(req, resp);
    }
}