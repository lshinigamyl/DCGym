<footer class="navbar navbar-inverse navbar-fixed-bottom" style="color: white">
    <div class="container-fluid">

        <div class="col-sm-3 text-center">
            <div class="row">
                <br>
            </div>

            <button class="btn btn-success vcenter" style="background:transparent; border: 2px solid white;border-radius: 30px 30px 30px 30px;">Conocenos</button>
            <div class="row">
                <br>
            </div>
        </div>
        <div class="col-sm-6 text-center">
            <footer id="pagefooter">
                <p id="copyright"></p>
            </footer>
            Telefonos: 991935770 - 2937353<br>
            Email: teamdcgym@gmail.com<br>
            Av. Lima 1994  V.M.T
        </div>
        <div class="col-sm-3 text-center">
            <div class="row">
                <br>
            </div>

            <button class="btn btn-success vcenter" style="background:transparent; border: 2px solid white;border-radius: 30px 30px 30px 30px;">Contactanos</button>
            <div class="row">
                <br>
            </div>

        </div>

    </div>
</footer>
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
