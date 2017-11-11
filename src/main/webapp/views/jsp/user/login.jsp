        <div class="container">
            
            <div class="row">
                <div class="col-md-4 col-sm-4 col-md-offset-4 col-sm-offset-4">
                    <section class="page-title">
                        <h1>Sign In</h1>
                    </section>
                    <!--end page-title-->
                    <section>
                        <form class="form inputs-underline" id="loginform" action="processsignin"  onsubmit="return validateLogin()">
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
                                <button type="submit" class="btn btn-primary width-100" id="login-button">Sign In</button>
                            </div>
                            <!--end form-group-->
                        </form>
						<form class="form inputs-underline" action="/connnect/facebook">
						<div class="form-group center">
							<button type="submit" class="btn btn-primary width-100">Facebook</button>
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


