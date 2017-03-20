<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Fjorsvartnir
  Date: 12/03/2017
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="_default_head.jsp"/>
</head>
<body>
    <jsp:include page="_default_navbar.jsp"/>
    <div class="container">
        <jsp:include page="_default_navbar_left.jsp"/>
            <div class="col-sm-9">
                <h1 class="text-center"><s:property value="#session.user"/></h1>
                <h2 class="text-center">Soy un cliente</h2>
            </div>
    </div>
    <jsp:include page="_default_footer.jsp"/>
</body>
</html>
