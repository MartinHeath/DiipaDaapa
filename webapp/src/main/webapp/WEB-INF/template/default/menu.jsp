<%@ include file="../../init.jspf" %>

<div class="menu">
     <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
                <a href="${homeUrl}"><spring:message code="header.menu.home" text="Home" /></a>
            </div>
            <ul class="nav navbar-nav">
                <li>
                    <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
                    <a href="${homeUrl}"><spring:message code="header.menu.home" text="Home" /></a>
                </li>
                <li>
                    <spring:url value="/about" var="aboutUrl" htmlEscape="true"/>
                    <a href="${aboutUrl}"><spring:message code="header.menu.about" text="About" /></a>
                </li>
                <li>
                    <spring:url value="/account" var="accountUrl" htmlEscape="true"/>
                    <a href="${accountUrl}"><spring:message code="header.menu.account" text="Account" /></a>
                </li>
                <li>
                    <spring:url value="/j_spring_security_logout" var="logoutUrl" htmlEscape="true"/>
                    <a href="${logoutUrl}"><spring:message code="header.menu.logout" text="logout" /></a>
                </li>
                <li>
                    <spring:url value="/login" var="loginUrl" htmlEscape="true"/>
                    <a href="${loginUrl}"><spring:message code="header.menu.login" text="login" /></a>
                </li>
                <li>
                    <spring:url value="/formexample" var="feUrl" htmlEscape="true"/>
                    <a href="${feUrl}">Form Example</a>
                </li>
                <li>
                    <spring:url value="/numberlist/start" var="nlUrl" htmlEscape="true"/>
                    <a href="${nlUrl}">Numberlist</a>
                </li>

                <li>
                    <spring:url value="/quiz" var="quizUrl" htmlEscape="true"/>
                    <a href="${quizUrl}">Quiz</a>
                </li>

                <li>
                    <spring:url value="/user/create" var="userUrl" htmlEscape="true"/>
                    <a href="${userUrl}">Create User</a>
                </li>
                <li>
                    <spring:url value="/account/list" var="accListUrl" htmlEscape="true"/>
                    <a href="${accListUrl}">Accounts</a>
                </li>


                <li>
                    <spring:url value="/autocomplete/view" var="acUrl" htmlEscape="true"/>
                    <a href="${acUrl}">Autocomplete</a>
                </li>
                <li>
                    <spring:url value="/morsku" var="morUrl" htmlEscape="true"/>
                    <a href="${morUrl}">MorskuSite</a>
                </li>
                <li>
                    <spring:url value="/course/home" var="cUrl" htmlEscape="true"/>
                    <a href="${cUrl}">Courses</a>
                </li>
        
                <li>
                    <spring:url value="/events/home" var="eUrl" htmlEscape="true"/>
                    <a href="${eUrl}"><spring:message code="header.menu.events" text="Events" /></a>
                </li>

            </ul>
        </div>
     </nav>
</div>