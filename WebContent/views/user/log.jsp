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
<link rel="stylesheet" href="${RESOURCES}/css/index.css" />
</head>
<body>
	<div class="wrap">
		<jsp:include page="../common/header.jsp" />
		<div class="page-wrapper">
			<jsp:include page="../common/navbar.jsp" />
			<jsp:include page="../common/breadcrumb.jsp" />
			<div class="wrapper wrapper-content animated fadeInDown">
			
			
				<block name="content"> 
				<c:forEach items="${logs}" var="log">
					<c:out value="${log.time}" /> <br />
				</c:forEach>
				
				
				<c:if test="${sessionScope.logPageInfo.page < 1 }">
					<li class="disabled"><a href="">&laquo;</a></li>
				</c:if>
				 <c:if test="${sessionScope.logPageInfo.page >= 1}">
					<li><a
						href="${ROOT}/user/log/${sessionScope.logPageInfo.page-1}">&laquo;</a></li>
				</c:if>
				 <c:if test="${sessionScope.logPageInfo.ifHaveNext =='false' }">
					<li class="disabled"><a href="">&raquo;</a></li>
				</c:if>
				 <c:if test="${sessionScope.logPageInfo.ifHaveNext =='true' }">
					<li><a
						href="${ROOT}/user/log/${sessionScope.logPageInfo.page+1}">&raquo;</a></li>
				</c:if> </block>
			</div>
			<jsp:include page="../common/footer.jsp" />
		</div>
	</div>
	<script type="text/javascript"
		src="${RESOURCES }/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${RESOURCES }/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${RESOURCES }/js/common.js"></script>
	<script type="text/javascript" src="${RESOURCES }/js/index.js"></script>
</body>
</html>