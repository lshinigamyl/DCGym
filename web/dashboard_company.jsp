<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Fjorsvartnir
  Date: 12/03/2017
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<!-- public class UserInfoBean implements java.io.Serializable
{
private String firstName;
private boolean registered;

public String getFirstName() {
return firstName;
}
public void setFirstName(String firstName) {
this.firstName = firstName;
}
public boolean isRegistered() {
return registered;
}
public void setRegistered(boolean registered) {
this.registered = registered;
}
}-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="_default_head.jsp"/>
</head>
<body style="background: url(image/fondo3.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
<jsp:include page="_default_navbar.jsp"/>
    <div class="container">
        <jsp:include page="_default_navbar_left_company.jsp"/>
        <div class="col-sm-9">


        </div>
    </div>

<jsp:include page="_default_footer.jsp"/>

</body>
</html>
