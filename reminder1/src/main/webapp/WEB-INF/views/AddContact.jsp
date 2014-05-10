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

	<div id="mainContainer">
		<form action="addContct.htm" method="post">
			<div id="content">
				<div>
					<div class="label">Name</div>
					<div class="input">
						<input type="text" name="grpName" id="grpName"> </input>
					</div>
				</div>

				<div>
					<div class="label">DOB</div>
					<div class="input">
						<input type="text" name="dob" id="dob"> </input>
					</div>
				</div>

				<div>
					<div class="label">Anniversary Date</div>
					<div class="input">
						<input type="text" name="anniDate" id="anniDate"> </input>
					</div>
				</div>

				<div>
					<div class="label">Phone No</div>
					<div class="input">
						<input type="text" name="phoneNo" id="phoneNo"> </input>
					</div>
				</div>

				<div>
					<div class="label">E-mail:</div>
					<div class="input">
						<input type="text" name="email" id="email"> </input>
					</div>
				</div>
				<button type="Submit">Submit</button>
				<h1>${message}</h1>

			</div>
		</form>
	</div>

</body>
</html>