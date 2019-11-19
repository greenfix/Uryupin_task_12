<%@ page import="webapp.ListDirBean" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>List directory</title>
</head>
<body>
<%
    ListDirBean list = new ListDirBean();
%>
<%= list.show() %>
</body>
</html>
