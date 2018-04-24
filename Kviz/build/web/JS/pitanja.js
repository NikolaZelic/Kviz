$(function () {

    var tabela = $("#odg");
    var potvrdi = $("#btn2");
    var indexPitanja = 0;
    var zbirPoena = 0;
    var pitanja;

    $.get("http://671n121.mars-t.mars-hosting.com/pitanja", function (data) {
        pitanja = data.pitanja;
        refresh();
    });

    function refresh() {
        tabela.empty();
        potvrdi.prop("disabled", true);
        var pit = pitanja[indexPitanja];
        if (pit === undefined)
        {
            window.location.href = "kraj.html";
            $.post("zbir", {"zbir": zbirPoena}, function () {});
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
        ++indexPitanja;
        refresh();
    });

    $("#btn2").click(function () {
        $('td input:checked').each(function () {
            var pit = pitanja[indexPitanja];
            var nn = this.id.substring(5, 7);
            if (pit.odgovori[nn].odg_true === "1") {
                zbirPoena += parseInt(pit.pit_bodovi);
            }
        });
        ++indexPitanja;
        refresh();
    });
});
