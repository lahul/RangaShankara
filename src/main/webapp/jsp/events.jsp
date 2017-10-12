<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div class="page-wrapper">
    <div id="page-content">
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li><a href="#">Pages</a></li>
                <li class="active">Contact</li>
            </ol>
            <div class="row">
                <div class="col-md-12 col-sm-8">
                    <section class="page-title">
                        <h1>Agents / Persons</h1>
                    </section>
                    <!--end section-title-->
                    
                    <section>
                        <div class="row">
                        	<c:forEach items="${list}" var="item">
                            <div class="col-md-3 col-sm-6">
                                <div class="subject-list">
                                    <figure class="ribbon">Top</figure>
                                    <a href="agent-detail.html" class="image">
                                        <div class="bg-transfer disable-on-mobile">
                                            <img src="assets/img/person-01-big.jpg" alt="">
                                        </div>
                                    </a>
                                    <!--end image-->
                                    <div class="description">
                                        <section class="name">
                                            <h3><a href="eventdetail?eventName=${item.eventName}">${item.eventName}</a></h3>
                                            <h4>${item.eventTime}</h4>
                                        </section>
                                        <!--end description-->
                                        <section class="contacts">
                                            <figure><i class="fa fa-phone"></i>(123) 456 789</figure>
                                            <figure><a href="#"><i class="fa fa-envelope"></i>jane.doe@example.com</a></figure>
                                        </section>
                                        <!--end contacts-->
                                        <section class="social">
                                            <a href="#"><i class="social_twitter"></i></a>
                                            <a href="#"><i class="social_facebook"></i></a>
                                            <a href="#"><i class="social_youtube"></i></a>
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
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li class="active"><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li class="next">
                                        <a href="#" aria-label="Next">
                                            <i class="arrow_right"></i>
                                        </a>
                                    </li>
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

