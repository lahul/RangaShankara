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
                                    <img src="assets/img/person-01-big.jpg" alt="">
                                </div>
                            </div>
                            <div class="description">
                                <section class="name">
                                    <h3>${eventlist[0].eventName}</h3>
                                    <p>${eventlist[0].eventDescription}</p>
                                    <p>${userlist[0].first_name}</p>
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
                                <section>
                                <a class="btn btn-primary btn-sm active" href="/editevent?eventName=${eventlist[0].eventName}"><span class="glyphicon glyphicon-edit"></span> Edit</a>
                                <a class="btn btn-danger btn-sm active" href="/deleteevent?eventName=${eventlist[0].eventName}"><span class="glyphicon glyphicon-edit"></span> Delete</a>
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
