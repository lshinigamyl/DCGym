
<%--
  Created by IntelliJ IDEA.
  User: Fjorsvartnir
  Date: 12/03/2017
  Time: 15:51
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
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Login</title>
    <script src="js/jquery.js"/>
    <sb:head/>
    <jsp:include page="_default_head.jsp"/>
</head>
<body style="background: url(image/fondo2.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
    <%--<s:actionerror theme="bootstrap"/>--%>
    <%--<s:actionmessage theme="bootstrap"/>--%>
    <%--<s:fielderror theme="bootstrap"/>--%>
    <%--<s:form action="validate" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal"--%>
                <%--label="A sample horizontal Form">--%>
        <%--<s:textfield name="userName" label="Usuario"/>--%>
        <%--<s:password name="password" label="Password"/>--%>
        <%--<s:submit value="login" cssClass="btn"/>--%>
    <%--</s:form>--%>

<div class="container" style="margin-top:30px">
    <div class="col-md-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading"><h3 class="panel-title"><strong>Login</strong></h3>
                <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Olvidaste tu contraseña?</a></div>
            </div>

            <div class="panel-body">
                <form id="login" name="login" action="<s:url value="login.action"/>" enctype="multipart/form-data" role="form" method="post">
                    <s:if test="hasActionErrors()">
                        <div class="alert alert-danger">
                        <a class="close" data-dismiss="alert" href="#">×</a><s:actionerror/>
                        </div>
                    </s:if>


                    <div style="margin-bottom: 12px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="validate_userName" type="text" class="form-control" name="userName" value="" placeholder="usuario">
                    </div>
                    <div style="margin-bottom: 12px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="validate_password" type="password" class="form-control" name="password" placeholder="contraseña">
                    </div>
                    <div class="input-group">
                        <div class="checkbox" style="margin-top: 0px;">
                            <label>
                                <input id="login-remember" type="checkbox" name="remember" value="1"> Recuerdame
                            </label>
                        </div>
                    </div>

                    <input id="validate_0" type="submit"  value="Submit" class="btn btn-success">

                    <hr style="margin-top:10px;margin-bottom:10px;" >

                    <div class="form-group">

                        <div style="font-size:85%">
                            Don't have an account!
                            <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                Sign Up Here
                            </a>
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="_default_footer.jsp"/>
</body>
</html>
