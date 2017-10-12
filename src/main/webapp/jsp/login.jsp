
<body class="navigation-fixed">
<div class="page-wrapper">
    <div id="page-content">
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li><a href="#">Pages</a></li>
                <li class="active">Contact</li>
            </ol>
            <!--end breadcrumb-->
            <div class="row">
                <div class="col-md-4 col-sm-4 col-md-offset-4 col-sm-offset-4">
                    <section class="page-title">
                        <h1>Sign In</h1>
                    </section>
                    <!--end page-title-->
                    <section>
                        <form class="form inputs-underline" action="processsignin" method="post" onsubmit="return validateLogin()">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="text" class="form-control" name="email" id="email" placeholder="Your email">
                            </div>
                            <!--end form-group-->
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" name="password" id="password" placeholder="Your password">
                            </div>
                            <div class="form-group center">
                                <button type="submit" class="btn btn-primary width-100">Sign In</button>
                            </div>
                            <!--end form-group-->
                        </form>
						<form class="form inputs-underline" action="facebooksignin">
						<div class="form-group center">
							<button type="submit" class="btn btn-primary width-100">Facebbok</button>
						</div>
						</form>
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

