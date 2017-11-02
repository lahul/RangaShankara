<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<jsp:include page="/views/helpers/breadcrumb.jsp"></jsp:include>
	<div class="row">
		<div class="col-md-8 col-sm-8 col-md-offset-2 col-sm-offset-2">
			<section class="page-title">
				<h1>Add Event</h1>
			</section>
			<!--end page-title-->
			<section>
				<form:form class="form inputs-underline" id="addeventform"
					modelAttribute="event" action="/processaddevent"
					onsubmit="return validateaddevent()" enctype="multipart/form-data">
					<div class="form-group">
						<label for="event_name">Event Name</label>
						<form:input type="text" class="form-control" path="eventName"
							id="eventName" name="eventName" placeholder="Event name"
							maxlength="250"></form:input>
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
						<div id="loc">
							<input name="lat" id="lat" type="hidden" value=""> <input
								name="lng" id="lon" type="hidden" value=""> <label for="Location">Location</label><input
								id="my_input" name="formatted_address" type="text">
							<div id="my_map" style="width:500px;height:500px"></div>
						</div>

					</div>
					<!--  <div class="form-group">
						<label class="btn btn-default btn-file btn-block"> Upload:<input
							style="" type="file" name="file" id="file"
							accept="image/x-png,image/gif,image/jpeg" />
						</label>
					</div>-->
					<div class="form-group">
						<label>Upload Image</label>
						<div class="input-group">
							<span class="input-group-btn"> <span
								class="btn btn-default btn-file"> Browse… <input
									type="file" id="imgInp">
							</span>
							</span> <input type="text" class="form-control" readonly>
						</div>
						<img id='img-upload' />
					</div>
					<div class="form-group center">
						<button type="submit" name="submit" id="submit" value="submit"
							class="btn btn-primary btn-lg">Add Event</button>
						<a href="/events" class="cancel-anchor" role="button">Cancel</a>
					</div>
					<!--end form-group-->
				</form:form>
			</section>
		</div>
		<!--col-md-4-->
	</div>
	<!--end ro-->
</div>

