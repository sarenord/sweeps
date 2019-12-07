const Http = new XMLHttpRequest();
const baseUrl='localhost:8080/api/';

function getMap() {
    var url = baseUrl + 'getMap/';
    Http.open("GET", url);
    Http.send();
    Http.onreadystatechange = (e) => {
	renderMap(http.responseText);
    }
}

function renderMap(mapObject) {
    var canvas = getElementById("mapCanv");
    var map = json.parse(mapObject);



}
