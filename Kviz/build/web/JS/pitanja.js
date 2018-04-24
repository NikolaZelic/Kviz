$(function () {

    var tabela = $("#odg");
    var potvrdi = $("#btn2");
    var n = 0;
    var pitanja;
    var zbirPoena = 0;

    $.get("http://671n121.mars-t.mars-hosting.com/pitanja", function (data) {
        pitanja = data.pitanja;
        refresh();
    });

    function refresh() {
        tabela.empty();
        potvrdi.prop("disabled", true);
        var pit = pitanja[n];
        if (pit === undefined)
        {
            window.location.href = "kraj.html";
            return;
        }
        $("#pitanje").text(pit.pit_text);
        $("#poeni").text(pit.pit_bodovi);
        var odg = pit.odgovori;
        for (var i = 0; i < odg.length; i++) {
            var tr = document.createElement('tr');
            var td = document.createElement('td');
            var radio = document.createElement('input');
            radio.type = "radio";
            radio.id = "radio" + i;
            radio.name = "radio";
            radio.onclick = (function () {
                potvrdi.prop("disabled", false);
            });
            var label = document.createElement('label');
            label.htmlFor = radio.id;
            label.appendChild(document.createTextNode(pit.odgovori[i].odg_text));
            td.appendChild(radio);
            td.appendChild(label);
            tr.append(td);
            tabela.append(tr);
        }
    }

    $("#btn1").click(function () {
        ++n;
        refresh();
    });

    $("#btn2").click(function () {
        $('td input:checked').each(function () {
            var pit = pitanja[n];
            var nn = this.id.substring(5, 7);
//            console.log("tacno: "+pit.odgovori[nn].odg_true);
            if (pit.odgovori[nn].odg_true === "1") {
                zbirPoena += parseInt(pit.pit_bodovi);
            }
//            console.log(zbirPoena);
        });
        ++n;
        refresh();
        return;
//        var userOK = false;
//        var passwordOK = false;
//        var user = $("#user").val();
//        var password = $("#password").val();
//        if (user.length > 2) {
//            $("#error").hide();
//        } else {
//            $("#error").html("Username too short");
//            $("#error").show();
//            return;
//        }
//
//        $.post("proverikorisnika", {"poeni": zbirPoena}, function (data) {
//            if (data.user.toString().trim() === "1") {
//                userOK = true;
//            }
//            if (data.password.toString().trim() === "1") {
//                passwordOK = true;
//            }
//            if (!userOK) {
//                $("#error").show();
//                $("#error").html("Username incorrect");
//            } else if (!passwordOK) {
//                $("#error").show();
//                $("#error").html("Password incorrect");
//            } else {
//                $("#error").hide();
//                window.location.href = "http://localhost:8080/Kviz/pitanja.html";
//            }
//        });
    });
});
