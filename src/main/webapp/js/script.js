/**
 * Created by Ivo @ircube on 08/06/2015.
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
  btn.disabled = false;
  btn.onclick = function(){getByName()}
}

function getByName(){
  var name = document.getElementById("yourName").value;
  var request = gapi.client.presupEndpoints.getByName({'yourName':name});
  var spiner = document.getElementById('spinerEB');
  spiner.active = true;

  request.execute(sayHelloCallback);
  function sayHelloCallback(response){
    //alert(response.name);
    spiner.active = false;
    toast = document.getElementById('toast1');
    var result = document.getElementById("result");

    if(!response.error){
      result.innerHTML = response.name;
      toast.innerHTML = 'Correcto  <iron-icon icon="done"></iron-icon>';
      toast.text = '';

      toast.show();
    }

    else{
      toast.innerHTML =response.error.message + '  <iron-icon icon="error"></iron-icon>';
      toast.show();
    }
  }
}






