 var markers = [];
 var citys = [];
function initMap() {

  var myLatlng = {lat: 55.753215, lng: 37.622504};
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 5,
    center: myLatlng
  });

  getData()

  var zoom = 8;
  var markers = [];
  for (var i = 0; i < citys.length; i++) {
    var dataCity = citys[i];
    var latLng = new google.maps.LatLng(
      dataCity.lat,
      dataCity.lng
    );
//    console.log(citys[i].name);
    var marker = new google.maps.Marker({
      position: latLng,
      draggable: false,
      title: dataCity.name,
      animation: google.maps.Animation.DROP,
      icon: 'static/img/tgt.png',
      map: map,
      content: dataCity.name
      
    });
    attachMessage(marker, dataCity.name);

    markers.push(marker);
//    console.log(dataCity);
  }

  
  function attachMessage(marker, message) {
      var infowindow = new google.maps.InfoWindow({
        content: message
      });

      marker.addListener('click', function() {
        infowindow.open(marker.get('map'), marker);
        
        map.setCenter(marker.position)
        map.setZoom(map.getZoom()+1)
        console.log('pos=', marker.title)
        
      });
    }
  
  markerClusterOptions = {styles: [{ height: 50, url: "static/img/m11.png", width: 50},
									{height: 55,url: "static/img/m2.png",width: 55 },
									{height: 65,url: "static/img/m3.png",width: 65},
									{height: 75,url: "static/img/m4.png",width: 75},
									{height: 90,url: "static/img/m5.png",width: 90}]}

 markerCluster = new MarkerClusterer(map, markers,markerClusterOptions);
}

async function getData(){
    const response = await fetch('/geo.js')
    const data = await response.json()
    citys = data
}


