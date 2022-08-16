<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="epicure.fineDish.list.label.seqNumber" path="seqNumber" width="10%"/>
	<acme:list-column code="epicure.fineDish.list.label.instantiationMoment" path="instantiationMoment" width="10%"/>
	<acme:list-column code="epicure.fineDish.list.label.report" path="report" width="50%"/>
	<acme:list-column code="epicure.fineDish.list.label.link" path="link" width="30%"/>
</acme:list>