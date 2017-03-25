<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>DCGym - Conócenos</title>
    <jsp:include page="_default_head.jsp"/>

</head>
<style >
   h2 {
       -webkit-text-stroke: 2px blue;
       color: white;
   }

    p {
        font-weight: 900;
        text-align : justify;
    }

</style>

<body style="background: linear-gradient( 45deg, white, whitesmoke, white)  ; ">
    <jsp:include page="_default_navbar.jsp"/>
<%--Resultados--%>
    <div id="searchhere" class="container" >
            <div class="row" >
        <h1 style="text-align: center;-webkit-text-stroke: 2px black">Conócenos</h1>
            <div class="col-md-16" >
                <h2  >¿Qué Significa "Dc Gym"?</h2>
                <p >
                    Dc Gym es básicamente una idea que surgió de poder facilitar la administración de información de los centros de entrenamiento, puesto que el manejo de datos personales y de control de rutinas de sus usuarios son importantes para brindarles una adecuada atención. Sin embargo, el enfoque actual del proyecto va más allá de solo guardar datos, ya que ahora también se busca que el usuario pueda interactuar de manera dinámica con sus propios datos usando la plataforma y permitiéndole de esa forma estar actualizado de su progreso continuamente.
                </p>
            </div>

            <div class="col-md-16">
                <h2>¿Qué es "Dc Gym"?</h2>
                <p>
                    Es una plataforma web orientada principalmente a gimnasios, para que estos puedan archivar de forma ordenada el historial de sus clientes y sus entrenadores. También es útil para personas que desean buscar un centro de entrenamiento adecuado a sus necesidades o requerimientos.
                </p>
            </div>

            <div class="col-md-17">
                <h2>Misión</h2>
                <p>
                    Brindar una plataforma flexible y amigable para los gimnasios, sus usuarios, entrenadores y personas no asociadas a la página o visitantes en el cual se les brinde los servicios de guardar u obtener información dependiendo del caso.
                </p>
            </div>

                <div class="col-md-17">
                    <h2>Visión</h2>
                    <p>
                        Ser la plataforma web mejor desarrollada para administrar información de centros de entrenamiento en el Perú. y personas no asociadas a la página o visitantes en el cual se les brinde los servicios de guardar u obtener información dependiendo del caso.
                    </p>
                </div>

                <br>
                <br>
    </div>
    <jsp:include page="_default_footer.jsp"/>
    <script type="text/javascript" src="js/search.js"></script>

</body>
</html>
