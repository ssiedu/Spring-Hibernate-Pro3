<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Student-Updation-Form</h3>
		<form action="savestudentchanges" method="post">
		<pre>
			RollNo	<input type="text" name="rno" value="${student.rno}"/>
			SName	<input type="text" name="name" value="${student.name}"/>
			Branch	<input type="text" name="branch" value="${student.branch}"/>
			Semestr	<input type="text" name="sem" value="${student.sem}"/>
				<input type="submit" value="SaveChanges"/>
		</pre>				
		</form>
</body>
</html>