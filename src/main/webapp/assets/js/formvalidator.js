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
	var rating = document.getElementById("rating")
	var price=document.getElementById("price")
	var eventDescription=document.getElementById("eventDescription")
	var eventTime=document.getElementById("eventTime")
	
	var regex1 = /^[0-9]+$/;
	var regex2 = /^[1-5]$/;

	if (!(eventName.value && eventName)) {
		alert("Event Name must be filled out");
		return false;
	}
	
	if (!(rating.value && rating)) {
		alert("Rating must be filled out");
		return false;
	}
	
	if (!rating.value.match(regex2)) {
		alert("Rating must be a number[1-5]");
		return false;
	}
	
	if (!(price.value && price)) {
		alert("Price must be filled out");
		return false;
	}
	
	if (!price.value.match(regex1)) {
		alert("Price must be a number");
		return false;
	}
	
	if (!(eventDescription.value && eventDescription)) {
		alert("Event Description must be filled out");
		return false;
	}
	if (!(eventTime.value && eventTime)) {
		alert("Event Time must be filled out");
		return false;
	}
}

function validateeditevent() {
	var eventName = document.getElementById("eventName")
	var rating = document.getElementById("rating")
	var price=document.getElementById("price")
	var eventDescription=document.getElementById("eventDescription")
	var eventTime=document.getElementById("eventTime")
	
	var regex1 = /^[0-9]+$/;
	var regex2 = /^[1-5]$/;

	if (!(eventName.value && eventName)) {
		alert("Event Name must be filled out");
		return false;
	}
	
	if (!(rating.value && rating)) {
		alert("Rating must be filled out");
		return false;
	}
	
	if (!rating.value.match(regex2)) {
		alert("Rating must be a number[1-5]");
		return false;
	}
	
	if (!(price.value && price)) {
		alert("Price must be filled out");
		return false;
	}
	
	if (!price.value.match(regex1)) {
		alert("Price must be a number");
		return false;
	}
	
	if (!(eventDescription.value && eventDescription)) {
		alert("Event Description must be filled out");
		return false;
	}
	if (!(eventTime.value && eventTime)) {
		alert("Event Time must be filled out");
		return false;
	}
}
function confirmDelete() { 
	var status = confirm("Are you sure you want to delete?");   
	if(status)
	{
	return true;
	}
	}