/**
 * Created by Administrador on 08/06/2015.
 */


function init(){
  var rootpath = "//"+ window.location.host + "/_ah/api";
  gapi.client.load('presupEndpoints','v1',
    loadCallback, rootpath );
}

function loadCallback(){
  enableButtons();
}

function enableButtons(){
  btn = document.getElementById("endpointsButton");
  btn.onclick = function(){getByName()}
}

function getByName(){
  var name = document.getElementById("yourName").value;
  var request = gapi.client.presupEndpoints.getByName({'yourName':name});
  request.execute(sayHelloCallback);
}
function sayHelloCallback(response){
  //alert(response.name);
  var result = document.getElementById("result");

  result.innerHTML=response.name;
}