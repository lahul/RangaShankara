<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
	<div class="container">
		<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">Pages</a></li>
			<li class="active">Contact</li>
		</ol>
		<!--end breadcrumb-->
		<div class="row">
			<div class="col-md-4 col-sm-4 col-md-offset-4 col-sm-offset-4">
				<section class="page-title">
					<h1>ADD EVENT</h1>
				</section>
				<!--end page-title-->
				<section>
					<form:form class="form inputs-underline" id="addeventform"
						modelAttribute="event" action="/processaddevent">
						<div class="row">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<label for="event_name">Event Name</label>
									<form:input type="text" class="form-control" path="eventName"
										id="first_name" placeholder="Event name"></form:input>
								</div>
								<!--end form-group-->
							</div>
							<!--end col-md-6-->
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<label for="rating">Rating</label>
									<form:input type="number" class="form-control" path="rating"
										id="first_name" placeholder="Rating"></form:input>
								</div>
								<!--end form-group-->
							</div>
							<!--end col-md-6-->
						</div>
						<!--enr row-->
						<div class="form-group">
							<label for="price">Price</label>
							<form:input type="text" class="form-control" path="price"
								id="first_name" placeholder="Price"></form:input>
						</div>
						<!--end form-group-->
						<div class="form-group">
							<label for="Event Description">Event Description</label>
							<form:textarea class="form-control" path="eventDescription"
								form="addeventform" rows="3" cols="40"></form:textarea>
						</div>
						<div class="form-group">
							<label class="control-label">DateTime Picking</label>							
							<input type="text" value="2012-06-15 14:45:00" readonly class="form_datetime" value="" /><br/>
						</div>

						<!--end form-group-->
						<div class="form-group center">
							<button type="submit" class="btn btn-primary width-100">Add
								Event</button>
						</div>
						<!--end form-group-->
					</form:form>

					<hr>

					<p class="center">
						By clicking on “Register Now” button you are accepting the <a
							href="terms-conditions.html">Terms & Conditions</a>
					</p>
				</section>
			</div>
			<!--col-md-4-->
		</div>
		<!--end ro-->
	</div>
	<!--end container-->
</body>
