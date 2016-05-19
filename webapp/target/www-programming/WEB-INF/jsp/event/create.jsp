<%@ include file="../../init.jspf" %>
<!DOCTYPE html>
<h2 class="columnHeading">Create Event</h2>

<p>
    <spring:message code="content.event.addNew" text="Create Event" />
</p>

<spring:url value="/events/create" var="formAction" htmlEscape="true"/>


<form:form modelAttribute="form" id="eventform" methodParam="POST" action="${formAction}" cssClass="eventForm">
    
    <div class="formRowHolder">
        <span><form:hidden path="id" htmlEscape="true" /><form:errors element="id" /></span>
    </div>

    <div class="formRowHolder">
        <label><spring:message code="content.event.name" text="Name" />:</label><span><form:input path="eventName" htmlEscape="true" /><form:errors element="eventName" /></span>
    </div>
    
    <div class="formRowHolder">
        <label><spring:message code="content.event.system" text="System" />:</label><span><form:input path="system"  htmlEscape="true"/><form:errors element="system" /></span>
    </div>
    
    <div class="formRowHolder">
        <label><spring:message code="content.event.description" text="Description" />:</label><span><form:input id="tinytext" path="eventDescription" /><form:errors element="eventDescription" /></span>
    </div>
    
    <div class="formRowHolder" id="eventTime">
        <spring:message code="content.event.from" text="From" />:
        <form:input class="date start" path="startDate" /><form:errors element="startDate" /></span>
        <span><form:input class="time start" path="startTime" /><form:errors element="startTime" /></span>
        <br> 
        <spring:message code="content.event.to" text="To" />
        <br>
        <form:input class="date end" path="endDate" /><form:errors element="endDate" /></span>
        <span><form:input class="time end" path="endTime" /><form:errors element="endTime" /></span>
    </div>
    <form:button type="submit" id="formSubmit" name="formSubmit" value="save"><spring:message code="button.create" text="Create" /></form:button>
</form:form>
    
<a href="/webapp/events/home"> <spring:message code="button.back" text="Back" /> </a>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/bootstrapDatepicker/dist/css/bootstrap-datepicker.css' />" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/timepicker/jquery.timepicker.css' />" />
<script type="text/javascript" src="<c:url value='/resources/js/timepicker/jquery.timepicker.js' />"></script>
<script type="text/javascript" src="<c:url value='/resources/js/bootstrapDatepicker/js/bootstrap-datepicker.js' />"></script>
        

<script type="text/javascript" src="<c:url value='/resources/js/datepair/dist/datepair.js' />"></script>
<script>
    $("#eventTime .time").timepicker({
        'minTime': '12:00',
        'maxTime': '22:00',
        'showDuration': true,
        'timeFormat': "G:i"
    });
    
    $("#eventTime .date").datepicker({
        'startDate': new Date(),
        'format': "dd.mm.yyyy",
        'autoclose': true
    });
    
    var eventTime = document.getElementById('eventTime');
    var datepair = new Datepair(eventTime);
</script>
