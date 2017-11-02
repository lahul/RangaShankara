<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<html lang="en-US">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="ThemeStarz">

    <link href="/assets/fonts/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="/assets/fonts/elegant-fonts.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lato:400,300,700,900,400italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/zabuto_calendar.min.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/owl.carousel.css" type="text/css">

    <link rel="stylesheet" href="/assets/css/trackpad-scroll-emulator.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/jquery.nouislider.min.css" type="text/css">
    <link rel="stylesheet" href="/assets/css/style.css" type="text/css">
    <link href="/assets/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <title>Locations - Directory Listing HTML Template</title>
</head>

<body class="homepage">
	<div class="page-wrapper">
		<header id="page-header">

			<!-- Header -->
			<tiles:insertAttribute name="header" />
		</header>
		<!-- Body -->
		<div id="page-content">
		<tiles:insertAttribute name="body" />
		</div>
		<footer id="page-footer">
			<!-- Footer -->
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
	<a href="#" class="to-top scroll" data-show-after-scroll="600"><i
		class="arrow_up"></i></a>
		
<script type="text/javascript" src="/assets/js/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyBEDfNcQRmKQEyulDN8nGWjLYPm8s4YB58&libraries=places"></script>
<script type="text/javascript" src="/assets/js/richmarker-compiled.js"></script>
<script type="text/javascript" src="/assets/js/markerclusterer_packed.js"></script>
<script type="text/javascript" src="/assets/js/infobox.js"></script>
<script type="text/javascript" src="/assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery.fitvids.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="/assets/js/icheck.min.js"></script>
<script type="text/javascript" src="/assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="/assets/js/jquery.nouislider.all.min.js"></script>
<script type="text/javascript" src="/jquery.geocomplete.js"></script>
<script type="text/javascript" src="/assets/js/locationpicker.jquery.js"></script>
<script type="text/javascript" src="/assets/js/custom.js"></script>
<script type="text/javascript" src="/assets/js/maps.js"></script>
<script type="text/javascript" src="/assets/js/formvalidator.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/assets/js/locales/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript" src="/assets/js/jquery.geocomplete.js"></script>
<script type="text/javascript" src="/assets/js/addevent_custom.js"></script>
<script>
    var optimizedDatabaseLoading = 0;
    var _latitude = 40.7344458;
    var _longitude = -73.86704922;
    var element = "map-homepage";
    var markerTarget = "modal"; // use "sidebar", "infobox" or "modal" - defines the action after click on marker
    var sidebarResultTarget = "sidebar"; // use "sidebar", "modal" or "new_page" - defines the action after click on marker
    var showMarkerLabels = true; // next to every marker will be a bubble with title
    var mapDefaultZoom = 14; // default zoom
    heroMap(_latitude,_longitude, element, markerTarget, sidebarResultTarget, showMarkerLabels, mapDefaultZoom);
</script>
</body>
</html>