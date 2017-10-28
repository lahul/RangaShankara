<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <div class="container">
        <jsp:include page="./../../helpers/breadcrumb.jsp"></jsp:include>
            <div class="row">
                <div class="col-md-4 col-sm-4 col-md-offset-4 col-sm-offset-4">
                    <section class="page-title">
                        <h1>Register</h1>
                    </section>
                    <!--end page-title-->
                    <section>
                        <form:form class="form inputs-underline" modelAttribute="user" action="/processregister" onsubmit="return validateForm()">
                            <div class="row">
                                <div class="col-md-6 col-sm-6">
                                    <div class="form-group">
                                        <label for="first_name">First Name</label>
                                        <form:input type="text" class="form-control" path="first_name" id="first_name" placeholder="First name"></form:input>
                                    </div>
                                    <!--end form-group-->
                                </div>
                                <!--end col-md-6-->
                                <div class="col-md-6 col-sm-6">
                                    <div class="form-group">
                                        <label for="last_name">Last Name</label>
                                        <form:input type="text" class="form-control" path="last_name" id="last_name" placeholder="Last name"></form:input>
                                    </div>
                                    
                                    <!--end form-group-->
                                </div>
                                <!--end col-md-6-->
                            </div>
                            <!--enr row-->
                            <div class="form-group">
                                <label for="email">Email</label>
                                <form:input type="text" class="form-control" path="email" id="email" placeholder="Email"></form:input>
                            </div>
                            <!--end form-group-->
                            <div class="form-group">
                                <label for="password">Password</label>
                                <form:input type="password" class="form-control" path="password" id="password" placeholder="Password"></form:input>
                            </div>
                            <div class="form-group">
                                <label for="password">Confirm Password</label>
                                <input type="password" class="form-control" name="cpassword" id="cpassword" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label for="phoneNo">Phone Number</label>
                                <form:input type="text" class="form-control" path="phoneNo" id="phoneNo" placeholder="Phone Number"></form:input>
                            </div>
                            <!--end form-group-->
                            <div class="form-group center">
                                <button type="submit" class="btn btn-primary width-100">Register Now</button>
                            </div>
                            <!--end form-group-->
                        </form:form>

                        <hr>

                        <p class="center">By clicking on “Register Now” button you are accepting the <a href="terms-conditions.html">Terms & Conditions</a></p>
                    </section>
                </div>
                <!--col-md-4-->
            </div>
            <!--end ro-->
        </div>
        <!--end container-->
<a href="#" class="to-top scroll" data-show-after-scroll="600"><i class="arrow_up"></i></a>


