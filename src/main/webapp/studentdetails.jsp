<%@ page import="com.ssi.entities.Student" %>
<%
	//we need to fetch the data from request object
	Student student=(Student)request.getAttribute("student");	
%>

<html>
<body>
	<h3>Details of Student</h3>
	<hr>
		<pre>
			Roll Number	:	<%=student.getRno()%>
			Stud  Name	: 	<%=student.getName()%>
			Branch  	:	<%=student.getBranch()%>
			Semester	:	<%=student.getSem()%>
		</pre>
	<hr>
</body>
</html>