<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div id="page-content">
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li><a href="#">Pages</a></li>
                <li class="active">Contact</li>
            </ol>
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <section class="page-title">
                            
           
           		
                        <h1>${eventlist[0].eventName}</h1>
                    </section>
                    <!--end section-title-->
                    <section>
                        <div class="subject-detail">
                            <div class="image">
                                <div class="bg-transfer">
                                    <img src="assets/images/${eventlist[0].image}" alt="">
                                </div>
                            </div>
                            <div class="description">
                                <section class="name">
                                    <h3>${eventlist[0].eventName}</h3>
                                    <h4>Organized By : ${eventlist[0].organizer}</h4>
                                    <h5>Event Date : ${eventlist[0].eventDescription}</h5>
                                </section>
                                <!--end description-->
                                <section class="contacts">
                                    <figure><i class="fa fa-phone"></i>${eventlist[0].phoneNo}</figure>
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
    </div>
    <!--end page-content-->
