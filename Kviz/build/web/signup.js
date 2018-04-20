
$(document).ready(function(){
        $("#buttS").click(function(){

            var user = $("#nameS").val();
            var password = $("#passS").val();
            
        
            $.post("proverikorisnika",{"user":user},function (data,status){
                if(data.user !== "0"){
                    $("#error").show();
                    return;
                }else{
                $("#error").hide();
                $.post("signup",{"user":user,"password":password},function (data,status){
                        window.location.href = "http://localhost:8080/Kviz/pitanja.html";
                    });
                }});
        });
    });

