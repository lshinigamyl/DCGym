<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DCGym - Company - Clientes</title>
    <jsp:include page="_default_head.jsp"/>
</head>
<body style="background: url(image/fondo3.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
<jsp:include page="_default_navbar.jsp"/>
    <div class="container">
        <jsp:include page="_default_navbar_left_company.jsp"/>
        <div class="col-sm-9">


            <button class="btn btn-info" data-toggle="modal" data-target="#mymodal"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Usuario</button>
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
                    <th>Comentarios</th>
                    <th>Acciones</th>
                    <th>Membresia</th>
                    <th>Añadir</th>
                </tr>
                </thead>
                <tbody class="buscar">
                <s:iterator value="customerGymMembershipTypes">
                    <tr>
                        <td><s:property value="customer.people.firstName"/> <s:property value="customer.people.lastName"/></td>
                        <td><s:property value="customer.comment"/></td>
                        <td><a class="btn btn-info" href="">Modificar</a><br><a class="btn btn-danger" href="">Eliminar</a></td>
                        <td><s:property value="gymMembershipTypes.membershipType.name"/></td>
                        <td><a class="btn btn-info" href=""><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>1 mes</a></td>
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
            <form name="companyclientcreate" action="companyclientcreate.action" method="post">
            <div class="modal-body">
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6"><input class="form-control" name="customer.people.firstName" type="text" placeholder="Nombre" /></div>
                        <div class="col-md-6"><input class="form-control" name="customer.people.lastName" type="text" placeholder="Apellido" /></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6"><input class="form-control" name="customer.people.dni" type="text" placeholder="DNI" /></div>
                        <div class="col-md-6"><input class="form-control" name="customer.people.dateBirth" type="text" placeholder="F.Nacimiento AAAA-MM-DD" /></div>

                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6"><input class="form-control" name="customer.people.email" type="text" placeholder="Correo" /></div>
                        <div class="col-md-6"><input class="form-control" name="customer.people.address" type="text" placeholder="Direccion"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6"><input class="form-control" name="customer.people.cellPhone" type="tel" placeholder="Celular" /></div>
                        <div class="col-md-6"><input class="form-control" name="customer.people.telePhone" type="tel" placeholder="Telefono"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6"><input class="form-control" name="customer.people.userName" type="text" placeholder="Usuario" /></div>
                        <div class="col-md-6"><input class="form-control" name="customer.people.password" type="text" placeholder="Contraseña"/></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-12">
                            <textarea class="form-control" rows="3" name="customer.comment"></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-12">
                            <select class="form-control" name="gymMembershipTypes.id">
                                <s:iterator value="gymMembershipTypes">
                                    <option value="<s:property value="id"/>" > <s:property value="membershipType.name"/> ($/.<s:property value="membershipType.cost"/>)</option>
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
<s:iterator value="customerGymMembershipTypes">
    <div id="mymodal<s:property value="id"/>" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title text-center"> Membresia : <s:property value="id" /></h4>
                </div>
                <form name="companyclientedit" action="companyclientedit.action" method="post">
                    <div class="modal-body">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6"><input class="form-control" name="customer.people.firstName" type="text" placeholder="Nombre" value="<s:property value="customer.people.firstName"/>" /></div>
                                <div class="col-md-6"><input class="form-control" name="customer.people.lastName" type="text" placeholder="Apellido" value="<s:property value="customer.people.lastName"/>" /></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6"><input class="form-control" name="customer.people.dni" type="text" placeholder="DNI" value="<s:property value="customer.people.dni"/>" /></div>
                                <div class="col-md-6"><input class="form-control" name="customer.people.dateBirth" type="text" placeholder="F.Nacimiento AAAA-MM-DD" value="<s:property value="customer.people.dateBirth"/>"/></div>

                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6"><input class="form-control" name="customer.people.email" type="text" placeholder="Correo" value="<s:property value="customer.people.email"/>"/></div>
                                <div class="col-md-6"><input class="form-control" name="customer.people.address" type="text" placeholder="Direccion" value="<s:property value="customer.people.address"/>"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6"><input class="form-control" name="customer.people.cellPhone" type="tel" placeholder="Celular" value="<s:property value="customer.people.cellPhone"/>"/></div>
                                <div class="col-md-6"><input class="form-control" name="customer.people.telePhone" type="tel" placeholder="Telefono" value="<s:property value="customer.people.telePhone"/>"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-6"><input class="form-control" name="customer.people.userName" type="text" placeholder="Usuario"  value="<s:property value="customer.people.userName"/>"/></div>
                                <div class="col-md-6"><input class="form-control" name="customer.people.password" type="text" placeholder="Contraseña" value="<s:property value="customer.people.password"/>"/></div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12">
                                    <textarea class="form-control" rows="3" name="customer.comment"><s:property value="customer.comment"/></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-12">
                                    <select class="form-control" name="gymMembershipTypes.id">
                                        <s:iterator value="gymMembershipTypes">
                                            <option value="<s:property value="id"/>" > <s:property value="membershipType.name"/> ($/.<s:property value="membershipType.cost"/>)</option>
                                        </s:iterator>
                                    </select>
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
<%--<script type="text/javascript">--%>
    <%--$('#exampleModal').on('show.bs.modal', function (event) {--%>
        <%--var button = $(event.relatedTarget) // Button that triggered the modal--%>
        <%--var recipient = button.data('whatever') // Extract info from data-* attributes--%>
        <%--// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).--%>
        <%--// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.--%>
        <%--var modal = $(this)--%>
        <%--modal.find('.modal-title').text('New message to ' + recipient)--%>
        <%--modal.find('.modal-body input').val(recipient)--%>
    <%--})--%>
<%--</script>--%>
<s:form action="companyclientcreate">
    <s:textfield value="customer.people.firstName"/>
    <s:textfield value="customer.people.lastName"/>
    <s:textfield value="customer.people.userName"/>
</s:form>
</body>
</html>
