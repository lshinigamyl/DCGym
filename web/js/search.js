/**
 * Created by Fjorsvartnir on 18/03/2017.
 */
$(document).ready(function () {

    (function ($) {

        $('input#search').keyup(function () {
            console.log("escribes");
            var rex = new RegExp($(this).val(), 'i');
            $('#searchhere div.row.searchhere').hide();
            $('#searchhere div.row.searchhere').filter(function () {
                return rex.test($(this).text());
            }).show();

        })

    }(jQuery));

});