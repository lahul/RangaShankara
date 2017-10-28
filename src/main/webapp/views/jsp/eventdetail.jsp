<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <div class="container">
        <jsp:include page="./../../helpers/breadcrumb.jsp"></jsp:include>
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <section class="page-title">
                            
           
           		
                        <h1>${eventlist.eventName}</h1>
                    </section>
                    <!--end section-title-->
                    <section>
                        <div class="subject-detail">
                            <div class="image">
                                <div class="bg-transfer">
                                    <img src="/assets/images/${eventlist.image}" alt="">
                                </div>
                            </div>
                            <div class="description">
                                <section class="name">
                                    <h3>${eventlist.eventName}</h3>
                                    <h4>Organized By : ${eventlist.organizer}</h4>
                                    <h5>Event Description : ${eventlist.eventDescription}</h5>
                                </section>
                                <!--end description-->
                                <section class="contacts">
                                    <figure><i class="fa fa-phone"></i>${eventlist.phoneNo}</figure>
                                </section>
                                <!--end contacts-->
                                <section class="social">
                                    <a href="#"><i class="social_twitter"></i></a>
                                    <a href="#"><i class="social_facebook"></i></a>
                                    <a href="#"><i class="social_youtube"></i></a>
                                </section>
                                <section>
                                
                                </section>
                                <!--end social-->
                            </div>
                            <!--end description-->
                        </div>
                        <!--end subject-detail-->
                    </section>
                </div>
                <!--end col-md-9-->
            </div>
            <!--end row-->
        </div>
        <!--end container-->
