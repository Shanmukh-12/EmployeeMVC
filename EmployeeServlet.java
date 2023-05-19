package data;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;

		try {

			// call dAL
			EmployeeDAL edal = new EmployeeDAL();

			// get Employee list
			List<Employee> el = edal.getAllEmployee();

			// set the elist to the request
			request.setAttribute("emps", el);

			// get the request dispatcher pointer
			rd = request.getRequestDispatcher("/display.jsp");

			rd.forward(request, response);

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
