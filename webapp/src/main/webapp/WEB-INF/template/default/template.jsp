<%@ include file="../../init.jspf" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="bodyTemplate" />
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DiibaDaaba - The place to be</title>
    <link href="<c:url value='/resources/css/css.css' />" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
    <script type="text/javascript" src="<c:url value='/resources/js/js.js' />"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    
    <script src="<c:url value='/resources/js/tinymce/tinymce.min.js' />" ></script>
    <script>
          tinymce.init({
            selector: '#tinytext',
            menubar: false,
            theme: 'modern',
            width: 600,
            height: 150,
            toolbar: 'undo redo | styleselect | bold italic',
            valid_elements: '@[class],p[style],h3,h4,h5,h6,strong/b, div[align], br'
          });
  </script>
</head>
<body>
    <div id="wrapper">
        <div class="page container container-fluid" id="navContainer">
            <tiles:insertAttribute name="header" />
            <div class="content content-row">
                <tiles:insertAttribute name="menu" />
                <tiles:insertTemplate template="${bodyTemplate}" />
            </div>
            <tiles:insertAttribute name="footer" />
        </div>
    </div>
</body>
</html>
