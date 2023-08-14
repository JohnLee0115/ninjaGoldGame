<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Your Gold: <c:out value="${gold}" /></h2>
	<div>
		<div>
			<form action="/gold" method="post">
				<label>Farm</label>
				<label>(earns 10-20 gold)</label>
				<input type="hidden" name="hidden" value="farm" />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
		<div>
			<form action="/gold" method="post">
				<label>Cave</label>
				<label>(earns 5-10 gold)</label>
				<input type="hidden" name="hidden" value="cave" />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
		<div>
			<form action="/gold" method="post">
				<label>House</label>
				<label>(earns 2-5 gold)</label>
				<input type="hidden" name="hidden" value="house" />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
		<div>
			<form action="/gold" method="post">
				<label>Quest</label>
				<label>(earns/takes 0-50 gold)</label>
				<input type="hidden" name="hidden" value="quest" />
				<input type="submit" value="Find Gold!" />
			</form>
		</div>
	</div>
	
	<h2>Activities: </h2>
	<div>
		<c:forEach var="activity" items="${activities}">
			<p><c:out value="${activity}" /></p>
		</c:forEach>
	</div>

</body>
</html>