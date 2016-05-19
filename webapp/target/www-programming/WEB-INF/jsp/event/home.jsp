<%@ include file="../../init.jspf" %>
<!DOCTYPE html>

<html>
    <body>
        <div id="tabs">
            <ul class="nav nav-pills">
                <li class="active"><a data-toggle="pill" href="#list">List</a></li>
                <li><a data-toggle="pill" href="#calendar">Calendar</a></li>
            </ul>

            
            <div id="calendar" class="tab-pane fade" ></div>
            <div id="list" class="tab-pane fade in active"> 
                <table id="table" class="table table-striped">
                    <th>
                        <td>Name</td>
                        <td>System</td>
                        <td>Description</td>
                        <td>Date and time</td>
                        <td>Created on</td>
                        <td>Modified on</td>
                    </th>
                </table>
            </div>
        </div>
        
        <!-- Modal -->
        <div id="eventModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

            <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h2 class="modal-title"></h2>
                    </div>
                    <div class="modal-body"></div>
                    <div class="modal-footer">
                        <div class = 'buts'>
                            
                        </div>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        
        <a href="/webapp/events/create">Add new event</a>
        
        
        <link rel='stylesheet' href='<c:url value='/resources/js/fullcalendar/fullcalendar.css' />' />
        <script src='<c:url value='/resources/js/fullcalendar/lib/moment.min.js' />'></script>
        <script src='<c:url value='/resources/js/fullcalendar/fullcalendar.js' />'></script>
        <script>
            function addZero(minute){
                        if(minute < 10){
                            return "0" + minute;
                        }
                        else{
                            return minute;
                        }
            }
            $(document).ready(function($){     
                $('a[data-toggle="pill"]').on('shown.bs.tab', function () {
                    $('#calendar').fullCalendar({
                        header: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'month,agendaWeek,agendaDay'
                        },
                        defaultDate: new moment(),
                        eventLimit: true, // allow "more" link when too many events
                        events: function (start, end, timezone, callback) {

                            console.log(start, end, timezone);
                            $.ajax({
                                url: 'http://localhost:8080/webapp/events/list',
                                dataType: 'json',
                                data: {
                                    // our hypothetical feed requires UNIX timestamps
                                    start: start.format('YYYY-MM-DD'),
                                    end: end.format('YYYY-MM-DD'),
                                    'timezone': timezone
                                },
                                success: function(result) {
                                    console.log(result);
                                    var events = [];
                                    callback(result);
                                }
                            });
                        },
                        timeFormat: 'H(:mm)',
                        //getting corresponding data for modal window
                        eventClick: function(calEvent){
                             $.ajax({
                                url: 'http://localhost:8080/webapp/events/show?id=' + calEvent.id,
                                dataType: 'json',
                                success: function(result) {
                                    console.log(result);
                                    var startTime = result["startTime"]["dayOfMonth"] + "." + result["startTime"]["monthOfYear"] + "." + result["startTime"]["year"] + " - " + result["startTime"]["hourOfDay"] + ":";
                                    var minute = parseInt(result["startTime"]["minuteOfHour"]);
                                    startTime += addZero(minute);
                                    
                                    var endTime = result["endTime"]["hourOfDay"] + ":";
                                    minute= parseInt(result["endTime"]["minuteOfHour"]);
                                    endTime += addZero(minute);
                                    
                                    $(".modal-title").text(result["eventName"] + " - " + result["eventSystem"]);
                                    $(".modal-body").html(
                                          "<h4>FROM " + startTime + " TO " + endTime  + "</h4><br> <p>" + result["eventDescription"] +"</p>"
                                    );
                                    $(".buts").html(
                                            "<a href='/webapp/events/update?id=" + result["id"] +"'><button class='btn btn-primary'>UPDATE</button></a>" +
                                            "<a href='/webapp/events/delete?id=" + result["id"] +"'><button class='btn btn-danger'>DELETE</button></a>"
                                    );
                                }
                            });
                            $('#eventModal').modal('show');
                        }
                    });
                });
                $.getJSON( "http://localhost:8080/webapp/events/full-list", function( data ) {
                    var items = [];
                    $.each( data, function( key, val ) {
                        var startTime = val["startTime"]["dayOfMonth"] + "." + val["startTime"]["monthOfYear"] + "." + val["startTime"]["year"] + " - " + val["startTime"]["hourOfDay"] + ":";
                        var minute = parseInt(val["startTime"]["minuteOfHour"]);
                        startTime += addZero(minute);
                        
                        var createdOn = val["createdOn"]["dayOfMonth"] + "." + val["createdOn"]["monthOfYear"] + "." + val["createdOn"]["year"];
                        var modifiedOn = "";
                        if(val["modifiedOn"] != null){
                            modifiedOn = val["modifiedOn"]["dayOfMonth"] + "." + val["modifiedOn"]["monthOfYear"] + "." + val["modifiedOn"]["year"];
                        }
                        
                        items.push("<tr>");
                        items.push( "<td id='" + key + "'>" + val["eventName"] + "</li>");
                        items.push("<td id='" + key + "'>" + val["eventSystem"] + "</li>");
                        items.push("<td id='" + key + "'>" + val["eventDescription"] + "</li>");
                        items.push("<td id='" + key + "'>" + startTime + "</li>");
                        items.push("<td id='" + key + "'>" + createdOn + "</li>");
                        items.push("<td id='" + key + "'>" + modifiedOn + "</li>");
                        items.push("<td><a href='/webapp/events/update?id=" + val["id"] +"'><button class='btn btn-primary'>UPDATE</button></a></td>");
                        items.push("<td><a href='/webapp/events/delete?id=" + val["id"] + "'><button class='btn btn-danger'>DELETE</button></a></td>");
                        items.push("</tr>")
                    });
 
                    $(items.join( "" )).appendTo( "#table" );
                });
            });
        </script>
    </body>
</html>
