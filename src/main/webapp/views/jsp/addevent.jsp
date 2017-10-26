<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body onload="dategenerator()">

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-md-offset-4 col-sm-offset-4">
				<section class="page-title">
					<h1>ADD EVENT</h1>
				</section>
				<!--end page-title-->
				<section>
					<form:form class="form inputs-underline" id="addeventform"
						modelAttribute="event" action="/processaddevent"
						onsubmit="return validateaddevent()" enctype="multipart/form-data">
						<div class="form-group">
							<label for="event_name">Event Name</label>
							<form:input type="text" class="form-control" path="eventName"
								id="eventName" name="eventName" placeholder="Event name" maxlength="250"></form:input>
						</div>
						<!--enr row-->
						<div class="form-group">
							<label for="organizer">Organizer</label>
							<form:input type="text" class="form-control" path="organizer"
								id="organizer" name="organizer" placeholder="organizer"></form:input>
						</div>

						<!--end form-group-->
						<div class="form-group">

							<label for="Event Description">Event Description</label>
							<form:textarea class="form-control" path="eventDescription"
								name="eventDescription" form="addeventform" rows="3" cols="40"></form:textarea>
						</div>
						<div class="form-group">
							<label class="control-label">Event Time</label>

							<form:input type="text" path="eventTime" class="form_datetime"
								name="eventTime" id="date" value="" />
							<br />
						</div>
						<div class="form-group">
							<label for="price">Price</label>
							<form:input type="text" class="form-control" path="price"
								id="price" name="price" placeholder="Price"></form:input>
						</div>
						<div class="form-group">
							<label for="price">Phone Number</label>
							<form:input type="text" class="form-control" path="phoneNo"
								id="PhoneNo" name="PhoneNo" placeholder="Phone Number"></form:input>
						</div>
						<div class="form-group">
							<input type="file" name="file" value="upload" id="file" accept="image/x-png,image/gif,image/jpeg"/>
						</div>
						<div class="form-group center">
							<button type="submit" name="submit" id="submit" value="submit"
								class="btn btn-primary btn-lg">Add Event</button>
							<a href="/events" class="btn btn-primary btn-lg" style="padding-left: 22px; padding-right: 22px;" role="button">Cancel</a>
						</div>
						<!--end form-group-->
					</form:form>
				</section>
			</div>
			<!--col-md-4-->
		</div>
		<!--end ro-->
	</div>
	<!--end container-->
</body>
