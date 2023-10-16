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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
										class="card-header-title font-size-lg text-capitalize font-weight-normal">Tarjetas
										Registradas</div>

								</div>
								<div class="card-body">
									<table style="width: 100%" id="example"
										class="table table-hover table-striped table-bordered">
										<thead>
											<tr>
												<th class="text-center">Nombre Empresa</th>
												<th class="text-center">Cliente</th>
												<th class="text-center">Correo Cliente</th>
												<th class="text-center">N° Tarjeta</th>
												<th class="text-center">Tipo Tarjeta</th>
												<th class="text-center">Fecha Registro</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${tarjetasRegistradas}"
												var="tarjetasRegistradas">
												<tr>
													<td class="text-center">${tarjetasRegistradas.empresa}</td>
													<td class="text-center">${tarjetasRegistradas.identificador}</td>
													<td class="text-center">${tarjetasRegistradas.correo}</td>
													<td class="text-center">${tarjetasRegistradas.cardNumber}</td>
													<td class="text-center">${tarjetasRegistradas.cardType}</td>
													<td class="text-center">${tarjetasRegistradas.fechaCreacion}</td>
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
