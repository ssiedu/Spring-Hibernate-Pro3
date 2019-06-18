<%@page import="com.ssi.entities.Student"%>
<%@page import="java.util.List"%>
<%
	List<Student> students=(List<Student>)request.getAttribute("students");
%>

<html>
<body>
<h3>STUDENTS LIST</h3>
<hr>
<table border="2">
	<tr>
		<th>RollNo</th><th>Name</th><th>Branch</th><th>Sem</th>
	<tr>

<%
	for(Student student:students){
%>
<tr>
	<td><%=student.getRno()%></td>
	<td><%=student.getName()%></td>
	<td><%=student.getBranch()%></td>
	<td><%=student.getSem()%></td>
</tr>
<%
	}
%>
</table>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>