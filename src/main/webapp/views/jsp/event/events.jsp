<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
			<div class="container">
				<div class="row">
				<jsp:include page="./../../helpers/breadcrumb.jsp"></jsp:include>
					<div class="col-md-12 col-sm-8">
						<section class="page-title">
							<h1>Events</h1>

						</section>
						<section>
						<form> 
  <div class="row">
  
    <div class="col-xs-6 col-md-6">
    <form>
      <div class="input-group">
      
   <input type="text" class="form-control width-control" name="searchitem" placeholder="Search" id="txtSearch"/>
   <div class="input-group-btn">
   		<input type="hidden" name="searchflag" value="0">
        <button class="btn btn-primary extrapadding" type="submit">
        <span class="glyphicon glyphicon-search"></span>
        </button>
    </div>
   
  
   </div>
   </form>
    </div>
	
  </div>
</form>      
						</section>
						<section>
							<div class="row">
								<c:forEach items="${list}" var="item">
									<div class="col-md-3 col-sm-6 event_${item.eventPkId}">
										<div class="subject-list text-primary">

											<a href="eventdetail/${item.eventPkId}"><img
												src="/assets/images/${item.image}" width="263" height="210"></a>

											<!--end image-->
											<div class="description">
												<section class="name" <c:if test="${empty item.phoneNo}"> style="border-bottom: 0em;"</c:if>>
													<c:set var="eventName"
														value="${fn:toUpperCase(item.eventName)}"></c:set>
													<c:set var="length" value="${fn:length(eventName)}" />
													<c:choose>
														<c:when test="${length > 10}">
															<h3>
																<a href="eventdetail/${item.eventPkId}">${fn:substring(eventName,0,10)}...</a>
															</h3>
														</c:when>
														<c:otherwise>
															<h3>
																<a href="eventdetail/${item.eventPkId}">${eventName}</a>
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
												<c:choose>
												<c:when test="${not empty item.phoneNo}"><section class="contacts">
													<figure>
														<i class="fa fa-phone"></i>${item.phoneNo}</figure>
												</section></c:when>
												<c:otherwise>
												<section class="contacts">
													<figure>
														<i></i></figure>
												</section>
												</c:otherwise>
												</c:choose>
												<!--end contacts-->
												<section class="social">
													<a class="btn btn-danger btn-xs lmargin right active"
														href="javascript:;" onclick="confirmDelete(${item.eventPkId})" ><span
														class="glyphicon glyphicon-trash"></span>&nbsp&nbsp&nbsp
														Delete</a> 
														<a class="btn btn-primary btn-xs right active"
														href="/editevent/${item.eventPkId}" ><span
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
										<c:set var="active" value="active"/>
										<c:forEach begin="${index}" end="${totalPages-1}">
											<c:if test="${page==index}"><c:set var="a" value="active"></c:set></c:if>
											<li class="page-item ${a}"><a href="/events?page=${index+1}">${index+1}</a></li>
											<c:set var="index" value="${index+1}"></c:set>
											<c:if test="${a==active}"><c:set var="a" value=""></c:set></c:if>
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