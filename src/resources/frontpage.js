const Http = new XMLHttpRequest();
const baseUrl='localhost:8080/api/';

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
