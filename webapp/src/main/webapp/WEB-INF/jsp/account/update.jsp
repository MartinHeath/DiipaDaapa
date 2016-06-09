<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../init.jspf" %>



<h2 class="columnHeading">Käyttäjätili.</h2>

<p>
    Käyttäjätilin päivitys.
</p>

<spring:url value="/account/update" var="formAction" htmlEscape="true"/>


<form:form modelAttribute="form" id="personform" methodParam="POST" action="${formAction}" cssClass="userForm">
    
    <div class="formRowHolder">
        <span><form:hidden path="userId" /><form:errors element="userId" /></span>
    </div>

    <div class="formRowHolder">
        <label>Kirjautumistunnus</label><span><form:input path="userName" /><form:errors element="userName" /></span>
    </div>


    <div class="formRowHolder">
        <label>Etunimi</label><span><form:input path="firstName" /><form:errors element="firstName" /></span>
    </div>

    <div class="formRowHolder">
        <label>Sukunimi</label><span><form:input path="lastName" /><form:errors element="lastName" /></span>
    </div>

    <div class="formRowHolder">
        <label>Sähköposti</label><span><form:input path="email" /><form:errors element="email" /></span>
    </div>

    <form:button type="submit" id="formSubmit" name="formSubmit" value="save">Tallenna</form:button>
</form:form>