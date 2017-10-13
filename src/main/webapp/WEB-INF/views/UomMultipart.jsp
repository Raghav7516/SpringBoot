<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Multipart Operations</h1>
<h2>Export Data into Exel Sheet</h2>
<a href="uomExport">Export Uom Data</a>
<hr/>
<h2>Import data using Excel Sheet</h2>
<form action="uomImport" method="post" enctype="multipart/form-data">
<pre> 
select File :<input type="file" name="efile"/>
<input type="submit" value="Import Uoms"/>
</pre>
</form>
${ImportMessage}
</body>

</html>