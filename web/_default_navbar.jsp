<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-default navbar-fixed-top" style="background: linear-gradient( 100deg, #C6C2C0, white, whitesmoke,#C6C2C0)  ;  ">
<!--     style="background: url(image/Baner.jpg); background-position: center center;-->

    <div class="container ">
        <div class="navbar-header example5" >
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a rel="nofollow" class="navbar-brand" href="inicio"><img style=" height: 70px; " src="image/logogym.png" alt="logo">
               <h1 style="    position: absolute;    top: -10px;    left: 45%;    font-weight: bold;" >Dc Gym</h1>
            </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <!--            <li><a href="../navbar/">Default</a></li>-->
                <li class="active" >

                    <a href="login.action" style="    display: table-row-group  !important;background: transparent">


                        <s:if test="%{#session.user != null}">
                            <s:property value="#session.user"/>
                        </s:if>
                        <s:else>Login  </s:else>
                        <span class="sr-only">Inicia sesion</span>
                        <img style=" height: 50px; " src="image/DefaulUser.png" alt="logo">
                    </a>
                </li>
                     <!--<li><a href="../navbar-fixed-top/">Fixed top</a></li>-->
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>