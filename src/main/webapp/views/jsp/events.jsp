<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<body>
	<div class="page-wrapper">
		<div id="page-content">
			<div class="container">
				<div class="row">
					<ul class="breadcrumb">
						<li><a href="/">Home</a></li>
						<li><a href="/events">Events</a></li>
					</ul>
					<div class="col-md-12 col-sm-8">
						<section class="page-title">
							<h1>Events</h1>

						</section>
						<!--end section-title-->

						<section>
							<div class="row">
								<c:forEach items="${list}" var="item">
									<div class="col-md-3 col-sm-6">
										<div class="subject-list text-primary">

											<a href="eventdetail?eventName=${item.eventName}"><img
												src="assets/images/${item.image}" width="263" height="210"></a>

											<!--end image-->
											<div class="description">
												<section class="name">
													<c:set var="eventName"
														value="${fn:toUpperCase(item.eventName)}"></c:set>
													<c:set var="length" value="${fn:length(eventName)}" />
													<c:choose>
														<c:when test="${length > 10}">
															<h3>
																<a href="eventdetail?eventName=${eventName}">${fn:substring(eventName,0,10)}...</a>
															</h3>
														</c:when>
														<c:otherwise>
															<h3>
																<a href="eventdetail?eventName=${eventName}">${eventName}</a>
															</h3>
														</c:otherwise>
													</c:choose>

													<h4>Organized By: ${item.organizer}</h4>
													<h5>
														Event Date:
														<fmt:formatDate type="both" timeStyle="short"
															value="${item.eventTime}" />
													</h5>

												</section>
												<!--end description-->
												<section class="contacts">
													<figure>
														<i class="fa fa-phone"></i>${item.phoneNo}</figure>
												</section>
												<!--end contacts-->
												<section class="social">
													<a class="btn btn-danger btn-xs amargin right active"
														href="/deleteevent?eventName=${eventName}"><span
														class="glyphicon glyphicon-trash"></span>&nbsp&nbsp&nbsp
														Delete</a> <a class="btn btn-primary btn-xs right active"
														href="/editevent?eventName=${eventName}" onclick="javascript:confirmDelete();"><span
														class="glyphicon glyphicon-edit"></span> &nbsp&nbsp&nbsp
														Edit</a>
													<div class="clear"></div>
												</section>
												<!--end social-->
											</div>
											<!--end description-->

											<!--end subject-list-->
										</div>
									</div>
								</c:forEach>
							</div>
						</section>
						<!--end col-md-3-->
						<section>
							<div class="center">
								<nav aria-label="Page navigation">
									<ul class="pagination">

										<c:set var="index" value="0" />

										<c:forEach begin="${index}" end="${totalPages-1}">
											<li class="page-item"><a href="/events?page=${index+1}">${index+1}</a></li>
											<c:set var="index" value="${index+1}"></c:set>
										</c:forEach>
									</ul>
								</nav>
							</div>
						</section>
					</div>
					<!--end col-md-9-->
				</div>
				<!--end row-->
			</div>
			<!--end container-->
		</div>
		<!--end page-content-->
	</div>
	<!--end page-wrapper-->