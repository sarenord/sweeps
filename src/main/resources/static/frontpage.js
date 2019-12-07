document.onload = function() {
    getMap();
}

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
	console.log(data);
	renderMap(data);
	drawTheBoiz(data);
    });
}

function renderMap(data) {
    var canvas = document.getElementById("mapCanv");
    var ctx=canvas.getContext("2d");
    getSector(1, 1, function(err, data) {
	var sectorMap = data.map;
	ctx.fillStyle = '#000000';
	for (var x=0; x < 25; x++) {
	    for (var y=0; y < 25; y++) {
		ctx.beginPath();
		ctx.rect(25*x, 25*y, 25, 25);
		(sectorMap[x][y] == 1) ? ctx.fill() : ctx.stroke();
	    }
	}
	drawTheBoiz(data.entities);
    });
}

function drawTheBoiz(entities) {
    var canvas = document.getElementById("mapCanv");
    var ctx = canvas.getContext("2d");
    ctx.fillStyle = '#007733';
    for (var i=0; i<entities.length; i++) {
	let cx = 25*entities[i].xposition+13;
	let cy = 25*entities[i].yposition+13;
	ctx.beginPath();
	ctx.arc(cx, cy, 13, 0, 2*Math.PI);
	ctx.fill();
    }
}

function getSector(x, y, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open('PUT', '/api/getSector', true);
    xhr.responseType = 'json';
    xhr.setRequestHeader('content-type', 'application/json');
    xhr.send(JSON.stringify({"x": x, "y": y }));
    xhr.onload = function() {
	var status = xhr.status;
	if (status === 200) {
	    callback(null, xhr.response);
	} else {
	    callback(status, xhr.response);
	}
    };
}


function getApiKey() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/getNewAPIKey', true);
    xhr.responseType = 'json';
    xhr.send();
    xhr.onload = function() {
	var p = document.getElementById("display");
	p.innerHTML += xhr.response;
    }
}
