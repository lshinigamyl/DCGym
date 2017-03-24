<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="option" value="menuOption"/>
<div class="col-md-3">
        <a href="<s:url value="company.action" />"><div <s:if test="%{#option=='index'}">style="background-color: #d58512;"</s:if> class="well"><strong>DASHBOARD</strong> </div></a>
        <a href="<s:url value="companyusuarios.action" />"><div <s:if test="%{#option=='usuario'}">style="background-color: #d58512"</s:if> class="well"><strong>USUARIOS</strong> </div></a>
        <a href="<s:url value="companymembresia.action"/>"><div <s:if test="%{#option=='membresia'}">style="background-color: #d58512"</s:if> class="well"><strong>MEMBRESIA</strong> </div></a>
        <a href="<s:url value="companyentrenadores.action"/>"><div <s:if test="%{#option=='entrenador'}">style="background-color: #d58512"</s:if> class="well"><strong>PERSONAL</strong> </div></a>
    </div>
