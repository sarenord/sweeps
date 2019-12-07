const Http = new XMLHttpRequest();
const baseUrl='localhost:8080/api/';


var getJSON = function(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function() {
      var status = xhr.status;
      if (status === 200) {
	  console.log("breakpoint");
        callback(null, xhr.response);
      } else {
        callback(status, xhr.response);
      }
    };
    xhr.send();
};


function getMap() {
    var url = baseUrl + 'getMap/';
    Http.open("GET", "http://localhost:8080/api/getMap/");
    Http.send();
    Http.onreadystatechange = (e) => {
	console.log('JSON: ' + Http.responseText);
	renderMap(Http.responseText);
    }
}

function renderMap(mapObject) {
    var canvas = document.getElementById("mapCanv");
    var map = JSON.parse(mapObject);
}
