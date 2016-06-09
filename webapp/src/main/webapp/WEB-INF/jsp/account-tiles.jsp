<%@ include file="../init.jspf" %>
<h1>Account: ${username}</h1>

<c:choose>
    <c:when test="${username=='anonymousUser'}">
        <p>Your account... This page requires login first</p>
        <br />
    </c:when>
    <c:when test="${username=='admin'}">
        You are the admin. Woohoo.
        <table id="userTable">
            <tr>
                <th>
                    List of Users:
                </th>
            </tr>
        </table>
        
        <script>
             $.getJSON( "http://localhost:8080/webapp/account/restList", function( data ) {
                    var items = [];
                    $.each( data, function( key, val ) {
                        
                        items.push("<tr>");
                        items.push( "<td id='" + key + "'>" + val["userName"] + "</td>");
                        items.push("<td><a href='/webapp/account/update?id=" + val["id"] +"'><button class='btn btn-primary'>UPDATE</button></a></td>");
                        items.push("<td><a href='/webapp/account/delete?id=" + val["id"] + "'><button class='btn btn-danger'>DELETE</button></a></td>");
                        items.push("</tr>")
                    });
 
                    $(items.join( "" )).appendTo( "#userTable" );
                });
        </script>
    </c:when>
    <c:otherwise>
        <h3>${user.firstName} ${user.lastName} (${user.username})</h3>

    <table class="userDataTable">
        <tr><td colspan="2" style="font-weight: bold !important;"><h3>Henkilötiedot</h3></td></tr>
        <tr><td>Nimi</td><td>${user.firstName} ${user.lastName}</td></tr>
        <tr><td>Kotiosoite</td><td>${fn:replace(user.address, '\\n', '<br />')}</td></tr>
        <tr><td>S-posti</td><td>${user.email}</td></tr>
        <tr><td>Synt.aika</td><td><joda:format pattern="dd.MM.yyyy" value="${user.dateOfBirth}" /></td></tr>

        <tr><td colspan="2" style="font-weight: bold !important;"><h3>Metatiedot</h3></td></tr>
        <tr><td>Luotu </td><td><joda:format pattern="dd.MM.yyyy" value="${user.createdOn}" />.</td></tr>

        <tr><td>Muokattu </td><td><joda:format pattern="dd.MM.yyyy" value="${user.modifiedOn}" />.</td></tr>
        
        <tr>
            <td><a href="/webapp/account/update?id=${user.id}"> <button>UPDATE</button></a></td>
            <td><a href="/webapp/account/delete?id=${user.id}"> <button>DELETE</button></a></td>
        </tr>
    </table>
        <br />
    </c:otherwise>
</c:choose>