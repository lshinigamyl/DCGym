<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="gyms">
<div class="row searchhere" style="display: none;">
    <div class="col-sm-8 col-sm-offset-2 thumbnail">

        <div class="row">
            <div class="col-sm-4 text-center">
                <div class="row"><br></div>
                <img class="img-thumbnail" src="image/<s:property value="id"/>.jpg" alt="<s:property value="id"/>">
                <div class="row"><br></div>
            </div>
            <div class="col-sm-7">

                <div class="bg-primary img-rounded">
                    <h2 class="text-center "><s:property value="name"/></h2>
                </div>
                <address>
                    <strong>Descripcion:</strong><br>
                    <p class="text-justify"><s:property value="description"/></p>
                </address>
                <address>
                    <strong>Direccion:</strong><br>
                    <p><s:property value="address"/><br></p>
                    <abbr title="Phone">P:</abbr>  (01) <s:property value="telephone"/>
                </address>
                <address>
                    <strong>Sitio Web:</strong>
                    <a href="<s:property value="websites"/>"><s:property value="websites"/></a>
                </address>
            </div>
        </div>
    </div>
</div>
</s:iterator>