<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
	<div class="left">
	<a href="/">
		<img src="assets/img/logo.png"
			alt="">
	</a>
	</div>
	<!--end left-->
	<c:set var="s" value="no"></c:set>
	<div class="right">
		<div class="primary-nav has-mega-menu">
			<ul class="navigation">
				<li class="has-child"><a href="#nav-locations">Profile</a>
					<div class="wrapper">
						<div id="nav-locations" class="nav-wrapper">
							<ul>
								<c:if test="${status==s}"><li><a href="login">Login</a>
									</li></c:if>
								<c:if test="${status==s}"><li><a href="register">Register</a>
									</li></c:if>
									<li><a href="resetpassword">Reset Password</a>
									</li>
									<li><a href="events">Events</a>
									</li>
							</ul>
						</div>
						<!--end nav-wrapper-->
					</div> <!--end wrapper--></li>
			</ul>
			<!--end navigation-->
		</div>
		<!--end primary-nav-->
		<div class="secondary-nav">
			<a href="javascript:;" class="signInModal">Sign In</a> <a href="#"
				class="promoted" data-modal-external-file="modal_register.php"
				data-target="modal-register">Register</a>
		</div>
		<div class="secondary-nav">
		<a class="btn btn-primary btn-small btn-rounded icon shadow add-listing" href="/addevent">Add Event</a>
		</div>
	</div>
		
	<!--end right-->
</nav>
<!--end nav-->