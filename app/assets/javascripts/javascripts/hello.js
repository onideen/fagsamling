$(document).ready(function() {

    "use strict";
    var path = location.pathname;
    $("li").each(function(){ //if'en under sjekker de to første dir'ene i en url. Jeg får ikke contains til å funke.
        if($(this).find("a").attr("href") === path){
            $(this).addClass("active");
        }
    });
});