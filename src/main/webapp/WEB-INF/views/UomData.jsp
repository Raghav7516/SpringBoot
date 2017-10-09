<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p></p>
<h1>welcome to UOM Data Page!!</h1>
<table border="1">
<tr>
	<th>ID</th><th>TYPE</th><th>UOM</th><th>Created</th><th>Last Modified</th><th>Notes</th>
</tr>
<c:if test="${uoms==null}">
<c:forEach items="${uoms}" var="uom">
<tr>
<td><c:out value="${uom.uomId}"/></td>
<td><c:out value="${uom.uomType}"/></td>
<td><c:out value="${uom.uomModel}"/></td>
<td><c:out value="${uom.createDate}"/></td>
<td><c:out value="${uom.lastModified}"/></td>
<td><c:out value="${uom.description}"/></td>
<td><a href="/deleteUom?uomId=${uom.uomId}">DELETE</a></td>
</tr>
</c:forEach>
</c:if>
<c:if test="${uoms==null}">
<c:out value="done"></c:out>
</c:if>
</table>

</body>
</html>


