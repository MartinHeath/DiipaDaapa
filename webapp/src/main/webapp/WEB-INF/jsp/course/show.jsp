<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../init.jspf" %>

<h2 class="columnHeading">Course created:</h2>

<div class="item">

    <ul>
                <li> ID: ${currentCourse.courseId}</li>
                <li> NAME: ${currentCourse.courseName}</li>
                <li> DESCRIPTION :${currentCourse.courseDescription}</li>
                <li> CREATED ON: ${currentCourse.createdOn}</li>
   </ul>

    <a href="/webapp/course/home"> Back </a>

</div>