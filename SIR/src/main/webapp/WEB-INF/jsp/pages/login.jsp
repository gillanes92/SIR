<%@ include file="/WEB-INF/jsp/includes/include.jsp"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SIR</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />

<!-- Disable tap highlight on IE -->
<meta name="msapplication-tap-highlight" content="no">

<link rel="stylesheet" href="resources/css/base.min.css">


<script src="resources/js/scripts/jquery-3.3.1.min.js"></script>
<script src="resources/js/scripts/bootstrap.bundle.min.js"></script>
<script src="resources/js/vendors/carousel-slider.js"></script>
<script src="resources/js/scripts-init/carousel-slider.js"></script>

</head>

<body>
	<div class="app-container app-theme-white body-tabs-shadow">
		<div class="app-container">
			<div class="h-100">
				<div class="h-100 no-gutters row">
					<div class="d-none d-lg-block col-lg-4">
						<div class="slider-light">
							<div class="slick-slider">
								<div>
									<div
										class="position-relative h-100 d-flex justify-content-center align-items-center bg-plum-plate"
										tabindex="-1">
										<div class="slide-img-bg"
											style="background-image: url('resources/images/originals/city.jpg');"></div>
										<div class="slider-content">
											<h3>Perfect Balance</h3>
											<p>ArchitectUI is like a dream. Some think it's too good
												to be true! Extensive collection of unified React Boostrap
												Components and Elements.</p>
										</div>
									</div>
								</div>
								<div>
									<div
										class="position-relative h-100 d-flex justify-content-center align-items-center bg-premium-dark"
										tabindex="-1">
										<div class="slide-img-bg"
											style="background-image: url('resources/images/originals/citynights.jpg');"></div>
										<div class="slider-content">
											<h3>Scalable, Modular, Consistent</h3>
											<p>Easily exclude the components you don't require.
												Lightweight, consistent Bootstrap based styles across all
												elements and components</p>
										</div>
									</div>
								</div>
								<div>
									<div
										class="position-relative h-100 d-flex justify-content-center align-items-center bg-sunny-morning"
										tabindex="-1">
										<div class="slide-img-bg"
											style="background-image: url('resources/images/originals/citydark.jpg');"></div>
										<div class="slider-content">
											<h3>Complex, but lightweight</h3>
											<p>We've included a lot of components that cover almost
												all use cases for any type of application.</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div
						class="h-100 d-flex bg-white justify-content-center align-items-center col-md-12 col-lg-8">
						<div class="mx-auto app-login-box col-sm-12 col-md-10 col-lg-9">
							<div class="app-logo"></div>
							<h4 class="mb-0">
								<span class="d-block">Bienvenido de nuevo,</span> <span>Inicie
									sesi&oacute;n en su cuenta.</span>
							</h4>
							<!-- <h6 class="mt-3">
								¿Sin cuenta? <a href="register.htm" class="text-primary">Reg&iacute;strate
									ahora</a>
							</h6>  -->
							<div class="divider row"></div>
							<div>
								<form name="login" id="login" method="post"
									action="<c:url value='/j_spring_security_check' />">
									<div class="form-row">
										<div class="col-md-6">
											<div class="position-relative form-group">
												<label for="exampleEmail" class="">Correo
													electr&oacute;nico</label> <input name="j_username" id="j_username"
													placeholder="Correo electr&oacute;nico aqu&iacute;..."
													type="email" class="form-control">
											</div>
										</div>
										<div class="col-md-6">
											<div class="position-relative form-group">
												<label for="examplePassword" class="">Contrase&ntilde;a</label>
												<input name="j_password" id="j_password"
													placeholder="Contrase&ntilde;a aqu&iacute;..."
													type="password" class="form-control">
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="col-md-6">
											<div class="position-relative form-check">
												<input name="check" id="exampleCheck" type="checkbox"
													class="form-check-input"><label for="exampleCheck"
													class="form-check-label">Mantenme conectado</label>
											</div>
										</div>
										<c:if test="${not empty error}">
											<div class="col-md-6">
												<div>
													<label class="text-danger">Credenciales incorrectas</label>
												</div>
											</div>
										</c:if>
									</div>
									<div class="divider row"></div>
									<div class="d-flex align-items-center">
										<div class="ml-auto">
											<a href="forgot-password.htm" class="btn-lg btn btn-link">Recuperar
												contrase&ntilde;a</a>
											<button class="btn btn-primary btn-lg" id="Login"
												name="Login">Iniciar Sesi&oacute;n</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
