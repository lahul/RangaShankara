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
