$(function () {
    $("#name").keyup(function () {
        var dugme = $("#dugme");
        var name = $("#name").val();
        dugme.prop("disabled", name.length < 3);
    });

    $("#dugme").click(function () {
//        alert("zdravo1");
        $.post("proverikorisnika", {"user": "user", "password": password}, function (data) {
            alert("zdravo2 "+ data);
        });
    });
});