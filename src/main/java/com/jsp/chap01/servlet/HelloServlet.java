package com.jsp.chap01.servlet;


/*
* 서블릿 역할 : HTTP 요청과 응답 데이터를 쉽게 처리할 수 있게 해주는 자바의 API
* */


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


//WAS에게 해당 서블릿을 언제 사용할지 알려주는 코드
@WebServlet("/hello") // ->클라이언트가 /hello라고하면 이 함수 실행해라
public class HelloServlet extends HttpServlet { //extends HttpServlet하면 서블릿 API 사용 가능. 따로 깔아야하는 라이브러리인데 톰켓에 깔려있음

    //기본 생성자
    public HelloServlet() {
        System.out.println("\n\n\n\n헬로 서블릿 객체가 생성됨!\n\n\n\n");
    }

    //실제로 개발자가 작성해야하는 부분 //https://www.notion.so/3-8bc0c34d5e3a417abb225de822ce3547 여기 사진에서 가운데부분 역할
    //실행시점 : 클라이언트가 어떠한 요청을 했을 때 서버는 뭘해줄것인가?
    //요청이 들어왔을 떄 호출( -> 콜백 개념)하도록 위임 -> 톰캣에게 위임
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //헤더 정보 가져오고 이런거 서블릿이 제공하는 함수로 가져올 수 있따는거
//        암기 x. 옛날 방식 살펴보는거임 -> 스프링에 다 들어 있음
        //요청 방식
        String method = req.getMethod();
        //요청 URI
        String uri = req.getRequestURI();
        //요청 파라미터
        String queryString = req.getQueryString();
        // 헤더 정보 읽기
        String cc = req.getHeader("Cache-Control");

        //http://localhost:8383/hello?name=%EA%B9%80%EC%B2%A0%EC%88%98&age=30 이렇게 했음 / name=김철수
        System.out.println("무슨일을 해볼까??");
        System.out.println("method = " + method); //method = GET
        System.out.println("uri = " + uri);//uri = /hello
        System.out.println("queryString = " + queryString);//queryString = name=%EA%B9%80%EC%B2%A0%EC%88%98&age=30
        System.out.println("cc = " + cc);//cc = max-age=0
//    소스코드 바뀌면 톰켓 재실행 필요

        //쿼리 스트링 파라미터 값 가져오기
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("name = " + name);// name = 김철수
        System.out.println("age = " + age);// age = 30

        //응답메시지 생성
        //h1태그로 xxx님의 출생년도는 xxxx년입니다.
        //핵심로직 : 출생년도 구하기
        //올해년도 - 나이 + 1
        int year=LocalDate.now().getYear();
        int birthYear = year - Integer.parseInt(age) + 1;
        System.out.println("birthYear = "+birthYear); //birthYear = 1994

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //응답 메시지 생성
        //펜을 가져옴
        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
            w.write("<head>\n");
            w.write("</head>\n");
                w.write("<body>\n");
                    w.write("   <h1>\n");
                        w.write(String.format("%s님은 %d년생입니다.",name,birthYear));
                    w.write(String.format(" </h1>\n"));
                w.write("</body>\n");
        w.write("</html>");

        w.flush(); //버퍼 비우기
        w.close(); // 펜 객체 해제
    }
}
