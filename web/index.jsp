<%--
  Created by IntelliJ IDEA.
  User: Fjorsvartnir
  Date: 12/03/2017
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>DCGym - Bienvenido</title>
    <jsp:include page="_default_head.jsp"/>
    <style>
      /* Sticky footer styles
-------------------------------------------------- */
      html {
        position: relative;
        min-height: 100%;
      }
      body {
        /* Margin bottom by footer height */
        margin-bottom: 60px;
      }
      .footer {
        /*  position: absolute;*/
        bottom: 0;
        width: 100%;
        /* Set the fixed height of the footer here */
        height: 60px;
        background-color: #f5f5f5;
      }


      /* Custom page CSS
      -------------------------------------------------- */
      /* Not required for template or sticky footer method. */

      body > .container {
        padding: 60px 15px 0;
      }
      .container .text-muted {
        margin: 20px 0;
      }

      .footer > .container {
        padding-right: 15px;
        padding-left: 15px;
      }

      code {
        font-size: 80%;
      }
      #custom-search-input{
        padding: 3px;
        border: solid 1px #E4E4E4;
        border-radius: 6px;
        background-color: #fff;
      }

      #custom-search-input input{
        border: 0;
        box-shadow: none;
      }

      #custom-search-input button{
        margin: 2px 0 0 0;
        background: none;
        box-shadow: none;
        border: 0;
        color: #666666;
        padding: 0 8px 0 10px;
        border-left: solid 1px #ccc;
      }

      #custom-search-input button:hover{
        border: 0;
        box-shadow: none;
        border-left: solid 1px #ccc;
      }

      #custom-search-input .glyphicon-search{
        font-size: 23px;
      }
    </style>
  </head>
  <body>
  <jsp:include page="_default_navbar.jsp"/>
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <h2 class="text-center">Ingrese datos de referencia</h2>
        <div id="custom-search-input">
          <div class="input-group col-md-12">
            <input type="text" class="form-control input-lg" placeholder="Buscar" />
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
  <div class="container">
    <div class="row">
      <div class="col-md-8 col-md-offset-2">
        <h1>Gymnasio 1 </h1>
        <h2>Direccion</h2>
        <h3>Telegonos</h3>
        <h4>Celular</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-md-8 col-md-offset-2">
        <h1>Gymnasio 1 </h1>
        <h2>Direccion</h2>
        <h3>Telegonos</h3>
        <h4>Celular</h4>
      </div>
    </div>
    <div class="row">
      <div class="col-md-8 col-md-offset-2">
        <h1>Gymnasio 1 </h1>
        <h2>Direccion</h2>
        <h3>Telegonos</h3>
        <h4>Celular</h4>
      </div>
    </div>
  </div>
  <footer class="footer navbar-fixed-bottom">
    <div class="container">

      <div class="col-sm-4 text-center">
        <button class="btn btn-success">Conocenos</button>
      </div>
      <div class="col-sm-4 text-center">
        <p>hols smos team dc</p>
        <p>hols smos team dc</p>
        <p>hols smos team dc</p>
        <p>hols smos team dc</p>
      </div>
      <div class="col-sm-4 text-center">
        <button class="btn btn-success">Contactanos</button>
      </div>

    </div>
  </footer>
  <jsp:include page="_default_footer.jsp"/>
  </body>
</html>
