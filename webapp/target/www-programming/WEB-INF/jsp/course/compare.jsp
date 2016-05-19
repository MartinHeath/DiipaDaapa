<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../init.jspf" %>

<h2 class="columnHeading">Course updated:</h2>

<div class="item">

    <ul>
                <li>${oldCourse.courseName} -> ${newCourse.courseName} </li>
                <li>${oldCourse.courseDescription}  -> ${newCourse.courseDescription} </li>
   </ul>

    <a href="/webapp/course/home"> Home </a>

</div>