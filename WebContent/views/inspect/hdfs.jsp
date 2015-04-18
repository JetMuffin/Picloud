<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${TITLE}</title>
<link rel="stylesheet" href="${RESOURCES}/font/css/font-awesome.min.css" />
<link rel="stylesheet" href="${RESOURCES}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${RESOURCES}/css/common.css" />
</head>
<body>
	<div class="wrap">
		<jsp:include page="../common/header.jsp" />
		<div class="page-wrapper">
			<jsp:include page="../common/navbar.jsp" />
			<jsp:include page="../common/breadcrumb.jsp" />
			<div class="wrapper wrapper-content animated fadeInDown">
				<block name="content">
				<div class="row">
					<div class="col-md-12">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>
									概况 <small>HDFS</small>
								</h5>
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a
										class="close-link"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="ibox-content" style="display: block;">
								<div class="row">
									<div class="col-md-8">
										<table class="table table-striped table table-bordered table-hover dataTables-example">
											<tbody>
												<tr><td><strong>DFS Used:</strong></td><td>${systemState.dfsUsed}</td></tr>
												<tr><td><strong>Non DFS Used:</strong></td><td>${systemState.nonDFSUsed}</td></tr>
												<tr><td><strong>DFS Remaining:</strong></td><td>${systemState.dfsRemaining}</td></tr>
											<tr><td><strong>DFS Used%:</strong></td><td>${systemState.dfsUsedPercent}</td></tr>
											<tr><td><strong>DFS Remaining%:</strong></td><td>${systemState.dfsRemainingPercent}</td></tr>
											<tr><td><strong>Block Pool Used:</strong></td><td>${systemState.blockPoolUsed}</td></tr>
											<tr><td><strong>Block Pool Used%:</strong></td><td>${systemState.blockPoolUsedPercent}</td></tr>
											<tr><td><strong>DataNodes usages% (Min/Median/Max/stdDev):</strong></td><td>${systemState.nodeUsageMin}/${systemState.nodeUsageMedian}/${systemState.nodeUsageMax}/${systemState.nodeUsageStdDev}</td></tr>
											</tbody>
										</table>									
									</div>
									<div class="col-md-4">
										<div class="flot-chart-content" id="flot-pie-chart" style="height:280px"
												></div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-12">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>
									全景图片 <small>全景图片列表</small>
								</h5>
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a> <a
										class="close-link"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="ibox-content" style="display: block;">
							</div>
						</div>
					</div>
				</div>
				<div id="url_base" data-url="${IP}${ROOT}"></div>
				</block>
			</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
	<script type="text/javascript"
		src="${RESOURCES }/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${RESOURCES }/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${RESOURCES }/js/common.js"></script>
	<script src="${PLUGIN}/flot/jquery.flot.min.js"></script>
	<script type="text/javascript" src="${PLUGIN}/flot/jquery.flot.pie.min.js"></script>
		<script type="text/javascript" src="${PLUGIN}/flot/jquery.flot.tooltip.min.js"></script>
		<script src="${RESOURCES}/js/hdfs.js"></script>
</body>
</html>