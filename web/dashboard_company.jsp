<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>


<html>
<head>
    <title>Title</title>
    <jsp:include page="_default_head.jsp"/>
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/jquery.simpleWeather.min.js"></script>
    <script src="js/Chart.min.js"></script>
    <script src="js/graficos.js" type="text/javascript"></script>

</head>
<body style="background: url(image/fondo3.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
<jsp:include page="_default_navbar.jsp"/>
<div class="container">
    <jsp:include page="_default_navbar_left_company.jsp"/>
    <div class="col-sm-9">
        <div class="row">




            <!-- COLUMN TWO -->
            <div class="col-sm-5 col-md-7">
                <div id="pie-chart-widget" class="panel">
                    <div class="panel-heading text-center">
                        <h5 class="text-uppercase"><strong>Visitas</strong></h5>
                    </div>
                    <div class="panel-body">
                        <canvas id="myPieChart" width="360" height="180" style="width: 360px; height: 180px;"></canvas>
                    </div>
                    <div class="panel-footer">
                        <div class="list-block">

                                <ul class="text-center legend">
                                    <li class="Clientes" style="margin-right: 1px;">
                                        Clientes
                                        <h2>53% </h2>
                                    </li>
                                    <li class="Entrenadores">
                                        Entrenadores
                                        <h2>31%</h2>
                                    </li>
                                    <li class="Otros" style="margin-left: 1px;">
                                        Otros
                                        <h2>17%</h2>
                                    </li>
                                </ul>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="_default_footer.jsp"/>
</body>
</html>