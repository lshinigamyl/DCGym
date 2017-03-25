<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DCGym - Company - Membresias</title>
    <jsp:include page="_default_head.jsp"/>
</head>
<body style="background: url(image/fondo3.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
<jsp:include page="_default_navbar.jsp"/>
    <div class="container">
        <jsp:include page="_default_navbar_left_company.jsp"/>
        <div class="col-sm-9">


            <button class="btn btn-info" data-toggle="modal" data-target="#mymodal"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Membresia</button>
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
                    <th>Precio</th>
                    <th>Descripcion</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody class="buscar">
                <s:iterator value="gymMembershipTypes">
                    <tr>
                        <td><s:property value="membershipType.name"/></td>
                        <td><s:property value="membershipType.cost"/></td>
                        <td><s:property value="membershipType.description"/></td>
                        <td><form id="companynewgymmembershiptypedelete" name="companynewgymmembershiptypedelete" action="companynewgymmembershiptypedelete.action" method="post"> <input name="id" style="display: none;" value="<s:property value="id"/>"><input type="submit" class="btn btn-danger" value="Eliminar"></form><br><button class="btn btn-info" data-toggle="modal" data-target="#mymodal<s:property value="id"/>"> Editar</button></td>
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
                <h4 class="modal-title text-center" id="gridSystemModalLabel">Nuevo Tipo de Membresia</h4>
            </div>
            <form id="companynewgymmembershiptype" name="companynewgymmembershiptype" action="companynewgymmembershiptype.action" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12"><input class="form-control" name="membershipType.name" type="text" placeholder="Nombre de Membresia" /></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6"><input class="form-control" name="membershipType.cost" type="number" placeholder="Costo"/></div>
                            <div class="col-md-6"><input class="form-control" name="membershipType.daysDuration" type="number" placeholder="Duracion"/></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-12">
                                <textarea name="membershipType.description" class="form-control" rows="3"></textarea>
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
<s:iterator value="gymMembershipTypes">
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
