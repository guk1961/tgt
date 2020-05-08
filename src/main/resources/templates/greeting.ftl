<!DOCTYPE html>
<html lang="ru">
  <head>
   <title>TgT</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta contentType="text/html; charset=UTF-8"/>
	<!-- <link rel="stylesheet" href="css/style.css"> -->

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
	<script src ="js/jquery-3.5.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src='https://www.google.com/recaptcha/api.js'></script>
<!--     <script src="https://cdnjs.cloudflare.com/ajax/libs/turbolinks/5.2.0/turbolinks.js"></script> -->

    <style>
        .turbolinks-progress-bar {
            height: 2px;
            background-color: navy;
        }
        #map {
        height: 600px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
      }
      /* Optional: Makes the sample page fill the window. */
 html, body {
   height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>

  </head>
  <body>
  
<#include "parts/navbar.ftl">
    <h3 class="mt-3 text-center">Карта свободного такси</h3>
    <form id="searchForm" class="mt-3 ml-2 mr-2" action="/search" method="post">
	    <div class="input-group mb-3">
	      <input type="hidden" name="_csrf" value="${_csrf.token}" />
	      <input name="cityname" type="text" class="form-control mr-1" placeholder="Название населенного пункта" aria-label="cityname" aria-describedby="button-addon2">
		  <div class="input-group-append">
		    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Найти</button>
		  </div>
		</div>
	</form>
    <div id="map"></div>
    
    <script src="js/axios.min.js"></script>
	<script src="js/gmap.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/js-marker-clusterer/1.0.0/markerclusterer_compiled.js">
    </script>   
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCfVLGvS065qHj20IKuYVMtJ6wb1Q7C9WQ&language=ru&callback=initMap">
    </script>
    
  </body>
</html>
