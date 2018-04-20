$(document).ready(
        $("#buttS").click(function () {
    var user = $("#nameS").val();
    var password = $("#nameS").val();


    $.post("proverikorisnika", {"user": user}, function (data, status) {
        if (rata.user != "1")
            return;
    });

    $.post("signup", {"user": nesto, "password": password}, function (data, status) {

        window.location.href = "http://localhost:8080/Kviz/pitanja.html";
    });
}));



