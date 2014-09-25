$(document).ready(function() {

    "use strict";
    var path = location.pathname;
    $("li").each(function(){ //if'en under sjekker de to første dir'ene i en url. Jeg får ikke contains til å funke.
        if($(this).find("a").attr("href") === path){
            $(this).addClass("active");
        }
    });
});


var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";

$(document).keydown(function(e) {

    kkeys.push( e.keyCode );

    if ( kkeys.toString().indexOf( konami ) >= 0 ) {

        $(document).unbind('keydown',arguments.callee);

        alert("KONAMI");
        // do something awesome
        $("body").addClass("konami");

    }

});