package com.jsp.chap02;

import com.jsp.entity.Dancer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//등록데이터를 데이터베이스에 넣고 댄서목록을 보여줘!
@WebServlet("/chap02/dancer/reg-process")
public class DancerRegProcessServlet extends HttpServlet {

    // 댄서들의 데이터베이스 역할 (key: 댄서명, value: 댄서객체) : 아직 db 안배워서 Map이 대신
    private final static Map<String, Dancer> dancerMap = new HashMap();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //form에서 전송한데이터 한글처리
        req.setCharacterEncoding("UTF-8");

        // DancerRegisterViewServlet에서 전달된 파라미터 읽기
        String name = req.getParameter("name"); //name="name"
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genresArray = req.getParameterValues("genres"); //장르 여러개라 getParameterValues

        // Dancer 객체로 포장
        Dancer dancer = new Dancer();
        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel)); //valueOf : enum으로 바꿀 떄 사용

        List<Dancer.Genre> genres = new ArrayList<>();
        if (genresArray != null) {
            for (String g : genresArray) {
                genres.add(Dancer.Genre.valueOf(g));
            }
        }
        dancer.setGenres(genres);

        System.out.println("dancer = " + dancer);


        // dancerList에 저장
        dancerMap.put(name, dancer);


        // 결과 출력
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");

        w.write("<ul>");

        for (String key : dancerMap.keySet()) {
            Dancer foundDancer = dancerMap.get(key);
            w.write(String.format("<li># 이름 : %s, 크루명: %s, 수준: %s, 공연당페이: %d원, 장르: %s</li>\n"
                    , foundDancer.getName(), foundDancer.getCrewName(),
                    foundDancer.getDanceLevel().getLevelDescription(),
                    foundDancer.getDanceLevel().getPayPerEvent(),
                    foundDancer.getGenres()));
        }

        w.write("</ul>");

        w.write("<a href=\"/chap02/dancer/register\">새로운 등록하기</a>");

        w.write("</body>\n");
        w.write("</html>");

        w.flush();
        w.close();
    }
}