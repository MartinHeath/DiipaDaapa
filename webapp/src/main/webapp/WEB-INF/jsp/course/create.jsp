<%@ include file="../../init.jspf" %>
<!DOCTYPE html>
<h2 class="columnHeading">Courses</h2>

<p>
    Create a new course
</p>

<spring:url value="/course/create" var="formAction" htmlEscape="true"/>


<form:form modelAttribute="form" id="courseform" methodParam="POST" action="${formAction}" cssClass="courseForm">
    
    <div class="formRowHolder">
        <span><form:hidden path="courseId" /><form:errors element="courseId" /></span>
    </div>

    <div class="formRowHolder">
        <label>Course name</label><span><form:input path="courseName" /><form:errors element="courseName" /></span>
    </div>

    <div class="formRowHolder">
        <label>Course description</label><span><form:input id="tinytext" path="courseDescription" /><form:errors element="courseDescription" /></span>
    </div>

    <form:button type="submit" id="formSubmit" name="formSubmit" value="save">Create</form:button>
</form:form>
    
    
    <div>
        <table id="tab">
            
        </table>
        
    </div>
    
    <script type = "text/javascript" language = "javascript">
        $(document).ready(function() {
           $.ajax({
               type: "GET",
               url: "http://localhost:8080/webapp/course/hello",
               success: function(data){
                   var tr;
                   for(var i = 0; i<data.length;i++){
                       tr=$('<tr/>')
                       tr.append("<td>" + data[i].courseId +"</td>");
                       tr.append("<td>" + data[i].courseName +"</td>");
                       tr.append("<td>" + data[i].courseDescription +"</td>");
                       $('#tab').append(tr);
                   }
               },
               error: "lol",
               dataType: "JSON"
           });
        });
    </script>
    
<a href="/webapp/course/home"> Back </a>