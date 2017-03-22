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
        <jsp:include page="_default_navbar_left_company.jsp"/>
        <div class="col-sm-9">
            <h1 class="text-center"><s:property value="#session.user"/></h1>
            <h2 class="text-center">Soy un negocio</h2>
            <button class="btn btn-info"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Entrenador</button>
            <div class="row"><br></div>
            <div class="input-group">

                <span class="input-group-addon">Buscar</span>
                <input id="filtrar" type="text" class="form-control" placeholder="Ingresa la canción de este Disco que deseas Buscar...">
            </div>
            </br>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Telefono</th>
                    <th>Direccion</th>
                    <th>DNI</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody class="buscar">
                <s:iterator value="employees">
                    <tr>
                        <td><s:property value="people.name"/> <s:property value="people.surName"/></td>
                        <td><s:property value="people.cellphone"/></td>
                        <td><s:property value="employeeType.name"/></td>
                        <td><s:property value="trainingCenters.name"/></td>
                        <td><s:property value="employeeType.name"/></td>
                        <td><a class="btn btn-info" href="">Modificar</a><br><a class="btn btn-danger" href="">Eliminar</a></td>
                    </tr>

                </s:iterator>
                </tbody>
            </table>

        </div>
    </div>
<jsp:include page="_default_footer.jsp"/>
</body>
</html>
