$(function () {
    $.get("zbir", function (data) {
        
        var zbir = data;
        $("#zbir").text(zbir);
    });

    $("#pp").click(function () {
        window.location.href = "pitanja.html";
    });
});