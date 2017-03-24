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
            <table class="table table-hover">
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
                <s:iterator value="customerMemberships">
                    <tr>
                        <td><s:property value="customer.people.name"/> <s:property value="customer.people.surName"/></td>
                        <td><s:property value="customer.comment"/></td>
                        <td><a class="btn btn-info" href="">Modificar</a><br><a class="btn btn-danger" href="">Eliminar</a></td>
                        <td><s:property value="trainingCenterMembership.membershipType.name"/></td>
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
            <form id="" name="" action="" method="post">
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
                                <s:iterator value="trainingCenterMemberships">
                                    <option value="<s:property value="id"/>" > <s:property value="membershipType.name"/></option>
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
</body>
</html>
