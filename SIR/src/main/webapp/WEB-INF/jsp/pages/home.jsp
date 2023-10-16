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
<script src="resources/js/scripts/metismenu"></script>
<script src="resources/js/scripts-init/app.js"></script>
<script src="resources/js/scripts-init/demo.js"></script>

<script src="resources/js/vendors/charts/apex-charts.js"></script>

<script src="resources/js/scripts-init/charts/apex-charts.js"></script>
<script src="resources/js/scripts-init/charts/apex-series.js"></script>

<!--Sparklines-->
<script src="resources/js/vendors/charts/charts-sparklines.js"></script>
<script src="resources/js/scripts-init/charts/charts-sparklines.js"></script>

<!--Chart.js-->
<script src="resources/js/scripts/Chart.min.js"></script>
<script src="resources/js/scripts-init/charts/chartsjs-utils.js"></script>

<!--Slick Carousel -->
<script src="resources/js/vendors/carousel-slider.js"></script>
<script src="resources/js/scripts-init/carousel-slider.js"></script>


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
					<div class="tabs-animation">
						<div class="mb-3 card">
							<div class="card-header-tab card-header">
								<div
									class="card-header-title font-size-lg text-capitalize font-weight-normal">
									<i class="header-icon lnr-charts icon-gradient bg-happy-green">
									</i> Rendimiento De La Cartera
								</div>
								<div class="btn-actions-pane-right text-capitalize">
									<button
										class="btn-wide btn-outline-2x mr-md-2 btn btn-outline-focus btn-sm">Ver
										todo</button>
								</div>
							</div>
							<div class="no-gutters row">
								<div class="col-sm-6 col-md-4 col-xl-4">
									<div
										class="card no-shadow rm-border bg-transparent widget-chart text-left">
										<div class="icon-wrapper rounded-circle">
											<div class="icon-wrapper-bg opacity-10 bg-warning"></div>
											<i class="lnr-laptop-phone text-dark opacity-8"></i>
										</div>
										<div class="widget-chart-content">
											<div class="widget-subheading">Dep&oacute;sitos en
												efectivo</div>
											<div class="widget-numbers">1,7M</div>
											<div class="widget-description opacity-8 text-focus">
												<div class="d-inline text-danger pr-1">
													<i class="fa fa-angle-down"></i> <span class="pl-1">54.1%</span>
												</div>
												less earnings
											</div>
										</div>
									</div>
									<div class="divider m-0 d-md-none d-sm-block"></div>
								</div>
								<div class="col-sm-6 col-md-4 col-xl-4">
									<div
										class="card no-shadow rm-border bg-transparent widget-chart text-left">
										<div class="icon-wrapper rounded-circle">
											<div class="icon-wrapper-bg opacity-9 bg-danger"></div>
											<i class="lnr-graduation-hat text-white"></i>
										</div>
										<div class="widget-chart-content">
											<div class="widget-subheading">Dividendos invertidos</div>
											<div class="widget-numbers">
												<span>9M</span>
											</div>
											<div class="widget-description opacity-8 text-focus">
												Tasa de crecimiento: <span class="text-info pl-1"> <i
													class="fa fa-angle-down"></i> <span class="pl-1">14.1%</span>
												</span>
											</div>
										</div>
									</div>
									<div class="divider m-0 d-md-none d-sm-block"></div>
								</div>
							</div>
							<div class="text-center d-block p-3 card-footer">
								<button
									class="btn-pill btn-shadow btn-wide fsize-1 btn btn-primary btn-lg">
									<span class="mr-2 opacity-7"> <i
										class="icon icon-anim-pulse ion-ios-analytics-outline"></i>
									</span> <span class="mr-1">Ver informe completo</span>
								</button>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 col-lg-12">
								<div class="mb-3 card">
									<div class="card-header-tab card-header">
										<div
											class="card-header-title font-size-lg text-capitalize font-weight-normal">
											<i
												class="header-icon lnr-cloud-download icon-gradient bg-happy-itmeo">
											</i> Soporte T&eacute;cnico
										</div>
										<div
											class="btn-actions-pane-right text-capitalize actions-icon-btn">
											<div class="btn-group dropdown">
												<button type="button" data-toggle="dropdown"
													aria-haspopup="true" aria-expanded="false"
													class="btn-icon btn-icon-only btn btn-link">
													<i class="pe-7s-menu btn-icon-wrapper"></i>
												</button>
												<div tabindex="-1" role="menu" aria-hidden="true"
													class="dropdown-menu-right rm-pointers dropdown-menu-shadow dropdown-menu-hover-link dropdown-menu">
													<h6 tabindex="-1" class="dropdown-header">Header</h6>
													<button type="button" tabindex="0" class="dropdown-item">
														<i class="dropdown-icon lnr-inbox"> </i><span>Menus</span>
													</button>
													<button type="button" tabindex="0" class="dropdown-item">
														<i class="dropdown-icon lnr-file-empty"> </i><span>Settings</span>
													</button>
													<button type="button" tabindex="0" class="dropdown-item">
														<i class="dropdown-icon lnr-book"> </i><span>Actions</span>
													</button>
													<div tabindex="-1" class="dropdown-divider"></div>
													<div class="p-3 text-right">
														<button class="mr-2 btn-shadow btn-sm btn btn-link">View
															Details</button>
														<button class="mr-2 btn-shadow btn-sm btn btn-primary">Action</button>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="p-0 card-body">
										<div class="p-1 slick-slider-sm mx-auto">
											<div class="slick-slider">
												<div>
													<div class="widget-chart widget-chart2 text-left p-0">
														<div class="widget-chat-wrapper-outer">
															<div
																class="widget-chart-content widget-chart-content-lg pb-0">
																<div class="widget-chart-flex">
																	<div
																		class="widget-title opacity-5 text-muted text-uppercase">New
																		Accounts since 2018</div>
																</div>
																<div class="widget-numbers">
																	<div class="widget-chart-flex">
																		<div>
																			<span class="opacity-10 text-success pr-2"> <i
																				class="fa fa-angle-up"></i>
																			</span> <span>78</span> <small class="opacity-5 pl-1">%</small>
																		</div>
																		<div
																			class="widget-title ml-2 font-size-lg font-weight-normal text-muted">
																			<span class="text-success pl-2">+14</span>
																		</div>
																	</div>
																</div>
															</div>
															<div class="widget-chart-wrapper he-auto opacity-10 m-0">
																<div id="dashboard-sparkline-3"></div>
															</div>
														</div>
													</div>
												</div>
												<div>
													<div class="widget-chart widget-chart2 text-left p-0">
														<div class="widget-chat-wrapper-outer">
															<div
																class="widget-chart-content widget-chart-content-lg pb-0">
																<div class="widget-chart-flex">
																	<div
																		class="widget-title opacity-5 text-muted text-uppercase">Last
																		Year Total Sales</div>
																</div>
																<div class="widget-numbers">
																	<div class="widget-chart-flex">
																		<div>
																			<small class="opacity-3 pr-1">$</small> <span>629</span>
																			<span class="text-primary pl-3"> <i
																				class="fa fa-angle-down"></i>
																			</span>
																		</div>
																	</div>
																</div>
															</div>
															<div class="widget-chart-wrapper he-auto opacity-10 m-0">
																<div id="dashboard-sparkline-1"></div>
															</div>
														</div>
													</div>
												</div>
												<div>
													<div class="widget-chart widget-chart2 text-left p-0">
														<div class="widget-chat-wrapper-outer">
															<div
																class="widget-chart-content widget-chart-content-lg pb-0">
																<div class="widget-chart-flex">
																	<div
																		class="widget-title opacity-5 text-muted text-uppercase">Helpdesk
																		Tickets</div>
																</div>
																<div class="widget-numbers">
																	<div class="widget-chart-flex">
																		<div>
																			<span class="text-warning">34</span>
																		</div>
																		<div
																			class="widget-title ml-2 font-size-lg font-weight-normal text-dark">
																			<span class="opacity-5 text-muted pl-2 pr-1">5%</span>
																			increase
																		</div>
																	</div>
																</div>
															</div>
															<div class="widget-chart-wrapper he-auto opacity-10 m-0">
																<div id="dashboard-sparkline-2"></div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<h6
											class="text-muted text-uppercase font-size-md opacity-5 pl-3 pr-3 pb-1 font-weight-normal">Sales
											Progress</h6>
										<ul class="list-group list-group-flush">
											<li class="p-3 bg-transparent list-group-item">
												<div class="widget-content p-0">
													<div class="widget-content-outer">
														<div class="widget-content-wrapper">
															<div class="widget-content-left">
																<div class="widget-heading">Total Orders</div>
																<div class="widget-subheading">Last year expenses</div>
															</div>
															<div class="widget-content-right">
																<div class="widget-numbers text-success">
																	<small>$</small> 1896
																</div>
															</div>
														</div>
														<div class="widget-progress-wrapper">
															<div
																class="progress-bar-sm progress-bar-animated-alt progress">
																<div class="progress-bar bg-primary" role="progressbar"
																	aria-valuenow="43" aria-valuemin="0"
																	aria-valuemax="100" style="width: 43%;"></div>
															</div>
															<div class="progress-sub-label">
																<div class="sub-label-left">YoY Growth</div>
																<div class="sub-label-right">100%</div>
															</div>
														</div>
													</div>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-xl-3">
								<div
									class="card mb-3 widget-chart widget-chart2 text-left card-btm-border card-shadow-success border-success">
									<div class="widget-chat-wrapper-outer">
										<div class="widget-chart-content pt-3 pl-3 pb-1">
											<div class="widget-chart-flex">
												<div class="widget-numbers">
													<div class="widget-chart-flex">
														<div class="fsize-4">
															<small class="opacity-5">$</small> <span>874</span>
														</div>
													</div>
												</div>
											</div>
											<h6 class="widget-subheading mb-0 opacity-5">sales last
												month</h6>
										</div>
										<div
											class="no-gutters widget-chart-wrapper mt-3 mb-3 pl-2 he-auto row">
											<div class="col-md-9">
												<div id="dashboard-sparklines-1"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-xl-3">
								<div
									class="card mb-3 widget-chart widget-chart2 text-left card-btm-border card-shadow-primary border-primary">
									<div class="widget-chat-wrapper-outer">
										<div class="widget-chart-content pt-3 pl-3 pb-1">
											<div class="widget-chart-flex">
												<div class="widget-numbers">
													<div class="widget-chart-flex">
														<div class="fsize-4">
															<small class="opacity-5">$</small> <span>1283</span>
														</div>
													</div>
												</div>
											</div>
											<h6 class="widget-subheading mb-0 opacity-5">sales
												Income</h6>
										</div>
										<div
											class="no-gutters widget-chart-wrapper mt-3 mb-3 pl-2 he-auto row">
											<div class="col-md-9">
												<div id="dashboard-sparklines-2"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-xl-3">
								<div
									class="card mb-3 widget-chart widget-chart2 text-left card-btm-border card-shadow-warning border-warning">
									<div class="widget-chat-wrapper-outer">
										<div class="widget-chart-content pt-3 pl-3 pb-1">
											<div class="widget-chart-flex">
												<div class="widget-numbers">
													<div class="widget-chart-flex">
														<div class="fsize-4">
															<small class="opacity-5">$</small> <span>1286</span>
														</div>
													</div>
												</div>
											</div>
											<h6 class="widget-subheading mb-0 opacity-5">last month
												sales</h6>
										</div>
										<div
											class="no-gutters widget-chart-wrapper mt-3 mb-3 pl-2 he-auto row">
											<div class="col-md-9">
												<div id="dashboard-sparklines-3"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-xl-3">
								<div
									class="card mb-3 widget-chart widget-chart2 text-left card-btm-border card-shadow-danger border-danger">
									<div class="widget-chat-wrapper-outer">
										<div class="widget-chart-content pt-3 pl-3 pb-1">
											<div class="widget-chart-flex">
												<div class="widget-numbers">
													<div class="widget-chart-flex">
														<div class="fsize-4">
															<small class="opacity-5">$</small> <span>564</span>
														</div>
													</div>
												</div>
											</div>
											<h6 class="widget-subheading mb-0 opacity-5">total
												revenue</h6>
										</div>
										<div
											class="no-gutters widget-chart-wrapper mt-3 mb-3 pl-2 he-auto row">
											<div class="col-md-9">
												<div id="dashboard-sparklines-4"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div
							class="card no-shadow bg-transparent no-border rm-borders mb-3">
							<div class="card">
								<div class="no-gutters row">
									<div class="col-md-12 col-lg-4">
										<ul class="list-group list-group-flush">
											<li class="bg-transparent list-group-item">
												<div class="widget-content p-0">
													<div class="widget-content-outer">
														<div class="widget-content-wrapper">
															<div class="widget-content-left">
																<div class="widget-heading">Total Orders</div>
																<div class="widget-subheading">Last year expenses</div>
															</div>
															<div class="widget-content-right">
																<div class="widget-numbers text-success">1896</div>
															</div>
														</div>
													</div>
												</div>
											</li>
											<li class="bg-transparent list-group-item">
												<div class="widget-content p-0">
													<div class="widget-content-outer">
														<div class="widget-content-wrapper">
															<div class="widget-content-left">
																<div class="widget-heading">Clients</div>
																<div class="widget-subheading">Total Clients
																	Profit</div>
															</div>
															<div class="widget-content-right">
																<div class="widget-numbers text-primary">$12.6k</div>
															</div>
														</div>
													</div>
												</div>
											</li>
										</ul>
									</div>
									<div class="col-md-12 col-lg-4">
										<ul class="list-group list-group-flush">
											<li class="bg-transparent list-group-item">
												<div class="widget-content p-0">
													<div class="widget-content-outer">
														<div class="widget-content-wrapper">
															<div class="widget-content-left">
																<div class="widget-heading">Followers</div>
																<div class="widget-subheading">People Interested</div>
															</div>
															<div class="widget-content-right">
																<div class="widget-numbers text-danger">45,9%</div>
															</div>
														</div>
													</div>
												</div>
											</li>
											<li class="bg-transparent list-group-item">
												<div class="widget-content p-0">
													<div class="widget-content-outer">
														<div class="widget-content-wrapper">
															<div class="widget-content-left">
																<div class="widget-heading">Products Sold</div>
																<div class="widget-subheading">Total revenue
																	streams</div>
															</div>
															<div class="widget-content-right">
																<div class="widget-numbers text-warning">$3M</div>
															</div>
														</div>
													</div>
												</div>
											</li>
										</ul>
									</div>
									<div class="col-md-12 col-lg-4">
										<ul class="list-group list-group-flush">
											<li class="bg-transparent list-group-item">
												<div class="widget-content p-0">
													<div class="widget-content-outer">
														<div class="widget-content-wrapper">
															<div class="widget-content-left">
																<div class="widget-heading">Total Orders</div>
																<div class="widget-subheading">Last year expenses</div>
															</div>
															<div class="widget-content-right">
																<div class="widget-numbers text-success">1896</div>
															</div>
														</div>
													</div>
												</div>
											</li>
											<li class="bg-transparent list-group-item">
												<div class="widget-content p-0">
													<div class="widget-content-outer">
														<div class="widget-content-wrapper">
															<div class="widget-content-left">
																<div class="widget-heading">Clients</div>
																<div class="widget-subheading">Total Clients
																	Profit</div>
															</div>
															<div class="widget-content-right">
																<div class="widget-numbers text-primary">$12.6k</div>
															</div>
														</div>
													</div>
												</div>
											</li>
										</ul>
									</div>
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
