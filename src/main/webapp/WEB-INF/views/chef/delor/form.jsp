<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@ page import="acme.entities.cookingItem.Status" %>

<acme:form>
	<jstl:choose>
		<jstl:when test="${command=='show'}">
				<acme:input-textbox code="chef.delor.form.label.keylet" path="keylet" readonly="true" />
				<acme:input-textbox code="chef.delor.form.label.instantiationMoment" path="instantiationMoment" readonly="true" />
				<acme:input-textbox code="chef.delor.form.label.subject" path="subject" readonly="true" />
				<acme:input-textbox code="chef.delor.form.label.explanation" path="explanation" readonly="true" />
				<acme:input-textbox code="chef.delor.form.label.startsAt" path="startsAt" readonly="true" />
				<acme:input-textbox code="chef.delor.form.label.finishesAt" path="finishesAt" readonly="true" />
				<acme:input-money code="chef.delor.form.label.income" path="income" readonly="true" />
				<acme:input-url code="chef.delor.form.label.moreInfo" path="moreInfo" readonly="true" />
				
			<jstl:if test="${statusci == 'NONE_PUBLISHED' }">
				<acme:submit code="chef.pimpam.form.button.delete" action="/chef/pimpam/delete?id=${param.id}"/>
				<acme:button code="chef.pimpam.form.button.update" action="/chef/pimpam/update?id=${param.id}"/>
			
			</jstl:if>
	
	</jstl:when>
	
		<jstl:when test="${command == 'create'}">
			<acme:input-textbox code="chef.pimpam.form.label.code" path="code"  />
			<acme:input-textbox code="chef.pimpam.form.label.instationMoment" path="instationMoment" readonly="true"/>
			<acme:input-textbox code="chef.pimpam.form.label.title" path="title"/>
			<acme:input-textbox code="chef.pimpam.form.label.description" path="description"/>
			<acme:input-textbox code="chef.pimpam.form.label.startsAt" path="startsAt" />
			<acme:input-textbox code="chef.pimpam.form.label.finishesAt" path="finishesAt"/>
			<acme:input-money code="chef.pimpam.form.label.budget" path="budget"/>
			<acme:input-textbox code="chef.pimpam.form.label.link" path="link"/>
			<acme:submit code="chef.pimpam.form.button.create" action="/chef/pimpam/create?id=${param.id}"/>
			
		</jstl:when>
		
		<jstl:when test = "${command == 'update' }">
				<acme:input-textbox code="chef.pimpam.form.label.code" path="code"  />
			<acme:input-textbox code="chef.pimpam.form.label.instationMoment" path="instationMoment" readonly="true"/>
			<acme:input-textbox code="chef.pimpam.form.label.title" path="title"/>
			<acme:input-textbox code="chef.pimpam.form.label.description" path="description"/>
			<acme:input-textbox code="chef.pimpam.form.label.startsAt" path="startsAt" />
			<acme:input-textbox code="chef.pimpam.form.label.finishesAt" path="finishesAt"/>
			<acme:input-money code="chef.pimpam.form.label.budget" path="budget"/>
			<acme:input-textbox code="chef.pimpam.form.label.link" path="link"/>
			<acme:submit code="chef.pimpam.form.button.update" action="/chef/pimpam/update?id=${param.id}"/>
	</jstl:when>
		


	</jstl:choose>

</acme:form>