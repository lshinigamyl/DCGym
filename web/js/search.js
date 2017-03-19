/**
 * Created by Fjorsvartnir on 18/03/2017.
 */
$(document).ready(function () {


    (function ($) {

        $('input#search').keyup(function () {
            if($(this).val().length==0){
                console.log("estoy vacio");
                $('#searchhere div.row.searchhere').hide();
            }else {
                var rex = new RegExp($(this).val(), 'i');
                $('#searchhere div.row.searchhere').hide();
                $('#searchhere div.row.searchhere').filter(function () {
                    return rex.test($(this).text());
                }).show();
            }


        })

    }(jQuery));

});