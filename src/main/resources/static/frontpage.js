var getJSON = function(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', url, true);
    xhr.responseType = 'json';
    xhr.onload = function() {
      var status = xhr.status;
      if (status === 200) {
        callback(null, xhr.response);
      } else {
        callback(status, xhr.response);
      }
    };
    xhr.send();
};

function getMap() {
    getJSON('/api/getMap', function(err, data) {
	renderMap(data);
    });
}

function renderMap(mapObject) {
    var canvas = document.getElementById("mapCanv");
    var map = JSON.parse(mapObject);
}

function getSector(x, y) {
    var xhr = new XMLHttpRequest();
    xhr.open('PUT', '/api/getSector', true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('content-type', 'application/json');
    xhr.send(JSON.stringify({"x": x, "y": y }));
    xhr.onload = function() {
	console.log(xhr.response);
    };
}

