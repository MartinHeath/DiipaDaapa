<%@ include file="../../init.jspf" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Course homepage</title>
    </head>
    <body>
        <h1>Here you can create, edit and see your course table!</h1>
        
        <div id="courselist">
            ${content}
            <a href="/webapp/course/create">Create</a>
            <a href="/webapp/course/list">List</a>
        </div>
    </body>
</html>
