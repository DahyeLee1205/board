<!DOCTYPE html>
<html lang="en">
<%
	String context = request.getContextPath();
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="<%=context%>/templates/board/js/boardMain.js"></script>
    <title>Board</title>
</head>
<body>
    <jsp:forward page="<%=context%>/templates/board/boardMain.jsp" />
</body>
</html>