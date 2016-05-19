<%@ include file="../../init.jspf" %>
<!DOCTYPE html>
<h2 class="columnHeading">Update Event</h2>

<p>
   Update event
</p>

<spring:url value="/events/update" var="formAction" htmlEscape="true"/>


<form:form modelAttribute="form" id="eventform" methodParam="POST" action="${formAction}" cssClass="eventForm">
    
    <div class="formRowHolder">
        <span><form:hidden path="id" /><form:errors element="id" /></span>
    </div>

    <div class="formRowHolder">
        <label>Event name:</label><span><form:input path="eventName" /><form:errors element="eventName" /></span>
    </div>
    
    <div class="formRowHolder">
        <label>Event system:</label><span><form:input path="system" /><form:errors element="system" /></span>
    </div>
    
    <div class="formRowHolder">
        <label>Event description:</label><span><form:input id="tinytext" path="eventDescription" /><form:errors element="eventDescription" /></span>
    </div>
    
    <div class="formRowHolder" id="eventTime">
        From:
        <form:input class="date start" path="startDate" /><form:errors element="startDate" /></span>
        <span><form:input class="time start" path="startTime" /><form:errors element="startTime" /></span>
        <br> 
        to
        <br>
        <form:input class="date end" path="endDate" /><form:errors element="endDate" /></span>
        <span><form:input class="time end" path="endTime" /><form:errors element="endTime" /></span>
    </div>
    <form:button type="submit" id="formSubmit" name="formSubmit" value="save">Update</form:button>
</form:form>
    
<a href="/webapp/events/home"> Back </a>

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
