<%@ include file="/common/taglibs.jsp"%>
<c:if test="${param['noHeaders']!=1}">
	<div id="twopartheader">
		<h2><spring:message code="blanket.search.header"/> <strong>${searchString}</strong> </h2>
		<ul class="scResults">
			<li class="scNames"><a href="#Names1"><spring:message code="blanket.search.scientific.names.title"/></a></li>
			<li class="scNames"><a href="#Names2"><spring:message code="blanket.search.common.names.title"/></a></li>
			<li class="scCountries"><a href="#Countries"><spring:message code="blanket.search.geographical.areas.title"/></a></li>
			<li class="scDatasets"><a href="#Datasets"><spring:message code="blanket.search.data.resources.title"/></a></li>
		</ul>
	</div>
</c:if>	

<div id="scientificNameResults" class="blanketResultsContainer">
	<tiles:insert definition="search.taxa.bare"/>
</div>	
<div id="commonNameResults" class="blanketResultsContainer">
	<tiles:insert definition="search.commonNames.bare"/>
</div>	
<div id="geospatialResults" class="blanketResultsContainer">
	<tiles:insert definition="search.countries.bare"/>
</div>	
<div id="datasetResults" class="blanketResultsContainer">
	<tiles:insert definition="search.datasets.bare"/>
</div>