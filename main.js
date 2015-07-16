var scalaLogo = {
  url: './logo.png'
}

var fpLogo = {
  url: './lambda.png'
}

function logo(scala) {
  if(scala) {
    return scalaLogo;
  } else {
    return fpLogo;
  }
}

var map = new google.maps.Map(document.getElementById('map'), {
  zoom: 6,
  center: new google.maps.LatLng(51.5072, 0.1275),
  mapTypeId: google.maps.MapTypeId.TERRAIN,
  mapTypeControl: false,
  panControlOptions: {
    position: google.maps.ControlPosition.TOP_RIGHT
  },
  zoomControlOptions: {
    style: google.maps.ZoomControlStyle.SMALL,
    position: google.maps.ControlPosition.TOP_RIGHT
  }
});

if(navigator.geolocation) {
  navigator.geolocation.getCurrentPosition(function(pos) {
    map.setCenter(new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude));
  });
}

var info = new google.maps.InfoWindow();

var marker, i;

for(i = 0; i < groups.length; i++) {  
  marker = new google.maps.Marker({
    position: new google.maps.LatLng(groups[i][2], groups[i][3]),
    icon: logo(groups[i][4]),
    map: map
  });

  google.maps.event.addListener(marker, 'click', (function(marker, i) {
    return function() {
      var link = function(s){if(s.startsWith('http')) { return s; } else { return 'http://www.meetup.com/'+s+'/'; }}(groups[i][1]);
      info.setContent('<a href="'+link+'">'+groups[i][0]+'</a>');
      info.open(map, marker);
    }
  })(marker, i));
}

var contribute = document.getElementById('contribute');
var expandContribute = document.getElementById('expand-contribute');
expandContribute.onclick = function () {
  if (!contribute.style.display || contribute.style.display === 'none') {
    contribute.style.display = 'block';
    expandContribute.innerHTML = 'Got it, close this notice.';
  } else {
    contribute.style.display = 'none';
    expandContribute.innerHTML = 'Would you like to improve this site? Learn how!';
  }
};

map.controls[google.maps.ControlPosition.TOP_LEFT].push(document.getElementById('intro'));
