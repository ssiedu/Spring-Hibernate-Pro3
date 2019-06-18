<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Student-Details</h3>
	<hr>
		<pre>
			RlNo	${student.rno}
			Name	${student.name}
			Branch	${student.branch}
			Semst	${student.sem}
		</pre>
	<hr>
	<a href="searchstudent">Search-More</a><br>
	<a href="index.jsp">Home</a><br>
</body>
</html>