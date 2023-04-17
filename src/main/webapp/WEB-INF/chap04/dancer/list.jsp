<%-- 서버가 만들어준 데이터 출력만 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.*" %>
<%@ page import="com.jsp.entity.Dancer" %>

<%
    // request객체에 담긴 리스트 꺼내기
    List<Dancer> dancerList = (List<Dancer>) request.getAttribute("dl");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>mvc 버전 댄서 목록 뷰</h1>
    <% for (Dancer d : dancerList) {  %>

        <li>
            # 이름: <%= d.getName() %>,
            # 크루명: <%= d.getCrewName() %>,
            # 레벨: <%= d.getDanceLevel() %>
        </li>

    <% } %>

        <a href="/dancer/join">재등록</a>

</body>
</html>