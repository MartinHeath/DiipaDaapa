<%@ include file="../../init.jspf" %>
<!DOCTYPE html>
<h2 class="columnHeading">Courses</h2>

<p>
    Update course
</p>

<spring:url value="/course/update" var="formAction" htmlEscape="true"/>


<form:form modelAttribute="form" id="courseform" methodParam="POST" action="${formAction}" cssClass="courseForm">
    
    <div class="formRowHolder">
        <span><form:hidden path="courseId" /><form:errors element="courseId" /></span>
        <p>ID is: ${id}</p>
    </div>

    <div class="formRowHolder">
        <label>Course name</label><span><form:input path="courseName" /><form:errors element="courseName" /></span>
    </div>

    <div class="formRowHolder">
        <label>Course description</label><span><form:input path="courseDescription" id="tinytext" /><form:errors element="courseDescription" /></span>
    </div>

    <form:button type="submit" id="formSubmit" name="formSubmit" value="save">Update</form:button>
</form:form>
    
    
<a href="/webapp/course/home"> Back </a>

