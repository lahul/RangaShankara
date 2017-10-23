<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body class="navigation-fixed">
<div class="page-wrapper">
    <div id="page-content">
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li><a href="#">Pages</a></li>
                <li class="active">Contact</li>
            </ol>
            <c:out value="${email}"/>
            <!--end breadcrumb-->
            <div class="row">
                <div class="col-md-4 col-sm-4 col-md-offset-4 col-sm-offset-4">
                    <section class="page-title">
                        <h1>Reset Password</h1>
                    </section>
                    <!--end page-title-->
                    <section>
                        <form:form class="form inputs-underline" method="post">
                            <div class="form-group">
                                <label for="password">New Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="New Password">
                            </div>
                            <!--end form-group-->
                            <div class="form-group">
                                <label for="password">Confirm Password</label>
                                <input type="password" class="form-control" name="cpassword" id="password" placeholder="Your password">
                            </div>
                            <div class="form-group center">
                            	<input type="hidden" name="token" value="${email}" />
                                <button type="submit" class="btn btn-primary width-100">Change Password</button>
                            </div>
                            <!--end form-group-->
                        </form:form>
                        <hr>

                        <a href="#" data-modal-external-file="modal_reset_password.php" data-target="modal-reset-password">I have forgot my password</a>
                    </section>
                </div>
                <!--col-md-4-->
            </div>
            <!--end ro-->
        </div>
        <!--end container-->
    </div>
    <!--end page-content-->

</div>
</body>

