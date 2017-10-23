<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<body>
<div class="page-wrapper">
    <div id="page-content">
        <div class="container">
                <div class="row">
                <div class="col-md-12 col-sm-8">
                    <section class="page-title">
                        <h1>Events</h1>
                    </section>
                    <!--end section-title-->
                    
                    <section>
                        <div class="row">
                        	<c:forEach begin="${count}" end="${end}" items="${list}" var="item">
                            <div class="col-md-3 col-sm-6">
                                <div class="subject-list">
                                    
                                    <img src="assets/images/${item.image}" width="263" height="210">
                                        
                                     <!--end image-->
                                    <div class="description">
                                        <section class="name">
                                            <h2><a href="eventdetail?eventName=${item.eventName}">${item.eventName}</a></h2>
                                            <h3>${item.organizer}</h3>
                                           	<h4><fmt:formatDate type = "both" timeStyle = "short" value = "${item.eventTime}" /></h4>
                                            
                                        </section>
                                        <!--end description-->
                                        <section class="contacts">
                                            <figure><i class="fa fa-phone"></i>${item.phoneNo}</figure>
                                        </section>
                                        <!--end contacts-->
                                        <section class="social">
                                            <a href="#"><i class="social_twitter"></i></a>
                                            <a href="#"><i class="social_facebook"></i></a>
                                            <a href="#"><i class="social_youtube"></i></a>
                                        	<a class="btn btn-primary btn-sm active" href="/editevent?eventName=${item.eventName}"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                                			<a class="btn btn-danger btn-sm active" href="/deleteevent?eventName=${item.eventName}"><span class="glyphicon glyphicon-edit"></span> Delete</a>
                                        </section>
                                        <!--end social-->
                                    </div>
                                    <!--end description-->
                                </div>
                                <!--end subject-list-->
                            </div>
                             </c:forEach>
                            </div>
                            </section>
                            <!--end col-md-3-->
                    <section>
                        <div class="center">
                            <nav aria-label="Page navigation">
                                <ul class="pagination">
                                    <li class="disabled previous">
                                        <a href="#" aria-label="Previous">
                                            <i class="arrow_left"></i>
                                        </a>
                                    </li>
                                    <c:set var="index" value="1"/>
                                    <c:forEach  begin="${index}" end="${size}">
                                    <li class=active><a href="/events?page=${index}"></a></li></c:forEach>
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

