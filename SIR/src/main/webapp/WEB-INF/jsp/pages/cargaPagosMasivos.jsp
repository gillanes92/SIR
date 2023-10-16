<%@ include file="/WEB-INF/jsp/includes/include.jsp"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Language" content="en">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SIR</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />

<!-- Disable tap highlight on IE -->
<meta name="msapplication-tap-highlight" content="no">

<link rel="stylesheet" href="resources/css/base.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/buttons.dataTables.min.css">
<script src="resources/js/scripts/jquery-3.3.1.min.js"></script>

<script src="resources/js/scripts/bootstrap.bundle.min.js"></script>
<script src="resources/js/scripts/metismenu"></script>
<script src="resources/js/scripts-init/app.js"></script>
<script src="resources/js/scripts-init/demo.js"></script>
<script src="resources/js/vendors/form-components/datepicker.js"></script>
<script src="resources/js/vendors/form-components/daterangepicker.js"></script>
<script src="resources/js/vendors/form-components/moment.js"></script>
<script src="resources/js/scripts-init/form-components/datepicker.js"></script>
<script src="resources/js/scripts/jquery.dataTables.min.js"></script>
<script src="resources/js/scripts/dataTables.buttons.min.js"></script>
<script src="resources/js/scripts/jszip.min.js"></script>
<script src="resources/js/scripts/vfs_fonts.js"></script>
<script src="resources/js/scripts/buttons.html5.min.js"></script>
<script src="resources/js/scripts/buttons.print.min.js"></script>
<script src="resources/js/scripts/dataTables.bootstrap4.min.js"></script>
<script src="resources/js/scripts/dataTables.responsive.min.js"></script>
<script src="resources/js/scripts/responsive.bootstrap.min.js"></script>
<script src="resources/js/vendors/tables.js"></script>
<script src="resources/js/scripts-init/tables.js"></script>
<script src="resources/js/vendors/blockui.js"></script>
<script src="resources/js/scripts-init/blockui.js"></script>

<script type="text/javascript"
	src="resources/js/toquenizacion/cargaPagosMasivos.js"></script>
</head>
<body>
	<div class="app-container app-theme-white body-tabs-shadow">

		<!--Header START-->
		<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>
		<!--Header END-->

		<div class="app-main">
			<!--Menu START-->
			<%@ include file="/WEB-INF/jsp/includes/menu.jsp"%>
			<!--Menu END-->
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="app-page-title">
						<div class="page-title-wrapper">
							<div class="page-title-heading">
								<div>Carga Pagos Masivos</div>
							</div>
						</div>
					</div>
					<div class="tabs-animation">
						<div class="row">
							<div class="col-md-6">
								<div class="card main-card mb-3">
									<div class="card-header">
										<div col-md-6>
											<div>1.- FECHA DE CARGA DE LOS PAGOS</div>
										</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<div class="input-group">
												<input id="datepicker" placeholder="dd/mm/yyyy" name="dp"
													class="form-control" data-toggle="datepicker-button"
													disabled readonly>
												<script>
													$("#datepicker")
															.datepicker(
																	{
																		dateFormat : 'dd/mm/yy',
																	})
															.datepicker(
																	"setDate",
																	new Date());
												</script>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="card main-card mb-3">
									<div class="card-header">3.- CARGAR ARCHIVO DE PAGOS
										MASIVOS (.csv)</div>
									<div class="card-body">
										<div class="form-row">
											<div class="col-md-6">
												<div class="position-relative form-group">
													<input class="form-control-file upload" type="file"
														accept=".txt,.dat,.csv" id="inputfile">
												</div>
											</div>
											<div class="col-md-6">
												<div class="position-relative form-group">
													<button id="cargarArchivo" class="btn btn-primary">Cargar
														archivo</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="main-card mb-3 card">
							<div class="card-header">
								<div
									class="card-header-title font-size-lg text-capitalize font-weight-normal">Archivos
									cargados</div>
							</div>
							<div class="card-body">
								<table style="width: 100%" id="example"
									class="table table-hover table-striped table-bordered">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Nombre archivo</th>
											<th class="text-center">Fecha de Carga</th>
											<th class="text-center">Cantidad de Pagos</th>
											<th class="text-center">Pagos Correctos</th>
											<th class="text-center">Pagos Fallidos</th>
											<th class="text-center">Estado</th>
											<th class="text-center">Acciones</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${rendiciones}" var="rendicion">
											<tr>
												<td class="text-center text-muted">${rendicion.idRendicion}</td>
												<td class="text-center"><img width="100"
													class="rounded-circle" src="${rendicion.image}" alt=""></td>
												<td class="text-center">${rendicion.codigoComercio}</td>
												<td class="text-center">${rendicion.nombreFantasia}</td>
												<td class="text-center">${rendicion.producto}</td>
												<td class="text-center">${rendicion.fechaAbono}</td>
												<td class="text-center">${rendicion.fechaRendicion}</td>
												<td class="text-center">${rendicion.cantidad}</td>
												<td class="text-center">${rendicion.conciliadas}</td>
												<td class="text-center">
													<div class="badge badge-pill badge-info">${rendicion.estado}</div>
												</td>
												<td class="text-center">
													<div role="group" class="btn-group-sm btn-group">
														<button onclick="ver('${rendicion.idRendicion}')"
															class="btn-shadow btn btn-primary">Ver</button>
														<button onclick="eliminar('${rendicion.idRendicion}')"
															class="btn-shadow btn btn-primary">
															<i class="fa fa-trash"></i>
														</button>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>

					</div>
				</div>
				<!-- Footer START -->
				<%@ include file="/WEB-INF/jsp/includes/footer.jsp"%>
				<!-- FOOTER END -->
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

<div class="modal fade show" id="modalConciliacion" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"></h5>
			</div>
			<div class="modal-body">
				<p class="mb-0" id="mensajeModal"></p>
			</div>
			<div class="modal-footer">
				<button id="cerrarModal" type="button" class="btn btn-primary"></button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade show" id="modalConfirmArchivo" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Confirmaci&oacute;n</h5>
			</div>
			<div class="modal-body">
				<p class="mb-0" id="mensModalConf"></p>
			</div>
			<div class="modal-footer">
				<button id="cerrarConc" type="button" class="btn btn-secondary">Cerrar</button>
				<button id="aceptarConc" type="button" class="btn btn-primary">Aceptar</button>
			</div>
		</div>
	</div>
</div>

