<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<%
	String context = request.getContextPath();
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="<%=context%>/static/board/js/boardMain.js"></script>
    <title>Board</title>
</head>
<body>
    <jsp:forward page="<%= context %>/WEB-INF/board/boardMain.jsp" />
</body>
</html>