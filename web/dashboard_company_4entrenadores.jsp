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
            <button class="btn btn-info" data-toggle="modal" data-target="#mymodal"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Personal</button>
            <div class="row"><br></div>
            <div class="input-group">

                <span class="input-group-addon">Buscar</span>
                <input id="filtrar" type="text" class="form-control" placeholder="Ingresa la canción de este Disco que deseas Buscar...">
            </div>
            </br>
            <table class="table table-responsive">
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
                            <td><s:property value="people.firstName"/> <s:property value="people.lastName"/></td>
                            <td><s:property value="people.cellPhone"/></td>
                            <td><s:property value="employeeType.name"/></td>
                            <td><s:property value="people.dateBirth"/></td>
                            <td><a class="btn btn-info" href="">Modificar</a><br><a class="btn btn-danger" href="">Eliminar</a></td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>

        </div>
    </div>
<div id="mymodal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center" id="gridSystemModalLabel">Nuevo Usuario</h4>
            </div>
            <form name="companyemployeecreate" action="companyemployeecreate.action" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="people.firstName" type="text" placeholder="Nombre" /></div>
                            <div class="col-md-6"><input class="form-control" name="people.lastName" type="text" placeholder="Apellido" /></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="people.dni" type="text" placeholder="DNI" /></div>
                            <div class="col-md-6"><input class="form-control" name="people.dateBirth" type="text" placeholder="F.Nacimiento AAAA-MM-DD" /></div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="people.email" type="text" placeholder="Correo" /></div>
                            <div class="col-md-6"><input class="form-control" name="people.address" type="text" placeholder="Direccion"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="people.cellPhone" type="tel" placeholder="Celular" /></div>
                            <div class="col-md-6"><input class="form-control" name="people.telePhone" type="tel" placeholder="Telefono"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="people.userName" type="text" placeholder="Usuario" /></div>
                            <div class="col-md-6"><input class="form-control" name="people.password" type="text" placeholder="Contraseña"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12">
                                <select class="form-control" name="employeeType.id">
                                    <s:iterator value="employeeTypes">
                                        <option value="<s:property value="id"/>" > <s:property value="name"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    <%--<button type="button" class="btn btn-primary">Guardar</button>--%>
                    <input type="submit" class="btn btn-primary" value="Guardar">
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<s:iterator value="employees">
    <div id="mymodal<s:property value="id"/>" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title text-center"> Membresia : <s:property value="id" /></h4>
                </div>
                <form name="companynewgymmembershiptypeedit" action="companynewgymmembershiptypeedit.action" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="row">
                                <input type="hidden" name="membershipType.id" value="<s:property value="membershipType.id"/>">
                                <div class="col-md-12"><input class="form-control" name="membershipType.name" type="text" placeholder="Nombre de Membresia" value="<s:property value="membershipType.name"/>" /></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6"><input class="form-control" name="membershipType.cost" type="number" value="<s:property value="membershipType.cost"/>"/></div>
                                <div class="col-md-6"><input class="form-control" name="membershipType.daysDuration" type="number" value="<s:property value="membershipType.daysDuration"/>"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12">
                                    <textarea name="membershipType.description" class="form-control" rows="3"><s:property value="membershipType.description"/></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            <%--<button type="button" class="btn btn-primary">Guardar</button>--%>
                        <input type="submit" class="btn btn-primary" value="Guardar">
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</s:iterator>
<jsp:include page="_default_footer.jsp"/>
</body>
</html>
