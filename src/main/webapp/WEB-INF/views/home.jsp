<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: EVREN
  Date: 19.3.2018
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${homepage.title}</title>
</head>
<body>
<h1>Spring MVC Dil Desteği</h1>
Language : <a href="?lang=en">English</a> | <a href="?lang=tr">Türkçe</a>

<p>${karsilama}</p>


</body>
</html>
