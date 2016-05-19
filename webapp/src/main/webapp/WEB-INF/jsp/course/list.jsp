<%@ include file="../../init.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Course list</title>
    </head>
    <body>
        <h1>Here are your courses:</h1>
        
        <table>
            <th> 
                <td>id</td>
                <td>name</td>
                <td>description</td> 
                <td>Created on</td>
                <td>Modified on</td>
            </th>
            <c:forEach items="${courses}" var="course" >
            <tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.courseDescription}</td>
                <td>${course.createdOn}</td>
                <td>${course.modifiedOn}</td>
                <td><a href="/webapp/course/update?courseId=${course.courseId}"> <button>UPDATE</button></a></td>
                <td><a href="/webapp/course/delete?courseId=${course.courseId}"> <button>DELETE</button></a></td>
            </tr>
            </c:forEach>
    </table>
       
       <a href ="/webapp/course/home"> Back </a>

    </body>
</html>
