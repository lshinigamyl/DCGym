<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container-fluid">

        <div class="col-sm-3 text-center">
            <div class="row">
                <br>
            </div>

            <button class="btn btn-success vcenter" >Conocenos</button>
            <div class="row">
                <br>
            </div>
        </div>
        <div class="col-sm-6 text-center">
            <footer id="pagefooter">
                <p id="copyright"></p>
            </footer>
            Telefonos: 991935770 - 2937353<br>
            Email: teamdcgym@gmail.com
        </div>
        <div class="col-sm-3 text-center">
            <div class="row">
                <br>
            </div>

            <button class="btn btn-success vcenter" >Contactanos</button>
            <div class="row">
                <br>
            </div>

        </div>

    </div>
</nav>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script>
    function copyrightYear() {
        var d = new Date();
        var y = d.getFullYear();
        document.getElementById("copyright").innerHTML = '<strong>Copyright &copy; TEAMDC ' + y + ' todos los derechos reservados</strong>';
    }

    copyrightYear();
</script>
