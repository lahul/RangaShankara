
$('.form_datetime').datetimepicker({
    //language:  'fr',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	forceParse: 0,
    showMeridian: 1
});

$("#my_input").geocomplete({ details: "#loc" });
/*$("#my_input").geocomplete({
	  map: "#my_map",
	  mapOptions: {
	    zoom: 10
	  },
	  markerOptions: {
	    draggable: true
	  }
	});

	var lat = $('#lat').val();
	var lon = $('#lon').val();
    var myLatlng = new google.maps.LatLng(lat,lon);
    var myOptions = {
        zoom: 4,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
        }
     map = new google.maps.Map($('#my_map'), myOptions);
     var marker = new google.maps.Marker({
         position: myLatlng, 
         map: map,
     title:"Fast marker"
    }); 
*/
function myMap() {
	var mapProp= {
	    center:new google.maps.LatLng(51.508742,-0.120850),
	    zoom:5,
	};
	var map=new google.maps.Map(document.getElementById("my_map"),mapProp);
	}

