<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UOM Register</title>
</head>
<body>
<h1>Welcome to UOM Register Page!!</h1>
<form action="insertUom" method="post">
<pre>
UOM Type   :<select name="uomType">
			<option value="-1">--select--</option>
			<option value="PACK">PACKING</option>
			<option value="NOPACK">NO PACKING</option>
			<option value="NA">-NA-</option>
			</select>

UOM Model  :<input type="text" name="uomModel"/>

Description:<textarea name="description"></textarea>

<input type="submit" value="Create UOM"/>
</pre>
</form>
${message}
<br/>
<a href="getAllUoms">View All UOMs</a>
</body>
</html>



