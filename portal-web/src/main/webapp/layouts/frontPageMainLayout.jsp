<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %><%@ include file="/common/taglibs.jsp"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
 <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/jquery-ui.min.js"></script>
 <script src="${pageContext.request.contextPath}/javascript/jconf.jquery.js" type="text/javascript" language="javascript"></script>

<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="urlt" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}"/>


<script type="text/javascript">
<spring:message code="sib.terms.dialog.question" var="question"/>
<spring:message code="sib.terms.dialog.accept" var="accept"/>
<spring:message code="sib.terms.dialog.cancel" var="cancel"/>
$(document).ready(function() {
	/*
	//alert(readCookies());
	if(readCookie('GbifTermsAndConditions')===null){
		$('.confirm').jConfirmAction({question : '${question}'+'<br/><a href="${urlt}/terms.htm" class="newtab">${urlt}/terms.htm</a>', yesAnswer : '${accept}', cancelAnswer : '${cancel}', url:''});
		$('a.newtab').bind('click', function(e) {
        	e.preventDefault();
        	nref = $(this).attr('href');
        	console.log(":D");
        });
	}
	*/
});
</script>


<c:if test="${param['noHeaders']!=1}"><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<!-- GBIF Portal Version: <gbif:propertyLoader bundle="portal" property="version"/> -->	
	<head>
    	<tiles:insert name="headcontent" flush="true"/>	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
		<c:if test="${not empty points}">
			<meta name="geo.position" content="<c:forEach items="${points}" var="point">${point.latitude};${point.longitude}</c:forEach>">
		</c:if> 		
		
		<tiles:insert name="keywords"/>
		<title>
			<tiles:insert name="subtitle"/>
				- 			
			<c:set var="title" scope="page"><tiles:getAsString name="title"/></c:set>
			<spring:message code="${title}"/> 
		</title>
		<c:set var="title" scope="request"><tiles:insert name="subtitle" flush="false"/></c:set>		
	</head>
	<body>
	<spring:message code="sib.terms.dialog.terms" var="terms"/>
	
	<!-- jquery dialog div-->
	<!--  
	<div id="dialog-confirm" class="some" title="${terms}"></div>
	-->
	<!-- jquery dialog div-->	
		
	</body>
	    <div id="skipNav">
			<ul title="<spring:message code="accessibility.title" text="Accessibility options"/>">
	  		<li><a href="#mainContent" accesskey="C"><spring:message code="accessibility.skip.to.content" text="Skip to Content"/></a></li>
	  		<li><a href="#sidebar" accesskey="S"><spring:message code="accessibility.skip.to.sidebar" text="Skip to Sidebar"/></a></li>
			</ul> 
	    </div>
		<div id="cocoon">
			<div id="container">	
				<tiles:insert name="header"/>
				<tiles:insert name="topmenu"/>
				<div id="content">
</c:if>       				
					<tiles:insert name="content"/>
<c:if test="${param['noHeaders']!=1}">					
					<tiles:insert name="breadcrumbs"/>
				</div><!--End content -->				
				<tiles:insert name="footer"/>
			</div><!-- End container-->
		</div><!-- End cocoon-->	
	
	

</html>
</c:if>