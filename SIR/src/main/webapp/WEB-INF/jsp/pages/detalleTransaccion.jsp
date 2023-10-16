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
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/buttons.dataTables.min.css">
<script src="resources/js/scripts/jquery-3.3.1.min.js"></script>
<script src="resources/js/scripts/bootstrap.bundle.min.js"></script>
<script src="resources/js/scripts/metismenu"></script>
<script src="resources/js/scripts-init/app.js"></script>
<script src="resources/js/scripts-init/demo.js"></script>
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

</head>
<body>
	<div class="app-container app-theme-white body-tabs-shadow">

		<!--Header START-->
		<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>
		<!--Header END-->
		<div class="app-main">
			<%@ include file="/WEB-INF/jsp/includes/menu.jsp"%>
			<div class="app-main__outer">
				<div class="app-main__inner">
					<div class="tab-content">
						<div class="tab-pane tabs-animation fade show active"
							id="tab-content-0" role="tabpanel">
							<div class="main-card mb-3 card">
								<div class="card-header">
									<div
										class="card-header-title font-size-lg text-capitalize font-weight-normal">Detalle
										de Pago</div>
									<div style="margin-left: auto; margin-right: inherit;">
										<a href="cargaRendiciones.htm" class="mt-2 btn btn-primary"
											style="">Cargar rendición</a>
									</div>
								</div>
								<div class="card-body">
									<table style="width: 100%" id="example"
										class="table table-hover table-striped table-bordered">
										<thead>
											<tr>
												<th class="text-center">#</th>
												<th class="text-center">Identificador</th>
												<th class="text-center">Monto Venta</th>
												<th class="text-center">Fecha venta</th>
												<th class="text-center">Tipo tarjeta</th>
												<th class="text-center">C&oacute;digo
													autorizaci&oacute;n</th>
												<th class="text-center">Cargado en Rendici&oacute;n</th>
												<th class="text-center">Estado</th>
												<th class="text-center">Acciones</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${detallesTransaccion}" var="detalleTransaccion">
												<tr>
													<td class="text-center text-muted">${detalleTransaccion.idDetallePago}</td>
													<td class="text-center">${detalleTransaccion.identificador}</td>
													<td class="text-center">${detalleTransaccion.montoPago}</td>
													<td class="text-center">${detalleTransaccion.fechaVenta}</td>
													<td class="text-center">${detalleTransaccion.tipoTarjeta}</td>
													<td class="text-center">${detalleTransaccion.codAutorizacion}</td>
													<td class="text-center"># ${detalleTransaccion.idRend}</td>
													<c:if test="${detalleTransaccion.estadoConcilia == 'SI'}">
														<td class="text-center">
															<div class="badge badge-pill badge-info">Encontrado</div>
														</td>
													</c:if>
													<c:if test="${detalleTransaccion.estadoConcilia == 'NO'}">
														<td class="text-center">
															<div class="badge badge-pill badge-warning">No
																encontrado</div>
														</td>
													</c:if>

													<td class="text-center">
														<div role="group" class="btn-group-sm btn-group">
															<button
																onclick="eliminar('${detalleTransaccion.idDetallePago}')"
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
				</div>
				<%@ include file="/WEB-INF/jsp/includes/footer.jsp"%>
			</div>
		</div>
	</div>

</body>
</html>
