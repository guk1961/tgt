 var markers = [];
 var citys = [];
 var map;


 function initialize() {
	 //markersArray.push(newMarker) ;
	 var mapProp = {			 
			 center: new google.maps.LatLng("55.753215", "37.622504"),
			 zoom: 6,
			 mapTypeId: google.maps.MapTypeId.ROADMAP
		};
	
   map = new google.maps.Map(document.getElementById('map'), mapProp);
 };
 
function initMap() {

	initialize();
	getData()
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


 function getData(){
	  axios.get('/geo.js')
	  .then(function (response) {
	    citys = response.data;
	    console.log('ArrayLength = ',citys.length);
	    setMap(response.data);
	  })
	  .catch(function (error) {
	    console.log(error);
	  });
}

function setMap(arrCitys){
    var zoom = 8;
//    var markers = [];
    
    for (var i = 0; i < arrCitys.length; i++) {
      var dataCity = arrCitys[i];
      var latLng = new google.maps.LatLng(
        dataCity.lat,
        dataCity.lng
      );
      let dateGeoposition;
      var x = new Date();
      dateGeoposition = x.toString();
      
      var message = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h1 id="firstHeading" class="firstHeading">'+ dataCity.name +'</h1>'+
      '<div id="bodyContent">'+
      '<p><b>'+ dataCity.name +'</b>, Это локация нашей группы <b>свободных таксистов</b>. ' +
      'Вы можете заказать такси, напрямую, без агрегатора и обговорить детали поездки '+
      '<p>Ознакомиться со стандартами нашей группы, тарифами, автомобилями и непосредственно с водителями здесь: <a href="http://telegataxi.ru">'+
      'Стандарты нашего города</a> '+
      '(Геопозиция от ' +dateGeoposition+').</p>'+
      '</div>'+
      '</div>';
      
//      console.log(citys[i].name);
      let marker = new google.maps.Marker({
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
//    markerCluster.setIgnoreHidden(true);

}

function removeMarkers(){

	markerCluster.clearMarkers();

	for(i=0; i<markers.length; i++){
        
        markers[i].visible=false;
        markers[i].setMap(null);
//        console.log(markers[i])
    }
    markers = []
    markers.length = 0
//    console.log('markers = ', markers)

    //	markerCluster.repaint();

}

var removeByAttr = function(arr, attr, value){
    var i = markers.length;
    while(i--){
       if( markers[i])

    	   markers.splice(i,1);
       
    }
    return arr;
}


$(document).ready(function(){
	$('#searchForm').submit(function(event){
		event.preventDefault();

//		initialize();
			removeMarkers()
			$.ajax({
			type: $(this).attr('method'),
			url: $(this).attr('action'),
			data: new FormData(this),
			contentType: false,
			cache: false,
			processData: false,
			success: function(result){
				 setMap(result);
				 if(result.length>0)
					 map.setCenter(markers[0].position)
				 
			}
		})
	})
})

