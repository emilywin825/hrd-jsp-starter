<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.jsp.entity.Dancer" %>
<%!
    // 필드 선언 -> 이거 클래스이므로
    // 댄서들의 데이터베이스 역할 (key: 댄서명, value: 댄서객체)
    private final static Map<String, Dancer> dancerMap = new HashMap();
%>

<%
    // 비즈니스 로직
    //form에서 전송한데이터 한글처리
    request.setCharacterEncoding("UTF-8");

    // DancerRegisterViewServlet에서 전달된 파라미터 읽기
    String name = request.getParameter("name");
    String crewName = request.getParameter("crewName");
    String danceLevel = request.getParameter("danceLevel");
    String[] genresArray = request.getParameterValues("genres");

    // Dancer 객체로 포장
    Dancer dancer = new Dancer();
    dancer.setName(name);
    dancer.setCrewName(crewName);
    dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));

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

%>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>jsp 버전 댄스 리스트</h1>
    <ul>
        <%
            for (String key : dancerMap.keySet()) {
                Dancer foundDancer = dancerMap.get(key);
                out.write(String.format("<li># 이름 : %s, 크루명: %s, 수준: %s, 공연당페이: %d원, 장르: %s</li>\n"
                        , foundDancer.getName(), foundDancer.getCrewName(),
                        foundDancer.getDanceLevel().getLevelDescription(),
                        foundDancer.getDanceLevel().getPayPerEvent(),
                        foundDancer.getGenres()));
            }

        %>
    </ul>

    <a href="/chap03/dancer/register.jsp">재등록하기</a>

</body>
</html>