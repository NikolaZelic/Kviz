$(function () {
    $("#dugme").click(function () {
        var userOK = false;
        var passwordOK = false;
        var user = $("#user").val();
        var password = $("#password").val();
        if (user.length > 2) {
            $("#error").hide();
        } else {
            $("#error").html("Username too short");
            $("#error").show();
            return;
        }
        $.post("proverikorisnika", {"user": user, "password": password}, function (data) {
            if (data.user.toString().trim() === "1") {
                userOK = true;
            }
            if (data.password.toString().trim() === "1") {
                passwordOK = true;
            }
            if (!userOK) {
                $("#error").show();
                $("#error").html("Username incorrect");
            } else if (!passwordOK) {
                $("#error").show();
                $("#error").html("Password incorrect");
            } else {
                $("#error").hide();
                window.location.href = "http://localhost:8080/Kviz/pitanja.html";
            }
        });
    });
});
