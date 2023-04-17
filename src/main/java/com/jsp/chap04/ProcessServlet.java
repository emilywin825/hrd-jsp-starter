package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dancer/process")
public class ProcessServlet extends HttpServlet {

    //댄서 저장소를 의존해야 한다.
    private final DancerRepository repository = new DancerRepository();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        
        //form에서 넘어온 데이터 읽기 (클라이언트 데이터 처리 : controller -> service가 담당)

        //form에서 전송한데이터 한글처리
        request.setCharacterEncoding("UTF-8");

        // DancerRegisterViewServlet에서 전달된 파라미터 읽기
        String name = request.getParameter("name");
        String crewName = request.getParameter("crewName");
        String danceLevel = request.getParameter("danceLevel");
        String[] genresArray = request.getParameterValues("genres");
        
        //Dancer 객체를 생성, 입력값 세팅 (business logic : model(자바객체)) //business logic : 서버가 내부에서 핵심적으로 해야할 일
        //db에 저장 (business logic : model(자바객체)) -> 다른 클래스에게 위임
        repository.save(name,crewName,danceLevel,genresArray);
        
        //댄서 목록을 브라우저에 출력 (jsp에게 맞김 : view) - 뷰 포워딩을 통해서
        //저장소에 있는 댄서 목록을 jsp파일로 전달할 수 있는 방법이 필요
        //DancerRepository의 map을 서블릿이 받고 그걸 뷰에 출력

        List<Dancer> dancerList = repository.findAll(); //dancerList를 jsp로 보내야함

        //request 객체는 하나의 요청간에 데이터 수송을 할 수 있음.
        request.setAttribute("dl",dancerList); //서블릿에서 객체 수송 방법 -> request에 태워서 dl이란 이름으로 보냄 (list.jsp로)!!스프링에서도 나옴!!

        RequestDispatcher dp
                = request.getRequestDispatcher("/WEB-INF/chap04/dancer/list.jsp"); //dp : 포워드하기 위한 객체
        dp.forward(request, resp);

    }
}
