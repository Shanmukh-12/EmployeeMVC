package data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAL {

	public List<Employee> getAllEmployee() {

		int eid, mgr, deptno;
		double sal, comm;
		String ename, job;
		Date date;

		Connection conn = null;
		Statement st = null;
		ResultSet rst = null;
		String qry, cs, ls;

		ArrayList<Employee> elist = null;

		try {

			// register the driver
			Class.forName("org.postgresql.Driver");

			// connect to the database
			cs = "jdbc:postgresql://192.168.110.48:5432/plf_training?user=plf_training_admin&password=pff123";
			conn = DriverManager.getConnection(cs);

			// create prepared statement
			qry = "select * from empsh";
			st = conn.createStatement();

			rst = st.executeQuery(qry);

			// create the empty list
			elist = new ArrayList<Employee>();

			// read all products
			while (rst.next()) {

				// read each record
				eid = rst.getInt("eid");
				ename = rst.getString("ename");
				job = rst.getString("job");
				mgr = rst.getInt("mgr");
				date = rst.getDate(5);
				String s = rst.getString(5);
				sal = rst.getInt("sal");
				comm = rst.getInt("comm");
				deptno = rst.getInt("deptno");

				// create Employee and add to the list
				Employee e = new Employee(eid, ename, job, mgr, s, sal, comm, deptno);
				e.setEmpno(eid);
				e.setEname(ename);
				e.setJob(job);
				e.setMgr(mgr);
				e.setDate(s);
				e.setSalary(sal);
				e.setComm(comm);
				e.setDeptno(deptno);

				// add elist to lst
				elist.add(e);

			}

			rst.close();
			conn.close();

		} catch (ClassNotFoundException cex) {
			System.out.println(cex.getMessage());
		} catch (SQLException sqex) {
			System.out.println(sqex.getMessage());
		}

		return elist;
	}
}