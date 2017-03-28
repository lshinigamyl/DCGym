<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>DCGym - Contáctanos</title>

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
    label{
        font-weight: 900;
        color: black;
        -webkit-text-stroke:  0.2px #dcaa88 ;
        font-size: 20px;
    }

</style>
<body style="background: url(image/fondo1.png); background-position: center center; background-repeat: no-repeat;
 background-attachment: fixed;background-size: cover;">
    <jsp:include page="_default_navbar.jsp"/>
    <%--Resultados--%>
    <div class="container">
        <div id="contact_form" class="row">
            <div class="col-md-12">
                <h2>Contáctenos</h2>
                <form role="form" id="feedbackForm"  data-toggle="validator" data-disable="false" action="EmailSendingServlet" method="post">
                    <div class="form-group">
                        <label class="control-label" for="name">Nombre *</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Escribe tu nombre" required/>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked form-control-feedback"></i></span>
                        </div>
                        <span class="help-block" style="display: none;">Por favor escribe tu nombre.</span>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="email">Motivo*</label>
                        <select name="subject" class="form-control" required>
                            <option value="Consulta General">Consulta General </option>
                            <option value="Registrar mi Gimnasio">Registrar mi Gimnasio</option>
                            <option value="Reportar Error">Reportar Error</option>
                        </select>
                        <span class="help-block" style="display: none;">Por favor escribe un  e-mail valido.</span>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="email">Email *</label>
                        <div class="input-group">
                            <input type="email" class="form-control" id="email" name="recipient" placeholder="Escribe tu email" required/>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked form-control-feedback"></i></span>
                        </div>
                        <span class="help-block" style="display: none;">Por favor enter a valid e-mail address.</span>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="message">Mensaje *</label>
                        <div class="input-group">
                            <textarea rows="5" cols="30" class="form-control" id="message" name="content" placeholder="Escribe tu mensaje" required></textarea>
                            <span class="input-group-addon"><i class="glyphicon glyphicon-unchecked form-control-feedback"></i></span>
                        </div>
                        <span class="help-block" style="display: none;">Por favor escribe enter a message.</span>
                    </div>
                    <div class="form-group">
                        <div class="g-recaptcha" data-sitekey="your_site_key"></div>
                        <span class="help-block" style="display: none;">Por favor escribe check that you are not a robot.</span>
                    </div>
                    <span class="help-block" style="display: none;">Please enter a the security code.</span>
                 <button type="submit" id="feedbackSubmit"  class="btn btn-primary btn-lg" data-loading-text="Sending..." style="display: block; margin-top: 10px;">Enviar</button>

                </form>
            </div><!--/span-->
        </div><!--/row-->
        <hr>
    </div><!--/.container-->
    <jsp:include page="_default_footer.jsp"/>
    <script type="text/javascript" src="js/search.js"></script>
</body>


<!--/.javamail mail = new javamail();mail.send("destino@mail.com","Esto es una prueba","Este correo fue enviado usando JavaMail");-->

</html>
