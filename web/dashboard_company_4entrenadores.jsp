<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DCGym - Company - Personal</title>
    <jsp:include page="_default_head.jsp"/>
</head>
<body style="background: url(image/fondo3.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
<jsp:include page="_default_navbar.jsp"/>
    <div class="container">
        <jsp:include page="_default_navbar_left_company.jsp"/>
        <div class="col-sm-9">
            <button class="btn btn-info"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Personal</button>
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
