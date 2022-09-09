<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@ page import="acme.entities.cookingItem.Status" %>

<acme:list>

	<acme:list-column code="chef.delor.list.label.keylet" path="keylet" width="20%"/>
	<acme:list-column code="chef.delor.list.label.instantiationMoment" path="instantiationMoment" width="20%"/>
	<acme:list-column code="chef.delor.list.label.subject" path="subject" width="20%"/>
	<acme:list-column code="chef.delor.list.label.explanation" path="explanation" width="20%"/>
	<acme:list-column code="chef.delor.list.label.startsAt" path="startsAt" width="20%"/>
	<acme:list-column code="chef.delor.list.label.finishesAt" path="finishesAt" width="20%"/>
	<acme:list-column code="chef.delor.list.label.income" path="income" width="20%"/>		
	<acme:list-column code="chef.delor.list.label.moreInfo" path="moreInfo" width="20%"/>


</acme:list>

		<jstl:if test="${statusci == 'NONE_PUBLISHED'}">
	
		<acme:button code="chef.pimpam.form.button.create" action="/chef/pimpam/create?id=${param.id}"/>
		
		</jstl:if>
		


		
