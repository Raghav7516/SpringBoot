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
<c:forEach items="${uoms.getContent()}" var="uom">
<tr>
<td><c:out value="${uom.uomId}"/></td>
<td><c:out value="${uom.uomType}"/></td>
<td><c:out value="${uom.uomModel}"/></td>
<td><c:out value="${uom.createDate}"/></td>
<td><c:out value="${uom.lastModified}"/></td>
<td><c:out value="${uom.description}"/></td>
<td><a href="/deleteUom?uomId=${uom.uomId}">DELETE</a></td>
<td><a href="/editUom?uomId=${uom.uomId}">EDIT</a></td>
</tr>
</c:forEach>
<c:if test="${!uoms.isFirst()}">
<a href="getAllUoms?page=0">First</a>&nbsp;
</c:if>
<c:if test="${uoms.hasPrevious()}">
<a href="getAllUoms?page=${uoms.getNumber()-1}">Previous</a>&nbsp;
</c:if>
<c:forEach begin="0" end="${uoms.getTotalPages()-1}" var="i">
<c:choose>
<c:when test="${uoms.getNumber() eq i}">
<c:out value="${i+1}"/>&nbsp;
</c:when>
<c:otherwise>
<a href="getAllUoms?page=${i}"><c:out value="${i+1}"/></a>&nbsp;
</c:otherwise>
</c:choose>
</c:forEach>

<c:if test="${uoms.hasNext()}">
<a href="getAllUoms?page=${uoms.getNumber()+1}">Next</a>&nbsp;
</c:if>


<c:if test="${!uoms.isLast()}">
<a href="getAllUoms?page=${uoms.getTotalPages()-1}">Last</a>&nbsp;
</c:if> 

</table>
</body>
</html>


