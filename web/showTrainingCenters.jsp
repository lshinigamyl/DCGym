<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Fjorsvartnir
  Date: 18/03/2017
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>

<s:iterator value="trainingCenters">
<div class="row">
    <div class="col-sm-8 col-sm-offset-2 thumbnail">

        <div class="row">
            <div class="col-sm-4 text-center">
                <div class="row"><br></div>
                <img class="img-thumbnail" src="image/<s:property value="id"/><s:property value="name"/>.jpg" alt="img1">
                <div class="row"><br></div>
            </div>
            <div class="col-sm-7">

                <div class="bg-primary img-rounded">
                    <h2 class="text-center "><s:property value="name"/></h2>
                </div>
                <address>
                    <strong>Descripcion:</strong><br>
                    <p class="text-justify"><s:property value="description"/></p><br>
                </address>
                <address>
                    <strong>Direccion:</strong><br>
                    <s:property value="address"/><br>
                    <abbr title="Phone">P:</abbr><s:property value="telephone"/>
                </address>
                <address>
                    <strong>Correo:</strong><br>
                    <a href="<s:property value="websites"/>"><s:property value="websites"/></a>
                </address>
            </div>
        </div>
    </div>
</div>
</s:iterator>