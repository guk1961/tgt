 var markers = [];
 var citys = [];
 
function initMap() {

  var myLatlng = {lat: 55.753215, lng: 37.622504};
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 5,
    center: myLatlng
  });


  axios.get('/geo.js')
  .then(function (response) {
	  citys = response.data;
//    console.log('Массив координат городов = ', citys);
    console.log('ArrayLength = ',citys.length)
    /////////////////////////////////
    var zoom = 8;
    var markers = [];
    for (var i = 0; i < citys.length; i++) {
      var dataCity = citys[i];
      var latLng = new google.maps.LatLng(
        dataCity.lat,
        dataCity.lng
      );
      
      var message = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">'+ dataCity.name +'</h1>'+
      '<div id="bodyContent">'+
      '<p><b>'+ dataCity.name +'</b>, Это локация нашей группы <b>свободных таксистов</b>. ' +
      'Вы можете заказать такси, напрямую, без агрегатора и обговорить детали поездки '+
      '<p>Ознакомиться со стандартами нашей группы, тарифами, автомобилями и непосредственно с водителями здесь: <a href="http://telegataxi.ru">'+
      'Стандарты нашего города</a> '+
      '(Геопозиция от 28.04.2020 20.45 мск).</p>'+
      '</div>'+
      '</div>';
      
//      console.log(citys[i].name);
      var marker = new google.maps.Marker({
        position: latLng,
        draggable: false,
        title: dataCity.name,
        animation: google.maps.Animation.DROP,
        icon: 'static/img/tgt.png',
        map: map,
        content: dataCity.name
        
      });
//      attachMessage(marker, dataCity.name);
      attachMessage(marker, message);

      markers.push(marker);
//      console.log(dataCity);
    }

    markerClusterOptions = {styles: [{ height: 50, url: "static/img/m11.png", width: 50},
		{height: 55,url: "static/img/m2.png",width: 55 },
		{height: 65,url: "static/img/m3.png",width: 65},
		{height: 75,url: "static/img/m4.png",width: 75},
		{height: 90,url: "static/img/m5.png",width: 90}]}

    markerCluster = new MarkerClusterer(map, markers,markerClusterOptions);

    
    /////////////////////////////////////////////////
  })
  .catch(function (error) {
    console.log(error);
  });
  
//getData()


  
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
  

  async function getData(){
	    let response = await fetch('/geo.js')
	    let data = await response.json()
	    citys = data
	    console.log('Data222 = ',citys)
	    return data
	    
	}

}



