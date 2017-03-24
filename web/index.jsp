<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>DCGym - Bienvenido</title>
    <jsp:include page="_default_head.jsp"/>

</head>
<body style="background: url(image/fondo1.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
    <jsp:include page="_default_navbar.jsp"/>
    <%--Buscador--%>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <h2 class="text-center" style="  color: white;
  font-weight: bold;    -webkit-text-stroke: 2px darkslategrey">Ingrese datos de referencia</h2>
                <div id="custom-search-input">
                    <div class="input-group col-md-12">
                        <input id="search" type="text" class="form-control input-lg" placeholder="Buscar"/>
                        <span class="input-group-btn">
                            <button class="btn btn-info btn-lg" type="button">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--FIN Buscador--%>

    <%--Resultados--%>
    <div id="searchhere" class="container">
        <s:action name="show" flush="true" executeResult="true" namespace="/"/>
    </div>

    <jsp:include page="_default_footer.jsp"/>
    <script type="text/javascript" src="js/search.js"></script>
</body>
</html>
