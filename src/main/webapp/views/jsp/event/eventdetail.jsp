        <div class="container">
        <jsp:include page="./../../helpers/breadcrumb.jsp"></jsp:include>
            <div class="row">
                <div class="col-md-9 col-sm-9">
                    <section class="page-title">
                        <div class="pull-left">
                            <h1>${eventlist.eventName}</h1>
                            <h3>${eventlist.organizer}</h3>
                            <div class="rating-passive" data-rating="4">
                                <span class="stars"></span>
                                <span class="reviews">6</span>
                            </div>
                        </div>
                        <!--end page-title-->
                       
                    </section>

                    <div class="row">
                        <div class="col-md-8 col-sm-12">
                            <section>
                                <div class="gallery detail">
                                    <div class="owl-carousel" data-owl-nav="0" data-owl-dots="0">
                                        <div class="image">
                                            <div class="bg-transfer"><img src="/assets/images/${eventlist.image}" alt=""></div>
                                        </div>
                                    </div>
                                    <!--end owl-carousel-->
                                </div>
                                <!--end gallery-->
                            </section>

                            <section>
                                <section>
                                    <h4>About this Event</h4>
                                    <h6>
                                    ${eventlist.eventDescription }
                                    </h6>
                                </section>
                            </section>
                        </div>
                        <!--end col-md-6-->
                        <div class="col-md-4 col-sm-12">
                            <section>
                                <div class="detail-sidebar">
                                    <section class="shadow">
                                        <div class="map height-250px" id="map-detail"></div>
                                        <!--end map-->
                                        <div class="content">
                                            <div class="vertical-aligned-elements">
                                                <div class="element"><img src="assets/img/logo-2.png" alt=""></div>
                                            </div>
                                            <hr>
                                            <address>
                                                <figure><i class="fa fa-map-marker"></i>3858 Marion Street<br>Morrisville, VT 05661 </figure>
                                                <figure><i class="fa fa-envelope"></i><a href="#">email@example.com</a></figure>
                                                <figure><i class="fa fa-phone"></i>316-436-8619</figure>
                                                <figure><i class="fa fa-globe"></i><a href="#">www.markysrestaurant.com</a></figure>
                                            </address>
                                        </div>
                                    </section>
                                </div>
                                <!--end detail-sidebar-->
                            </section>
                         </div>
                        <!--end col-md-3-->
                    </div>
                    <!--end row-->
                </div>
                <!--end col-md-9-->
                    <!--end sidebar-->
                </div>
                <!--end col-md-3-->
            </div>
        </div>
