<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DCGym - Company - Rutinas</title>
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
            <div class="row">
            <div class="col-sm-12">
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
                <s:iterator var="exe" value="exerciseRoutines">
                    <s:if test="#id!=#exe.routine.id">
                        <tr >
                            <td colspan="4"><s:property value="#exe.routine.name"/></td>
                        </tr>
                        <s:set name="id" value="#exe.routine.id"/>
                    </s:if>

                    <tr>

                        <td><s:property value="#exe.range"/></td>
                        <td><s:property value="#exe.repeat"/></td>
                        <td><s:property value="#exe.value_percent"/></td>
                        <td><s:property value="#exe.comment"/></td>
                        <td><s:property value="#exe.sequence"/></td>
                        <td><a class="btn btn-info" href="">Modificar</a><br><a class="btn btn-danger" href="">Eliminar</a></td>
                    </tr>

                </s:iterator>
                </tbody>
            </table>
            </div>
            </div>
        </div>
    </div>
<div id="mymodal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title text-center" id="gridSystemModalLabel">Nuevo Usuario</h4>
            </div>
            <form name="companyroutinecreate" action="companyroutinecreate.action" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="name" type="text" placeholder="Nombre" /></div>
                            <div class="col-md-6"><input class="form-control" name="surname" type="text" placeholder="Apellido" /></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="document_number" type="number" placeholder="DNI" /></div>
                            <div class="col-md-6"><input class="form-control" name="email" type="email" placeholder="Correo" /></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="date_birth" type="date" /></div>
                            <div class="col-md-6"><input class="form-control" name="address" type="text" placeholder="Direccion"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="cellphone" type="tel" placeholder="Celular" /></div>
                            <div class="col-md-6"><input class="form-control" name="telephone" type="tel" placeholder="Telefono"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="user" type="text" placeholder="Usuario" /></div>
                            <div class="col-md-6"><input class="form-control" name="password" type="password" placeholder="Contraseña"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12">
                                <textarea class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12">
                                <select class="form-control" name="training_id">
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
<jsp:include page="_default_footer.jsp"/>
</body>
</html>
