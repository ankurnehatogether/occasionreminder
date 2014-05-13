<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<form action="login.htm" method="POST">
	<div id="mainContainer">
		<div>
			<span>Uer-Id</span>
			<span>
				<input type="text" name="email" id="email" />
			</span>
		</div>
		<div>
			<span>Password</span>
			<span>
				<input type="password" name="password" id="password" />
			</span>
		</div>
		<div>	
			<button type="Submit">Submit</button>
		</div>
	</div>
	<h2>${errMag}</h2>
	</form>
</body>
</html>