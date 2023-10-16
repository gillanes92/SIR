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
<script src="resources/js/vendors/jszip.js"></script>
<script src="resources/js/vendors/FileSaver.js"></script>
<script src="resources/js/vendors/excel.js"></script>
<script src="resources/js/rendicion/transacciones.js"></script>
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
								<div>Carga Transacciones</div>
							</div>
						</div>
					</div>
					<div class="tabs-animation">
						<div class="row">
							<div class="col-md-4">
								<div class="card main-card mb-3">
									<div class="card-header">
										<div col-md-6>
											<div>1.- SELECCIONA LA FECHA DE LAS TRANSACCIONES A
												CARGAR</div>
										</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<div class="input-group">
												<input id="datepicker" placeholder="dd/mm/yyyy" name="dp"
													class="form-control" data-toggle="datepicker-button">
												<div class="input-group-append">
													<button class="btn btn-primary datepicker-trigger-btn">
														<i class="fa fa-calendar"></i>
													</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="card main-card mb-3">
									<div class="card-header">
										<div col-md-6>
											<div>2.- Seleccione el comercio de los pagos</div>
										</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<div class="input-group">
												<select type="select" id="idConcen" name="idConcen"
													class="custom-select">
													<c:forEach items="${concentradores}" var="con">
														<option value="${con.idConcentrador}">${con.nomConcentrador}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="card main-card mb-3">
									<div class="card-header">
										<div col-md-6>
											<div>3.- Descargue el formato de archivo a subir (csv)</div>
										</div>
									</div>
									<div class="card-body">
										<div class="form-group">
											<div class="input-group">
												<button id="descargar" class="mt-2 btn btn-primary">Descargar</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="card main-card mb-3">
							<div class="card-header">4.- CARGA TODAS LAS TRANSACCIONES
								ASOCIADAS A LA FECHA SELECCIONADA ANTERIORMENTE.</div>
							<div class="card-body">
								<div class="divider"></div>
								<div class="position-relative form-group">
									<label class="form-label">Cargar archivo (.csv)</label> <input
										class="form-control upload" type="file" accept=".csv"
										id="inputfile">
								</div>
							</div>
							<button id="cargarArchivo" class="btn btn-primary">Cargar
								archivo</button>
						</div>

						<div class="main-card mb-3 card">
							<div class="card-header">
								<div
									class="card-header-title font-size-lg text-capitalize font-weight-normal">Lotes
									de transacciones cargadas</div>
							</div>
							<div class="card-body">
								<table style="width: 100%" id="example"
									class="table table-hover table-striped table-bordered">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Archivo</th>
											<th class="text-center">Fecha Carga</th>
											<th class="text-center">Cantidad</th>
											<th class="text-center">Conciliadas</th>
											<th class="text-center">Estado</th>
											<th class="text-center">Acciones</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pagos}" var="pago">
											<tr>
												<td class="text-center text-muted">${pago.idPago}</td>
												<td class="text-center">${pago.archivoOriginal}</td>
												<td class="text-center">${pago.fechaSubida}</td>
												<td class="text-center">${pago.cantidad}</td>
												<td class="text-center">${pago.conciliadas}</td>

												<c:if test="${pago.estado == 'PD'}">
													<td class="text-center">
														<div class="badge badge-pill badge-info">Pendiente</div>
													</td>
												</c:if>
												<c:if test="${pago.estado == 'PA'}">
													<td class="text-center">
														<div class="badge badge-pill badge-warning">En
															Proceso</div>
													</td>
												</c:if>
												<c:if test="${pago.estado == 'AP'}">
													<td class="text-center">
														<div class="badge badge-pill badge-warning">Procesado</div>
													</td>
												</c:if>
												<c:if test="${pago.estado == 'CA'}">
													<td class="text-center">
														<div class="badge badge-pill badge-warning">Conciliando</div>
													</td>
												</c:if>
												<c:if test="${pago.estado == 'ACC'}">
													<td class="text-center">
														<div class="badge badge-pill badge-warning">Conciliaci&oacute;n
															completa</div>
													</td>
												</c:if>
												<c:if test="${pago.estado == 'APC'}">
													<td class="text-center">
														<div class="badge badge-pill badge-success">Conciliaci&oacute;n
															incompleta</div>
													</td>
												</c:if>
												<c:if test="${pago.estado == 'ERF'}">
													<td class="text-center">
														<div class="badge badge-pill badge-danger">Error en
															formato</div>
													</td>
												</c:if>
												<c:if test="${pago.estado == 'ERC'}">
													<td class="text-center">
														<div class="badge badge-pill badge-danger">Error en
															conciliar</div>
													</td>
												</c:if>

												<td class="text-center">
													<div role="group" class="btn-group-sm btn-group">
														<button onclick="ver('${pago.idPago}')"
															class="btn-shadow btn btn-primary">Ver</button>
														<button onclick="eliminar('${pago.idPago}')"
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

<div class="modal fade show" id="modalPago" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" style="display: none;"
	aria-hidden="true">
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
<div class="modal fade show" id="modalConcentrador" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel"
	style="display: none;" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Confirmaci&oacute;n</h5>
			</div>
			<div class="modal-body">
				<p class="mb-0" id="mensModalCon"></p>
			</div>
			<div class="modal-footer">
				<button id="cerrarConc" type="button" class="btn btn-secondary">Cancelar</button>
				<button id="aceptarConc" type="button" class="btn btn-primary">Aceptar</button>
			</div>
		</div>
	</div>
</div>


