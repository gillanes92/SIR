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
<script src="resources/js/vendors/blockui.js"></script>
<script type="text/javascript" src="resources/js/login/sha512.js"></script>
<script type="text/javascript" src="resources/js/login/register.js"></script>


</head>

<body>
	<div class="app-container app-theme-white body-tabs-shadow">
		<div class="app-container">
			<div class="h-100">
				<div class="h-100 no-gutters row">
					<div
						class="h-100 d-md-flex d-sm-block bg-white justify-content-center align-items-center col-md-12 col-lg-7">
						<div class="mx-auto app-login-box col-sm-12 col-md-10 col-lg-9">
							<div class="app-logo"></div>
							<h4>
								<div>Bienvenido,</div>
								<span>Solo toma <span class="text-success">unos
										segundos</span> crear su cuenta
								</span>
							</h4>
							<div>
								<form>
									<div class="form-row">
										<div class="col-md-6">
											<div class="position-relative form-group">
												<label for="email" class=""><span
													class="text-danger">*</span> Correo electr&oacute;nico</label><input
													name="email" id="email"
													placeholder="Correo electr&oacute;nico aqu&iacute;..."
													type="email" class="form-control">
											</div>
										</div>
										<div class="col-md-6">
											<div class="position-relative form-group">
												<label for="name" class="">Nombre</label><input name="name"
													id="name" placeholder="Nombre aqu&iacute;..." type="text"
													class="form-control">
											</div>
										</div>
										<div class="col-md-6">
											<div class="position-relative form-group">
												<label for="password" class=""><span
													class="text-danger">*</span> Contrase&ntilde;a</label><input
													name="password" id="password"
													placeholder="Contrase&ntilde;a aqu&iacute;..."
													type="password" class="form-control">
											</div>
										</div>
										<div class="col-md-6">
											<div class="position-relative form-group">
												<label for="passwordrep" class=""><span
													class="text-danger">*</span> Repetir contrase&ntilde;a</label><input
													name="passwordrep" id="passwordrep"
													placeholder="Repetir contrase&ntilde;a aqu&iacute;..."
													type="password" class="form-control">
											</div>
										</div>
									</div>
									<div class="form-row">
										<div class="col-md-6">
											<div class="mt-3 position-relative form-check">
												<input name="check" id="exampleCheck" type="checkbox"
													class="form-check-input"><label for="exampleCheck"
													class="form-check-label">Acepta nuestros <a>T&eacute;rminos
														y Condiciones</a>.
												</label>
											</div>
										</div>
										<div class="col-md-6">
											<div>
												<label id="msgError" class="text-danger"></label>
											</div>
										</div>
									</div>


								</form>
								<div class="mt-4 d-flex align-items-center">
									<h5 class="mb-0">
										¿Ya tienes una cuenta? <a href="login.htm"
											class="text-primary">Inicia Sesión</a>
									</h5>
									<div class="ml-auto">
										<button
											class="btn-wide btn-pill btn-shadow btn-hover-shine btn btn-primary btn-lg"
											id="registrar" name="registrar">Crear una cuenta</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="d-lg-flex d-xs-none col-lg-5">
						<div class="slider-light">
							<div class="slick-slider slick-initialized">
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
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="body-block-example-1 d-none">
		<div class="loader bg-transparent no-shadow p-0">
			<div class="ball-grid-pulse">
				<div class="bg-white"></div>
				<div class="bg-white"></div>
				<div class="bg-white"></div>
				<div class="bg-white"></div>
				<div class="bg-white"></div>
				<div class="bg-white"></div>
				<div class="bg-white"></div>
				<div class="bg-white"></div>
				<div class="bg-white"></div>
			</div>
		</div>
	</div>

</body>
</html>


<div class="modal fade show" id="modalRegister" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
				<button id="cerrarModal" type="button" class="close"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p class="mb-0" id="mensajeModal"></p>
			</div>
			<div class="modal-footer">
				<a id="mensajebtnok" type="button" class="btn btn-primary" href="login.htm"></a>
				<button id="mensajebtner" type="button" class="btn btn-primary"></button>
			</div>
		</div>
	</div>
</div>
