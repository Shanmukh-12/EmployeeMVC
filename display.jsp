<%@ page import = "java.io.*,java.util.*,data.*"%>
 <html>
   <head>
      <title>Employees</title>
   </head>

      <table border = "1" width = "100%">
         <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Job</th>
            <th>MGR</th>
            <th>Date</th>
            <th>Salary</th>
            <th>Comm</th>
            <th>Deptno</th>
         </tr>
<%
		List<Employee> elist=(List<Employee>)request.getAttribute("emps");
		for(Employee emp:elist){
%>	
            <tr>
               <td>hi <%=emp.getEmpno() %></td>
               <td><%=emp.getEname() %></td>
               <td><%=emp.getJob() %></td>
               <td><%=emp.getMgr() %></td>
               <td><%=emp.getDate() %></td>
               <td><%=emp.getSalary() %></td>
               <td><%=emp.getComm() %></td>
               <td><%=emp.getDeptno() %></td>
            </tr>
<%
		}
%>
      </table>
 
   </body>
</html>