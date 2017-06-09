/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function creaIscritti(iscr){
    
    var a = $("<a>").attr("href", "Bacheca?user="+iscr.id);
    var li = $("<li>").attr("class", "link").append(a);
    var ul = $("<ul>").attr("class", "sidebar_ul").append(li);
    var name = $("<h2>").html(iscr.nome);
    var link = $("<a>")
            .attr("href", "Profilo?user="+iscr.id)
            .html("Link al Profilo");
    
    var userData = $("<div>")
            .attr("class","userData")
            .append(name)
            .append(link);
    
    return $("<div>").attr("class", "user").append(userData), ul;
}

function stateSuccess(data){
    var usersList = $("#usersList");
    $(usersList).empty();
    
    $("#searchError").hide();
    for(var iscritto in data){
       $(usersList).append(creaIscritti(data[iscritto]));
       
    }
    
}
function stateFailure(data, state){
    $("#searchError").show();
    console.log(state);
}


$(document).ready(function(){
    $("#searchFriend").click(function(){
        var q = $("#searchField")[0].value;
        $.ajax({
            url: "Filter",
            data:{ 
                cmd:"search",
                q: q                
            },
            dataType: "json",
            success: function(data, state){
                stateSuccess(data);
            },
            error: function(data, state){
                stateFailure(data, state);
            }
        });
           
   }); 

});

