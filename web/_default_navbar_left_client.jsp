<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="webFramework" value="framework"/>
<div class="col-md-3">
        <a href="<s:url value="" />" <s:if test="%{#option=='index'}">style="background-color: #d58512"</s:if>><div class="well"><strong>DASHBOARD</strong> </div></a>
        <a href="<s:url value="" />" <s:if test="%{#option=='index'}">style="background-color: #d58512"</s:if>><div class="well"><strong>MIS EJERCICIOS</strong> </div></a>
        <a href="<s:url value="" />" <s:if test="%{#option=='index'}">style="background-color: #d58512"</s:if>><div class="well"><strong>MI HISTORIAL</strong> </div></a>
        <a href="<s:url value="" />" <s:if test="%{#option=='index'}">style="background-color: #d58512"</s:if>><div class="well"><strong>MI SUSCRIPCION</strong> </div></a>
    </div>
<!-- public class UserInfoBean implements java.io.Serializable
{
private String firstName;
private boolean registered;

public String getFirstName() {
return firstName;
}
public void setFirstName(String firstName) {
this.firstName = firstName;
}
public boolean isRegistered() {
return registered;
}
public void setRegistered(boolean registered) {
this.registered = registered;
}
}-->