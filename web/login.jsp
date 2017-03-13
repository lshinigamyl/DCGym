<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Fjorsvartnir
  Date: 12/03/2017
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
    <title>TODO supply a title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<s:form action="validate">
    <s:textfield name="userName" label="User name"/>
    <s:password name="password" label="Password"/>
    <s:submit value="login"/>
</s:form>
<%--<div class="container" style="margin-top:30px">--%>
    <%--<div class="col-md-4 col-md-offset-4">--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading"><h3 class="panel-title"><strong>Sign in </strong></h3>--%>
                <%--<div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>--%>
            <%--</div>--%>

            <%--<div class="panel-body">--%>
                <%--<form role="form" method="post">--%>
                    <%--<div class="alert alert-danger">--%>
                        <%--<a class="close" data-dismiss="alert" href="#">×</a>Incorrect Username or Password!--%>
                    <%--</div>--%>
                    <%--<div style="margin-bottom: 12px" class="input-group">--%>
                        <%--<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>
                        <%--<input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username or email">--%>
                    <%--</div>--%>
                    <%--<div style="margin-bottom: 12px" class="input-group">--%>
                        <%--<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>--%>
                        <%--<input id="login-password" type="password" class="form-control" name="password" placeholder="password">--%>
                    <%--</div>--%>
                    <%--<div class="input-group">--%>
                        <%--<div class="checkbox" style="margin-top: 0px;">--%>
                            <%--<label>--%>
                                <%--<input id="login-remember" type="checkbox" name="remember" value="1"> Remember me--%>
                            <%--</label>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<button type="submit" class="btn btn-success">Sign in</button>--%>

                    <%--<hr style="margin-top:10px;margin-bottom:10px;" >--%>

                    <%--<div class="form-group">--%>

                        <%--<div style="font-size:85%">--%>
                            <%--Don't have an account!--%>
                            <%--<a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">--%>
                                <%--Sign Up Here--%>
                            <%--</a>--%>
                        <%--</div>--%>

                    <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
