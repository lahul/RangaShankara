'use strict';

function validateForm() {
	

	var firstName = document.getElementById("first_name")
	var lastName = document.getElementById("last_name")
	var email = document.getElementById("email")
	var password = document.getElementById("password")
	var phoneNo = document.getElementById("phoneNo")
	
	
	var emailFilter = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;
	var regex1 = /^[a-zA-Z]+$/;
	var regex2 = /^[0-9]+$/;

	if (!(firstName.value && firstName)) {
		alert("First Name must be filled out");
		return false;
	}

	if (!firstName.value.match(regex1)) {
		alert("First Name cant be a number");
		return false;
	}

	if (!(lastName.value && lastName)) {
		alert("Last Name must be filled out");
		return false;
	}

	if (!lastName.value.match(regex1)) {
		alert("Last Name cant be a number");
		return false;
	}

	if (!(email.value && email)) {
		alert("Email must be filled out");
		return false;
	}
	
	if (!email.value.match(emailFilter)) {
		alert("Enter email in proper form");
		return false;
	}
	
	if (!(password.value && password)) {
		alert("Password must be filled out");
		return false;
	}

	if (!(phoneNo.value && phoneNo)) {
		alert("Phone Number must be filled out");
		return false;

	}

	if (!phoneNo.value.match(regex2)) {
		alert("Phone Number should be a number");
		return false;
	}
	

}

function validateLogin() {
	var email = document.getElementById("email")
	var password = document.getElementById("password")
	
	var emailFilter = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/;

	if (!(email.value && email)) {
		alert("Email must be filled out");
		return false;
	}
	
	if (!email.value.match(emailFilter)) {
		alert("Enter email in proper form");
		return false;
	}
	
	if (!(password.value && password)) {
		alert("Password must be filled out");
		return false;
	
	}
}


function validateaddevent() {
	var eventName = document.getElementById("eventName")
	var price=document.getElementById("price")
	var eventDescription=document.getElementById("eventDescription")
	var organizer=document.getElementById("organizer")
	var phoneNo=document.getElementById("phoneNo")
	var location=document.getElementById("my_input")
	var eventTime=document.getElementById("date")
	var image=document.getElementById("imgInp");
	
	var regex1 = /^[0-9]+$/;
	var regex2 = /^[1-5]$/;

	if (!(eventName && eventName.value)) {
		alert("Event Name must be filled out");
		return false;
	}
		
	if (!(price && price.value)) {
		alert("Price must be filled out");
		return false;
	}
	
	if (!price.value.match(regex1)) {
		alert("Price must be a number");
		return false;
	}
	
	if (!(organizer && organizer.value)) {
		alert("organizer name must be filled out");
		return false;
	}
	
	if (!(eventDescription && eventDescription.value)) {
		alert("Event Description must be filled out");
		return false;
	}
	
	if (!(phoneNo && phoneNo.value)) {
		alert("Phone Number name must be filled out");
		return false;
	}
	
	if (!phoneNo.value.match(regex1)) {
		alert("Phone Number must be a number");
		return false;
	}
	
	if (!(location && location.value)) {
		alert("location is required");
		return false;
	}
	
	if (!(eventTime && eventTime.value)) {
		alert("Event Time must be filled out");
		return false;
	}
	
	if (!(image && image.value)) {
			alert("Image is required");
			return false;
	}
	
	return true;
}

function validateeditevent() {
	var eventName = document.getElementById("eventName")
	var price=document.getElementById("price")
	var eventDescription=document.getElementById("eventDescription")
	var eventTime=document.getElementById("date")
	var image=document.getElementById("imgInp");
	var organizer=document.getElementById("organizer")
	var phoneNo=document.getElementById("phoneNo")
	var location=document.getElementById("my_input")
	
	var regex1 = /^[0-9]+$/;
	var regex2 = /^[1-5]$/;

	if (!(eventName && eventName.value)) {
		alert("Event Name must be filled out");
		return false;
	}
	
	
	if (!(price && price.value)) {
		alert("Price must be filled out");
		return false;
	}
	
	if (!(organizer && organizer.value)) {
		alert("organizer name must be filled out");
		return false;
	}
	
	if (!( eventDescription && eventDescription.value)) {
		alert("Event Description must be filled out");
		return false;
	}
	if (!( eventTime  && eventTime.value)) {
		alert("Event Time must be filled out");
		return false;
	}
	
	
	if (!(phoneNo && phoneNo.value)) {
		alert("Phone Number name must be filled out");
		return false;
	}
	
	if (!phoneNo.value.match(regex1)) {
		alert("Phone Number must be a number");
		return false;
	}
	
	if (!(location && location.value)) {
		alert("location is required");
		return false;
	}
	
	/*
	if (!(image && image.value)) {
		alert("Image is required");
		return false;
	}
	*/
	return true;
}

$('#date').attr('readonly', true);

var eventsUrl= "/events";
var homeUrl="/";

	function confirmDelete(id) {
	  var confirmDelete = confirm("Are you sure you want to delete?");
	  if(confirmDelete){
		  $.ajax({
			  url: "/deleteevent/"+id,
			  type: "GET",
			  dataType: 'json',
			  //cache: false,
			  success: function(resp){
				  $(".event_"+id).remove();
				  window.location.href = window.location.href;
				  console.log(resp);
			    //$("#results").append(html);
				  
			  }
			});
	  }
	}

	
	$(document).on("submit", "#editeventform", function(e){
		e.preventDefault();

		var data = $('#editeventform').serialize();
		//alert(fdata);
		//var description=$('textarea#eventDescription').val();
		//var data =  'description='+ encodeURIComponent(description) + '&data='+encodeURIComponent(fdata);
		//*/
		$("#edit-button").html("Updating");
		console.log(data)
		$.ajax({
		  url: "/processeditevent",
		  type: "POST",
		  dataType: 'json',
		  data :data,

		  //cache: false,
		  success: function(response){
			  $("#edit-button").html("Updated");
			  window.location.href=eventsUrl;
			  //$.post('url', data);
			  //$(".event_"+id).remove();
			  //window.location.href = window.location.href;
			  console.log(response);
		    //$("#results").append(html);
			  
		  }
		});
		
	})
	
	
	
	$(document).on("submit", "#loginform", function(e){
		e.preventDefault();

		var data = $('#loginform').serialize();
		
		console.log(data)
		$.ajax({
		  url: "/processsignin",
		  type: "POST",
		  dataType: 'json',
		  data :data,
		  
		  //cache: false,
		  success: function(response){
			  
			  window.location.href=homeUrl;
			  console.log(response);
		    //$("#results").append(html);
			  
		  }
		});
		
	})
	
	
	
	$(document).on("submit", "#registerform", function(e){
		e.preventDefault();

		var data = $('#registerform').serialize();
		
		console.log(data)
		$.ajax({
		  url: "/processregister",
		  type: "POST",
		  dataType: 'json',
		  data :data,
		  
		  //cache: false,
		  success: function(response){
			  
			  window.location.href=homeUrl;
			  console.log(response);
		    //$("#results").append(html);
			  
		  }
		});
		
	})
	/*
	
	
	function performEdit(id,e){
		var json = {"id":id,"name":name}
		$.ajax({
			  url: "/processeditevent",
			  type: "POST",
			  dataType: 'json',
			  data: JSON.stringify(json),
			  //cache: false,
			  success: function(resp){
				  //$(".event_"+id).remove();
				  //window.location.href = window.location.href;
				  console.log(resp);
			    //$("#results").append(html);
				  
			  }
			});
	}
	*/