<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.dao.SectionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question</title>
</head>
<body>
 <h1> Section List</h1>
   
<%  
SectionDAOImpl sectionDao=new SectionDAOImpl();
ResultSet rs=sectionDao.showAllSection();
		%>
	
   		<table border="2">
			<thead>
				<tr>
				  <th >Section Name</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
				<tr>	
					 <td><%=rs.getString(2) %></td>							
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
   <form name="question" class="question" action="AddQuestionServlet" method="post">
      <table>
        <tr>
          <td><label for="name">Enter Question:</label></td>
          <td><input type="text" name="question" required autofocus></td>
        </tr> 
        <tr>      
          <td><label for="sectionName">Select your Section Name</label></td>
          <td><input type="text" name="sectionName" required></td>
        </tr>     
       
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
</body>
</html>